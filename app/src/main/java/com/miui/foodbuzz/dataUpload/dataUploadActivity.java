package com.miui.foodbuzz.dataUpload;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.miui.foodbuzz.ApiSet;
import com.miui.foodbuzz.R;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class dataUploadActivity extends AppCompatActivity {

    ImageView imageView;
    EditText title, price, description;
    Bitmap bitmap;
    ActivityResultLauncher<String> mTakePhoto;
    Button chooseImage, upload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_upload);


        title = findViewById(R.id.upload_itemTitle_id);
        price = findViewById(R.id.upload_itemPrice_id);
        description = findViewById(R.id.upload_itemDescription_id);
        imageView = findViewById(R.id.upload_itemImage_id);
        chooseImage = findViewById(R.id.upload_chooseImageButton_id);
        upload = findViewById(R.id.upload_buttonUpload_id);





        chooseImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseImage();
            }
        });
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadImage();
            }
        });


        // display picked image to imageview
        mTakePhoto = registerForActivityResult(
                new ActivityResultContracts.GetContent(),
                new ActivityResultCallback<Uri>() {
                    @Override
                    public void onActivityResult(Uri result) {

                        try {
                            bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), result);
                            imageView.setImageBitmap(bitmap);
                            imageView.setVisibility(View.VISIBLE);
                        } catch (IOException e) {
                            Toast.makeText(getApplicationContext(), "Error: "+e, Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );





    }

    public void chooseImage() {
        // opening intent to pickimage
        mTakePhoto.launch("image/*");

    }

    private void uploadImage() {

        String i_title = title.getText().toString();
        String i_price = title.getText().toString();
        String i_description = title.getText().toString();
        String i_image = imageToString();
        ApiSet apiSet = dataUploadInstance.getRetrofit().create(ApiSet.class);
        Call<dataUploadClass> call = apiSet.uploadImage(i_title, i_price, i_description, i_image);

        call.enqueue(new Callback<dataUploadClass>() {
            @Override
            public void onResponse(Call<dataUploadClass> call, Response<dataUploadClass> response) {
                dataUploadClass imageClass = response.body();
                Toast.makeText(dataUploadActivity.this, "Server Response: "+response, Toast.LENGTH_LONG).show();
                imageView.setVisibility(View.GONE);
                title.setText("");
                price.setText("");
                description.setText("");
            }

            @Override
            public void onFailure(Call<dataUploadClass> call, Throwable t) {

            }
        });
    }

    private String imageToString() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] imgByte = byteArrayOutputStream.toByteArray();
        return Base64.encodeToString(imgByte, Base64.DEFAULT);
    }

}
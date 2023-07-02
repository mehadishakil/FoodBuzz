package com.miui.foodbuzz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.hbb20.CountryCodePicker;

public class OTP extends AppCompatActivity {

    CountryCodePicker ccp;
    EditText number;
    Button sendOTP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        ccp = findViewById(R.id.ccp);
        number = findViewById(R.id.numberID);
        sendOTP = findViewById(R.id.send_otpID);

        sendOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ManageOTP.class);
                intent.putExtra("mobile", number.getText().toString());
                startActivity(intent);
            }
        });

    }
}
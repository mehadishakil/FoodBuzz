package com.miui.foodbuzz.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.miui.foodbuzz.R;

public class SplashScreen extends AppCompatActivity {

    ImageView logoImage;
    TextView appName;
    LottieAnimationView lottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // removing topbar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar();

        setContentView(R.layout.activity_splash_screen);


        logoImage = findViewById(R.id.logoImageView);
        appName = findViewById(R.id.apNameTxtView);
        lottieAnimationView = findViewById(R.id.lottieSplashScreen);


        logoImage.animate().translationY(-1600).setDuration(1000).setStartDelay(4000);
        appName.animate().translationY(-1600).setDuration(1000).setStartDelay(4000);
        lottieAnimationView.animate().translationY(1400).setDuration(1000).setStartDelay(4000);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(getApplicationContext(), LoginSignUpActivity.class);
                startActivity(i);
            }
        },4800);

    }
}
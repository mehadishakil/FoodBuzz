package com.miui.foodbuzz.Fragments;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.Nullable;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.miui.foodbuzz.OTP;
import com.miui.foodbuzz.R;

public class LoginTabFragment extends Fragment {

    FloatingActionButton fb, google, twitter;
    EditText mobile, pass;
    TextView forgetPass;
    Button login;
    float v = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.login_tab_fragment, container, false);


        mobile = root.findViewById(R.id.login_mobile_ID);
        pass = root.findViewById(R.id.login_pass_ID);
        forgetPass = root.findViewById(R.id.forgetPassID);
        login = root.findViewById(R.id.login_Btn_ID);
        fb = root.findViewById(R.id.fab_facebook);
        google = root.findViewById(R.id.fab_google);
        twitter = root.findViewById(R.id.fab_twitter);



        mobile.setTranslationX(400);
        pass.setTranslationX(400);
        forgetPass.setTranslationX(400);
        login.setTranslationX(400);
        fb.setTranslationY(400);
        google.setTranslationY(400);
        twitter.setTranslationY(400);


        mobile.setAlpha(v);
        pass.setAlpha(v);
        forgetPass.setAlpha(v);
        login.setAlpha(v);
        fb.setAlpha(v);
        google.setAlpha(v);
        twitter.setAlpha(v);


        mobile.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(400).start();
        pass.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(500).start();
        forgetPass.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(600).start();
        login.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(100).start();
        fb.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();
        google.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(550).start();
        twitter.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(700).start();



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkCredentials();
                Intent intent = new Intent(getContext(), OTP.class);
                startActivity(intent);
            }
        });


        return root;
    }






    private void checkCredentials() {
        String number = mobile.getText().toString();
        String password = pass.getText().toString();

        if(number.length() != 11)
            showError(mobile, "Please enter a valid mobile number");
        else if(password.isEmpty() || password.length()<7)
            showError(pass, "Please enter correct password");
    }

    private void showError(EditText input, String s) {
        input.setError(s);
        input.requestFocus();
    }







}

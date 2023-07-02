package com.miui.foodbuzz.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.miui.foodbuzz.Classes.User;
import com.miui.foodbuzz.MainActivity;
import com.miui.foodbuzz.R;

import java.util.Objects;

public class SignUpTabFragment extends Fragment {

    private EditText fullName, mobileNumber, emailAddress, pass1, pass2;
    private Button signUp;
    private ProgressBar progressBar;
    private FirebaseAuth mAuth;
    String name, mobile, email, password, confirmPassword;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.signup_tab_fragment, container, false);

        mAuth = FirebaseAuth.getInstance();

        fullName = root.findViewById(R.id.signup_name_ID);
        mobileNumber = root.findViewById(R.id.signup_mobile_ID);
        emailAddress = root.findViewById(R.id.signup_email_ID);
        pass1 = root.findViewById(R.id.signup_Password1_ID);
        pass2 = root.findViewById(R.id.signup_Password2_ID);
        signUp = root.findViewById(R.id.signup_btn_ID);
        progressBar = root.findViewById(R.id.progressBarID);




        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkCredentials();
            }
        });

        onStart();
        return root;
    }


    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            currentUser.reload();
        }
    }




    private void checkCredentials() {
        name = fullName.getText().toString();
        mobile = mobileNumber.getText().toString();
        email = emailAddress.getText().toString();
        password = pass1.getText().toString();
        confirmPassword = pass2.getText().toString();

        if(name.isEmpty())
            showError(fullName, "Name field can't be empty.");
        else if(mobile.length() != 11)
            showError(mobileNumber, "Enter valid mobile number");
        else if(!email.matches(emailPattern))
            showError(emailAddress, "Enter correct email");
        else if(password.isEmpty() || password.length()<7)
            showError(pass1, "Password must be 7 character");
        else if(confirmPassword.isEmpty() || !confirmPassword.equals(password))
            showError(pass2, "Password not matched!");
        else
            registerUser();
    }


    private void showError(EditText input, String s) {
        input.setError(s);
        input.requestFocus();
    }



    private void registerUser() {
        // set progressbar visible
        progressBar.setVisibility(View.VISIBLE);
        // Write a data to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Users");

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(requireActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            User user = new User(name, mobile, email, password);
                            myRef.setValue(user);
                            Toast.makeText(getActivity(), "User Created", Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                            startActivity(new Intent(getActivity(), MainActivity.class));
                        } else {
                            Toast.makeText(getActivity(), "Error "+ Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });
    }


}
package com.mounts.lenovo.delivery3.activity;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.mounts.lenovo.delivery3.R;
import com.mounts.lenovo.delivery3.api.ApiInterface;
import com.mounts.lenovo.delivery3.response.RegisterResponse;
import com.mounts.lenovo.delivery3.retrofit.RetrofitService;

import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Register extends AppCompatActivity {

    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    //"(?=.*[0-9])" +         //at least 1 digit
                    //"(?=.*[a-z])" +         //at least 1 lower case letter
                    //"(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[a-zA-Z])" +      //any letter
                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{4,}" +               //at least 4 characters
                    "$");

    private TextInputLayout phoneNumberRegister, passwordRegister, confirmPasswordRegister, name, email;
    private Button register;
    private TextView backToSignIn;
    private RetrofitService service;
    private ProgressBar progressBar;
    private String phoneNumber, useremail, username, password, confirmPassword;
    private ApiInterface api;
    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
        backToSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this, Login.class);
                startActivity(intent);
            }
        });
    }

    private void init() {

        email = findViewById(R.id.email);
        name = findViewById(R.id.name);
        phoneNumberRegister = findViewById(R.id.phoneNumberRegister);
        passwordRegister = findViewById(R.id.passwordRegister);
        confirmPasswordRegister = findViewById(R.id.confirmPasswordRegister);
        register = findViewById(R.id.register);
        backToSignIn = findViewById(R.id.signIn);

        service = new RetrofitService();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("button", "Clicked");

                username = name.getEditText().getText().toString().trim();
                useremail = email.getEditText().getText().toString();
                phoneNumber = phoneNumberRegister.getEditText().getText().toString();
                password = passwordRegister.getEditText().getText().toString();
                confirmPassword = confirmPasswordRegister.getEditText().getText().toString();

                Log.e("username", username);
                Log.e("useremail", useremail);
                Log.e("Phone num", phoneNumber);
                Log.e("password", password);
                Log.e("confirm_password", confirmPassword);


                if (useremail.isEmpty()) {
                    email.setError("Field can't be empty");
                } else if (!Patterns.EMAIL_ADDRESS.matcher(useremail).matches()) {
                    email.setError("Please enter a valid email address");
                } else {
                    email.setError(null);
                }//email validated or not??

                if (password.length() < 6) {
                    passwordRegister.setError("minimum 6 characters");
                } else if (confirmPassword.length() < 6) {
                    confirmPasswordRegister.setError("minimum 6 characters");
                } else if (password.equals(confirmPassword)) {
                    registerUser();
                    Intent intent = new Intent(Register.this, Login.class);
                    startActivity(intent);
                } else {
                    passwordRegister.setError("Incorrect password");
                    confirmPasswordRegister.setError("Incorrect password");
                }
                Log.e("Empty Click", "Clicked");
            }
        });

    }

    private void registerUser() {

        ApiInterface apiInterface = service.getService().create(ApiInterface.class);

        Log.e("registerUser", "success");

        apiInterface.register(username, phoneNumber, password, confirmPassword, useremail).enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {

                if (response.isSuccessful()) {
                    if (response.body().isSuccess) {
                        Intent intent = new Intent(getApplicationContext(), Login.class);
//                        intent.putExtra("Token", token);
//                        startActivity(intent);

                        Log.e("sessionId", response.body().sessionId);
                    } else {
                        Log.e("response.body.isSuccess", "false");
                        Log.e("response.body.isSuccess", response.body().errors);
                    }
                } else {
                    Log.e("response.isSuccessful", "fail");
                    Log.e("Email", "fail");
                }

            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {

                Log.e("onfailure", t.toString());
            }
        });
    }
}

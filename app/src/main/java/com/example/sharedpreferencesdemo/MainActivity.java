package com.example.sharedpreferencesdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnLogin, btnSignUp;
    EditText etUsername, etPassword;
    private final String USER_CREDENTIALS = "user_credentials_pref";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btn_login);
        btnSignUp = findViewById(R.id.btn_SignUp);
        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(intent);
                //finish();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences credentials = getSharedPreferences(USER_CREDENTIALS, Context.MODE_PRIVATE);
                String userName_from_signUp = credentials.getString("username", null);
                String password_from_signUp = credentials.getString("password", null);

                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                if (userName_from_signUp != null && username != null && username.equals(userName_from_signUp)){
                    if (password != null && password_from_signUp != null && password.equals(password_from_signUp)){
                        Toast.makeText(getApplicationContext(), "Login Successfully, Welcome", Toast.LENGTH_LONG).show();
                    }
                    else
                        Toast.makeText(getApplicationContext(), "Login Failed,Sorry", Toast.LENGTH_LONG).show();
                }
                else
                    Toast.makeText(getApplicationContext(), "Login Failed, Sorry", Toast.LENGTH_LONG).show();
            }
        });
    }
}
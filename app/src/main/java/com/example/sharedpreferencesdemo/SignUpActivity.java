package com.example.sharedpreferencesdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUpActivity extends AppCompatActivity {
    Button btnCreateUser;
    EditText etSignUsername, etSignPassword, etSignConfPassword;
    private final String USER_CREDENTIALS = "user_credentials_pref";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        btnCreateUser = findViewById(R.id.btn_create_newUser);
        etSignUsername = findViewById(R.id.et_signup_username);
        etSignPassword = findViewById(R.id.et_signup_password);
        etSignConfPassword = findViewById(R.id.et_signup_conf_password);

        btnCreateUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String signUpUsername = etSignUsername.getText().toString();
                String signUpPassword = etSignPassword.getText().toString();
                String signUpConfPassword = etSignConfPassword.getText().toString();

                if (signUpPassword != null && signUpConfPassword != null && signUpPassword.equals(signUpConfPassword)){
                    SharedPreferences userCredentials = getSharedPreferences(USER_CREDENTIALS, Context.MODE_PRIVATE);

                    SharedPreferences.Editor editor = userCredentials.edit();
                    editor.putString("username", signUpUsername);
                    editor.putString("password", signUpPassword);

                    editor.apply();

                    SignUpActivity.this.finish();
                }
            }
        });
    }
}
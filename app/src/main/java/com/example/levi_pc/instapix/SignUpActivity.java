package com.example.levi_pc.instapix;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUpActivity extends AppCompatActivity {

    private EditText etUsername;
    private EditText etPassword;
    private EditText etEmail;
    private Button btnCreateAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        etEmail = findViewById(R.id.etEmail);
        btnCreateAccount = findViewById(R.id.btnCreateAccount);
        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                String email = etEmail.getText().toString();
                signUp(username, password, email);
            }
        });
    }

    private void signUp(String username, String password, String email) {
        ParseUser user = new ParseUser();
        // Create the ParseUser
        // Set core properties
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        // Set custom properties
        user.put("phone", "650-253-0000");
        // Invoke signUpInBackground
        user.signUpInBackground(new SignUpCallback() {
            public void done(ParseException e) {
                if (e == null) {
                    finish();
                } else {
                    e.printStackTrace();
                    return;
                }
            }
        });
    }
}

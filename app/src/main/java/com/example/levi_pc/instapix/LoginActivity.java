 package com.example.levi_pc.instapix;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

 public class LoginActivity extends AppCompatActivity {

     private static final String TAG = "LoginActivity";

     private EditText etUsername;
     private EditText etPassword;
     private Button btnLogin;
     private Button btnSignUp;

     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_login);

         Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
         setSupportActionBar(toolbar);
         getSupportActionBar().setDisplayShowTitleEnabled(false);

         ParseUser currentUser = ParseUser.getCurrentUser();
         if(currentUser != null) {
             goMainActivity();
         }
         else {
             etUsername = findViewById(R.id.etUsername);
             etPassword = findViewById(R.id.etPassword);
             btnLogin = findViewById(R.id.btnLogin);
             btnLogin.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     String username = etUsername.getText().toString();
                     String password = etPassword.getText().toString();
                     login(username, password);
                 }
             });
             btnSignUp = findViewById(R.id.btnSignUp);
             btnSignUp.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     signUp();
                 }
             });
         }
     }

     private void signUp() {
         Intent i = new Intent(this, SignUpActivity.class);
         startActivity(i);
     }

     private void login(String username, String password) {
         ParseUser.logInInBackground(username, password, new LogInCallback() {
             @Override
             public void done(ParseUser user, ParseException e) {
                 if (e != null) {
                     // TODO: better error handling
                     e.printStackTrace();
                     return;
                 }
                 goMainActivity();
             }
         });
     }

     private void goMainActivity() {
         Intent i = new Intent(this, MainActivity.class);
         startActivity(i);
         finish();
     }
 }

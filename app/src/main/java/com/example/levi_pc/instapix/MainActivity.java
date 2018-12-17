package com.example.levi_pc.instapix;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.parse.ParseUser;

public class MainActivity extends AppCompatActivity {

    private Button btnPost;
    private Button btnLogout;
    private ImageButton camera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        camera = findViewById(R.id.camera);
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToPost();
            }
        });

        //btnPost = findViewById(R.id.btnPost);
        /*btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToPost();
            }
        });
*/
        btnLogout = findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser.logOut();
                goToLogin();
            }
        });

    }

    private void goToLogin() {
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
        finish();
    }

    private void goToPost() {
        Intent i = new Intent(this, PostActivity.class);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

}

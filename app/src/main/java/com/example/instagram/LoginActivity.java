package com.example.instagram;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";

    private ImageView logoText;
    private EditText etUsername;
    private EditText etPassword;
    private EditText etFPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        logoText = findViewById(R.id.logoText);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        //etFPassword = findViewById(R.id.etFPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Username = etUsername.getText().toString();
                String Password = etPassword.getText().toString();
                login (Username,Password);
            }
        });

    }
    private void login (String Username, String Password ){
        ParseUser.logInInBackground(Username, Password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if (e!=null){
                    //TODO: better login handler
                    Log.e(TAG, "Issue with login");
                    e.printStackTrace();
                    return;
                }
                goMainActivity();
            }
        });
    }
    private void goMainActivity(){
        Log.d(TAG, "navigate to the m");
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();

    }
}

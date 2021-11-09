package com.example.s4s;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.parse.ParseClassName;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

@ParseClassName("User")
public class RegisterAccount extends AppCompatActivity{

    public static final String TAG = "RegisterAccount";
    EditText userName;
    EditText userEmail;
    EditText userPassword;
    EditText goalsEntry;
    Button registerBTN;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_account);

        userName = findViewById(R.id.userName);
        userEmail = findViewById(R.id.userEmail);
        userPassword = findViewById(R.id.userPassword);
        goalsEntry = findViewById(R.id.goalsEntry);
        registerBTN = findViewById(R.id.registerBTN);
        imageView = findViewById(R.id.imageView);

        registerBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = userName.getText().toString();
                String email = userEmail.getText().toString();
                String password = userPassword.getText().toString();
                newUser(username, email, password);
            }
        });
    }

    private void newUser(String username, String email, String password) {
        ParseUser user = new ParseUser();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.signUpInBackground(new SignUpCallback() {
            public void done(ParseException e) {
                if (e == null) {
                    Log.e(TAG, "Issue with Login", e);
                }
                goLoginActivity();
            }
        });
    }

    private void goLoginActivity() {
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
        finish();
    }
}
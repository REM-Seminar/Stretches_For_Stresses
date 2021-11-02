package com.example.s4s;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class RegisterAccount extends AppCompatActivity {

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

        userName = findViewById(R.id.userEmail);
        userEmail = findViewById(R.id.userEmail);
        userPassword = findViewById(R.id.userPassword);
        goalsEntry = findViewById(R.id.goalsEntry);
        registerBTN = findViewById(R.id.registerBTN);
        imageView = findViewById(R.id.imageView);
    }
}
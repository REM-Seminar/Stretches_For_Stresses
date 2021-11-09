package com.example.s4s;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

public class FocusAreaActivity extends AppCompatActivity {

    public static final String TAG = "FocusAreaActivity";
    TextView tvSelect;
    ImageButton ibUpperBody;
    ImageButton ibLowerBody;
    ImageButton ibFullBody;
    ImageButton ibBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        tvSelect = findViewById(R.id.tvSelect);
        ibUpperBody = findViewById(R.id.ibUpperBody);
        ibLowerBody = findViewById(R.id.ibLowerBody);
        ibFullBody = findViewById(R.id.ibFullBody);
        ibBack = findViewById(R.id.ibBack);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_focus_area);
    }
}
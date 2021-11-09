package com.example.s4s;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    public static final String TAG ="HomeActivity";
    TextView tvWelcome;
    ImageButton ibSOTD;
    ImageButton ibStretchCatalog;
    TextView tvQOTD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tvWelcome = findViewById(R.id.tvWelcome);
        ibSOTD = findViewById(R.id.ibSOTD);
        ibStretchCatalog = findViewById(R.id.ibStretchCatalog);
        tvQOTD = findViewById(R.id.tvQOTD);
    }
}
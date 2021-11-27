package com.example.s4s;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.parse.ParseFile;

public class DetailedView extends AppCompatActivity {

    private static final String TAG = "DetailActivity";
    private TextView StretchTitle;
    private ImageView StretchImage;
    private TextView StretchDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_view);

        StretchTitle = findViewById(R.id.stretchTitle);
        StretchImage = findViewById(R.id.stretchImage);
        StretchDescription = findViewById(R.id.stretchDescription);

        if (getIntent().hasExtra("stretch")){
            Stretches stretch = getIntent().getParcelableExtra("stretch");
            Log.d(TAG, "Title "+ stretch.getTitle());

            StretchTitle.setText(stretch.getTitle());
            StretchDescription.setText(stretch.getDescription());
            ParseFile image = stretch.getImage();
            if (image != null) {
                Glide.with(this).load(stretch.getImage().getUrl()).into(StretchImage);
            }
        }
    }
}
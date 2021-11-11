package com.example.s4s.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.s4s.R;

public class CatalogScreenFragment {

    public static final String TAG ="CatalogScreenFragment";
    TextView stretchDescription;
    ImageView stretchImage;
    ImageButton timerButton;

    public CatalogScreenFragment(){

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_catalog_screen_fragment, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        stretchDescription = view.findViewById(R.id.stretchDescription);
        stretchImage = view.findViewById(R.id.stretchImage2);
        timerButton = view.findViewById(R.id.timerButton);

    }
};
    /*
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.stretch_catalog);
            TextView stretchName = (TextView) findViewById(R.id.StretchName);
            ImageView stretchImage = (TextView) findViewById(R.id.StretchImage);

*/


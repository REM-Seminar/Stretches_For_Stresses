package com.example.s4s.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.s4s.R;

import java.util.ArrayList;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    public static final String TAG ="HomeFragment";
    TextView tvWelcome;
    ImageButton ibSOTD;
    ImageButton ibStretchCatalog;
    TextView tvQOTD;
    Random random = new Random();

    public HomeFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvWelcome = view.findViewById(R.id.tvWelcome);
        ibSOTD = view.findViewById(R.id.ibSOTD);
        ibStretchCatalog = view.findViewById(R.id.ibStretchCatalog);
        tvQOTD = view.findViewById(R.id.tvQOTD);

        displayQuote();
    }

    public void displayQuote(){

        int randNum = random.nextInt((8+1)-1) + 1;
        String randQuote = "";

        switch (randNum){
            case 1:
                randQuote = getString(R.string.q1);
                break;
            case 2:
                randQuote = getString(R.string.q2);
                break;
            case 3:
                randQuote = getString(R.string.q3);
                break;
            case 4:
                randQuote = getString(R.string.q4);
                break;
            case 5:
                randQuote = getString(R.string.q5);
                break;
            case 6:
                randQuote = getString(R.string.q6);
                break;
            case 7:
                randQuote = getString(R.string.q7);
                break;
            case 8:
                randQuote = getString(R.string.q8);
                break;
        }
        tvQOTD.setText(randQuote);
    }
}
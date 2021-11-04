package com.example.s4s.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.s4s.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class CatalogFragment extends Fragment {

    public static final String TAG = "CatalogFragment";
    TextView tvSelect;
    ImageButton ibUpperBody;
    ImageButton ibLowerBody;
    ImageButton ibFullBody;
    ImageButton ibBack;

    public CatalogFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_catalog, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvSelect = view.findViewById(R.id.tvSelect);
        ibUpperBody = view.findViewById(R.id.ibUpperBody);
        ibLowerBody = view.findViewById(R.id.ibLowerBody);
        ibFullBody = view.findViewById(R.id.ibFullBody);
        ibBack = view.findViewById(R.id.ibBack);
    }
}
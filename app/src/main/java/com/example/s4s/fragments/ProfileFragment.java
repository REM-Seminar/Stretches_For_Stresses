package com.example.s4s.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.s4s.R;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    TextView displayUsername;
    TextView displayPassword;
    TextView displayEmail;
    TextView displayWelcomeMessage;
    ImageButton signOut;
    ImageView profileView;


    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        displayUsername = view.findViewById(R.id.displayUsername);
        displayPassword = view.findViewById(R.id.displayPassword);
        displayEmail = view.findViewById(R.id.displayEmail);
        displayWelcomeMessage = view.findViewById(R.id.displayWelcomeMessage);
        signOut = view.findViewById(R.id.signOut);
        profileView = view.findViewById(R.id.profileView);
    }
}
package com.example.s4s.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.s4s.LoginActivity;
//import com.example.s4s.Quotes;
import com.example.s4s.R;
import com.parse.ParseUser;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    public static final String TAG = "ProfileFragment";
    private Button btnSignout;
    TextView displayUsername;
    TextView displayPassword;
    TextView displayEmail;
    TextView displayWelcomeMessage;
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
        btnSignout = view.findViewById(R.id.btnSignout);

        displayUsername = view.findViewById(R.id.displayUsername);
        displayPassword = view.findViewById(R.id.displayPassword);
        displayEmail = view.findViewById(R.id.displayEmail);
        displayWelcomeMessage = view.findViewById(R.id.displayWelcomeMessage);
        profileView = view.findViewById(R.id.profileView);

        btnSignout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "onClick Logout button");
                ParseUser.logOut();
                ParseUser currentUser = ParseUser.getCurrentUser();
                goLoginActivity();
            }
        });
    }

    private void goLoginActivity() {
        Intent i = new Intent(getContext(), LoginActivity.class);
        startActivity(i);
    }

}
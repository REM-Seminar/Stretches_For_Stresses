package com.example.s4s.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.s4s.R;
import com.example.s4s.Stretches;
import com.parse.ParseClassName;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import java.util.List;

public class StretchCatalogFragment extends Fragment {

    public static final String TAG = "StretchCatalogFragment";
    private RecyclerView stretches;

    public StretchCatalogFragment() {
        // Required empty public constructor
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        stretches = view.findViewById(R.id.stretches);
    }

    @ParseClassName("Stretches")
    public class Stretches extends ParseObject {
        public static final String KEY_DESCRIPTION = "description";
        public static final String KEY_IMAGE = "image";
        public static final String KEY_TITLE = "title";

        public String getDescription() {
            return getString(KEY_DESCRIPTION);
        }

        public void setDescription(String description) {
            put(KEY_DESCRIPTION, description);
        }

        public ParseFile getImage() {
            return getParseFile(KEY_IMAGE);
        }

        public void setImage(ParseFile parsefile) {
            put(KEY_IMAGE, parsefile);
        }

        public String getTitle() {
            return getString(KEY_TITLE);
        }

        public void setTitle(String title) {
            put(KEY_TITLE, title);
        }


    }
}


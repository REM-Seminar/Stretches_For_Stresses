package com.example.s4s.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.s4s.CardViewAdapter;
import com.example.s4s.R;
import com.example.s4s.Stretches;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class UpperBody extends Fragment {

    public static final String TAG = "UpperBody";
    private RecyclerView rvUpper;
    private CardViewAdapter adapter;
    protected List<Stretches> allStretches;

    public UpperBody() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_upper_body, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvUpper = view.findViewById(R.id.rvUpper);

        allStretches = new ArrayList<>();
        adapter = new CardViewAdapter(getContext(), allStretches);

        rvUpper.setAdapter(adapter);
        rvUpper.setLayoutManager(new LinearLayoutManager(getContext()));

        queryStretches();
    }

    private void queryStretches() {
        ParseQuery<Stretches> query = ParseQuery.getQuery(Stretches.class);
        query.findInBackground(new FindCallback<Stretches>() {
            @Override
            public void done(List<Stretches> stretches, ParseException e) {
                if (e != null) {
                    Log.e(TAG, "Issue with getting post", e);
                    return;
                }
                for (Stretches post : stretches) {
                    Log.i(TAG, "Title: " + post.getTitle() + ", Description: " + post.getDescription());
                }
                allStretches.addAll(stretches);
                adapter.notifyDataSetChanged();
            }
        });
    }
}
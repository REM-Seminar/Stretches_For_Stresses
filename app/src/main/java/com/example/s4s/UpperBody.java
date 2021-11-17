package com.example.s4s;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class UpperBody extends AppCompatActivity {

    public static final String TAG = "UpperBody";
    protected ListViewAdapter adapter;
    List<Stretches> allStretches;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upperbody);

        allStretches = new ArrayList<>();
        RecyclerView rvUpper = findViewById(R.id.rvUpper);
        rvUpper.setAdapter(new ListViewAdapter(this,allStretches));
        rvUpper.setLayoutManager(new LinearLayoutManager(this));

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
                for (Stretches stretch : stretches) {
                    Log.i(TAG, "Title: " + stretch.getTitle() + ", Description: " + stretch.getDescription());
                }
                allStretches.addAll(stretches);
                //adapter.notifyDataSetChanged();
            }
        });
    }
}
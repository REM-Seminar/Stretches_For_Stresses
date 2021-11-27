package com.example.s4s;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class FullBody extends AppCompatActivity implements ListViewAdapter.OnStretchListener {

    public static final String TAG = "UpperBody";
    RecyclerView rvFocusArea;
    TextView FocusTitle;
    ListViewAdapter adapter;
    List<Stretches> allStretches;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.focus_area);
        rvFocusArea = findViewById(R.id.rvFocusArea);
        FocusTitle = findViewById(R.id.focusTitle);
        FocusTitle.setText("Full Body");

        allStretches = new ArrayList<>();
        adapter = new ListViewAdapter(this, allStretches, this);
        rvFocusArea.setAdapter(adapter);

        rvFocusArea.setLayoutManager(new LinearLayoutManager(this));

        queryStretches();
    }

    private void queryStretches() {
        ParseQuery<Stretches> query = ParseQuery.getQuery(Stretches.class);
        query.addAscendingOrder(Stretches.KEY_TITLE);
        query.whereEqualTo("type", "FullBody");
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
                adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onStretchClick(int position) {
        Intent i = new Intent(this, DetailedView.class);
        i.putExtra("stretch", allStretches.get(position));
        startActivity(i);
    }
}
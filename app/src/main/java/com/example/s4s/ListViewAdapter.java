package com.example.s4s;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.parse.ParseFile;

import java.security.AccessControlContext;
import java.util.ArrayList;
import java.util.List;

public class ListViewAdapter extends RecyclerView.Adapter<ListViewAdapter.ViewHolder> {

    private final Context context;
    private final List<Stretches> stretches;

    public ListViewAdapter(Context context,List<Stretches> stretches) {
        this.context = context;
        this.stretches = stretches;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Stretches stretch = stretches.get(position);
        holder.StretchTitle.setText(stretch.getTitle());
        holder.StretchDescription.setText(stretch.getDescription());
        ParseFile image = stretch.getImage();
    }

    @Override
    public int getItemCount() {
        return stretches.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView StretchTitle;
        private ImageView StretchImage;
        private TextView StretchDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            StretchTitle = itemView.findViewById(R.id.stretchTitle);
            StretchDescription = itemView.findViewById(R.id.stretchDescription);
            StretchImage = itemView.findViewById(R.id.stretchImage);
        }
    }
}

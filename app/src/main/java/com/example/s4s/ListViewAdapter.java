package com.example.s4s;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
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
    private OnStretchListener onStretchListener;

    public ListViewAdapter(Context context,List<Stretches> stretches, OnStretchListener onStretchListener) {
        this.context = context;
        this.stretches = stretches;
        this.onStretchListener = onStretchListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view, parent, false);
        return new ViewHolder(view, onStretchListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Stretches stretch = stretches.get(position);
        holder.StretchTitle.setText(stretch.getTitle());
        holder.StretchDescription.setText(stretch.getDescription());
        ParseFile image = stretch.getImage();
        if (image != null) {
            Glide.with(context).load(stretch.getImage().getUrl()).into(holder.StretchImage);
        }
    }

    @Override
    public int getItemCount() { return stretches.size(); }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView StretchTitle;
        private ImageView StretchImage;
        private TextView StretchDescription;
        OnStretchListener onStretchListener;

        public ViewHolder(@NonNull View itemView, OnStretchListener onStretchListener) {
            super(itemView);
            StretchTitle = itemView.findViewById(R.id.stretchTitle);
            StretchDescription = itemView.findViewById(R.id.stretchDescription);
            StretchImage = itemView.findViewById(R.id.stretchImage);
            this.onStretchListener = onStretchListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onStretchListener.onStretchClick(getAdapterPosition());
        }
    }

    public interface OnStretchListener{
        void onStretchClick(int position);
    }
}

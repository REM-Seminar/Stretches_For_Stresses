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

import java.util.List;

public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.ViewHolder> {

    private Context context;
    private List<Stretches> stretches;

    public CardViewAdapter(Context context, List<Stretches> stretches) {
        this.context = context;
        this.stretches = stretches;
    }

    @NonNull
    @Override
    public CardViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        CardViewAdapter.ViewHolder holder = new CardViewAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewAdapter.ViewHolder holder, int position) {
        Stretches stretch = stretches.get(position);
        holder.StretchTitle.setText(stretch.getTitle());
        holder.StretchDescription.setText(stretch.getDescription());
        ParseFile image = stretch.getImage();

        holder.bind(stretch);
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

        public void bind(Stretches stretch) {
            StretchDescription.setText(stretch.getDescription());
            StretchTitle.setText(stretch.getTitle());
            ParseFile image = stretch.getImage();
            if (image != null) {
                Glide.with(context).load(stretch.getImage().getUrl()).into(StretchImage);
            }
        }
    }
}

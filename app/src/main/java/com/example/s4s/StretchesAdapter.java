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

public class StretchesAdapter extends RecyclerView.Adapter<StretchesAdapter.ViewHolder> {

    private Context context;
    private List<Stretches> stretches;

    public StretchesAdapter(Context context, List<Stretches> stretches) {
        this.context = context;
        this.stretches = stretches;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_stretches, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Stretches stretch = stretches.get(position);
        holder.bind(stretch);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView StretchName;
        private ImageView StretchImage;
        private TextView description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            StretchName = itemView.findViewById(R.id.StretchName);
            description = itemView.findViewById(R.id.description);
            StretchImage = itemView.findViewById(R.id.StretchImage);
        }

        public void bind(Stretches stretch) {
            description.setText(stretch.getDescription());
            StretchName.setText(stretch.getTitle());
            ParseFile image = stretch.getImage();
            if (image != null) {
                Glide.with(context).load(stretch.getImage().getUrl()).into(StretchImage);
            }
        }
    }
}

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
import java.util.List;

public class ListViewAdapter extends RecyclerView.Adapter<ListViewAdapter.ViewHolder> {

    private Context context;
    private List<Stretches> stretches;

    public ListViewAdapter(Context context, List<Stretches> stretches) {
        this.context = context;
        this.stretches = stretches;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //holder.StretchName.setText(stretches.get(position).getTitle());
        //holder.StretchImage.setImage(stretches.get(position).getImage());
        //holder.description.setText(stretches.get(position).getDescription());
        Stretches stretch = stretches.get(position);
        holder.bind(stretch);
    }

    @Override
    public int getItemCount() {
        return stretches.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView StretchName;
        private ImageView StretchImage;
        private TextView description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            StretchName = itemView.findViewById(R.id.stretchTitle);
            description = itemView.findViewById(R.id.stretchDescription);
            StretchImage = itemView.findViewById(R.id.stretchImage);
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

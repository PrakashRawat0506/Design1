package com.example.design1.boatdetails.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.design1.R;

public class BoatDetailsAdapter extends RecyclerView.Adapter<BoatDetailsAdapter.ViewHolder> {

    private int[] boatImages;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView boatImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            boatImageView = itemView.findViewById(R.id.imageViewBoatDetails);
        }

        public ImageView getBoatImageView() {
            return boatImageView;
        }
    }

    public BoatDetailsAdapter(int[] boatImages) {
        this.boatImages = boatImages;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_recyclerview_boatdetails, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.getBoatImageView().setImageResource(boatImages[position]);
    }

    @Override
    public int getItemCount() {
        //Hard-coded recycler view size
        return 4;
    }
}

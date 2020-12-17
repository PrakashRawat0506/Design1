package com.example.design1.enginelist.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.design1.R;

public class EngineListAdapter extends RecyclerView.Adapter<EngineListAdapter.ViewHolder> {

    private int[] engineImages;

    private String[] engineName;

    private String[] sellerLocation;

    private String[] enginePrice;

    private String[] estEnginePrice;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView imageViewEngine;

        private final TextView textViewEngineName;

        private final TextView textViewSellerLocation;

        private final TextView textViewEnginePrice;

        private final TextView textViewEstEnginePrice;

        public ViewHolder(View itemView) {
            super(itemView);
            imageViewEngine = itemView.findViewById(R.id.imageViewRecyclerViewEngineList);
            textViewEngineName = itemView.findViewById(R.id.textViewNameEngineList);
            textViewSellerLocation = itemView.findViewById(R.id.textViewSellerEngineList);
            textViewEnginePrice = itemView.findViewById(R.id.textViewPriceEngineList);
            textViewEstEnginePrice = itemView.findViewById(R.id.textViewEstPriceEngineList);
        }

        public ImageView getImageViewEngine() {
            return imageViewEngine;
        }

        public TextView getTextViewEngineName() {
            return textViewEngineName;
        }

        public TextView getTextViewSellerLocation() {
            return textViewSellerLocation;
        }

        public TextView getTextViewEnginePrice() {
            return textViewEnginePrice;
        }

        public TextView getTextViewEstEnginePrice() {
            return textViewEstEnginePrice;
        }
    }

    public EngineListAdapter(int[] engineImages, String[] engineName,
                             String[] sellerLocation, String[] enginePrice, String[] estEnginePrice) {
        this.engineImages = engineImages;
        this.engineName = engineName;
        this.sellerLocation = sellerLocation;
        this.enginePrice = enginePrice;
        this.estEnginePrice = estEnginePrice;
    }

    @NonNull
    @Override
    public EngineListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_recyclerview_enginelist, parent, false);
        return new EngineListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EngineListAdapter.ViewHolder holder, int position) {
        holder.getImageViewEngine().setImageResource(engineImages[position]);
        holder.getTextViewEngineName().setText(engineName[position]);
        holder.getTextViewSellerLocation().setText(sellerLocation[position]);
        holder.getTextViewEnginePrice().setText(enginePrice[position]);
        holder.getTextViewEstEnginePrice().setText(estEnginePrice[position]);
    }

    @Override
    public int getItemCount() {
        //Hard-coded recycler view size
        return 5;
    }
}

package com.example.design1.boatdetails.services.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.design1.R;

public class BoatServicesAdapter extends RecyclerView.Adapter<BoatServicesAdapter.ViewHolder> {

    private final String[] serviceName;
    private final String[] serviceButton;
    private final String[] serviceDescription;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView boatServiceIcon;
        private final TextView boatServiceName;
        private final ImageView boatServiceDropDown;
        private final Button boatService;
        private final View viewDescService;
        private final TextView descService;

        public ViewHolder(View itemView) {
            super(itemView);
            boatServiceIcon = itemView.findViewById(R.id.imageViewIconBoatService);
            boatServiceName = itemView.findViewById(R.id.textViewNameBoatService);
            boatServiceDropDown = itemView.findViewById(R.id.imageViewDropDownBoatService);
            boatService = itemView.findViewById(R.id.buttonGetBoatService);
            viewDescService = itemView.findViewById(R.id.layoutServiceDescriptionBoatService);
            descService = itemView.findViewById(R.id.textViewDescServiceBoatService);
        }

        public ImageView getBoatServiceIcon() {
            return boatServiceIcon;
        }

        public TextView getBoatServiceName() {
            return boatServiceName;
        }

        public ImageView getBoatServiceDropDown() {
            return boatServiceDropDown;
        }

        public Button getBoatService() {
            return boatService;
        }

        public View getViewDescService() {
            return viewDescService;
        }

        public TextView getDescService() {
            return descService;
        }
    }

    public BoatServicesAdapter(String[] serviceName, String[] serviceButton,
                               String[] serviceDescription) {
        this.serviceName = serviceName;
        this.serviceButton = serviceButton;
        this.serviceDescription = serviceDescription;
    }

    @NonNull
    @Override
    public BoatServicesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_recyclerview_boat_services, parent, false);
        return new BoatServicesAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BoatServicesAdapter.ViewHolder holder, int position) {
        holder.getBoatServiceName().setText(serviceName[position]);
        holder.getBoatService().setText(serviceButton[position]);
        holder.getDescService().setText(serviceDescription[position]);
        holder.getBoatServiceDropDown().setOnClickListener(view -> {
            if(holder.getViewDescService().getVisibility() == View.VISIBLE) {
                holder.getViewDescService().setVisibility(View.GONE);
                holder.getBoatServiceDropDown().setImageResource(R.drawable.ic_drop_down_inactive);
            } else if(holder.getViewDescService().getVisibility() == View.GONE) {
                holder.getBoatServiceDropDown().setImageResource(R.drawable.ic_drop_down_active);
                holder.getViewDescService().setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public int getItemCount() {
        //Hard-coded recycler view size
        return 4;
    }
}

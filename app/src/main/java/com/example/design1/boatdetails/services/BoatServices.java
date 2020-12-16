package com.example.design1.boatdetails.services;

import android.os.Bundle;
import android.view.Menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.example.design1.R;
import com.example.design1.boatdetails.services.recyclerview.BoatServicesAdapter;

public class BoatServices extends AppCompatActivity {

    private String[] boatServiceName = {
            "Boatzon Insurance",
            "Boatzon Financing",
            "Boat History Report",
            "Boat Transport"
    };

    private String[] boatServiceButton = {
            "Get Insurance Now",
            "Finance this boat now",
            "Get boat history",
            "Boat Transport"
    };

    private String[] serviceDescription = {
            "This boat qualifies for Boatzon Insurance. We offer wholesale insurance prices to members.",
            "Financing This Boat With Us In A Few Clicks And Get The Lowest Payment As A Boatzon Member.",
            "Some random description....",
            "Some more random description...."
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boat_services);
        Toolbar toolbar = findViewById(R.id.toolbarBoatServices);
        setSupportActionBar(toolbar);
        RecyclerView recyclerView = findViewById(R.id.recyclerViewBoatServices);
        BoatServicesAdapter adapter = new BoatServicesAdapter(boatServiceName, boatServiceButton, serviceDescription);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_boat_details, menu);
        return true;
    }
}
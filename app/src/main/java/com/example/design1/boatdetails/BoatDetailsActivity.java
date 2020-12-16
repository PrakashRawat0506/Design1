package com.example.design1.boatdetails;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.design1.R;
import com.example.design1.boatdetails.recyclerview.BoatDetailsAdapter;
import com.example.design1.boatdetails.services.BoatServices;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class BoatDetailsActivity extends AppCompatActivity {

    private int[] boatImages = {
            R.drawable.boat_image_1,
            R.drawable.boat_image_2,
            R.drawable.boat_image_3,
            R.drawable.boat_image_4
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boat_details);
        BoatDetailsAdapter adapter = new BoatDetailsAdapter(boatImages);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView recyclerView = findViewById(R.id.recyclerViewBoatDetails);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        Toolbar toolbar = findViewById(R.id.toolbarBoatDetails);
        setSupportActionBar(toolbar);
        View button = findViewById(R.id.customButtonBoatDetails);
        button.setOnClickListener((View.OnClickListener) view -> {
            final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
                    BoatDetailsActivity.this,
                    R.style.BottomSheetDialogTheme
            );
            View bottomSheetView = LayoutInflater.from(getApplicationContext())
                    .inflate(
                            R.layout.layout_bottom_sheet_boat_details,
                            (ConstraintLayout) findViewById(R.id.layoutBottomSheetBoatDetails)
                    );
            bottomSheetView.findViewById(R.id.imageViewMinimizeBottomSheet).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    bottomSheetDialog.dismiss();
                }
            });
            bottomSheetDialog.setContentView(bottomSheetView);
            bottomSheetDialog.show();
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_boat_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.boat_settings:
                Intent intent = new Intent(BoatDetailsActivity.this, BoatServices.class);
                startActivity(intent);
                break;
        }
        return true;
    }
}
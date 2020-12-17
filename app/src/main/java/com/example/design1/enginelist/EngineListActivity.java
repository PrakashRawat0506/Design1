package com.example.design1.enginelist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.design1.R;
import com.example.design1.enginelist.recyclerview.EngineListAdapter;
import com.example.design1.pricepopup.PricePopupActivity;

public class EngineListActivity extends AppCompatActivity {

    private int[] engineImages = {
            R.drawable.img_engine_1,
            R.drawable.img_engine_2,
            R.drawable.img_engine_1,
            R.drawable.img_engine_2,
            R.drawable.img_engine_1
    };

    private String[] engineName = {
            "2021 Torqeedo Cruise 10.0 TXL",
            "2021 Tohatsu MFS30",
            "2021 Torqeedo Cruise 10.0 TXL",
            "2021 Tohatsu MFS30",
            "2021 Torqeedo Cruise 10.0 TXL"
    };

    private String[] sellerLocation = {
            "Fort Lauderdale, FL",
            "Fort Lauderdale, FL",
            "Fort Lauderdale, FL",
            "Fort Lauderdale, FL",
            "Fort Lauderdale, FL"
    };

    private String[] enginePrice = {
            "$ 9,599",
            "$ 5,125",
            "$ 9,599",
            "$ 5,125",
            "$ 9,599"
    };

    private String[] estEnginePrice = {
            "Est. $450/mo",
            "Est. $235/mo",
            "Est. $450/mo",
            "Est. $235/mo",
            "Est. $450/mo"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_engine_list);
        RecyclerView recyclerView = findViewById(R.id.recyclerViewEngineList);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        EngineListAdapter adapter = new EngineListAdapter(engineImages, engineName, sellerLocation,
                enginePrice, estEnginePrice);
        recyclerView.setAdapter(adapter);
        AppCompatImageButton imageButton = findViewById(R.id.imageButtonCloseLayoutEngineList);
        imageButton.setOnClickListener(view -> {
            findViewById(R.id.layoutGetApprovedEngineList).setVisibility(View.GONE);
            ConstraintLayout constraintLayout = findViewById(R.id.layoutEngineList);
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone(constraintLayout);
            constraintSet.connect(R.id.recyclerViewEngineList, ConstraintSet.TOP,
                    R.id.textViewItemsCountEngineList, ConstraintSet.BOTTOM, 16);
            constraintSet.applyTo(constraintLayout);
        });
        Button getPreApproved = findViewById(R.id.buttonGetApprovedEngineList);
        getPreApproved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EngineListActivity.this, PricePopupActivity.class);
                startActivity(intent);
            }
        });
    }
}
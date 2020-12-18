package com.example.design1.pricepopup;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.design1.R;
import com.google.android.material.slider.Slider;


public class PricePopupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_price_popup);
        TextView textViewCashDown = findViewById(R.id.textViewCashDownSelectPricePopup);
        textViewCashDown.setText(getString(R.string.cash_down_price, (int) 0));
        TextView textViewMonthlyPayment = findViewById(R.id.textViewMonthlyPaymentSelectPricePopup);
        textViewMonthlyPayment.setText(getString(R.string.cash_down_price, (int) 0));
        Slider sliderCashDown = findViewById(R.id.sliderCashDownPricePopup);
        sliderCashDown.addOnChangeListener((slider, value, fromUser) -> textViewCashDown.setText(getString(R.string.cash_down_price, (int) value)));
        Slider sliderMonthlyPayment = findViewById(R.id.sliderMonthlyPaymentPricePopup);
        sliderMonthlyPayment.addOnChangeListener((slider, value, fromUser) -> textViewMonthlyPayment.setText(getString(R.string.cash_down_price, (int) value)));
    }
}
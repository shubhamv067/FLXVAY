package com.example.flxvay;

import static com.example.flxvay.CheckoutActivity.SELECT_ADDRESS;
import static com.example.flxvay.UI.SettingsFragment.MANAGE_ADDRESS;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class AddAddressActivity extends AppCompatActivity {
    ImageView back_arrow;
    Button AddAddress_btn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_address);
        back_arrow = findViewById(R.id.Add_address_Back_arrow);
        AddAddress_btn = findViewById(R.id.AddAddress_btn);


        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        Toolbar toolbar = findViewById(R.id.Add_address_Toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        AddAddress_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent AddressIntent = new Intent(AddAddressActivity.this, CheckoutActivity.class);
                    startActivity(AddressIntent);
                    finish();
            }
        });
    }
}
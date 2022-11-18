package com.example.flxvay;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.flxvay.Adapters.CartAdapter;
import com.example.flxvay.Models.CartModel;

import java.util.ArrayList;
import java.util.List;

public class CheckoutActivity extends AppCompatActivity {

    ImageView back_arrow;
    RecyclerView Cart_checkout_recyclerView;
    CartAdapter cartAdapter;
    RadioButton Address_radio_Button;
    TextView Address;
    public static final int SELECT_ADDRESS = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        back_arrow = findViewById(R.id.Checkout_Back_arrow);
        Address_radio_Button = findViewById(R.id.Address_radio_Button);
        Address = findViewById(R.id.order_detail_Address);

        Address_radio_Button.setVisibility(View.VISIBLE);
        Address_radio_Button.setChecked(true);
        Address_radio_Button.setEnabled(true);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        Toolbar toolbar = findViewById(R.id.Checkout_Toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Cart_checkout_recyclerView = findViewById(R.id.Cart_checkout_recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        Cart_checkout_recyclerView.setLayoutManager(linearLayoutManager);

        List<CartModel> cartModelList = new ArrayList<>();
        cartModelList.add(new CartModel(R.drawable.itemphoto1,"Woman t- shirt","shubham.LTD","$44.00"));
        cartModelList.add(new CartModel(R.drawable.itemphoto1,"Woman t- shirt","shubham.LTD","$44.00"));
        cartModelList.add(new CartModel(R.drawable.itemphoto1,"Woman t- shirt","shubham.LTD","$44.00"));
        cartModelList.add(new CartModel(R.drawable.itemphoto1,"Woman t- shirt","shubham.LTD","$44.00"));
        cartModelList.add(new CartModel(R.drawable.itemphoto1,"Woman t- shirt","shubham.LTD","$44.00"));
        cartModelList.add(new CartModel(R.drawable.itemphoto1,"Woman t- shirt","shubham.LTD","$44.00"));
        cartModelList.add(new CartModel(R.drawable.itemphoto1,"Woman t- shirt","shubham.LTD","$44.00"));
        cartModelList.add(new CartModel(R.drawable.itemphoto1,"Woman t- shirt","shubham.LTD","$44.00"));
        cartModelList.add(new CartModel(R.drawable.itemphoto1,"Woman t- shirt","shubham.LTD","$44.00"));
        cartModelList.add(new CartModel(R.drawable.itemphoto1,"Woman t- shirt","shubham.LTD","$44.00"));
        cartModelList.add(new CartModel(R.drawable.itemphoto1,"Woman t- shirt","shubham.LTD","$44.00"));
        cartModelList.add(new CartModel(R.drawable.itemphoto1,"Woman t- shirt","shubham.LTD","$44.00"));
        cartModelList.add(new CartModel(R.drawable.itemphoto1,"Woman t- shirt","shubham.LTD","$44.00"));
        cartModelList.add(new CartModel(R.drawable.itemphoto1,"Woman t- shirt","shubham.LTD","$44.00"));
        cartModelList.add(new CartModel(R.drawable.itemphoto1,"Woman t- shirt","shubham.LTD","$44.00"));
        cartModelList.add(new CartModel(R.drawable.itemphoto1,"Woman t- shirt","shubham.LTD","$44.00"));
        cartModelList.add(new CartModel(R.drawable.itemphoto1,"Woman t- shirt","shubham.LTD","$44.00"));
        cartModelList.add(new CartModel(R.drawable.itemphoto1,"Woman t- shirt","shubham.LTD","$44.00"));


        cartAdapter = new CartAdapter(cartModelList);
        Cart_checkout_recyclerView.setAdapter(cartAdapter);
        cartAdapter.notifyDataSetChanged();

        Address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent AddressIntent = new Intent(CheckoutActivity.this,AddressActivity.class);
                AddressIntent.putExtra("MODE",SELECT_ADDRESS);
                startActivity(AddressIntent);
                finish();
            }
        });

    }
}
package com.example.flxvay;

import static com.example.flxvay.CheckoutActivity.SELECT_ADDRESS;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.flxvay.Adapters.AddressAdapter;
import com.example.flxvay.Models.AddressModel;

import java.util.ArrayList;
import java.util.List;

public class AddressActivity extends AppCompatActivity {

    RecyclerView address_recyclerView;
    ImageView back_arrow;
    Button Add_Address_btn;
    Button Continue_To_CheckOut_btn;
    private int mode;
    public static  AddressAdapter addressAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        address_recyclerView = findViewById(R.id.address_RecyclerView);
        back_arrow = findViewById(R.id.address_Back_arrow);
        Add_Address_btn = findViewById(R.id.Add_Address_btn);
        Continue_To_CheckOut_btn = findViewById(R.id.Continue_To_Checkout_btn);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        Toolbar toolbar = findViewById(R.id.Settings_Toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        address_recyclerView.setLayoutManager(layoutManager);

        List<AddressModel> addressModelList = new ArrayList<>();
        addressModelList.add(new AddressModel("Shewrapara, Mirpur, Dhaka-1216\n" +
                "House no: 938\n" +
                "Road no: 9",true));
        addressModelList.add(new AddressModel("Shewrapara, Mirpur, Dhaka-1216\n" +
                "House no: 938\n" +
                "Road no: 9",false));
        addressModelList.add(new AddressModel("Shewrapara, Mirpur, Dhaka-1216\n" +
                "House no: 938\n" +
                "Road no: 9",false));
        addressModelList.add(new AddressModel("Shewrapara, Mirpur, Dhaka-1216\n" +
                "House no: 938\n" +
                "Road no: 9",false));
        addressModelList.add(new AddressModel("Shewrapara, Mirpur, Dhaka-1216\n" +
                "House no: 938\n" +
                "Road no: 9",false));
        addressModelList.add(new AddressModel("Shewrapara, Mirpur, Dhaka-1216\n" +
                "House no: 938\n" +
                "Road no: 9",false));



        mode = getIntent().getIntExtra("MODE", -1);
        addressAdapter = new AddressAdapter(addressModelList,mode);
        address_recyclerView.setAdapter(addressAdapter);
        ((SimpleItemAnimator) address_recyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
        addressAdapter.notifyDataSetChanged();


        Add_Address_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent AddAddressIntent = new Intent(AddressActivity.this,AddAddressActivity.class);
                startActivity(AddAddressIntent);

            }
        });

        Continue_To_CheckOut_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent AddAddressIntent = new Intent(AddressActivity.this,CheckoutActivity.class);
                startActivity(AddAddressIntent);
                finish();
            }
        });


        if (mode == SELECT_ADDRESS) {
            Continue_To_CheckOut_btn.setVisibility(View.VISIBLE);
        } else {
            Continue_To_CheckOut_btn.setVisibility(View.GONE);

        }



    }

    public static void refreshitem(int deselect, int select) {
        addressAdapter.notifyItemChanged(deselect);
        addressAdapter.notifyItemChanged(select);

    }
}
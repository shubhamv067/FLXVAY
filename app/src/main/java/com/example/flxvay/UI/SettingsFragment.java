package com.example.flxvay.UI;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.flxvay.AddAddressActivity;
import com.example.flxvay.AddressActivity;
import com.example.flxvay.R;


public class SettingsFragment extends Fragment {

    public static final int MANAGE_ADDRESS = 1;

    TextView Manage_Address_btn;

    public SettingsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        Manage_Address_btn = view.findViewById(R.id.Manage_Address);
        Manage_Address_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent AddAddressIntent = new Intent(getContext(), AddressActivity.class);
                AddAddressIntent.putExtra("MODE",MANAGE_ADDRESS);
                getContext().startActivity(AddAddressIntent);
            }
        });

        return view;
    }
}
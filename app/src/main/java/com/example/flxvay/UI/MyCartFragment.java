package com.example.flxvay.UI;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.flxvay.Adapters.CartAdapter;
import com.example.flxvay.Models.CartModel;
import com.example.flxvay.R;

import java.util.ArrayList;
import java.util.List;

public class MyCartFragment extends Fragment {
    RecyclerView Cart_recyclerView;
    CartAdapter cartAdapter;


    public MyCartFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_cart, container, false);


        Cart_recyclerView = view.findViewById(R.id.Favorite_recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        Cart_recyclerView.setLayoutManager(linearLayoutManager);

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


        cartAdapter = new CartAdapter(cartModelList);
        Cart_recyclerView.setAdapter(cartAdapter);
        cartAdapter.notifyDataSetChanged();



        return view;
    }
}
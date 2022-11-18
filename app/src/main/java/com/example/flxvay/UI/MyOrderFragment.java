package com.example.flxvay.UI;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.flxvay.Adapters.CartAdapter;
import com.example.flxvay.Adapters.MyOrderAdapter;
import com.example.flxvay.Models.CartModel;
import com.example.flxvay.Models.MyOrderModel;
import com.example.flxvay.R;

import java.util.ArrayList;
import java.util.List;

public class MyOrderFragment extends Fragment {
    RecyclerView MyOder_recyclerView;
    MyOrderAdapter myOrderAdapter;

    public MyOrderFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_order, container, false);


        MyOder_recyclerView = view.findViewById(R.id.MyOrder_recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        MyOder_recyclerView.setLayoutManager(linearLayoutManager);

        List<MyOrderModel> myOrderModelList = new ArrayList<>();
        myOrderModelList.add(new MyOrderModel(R.drawable.itemphoto1,"Woman t- shirt","shubham.LTD","$44.00"));
        myOrderModelList.add(new MyOrderModel(R.drawable.itemphoto1,"Woman t- shirt","shubham.LTD","$44.00"));
        myOrderModelList.add(new MyOrderModel(R.drawable.itemphoto1,"Woman t- shirt","shubham.LTD","$44.00"));
        myOrderModelList.add(new MyOrderModel(R.drawable.itemphoto1,"Woman t- shirt","shubham.LTD","$44.00"));
        myOrderModelList.add(new MyOrderModel(R.drawable.itemphoto1,"Woman t- shirt","shubham.LTD","$44.00"));
        myOrderModelList.add(new MyOrderModel(R.drawable.itemphoto1,"Woman t- shirt","shubham.LTD","$44.00"));
        myOrderModelList.add(new MyOrderModel(R.drawable.itemphoto1,"Woman t- shirt","shubham.LTD","$44.00"));
        myOrderModelList.add(new MyOrderModel(R.drawable.itemphoto1,"Woman t- shirt","shubham.LTD","$44.00"));
        myOrderModelList.add(new MyOrderModel(R.drawable.itemphoto1,"Woman t- shirt","shubham.LTD","$44.00"));
        myOrderModelList.add(new MyOrderModel(R.drawable.itemphoto1,"Woman t- shirt","shubham.LTD","$44.00"));


        myOrderAdapter = new MyOrderAdapter(myOrderModelList);
        MyOder_recyclerView.setAdapter(myOrderAdapter);
        myOrderAdapter.notifyDataSetChanged();


        return view;
    }
}
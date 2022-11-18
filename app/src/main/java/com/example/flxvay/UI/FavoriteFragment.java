package com.example.flxvay.UI;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.flxvay.Adapters.HorizontalScrollProductAdapter;

import com.example.flxvay.Models.HorizontalScrollProductModel;
import com.example.flxvay.R;

import java.util.ArrayList;
import java.util.List;

public class FavoriteFragment extends Fragment {

    RecyclerView Favorite_RecyclerView;

    public FavoriteFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favorite, container, false);

        Favorite_RecyclerView = view.findViewById(R.id.Favorite_recyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
        gridLayoutManager.setOrientation(RecyclerView.VERTICAL);
        Favorite_RecyclerView.setLayoutManager(gridLayoutManager);

        List<HorizontalScrollProductModel> favoriteModelList = new ArrayList<>();
        favoriteModelList.add(new HorizontalScrollProductModel(R.drawable.itemphoto1,"$450.00","Woman T-Shirt"));
        favoriteModelList.add(new HorizontalScrollProductModel(R.drawable.itemphoto1,"$450.00","Woman T-Shirt"));
        favoriteModelList.add(new HorizontalScrollProductModel(R.drawable.itemphoto1,"$450.00","Woman T-Shirt"));
        favoriteModelList.add(new HorizontalScrollProductModel(R.drawable.itemphoto1,"$450.00","Woman T-Shirt"));
        favoriteModelList.add(new HorizontalScrollProductModel(R.drawable.itemphoto1,"$450.00","Woman T-Shirt"));
        favoriteModelList.add(new HorizontalScrollProductModel(R.drawable.itemphoto1,"$450.00","Woman T-Shirt"));

        HorizontalScrollProductAdapter horizontalScrollProductAdapter = new HorizontalScrollProductAdapter(favoriteModelList,true);
        Favorite_RecyclerView.setAdapter(horizontalScrollProductAdapter);
        horizontalScrollProductAdapter.notifyDataSetChanged();

        return view;
    }
}
package com.example.flxvay.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.flxvay.Adapters.SelectedSizeAdapter;
import com.example.flxvay.Models.SelectedSizeModel;
import com.example.flxvay.R;

import java.util.ArrayList;
import java.util.List;


public class SelectSizeFragment extends Fragment {

    RecyclerView Selected_size_recyclerView;

    public SelectSizeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_select_size, container, false);

        Selected_size_recyclerView = view.findViewById(R.id.selected_size_recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        Selected_size_recyclerView.setLayoutManager(linearLayoutManager);

        List<SelectedSizeModel> selectedSizeModelList = new ArrayList<>();
        selectedSizeModelList.add( new SelectedSizeModel("xx"));
        selectedSizeModelList.add( new SelectedSizeModel("x"));
        selectedSizeModelList.add( new SelectedSizeModel("s"));
        selectedSizeModelList.add( new SelectedSizeModel("xxx"));
        selectedSizeModelList.add( new SelectedSizeModel("xL"));
        selectedSizeModelList.add( new SelectedSizeModel("x"));
        selectedSizeModelList.add( new SelectedSizeModel("xm"));

        SelectedSizeAdapter selectedSizeAdapter = new SelectedSizeAdapter(selectedSizeModelList);
        Selected_size_recyclerView.setAdapter(selectedSizeAdapter);
        selectedSizeAdapter.notifyDataSetChanged();

        return view;
    }
}
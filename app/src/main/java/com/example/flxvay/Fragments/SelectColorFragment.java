package com.example.flxvay.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.flxvay.Adapters.SelectedColorAdapter;
import com.example.flxvay.Adapters.SelectedSizeAdapter;
import com.example.flxvay.Models.SelectedColorModel;
import com.example.flxvay.Models.SelectedSizeModel;
import com.example.flxvay.R;

import java.util.ArrayList;
import java.util.List;

public class SelectColorFragment extends Fragment {

    RecyclerView Selected_color_recyclerView;

    public SelectColorFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_select_color, container, false);

        Selected_color_recyclerView = view.findViewById(R.id.selected_color_recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        Selected_color_recyclerView.setLayoutManager(linearLayoutManager);

        List<SelectedColorModel> selectedColorModelList = new ArrayList<>();
        selectedColorModelList.add( new SelectedColorModel("#BC1717"));
        selectedColorModelList.add( new SelectedColorModel("#00d2ff"));
        selectedColorModelList.add( new SelectedColorModel("#ff008d"));
        selectedColorModelList.add( new SelectedColorModel("#e0af1f"));
        selectedColorModelList.add( new SelectedColorModel("#1f2212"));
        selectedColorModelList.add( new SelectedColorModel("#00FFFF"));


        SelectedColorAdapter selectedColorAdapter = new SelectedColorAdapter(selectedColorModelList);
        Selected_color_recyclerView.setAdapter(selectedColorAdapter);
        selectedColorAdapter.notifyDataSetChanged();

        return view;
    }
}
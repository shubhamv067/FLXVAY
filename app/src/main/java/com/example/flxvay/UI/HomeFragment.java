package com.example.flxvay.UI;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.afdhal_fa.imageslider.ImageSlider;
import com.example.flxvay.Adapters.CategoryAdapter;
import com.example.flxvay.Adapters.HomePageAdapter;
import com.example.flxvay.Adapters.HorizontalScrollProductAdapter;
import com.example.flxvay.Adapters.SliderAdapter;
import com.example.flxvay.Models.CategoryModel;
import com.example.flxvay.Models.HomePageModel;
import com.example.flxvay.Models.HorizontalScrollProductModel;
import com.example.flxvay.Models.bannerSliderModel;
import com.example.flxvay.R;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {




   ///home page recyclerView
    RecyclerView HomePage_RecyclerView;
    List<HomePageModel> homePageModelList;
    HomePageAdapter homePageAdapter;
    ///home page recyclerView



    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        ////Category//////


        List<CategoryModel> categoryModelList = new ArrayList<>();
        categoryModelList.add(new CategoryModel(R.drawable.baby,"baby","#D7416565"));
        categoryModelList.add(new CategoryModel(R.drawable.beauty,"beauty","#D7416565"));
        categoryModelList.add(new CategoryModel(R.drawable.boy,"boy","#D7416565"));
        categoryModelList.add(new CategoryModel(R.drawable.boygirl,"boy_girl","#D7416565"));
        categoryModelList.add(new CategoryModel(R.drawable.cuple,"couple","#D7416565"));
        categoryModelList.add(new CategoryModel(R.drawable.femily,"family","#D7416565"));
         ////Category/////


        ////HorizontalScrollProductLayout//////


        List<HorizontalScrollProductModel> horizontalScrollProductModelList = new ArrayList<>();
        horizontalScrollProductModelList.add(new HorizontalScrollProductModel(R.drawable.itemphoto1,"$34.00","Woman T-Shirt"));
        horizontalScrollProductModelList.add(new HorizontalScrollProductModel(R.drawable.itemphoto1,"$34.00","Woman T-Shirt"));
        horizontalScrollProductModelList.add(new HorizontalScrollProductModel(R.drawable.itemphoto1,"$34.00","Woman T-Shirt"));
        horizontalScrollProductModelList.add(new HorizontalScrollProductModel(R.drawable.itemphoto1,"$34.00","Woman T-Shirt"));
        horizontalScrollProductModelList.add(new HorizontalScrollProductModel(R.drawable.itemphoto1,"$34.00","Woman T-Shirt"));
        horizontalScrollProductModelList.add(new HorizontalScrollProductModel(R.drawable.itemphoto1,"$34.00","Woman T-Shirt"));
        horizontalScrollProductModelList.add(new HorizontalScrollProductModel(R.drawable.itemphoto1,"$34.00","Woman T-Shirt"));
        horizontalScrollProductModelList.add(new HorizontalScrollProductModel(R.drawable.itemphoto1,"$34.00","Woman T-Shirt"));
        horizontalScrollProductModelList.add(new HorizontalScrollProductModel(R.drawable.itemphoto1,"$34.00","Woman T-Shirt"));
        horizontalScrollProductModelList.add(new HorizontalScrollProductModel(R.drawable.itemphoto1,"$34.00","Woman T-Shirt"));
        horizontalScrollProductModelList.add(new HorizontalScrollProductModel(R.drawable.itemphoto1,"$34.00","Woman T-Shirt"));
        horizontalScrollProductModelList.add(new HorizontalScrollProductModel(R.drawable.itemphoto1,"$34.00","Woman T-Shirt"));
        HorizontalScrollProductAdapter horizontalScrollProductAdapter = new HorizontalScrollProductAdapter(horizontalScrollProductModelList,false);
         ////HorizontalScrollProductLayout//////


       ////banner slider



        List<bannerSliderModel> bannerSliderModelList = new ArrayList<>();
        bannerSliderModelList.add(new bannerSliderModel(R.drawable.banner1,"20% off in our All products"));
        bannerSliderModelList.add(new bannerSliderModel(R.drawable.banner1,"20% off in our All products"));
        bannerSliderModelList.add(new bannerSliderModel(R.drawable.banner1,"20% off in our All products"));
        bannerSliderModelList.add(new bannerSliderModel(R.drawable.banner1,"20% off in our All products"));
        bannerSliderModelList.add(new bannerSliderModel(R.drawable.banner1,"20% off in our All products"));

        ////banner slider

        ///home page recyclerView
        HomePage_RecyclerView = view.findViewById(R.id.HomePage_RecyclerView);
        LinearLayoutManager HomePageLinearLayoutManager = new LinearLayoutManager(getActivity());
        HomePageLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        HomePage_RecyclerView.setLayoutManager(HomePageLinearLayoutManager);

        homePageModelList = new ArrayList<>();
        homePageModelList.add(new HomePageModel(0,null,categoryModelList));
        homePageModelList.add(new HomePageModel(1,bannerSliderModelList, null));
        homePageModelList.add(new HomePageModel(2,horizontalScrollProductModelList,"Featured"));
        homePageModelList.add(new HomePageModel(2,horizontalScrollProductModelList,"Featured"));
        homePageModelList.add(new HomePageModel(2,horizontalScrollProductModelList,"Featured"));
        homePageModelList.add(new HomePageModel(2,horizontalScrollProductModelList,"Featured"));

        homePageAdapter = new HomePageAdapter(homePageModelList);
        HomePage_RecyclerView.setAdapter(homePageAdapter);
        homePageAdapter.notifyDataSetChanged();

        ///home page recyclerView


        return view;
    }


}
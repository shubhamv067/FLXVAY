package com.example.flxvay.Adapters;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.afdhal_fa.imageslider.ImageSlider;
import com.example.flxvay.Models.CategoryModel;
import com.example.flxvay.Models.HomePageModel;
import com.example.flxvay.Models.HorizontalScrollProductModel;
import com.example.flxvay.Models.bannerSliderModel;
import com.example.flxvay.ProductDetailActivity;
import com.example.flxvay.R;
import com.example.flxvay.SeeAllActivity;

import java.util.List;

public class HomePageAdapter extends RecyclerView.Adapter {

    List<HomePageModel> homePageModelList;
    private RecyclerView.RecycledViewPool recycledViewPool;

    public HomePageAdapter(List<HomePageModel> homePageModelList) {
        this.homePageModelList = homePageModelList;
        recycledViewPool = new RecyclerView.RecycledViewPool();
    }

    @Override
    public int getItemViewType(int position) {
        switch (homePageModelList.get(position).getType()) {
            case 0:
                return HomePageModel.CATEGORY_ITEM;
            case 1:
                return HomePageModel.BANNER_SLIDER;
            case 2:
                return HomePageModel.HORIZONTAL_PRODUCT_VIEW;
            default:
                return -1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {

            case HomePageModel.CATEGORY_ITEM:
                View Category_product = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item_layout, parent, false);
                return new CategoryItemViewHolder(Category_product);
            case HomePageModel.BANNER_SLIDER:
                View SliderView = LayoutInflater.from(parent.getContext()).inflate(R.layout.banner_slider_layout, parent, false);
                return new bannersliderViewHolder(SliderView);

            case HomePageModel.HORIZONTAL_PRODUCT_VIEW:
                View horizontalProductView = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontalscrollproductlayout, parent, false);
                return new HorizontalProductViewHolder(horizontalProductView);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        switch (homePageModelList.get(position).getType()) {
            case HomePageModel.CATEGORY_ITEM:
                List<CategoryModel> categoryModelList = homePageModelList.get(position).getCategoryModelList();
                ((CategoryItemViewHolder) holder).setCategoryLayout(categoryModelList);
                break;
            case HomePageModel.BANNER_SLIDER:
                List<bannerSliderModel> sliderModelList = homePageModelList.get(position).getBannerSliderModelList();
                ((bannersliderViewHolder) holder).setBannerSliderLayout(sliderModelList);
                break;
            case HomePageModel.HORIZONTAL_PRODUCT_VIEW:
                String HorizontalLayouttitle = homePageModelList.get(position).getH_P_title();
                List<HorizontalScrollProductModel> horizontalscrollproductModelList = homePageModelList.get(position).getHorizontalScrollProductModelList();
                ((HorizontalProductViewHolder) holder).setHorizontalLayout(horizontalscrollproductModelList, HorizontalLayouttitle);
                break;
            default:
                return;
        }
    }

    @Override
    public int getItemCount() {
        return homePageModelList.size();
    }

    public class CategoryItemViewHolder extends RecyclerView.ViewHolder{


        TextView Category_SeeAll;
        RecyclerView Category_RecyclerView;

        public CategoryItemViewHolder(@NonNull View itemView) {
            super(itemView);
            Category_SeeAll = itemView.findViewById(R.id.Category_SeeAlll_txt);
            Category_RecyclerView = itemView.findViewById(R.id.Category_recyclerView);
            Category_RecyclerView.setRecycledViewPool(recycledViewPool);
        }
        private void setCategoryLayout(List<CategoryModel> categoryModelList){

            Category_SeeAll.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intentSeeAllbtn = new Intent(itemView.getContext(), SeeAllActivity.class);
                    intentSeeAllbtn.putExtra("layout_code",0);
                    intentSeeAllbtn.putExtra("Title","Category");
                    itemView.getContext().startActivity(intentSeeAllbtn);
                }
            });

            LinearLayoutManager  Category_linearLayoutManager = new LinearLayoutManager(itemView.getContext());
            Category_linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            Category_RecyclerView.setLayoutManager(Category_linearLayoutManager);

            CategoryAdapter categoryAdapter = new CategoryAdapter(categoryModelList);
            Category_RecyclerView.setAdapter(categoryAdapter);
            categoryAdapter.notifyDataSetChanged();

        }
    }

    public class bannersliderViewHolder extends RecyclerView.ViewHolder{
        ImageSlider imageSlide;

        public bannersliderViewHolder(@NonNull View itemView) {
            super(itemView);

            imageSlide = itemView.findViewById(R.id.imageSlide);

        }
        private void setBannerSliderLayout(List<bannerSliderModel> bannerSliderModelList){
            SliderAdapter sliderAdapter = new SliderAdapter(bannerSliderModelList);
            imageSlide.setImageListWithAdapter(sliderAdapter, bannerSliderModelList.size());

        }
    }

    public class HorizontalProductViewHolder extends RecyclerView.ViewHolder{

        TextView H_S_P_SeeAll_txt;
        TextView H_S_P_Title;
        RecyclerView H_S_P_RecyclerView;

        public HorizontalProductViewHolder(@NonNull View itemView) {
            super(itemView);
            H_S_P_SeeAll_txt = itemView.findViewById(R.id.H_S_P_SeeAll_txt);
            H_S_P_Title = itemView.findViewById(R.id.H_S_P_Title);
            H_S_P_RecyclerView = itemView.findViewById(R.id.H_S_P_RecyclerView);
            H_S_P_RecyclerView.setRecycledViewPool(recycledViewPool);
        }
        private void setHorizontalLayout(List<HorizontalScrollProductModel> horizontalScrollProductModelList,String hsp_title){
            H_S_P_Title.setText(hsp_title);

            if (horizontalScrollProductModelList.size() > 8) {
                H_S_P_SeeAll_txt.setVisibility(View.VISIBLE);
                H_S_P_SeeAll_txt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intentSeeAllbtn = new Intent(itemView.getContext(), SeeAllActivity.class);
                        intentSeeAllbtn.putExtra("layout_code",1);
                        intentSeeAllbtn.putExtra("Title",hsp_title);
                        itemView.getContext().startActivity(intentSeeAllbtn);
                    }
                });

                if (H_S_P_Title.equals("")){
                    H_S_P_SeeAll_txt.setVisibility(View.GONE);
                }
            } else {
                H_S_P_SeeAll_txt.setVisibility(View.INVISIBLE);
            }


            LinearLayoutManager H_S_P_linearLayoutManager = new LinearLayoutManager(itemView.getContext());
            H_S_P_linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            H_S_P_RecyclerView.setLayoutManager(H_S_P_linearLayoutManager);

            HorizontalScrollProductAdapter horizontalScrollProductAdapter = new HorizontalScrollProductAdapter(horizontalScrollProductModelList,false);
            H_S_P_RecyclerView.setAdapter(horizontalScrollProductAdapter);
            horizontalScrollProductAdapter.notifyDataSetChanged();


        }
    }
}
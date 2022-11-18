package com.example.flxvay.Models;

import androidx.annotation.NonNull;

import java.util.List;

public class HomePageModel {
    public static final int CATEGORY_ITEM =0;
    public static final int BANNER_SLIDER =1;
    public static final int HORIZONTAL_PRODUCT_VIEW =2;


    private int type ;

    ///category
    List<CategoryModel> categoryModelList;

//    public HomePageModel(int type,  List<CategoryModel> categoryModelList ) {
//        this.type = type;
//        this.categoryModelList = categoryModelList;
//    }

    public List<CategoryModel> getCategoryModelList() {
        return categoryModelList;
    }

    public void setCategoryModelList(List<CategoryModel> categoryModelList) {
        this.categoryModelList = categoryModelList;
    }
    ///category

    /////banner slider
    List<bannerSliderModel> bannerSliderModelList;

    public HomePageModel(int type,@NonNull List<bannerSliderModel> bannerSliderModelList,@NonNull List<CategoryModel> categoryModelList) {
        this.type = type;
        this.bannerSliderModelList = bannerSliderModelList;
        this.categoryModelList = categoryModelList;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<bannerSliderModel> getBannerSliderModelList() {
        return bannerSliderModelList;
    }

    public void setBannerSliderModelList(List<bannerSliderModel> bannerSliderModelList) {
        this.bannerSliderModelList = bannerSliderModelList;
    }
    /////banner slider

    ////horizontalProduct
    List<HorizontalScrollProductModel> horizontalScrollProductModelList;
    String H_P_title;

    public HomePageModel(int type, List<HorizontalScrollProductModel> horizontalScrollProductModelList, String h_P_title) {
        this.type = type;
        this.horizontalScrollProductModelList = horizontalScrollProductModelList;
        H_P_title = h_P_title;
    }

    public List<HorizontalScrollProductModel> getHorizontalScrollProductModelList() {
        return horizontalScrollProductModelList;
    }

    public void setHorizontalScrollProductModelList(List<HorizontalScrollProductModel> horizontalScrollProductModelList) {
        this.horizontalScrollProductModelList = horizontalScrollProductModelList;
    }

    public String getH_P_title() {
        return H_P_title;
    }

    public void setH_P_title(String h_P_title) {
        H_P_title = h_P_title;
    }

    ////horizontalProduct


}

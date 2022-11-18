package com.example.flxvay.Models;

public class bannerSliderModel {
    int banner_image_view;
    String banner_offers;
    String banner_button;

    public bannerSliderModel(int banner_image_view, String banner_offers) {
        this.banner_image_view = banner_image_view;
        this.banner_offers = banner_offers;
    }

    public int getBanner_image_view() {
        return banner_image_view;
    }

    public void setBanner_image_view(int banner_image_view) {
        this.banner_image_view = banner_image_view;
    }

    public String getBanner_offers() {
        return banner_offers;
    }

    public void setBanner_offers(String banner_offers) {
        this.banner_offers = banner_offers;
    }

    public String getBanner_button() {
        return banner_button;
    }

    public void setBanner_button(String banner_button) {
        this.banner_button = banner_button;
    }
}

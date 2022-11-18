package com.example.flxvay;

import static com.example.flxvay.MainActivity.ShowCart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


import com.afdhal_fa.imageslider.ImageSlider;

import com.example.flxvay.Adapters.ProductDetailSliderImageviewAdapter;
import com.example.flxvay.Adapters.ProductDetailsAdapter;

import com.example.flxvay.Models.Product_detail_sliderImageView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailActivity extends AppCompatActivity {

    ImageView back_arrow;
    ImageSlider imageSlide;
    ViewPager productDetailViewpager;
    TabLayout productDetailTabLayout;
    Button buy_now_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        Toolbar toolbar = findViewById(R.id.SeeAll_Toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);


        init();
        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        List<Product_detail_sliderImageView> product_detail_sliderImageViewList = new ArrayList<>();
        product_detail_sliderImageViewList.add(new Product_detail_sliderImageView(R.drawable.banner1));
        product_detail_sliderImageViewList.add(new Product_detail_sliderImageView(R.drawable.banner1));
        product_detail_sliderImageViewList.add(new Product_detail_sliderImageView(R.drawable.banner1));
        product_detail_sliderImageViewList.add(new Product_detail_sliderImageView(R.drawable.banner1));
        product_detail_sliderImageViewList.add(new Product_detail_sliderImageView(R.drawable.banner1));



        ProductDetailSliderImageviewAdapter sliderAdapter = new ProductDetailSliderImageviewAdapter(product_detail_sliderImageViewList);
        imageSlide.setImageListWithAdapter(sliderAdapter, product_detail_sliderImageViewList.size());


        productDetailViewpager.setAdapter(new ProductDetailsAdapter(getSupportFragmentManager(),productDetailTabLayout.getTabCount()));
        productDetailViewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(productDetailTabLayout));
        productDetailTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                productDetailViewpager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        buy_now_btn = findViewById(R.id.product_detail_buy_now);
        buy_now_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent AddressIntent = new Intent(ProductDetailActivity.this,AddAddressActivity.class);
                startActivity(AddressIntent);
            }
        });
    }

    private void init(){
        back_arrow = findViewById(R.id.SeeAll_Back_Arrow);
        imageSlide = findViewById(R.id.imageSlide_Product_Detail_Activity);
        productDetailViewpager =  findViewById(R.id.product_detail_ViewPager);
        productDetailTabLayout = (TabLayout) findViewById(R.id.product_detail_tabLayout);

    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.product_detail_icon_menu, menu);

        for(int i = 0; i < menu.size(); i++) {
            Drawable drawable = menu.getItem(i).getIcon();
            if (drawable != null) {
                drawable.mutate();
                drawable.setColorFilter(getResources().getColor(R.color.black_browen), PorterDuff.Mode.SRC_ATOP);
            }
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();


        if (id == R.id.search_Product_detail) {

            return true;
        }else if (id == R.id.Cart_Product_detail) {
            Intent cartIntent = new Intent(ProductDetailActivity.this,MainActivity.class);
            ShowCart = true;
            startActivity(cartIntent);

            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
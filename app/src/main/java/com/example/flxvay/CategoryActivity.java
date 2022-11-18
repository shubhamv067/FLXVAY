package com.example.flxvay;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.flxvay.Adapters.HomePageAdapter;
import com.example.flxvay.Adapters.HorizontalScrollProductAdapter;
import com.example.flxvay.Models.HomePageModel;
import com.example.flxvay.Models.HorizontalScrollProductModel;
import com.example.flxvay.Models.bannerSliderModel;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {

    ImageView back_arrow;

    ///home page recyclerView
    RecyclerView Category_RecyclerView;
    List<HomePageModel> homePageModelList;
    HomePageAdapter homePageAdapter;
    ///home page recyclerView



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        Toolbar toolbar = findViewById(R.id.order_detail_Toolbar);
        setSupportActionBar(toolbar);
       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String categoryNameIntent = getIntent().getStringExtra("Category_Name");
        getSupportActionBar().setTitle(categoryNameIntent);
        toolbar.setTitleTextColor(getResources().getColor(R.color.black_browen));

        init();
        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

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
        LinearLayoutManager HomePageLinearLayoutManager = new LinearLayoutManager(this);
        HomePageLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        Category_RecyclerView.setLayoutManager(HomePageLinearLayoutManager);

        homePageModelList = new ArrayList<>();
        homePageModelList.add(new HomePageModel(1,bannerSliderModelList, null));
        homePageModelList.add(new HomePageModel(2,horizontalScrollProductModelList,"Featured"));
        homePageModelList.add(new HomePageModel(2,horizontalScrollProductModelList,"Featured"));
        homePageModelList.add(new HomePageModel(2,horizontalScrollProductModelList,"Featured"));
        homePageModelList.add(new HomePageModel(2,horizontalScrollProductModelList,"Featured"));

        homePageAdapter = new HomePageAdapter(homePageModelList);
        Category_RecyclerView.setAdapter(homePageAdapter);
        homePageAdapter.notifyDataSetChanged();

        ///home page recyclerView


    }
    private void init() {
       back_arrow = findViewById(R.id.order_detail_Back_arrow);
        Category_RecyclerView = findViewById(R.id.Category_RecyclerView);
    }

        @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.search_icon_item, menu);

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


        if (id == R.id.search_icon_item) {

            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
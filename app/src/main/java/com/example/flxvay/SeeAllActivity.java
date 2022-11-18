package com.example.flxvay;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.flxvay.Adapters.CategoryAdapter;
import com.example.flxvay.Adapters.HorizontalScrollProductAdapter;
import com.example.flxvay.Models.CategoryModel;
import com.example.flxvay.Models.HorizontalScrollProductModel;

import java.util.ArrayList;
import java.util.List;

public class SeeAllActivity extends AppCompatActivity {
    ImageView back_arrow;
    RecyclerView SeeAll_RecyclerView;
    TextView Title;
    public static List<CategoryModel> categoryModelList;
    public static List<HorizontalScrollProductModel> horizontalScrollProductModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_all);

        back_arrow = findViewById(R.id.SeeAll_Back_Arrow);
        SeeAll_RecyclerView = findViewById(R.id.SeeAll_RecyclerView);
        Title = findViewById(R.id.SeeAll_Title);

        Toolbar toolbar = findViewById(R.id.SeeAll_Toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        int layout_code = getIntent().getIntExtra("layout_code",-1);
        String Title_Data = getIntent().getStringExtra("Title");


        if (layout_code == 0) {
            Title.setText(Title_Data);
            GridLayoutManager Category_gridLayoutManager = new GridLayoutManager(this,2);
            Category_gridLayoutManager.setOrientation(RecyclerView.VERTICAL);
            SeeAll_RecyclerView.setLayoutManager(Category_gridLayoutManager);

            categoryModelList = new ArrayList<>();
            categoryModelList.add(new CategoryModel(R.drawable.baby,"baby","#D7416565"));
            categoryModelList.add(new CategoryModel(R.drawable.beauty,"beauty","#D7416565"));
            categoryModelList.add(new CategoryModel(R.drawable.boy,"boy","#D7416565"));
            categoryModelList.add(new CategoryModel(R.drawable.boygirl,"boy_girl","#D7416565"));
            categoryModelList.add(new CategoryModel(R.drawable.cuple,"couple","#D7416565"));
            categoryModelList.add(new CategoryModel(R.drawable.femily,"family","#D7416565"));

            CategoryAdapter categoryAdapter = new CategoryAdapter(categoryModelList);
            SeeAll_RecyclerView.setAdapter(categoryAdapter);
            categoryAdapter.notifyDataSetChanged();
        }else if (layout_code == 1){

            Title.setText(Title_Data);
            GridLayoutManager Horizontal_gridLayoutManager = new GridLayoutManager(this,2);
            Horizontal_gridLayoutManager.setOrientation(RecyclerView.VERTICAL);
            SeeAll_RecyclerView.setLayoutManager(Horizontal_gridLayoutManager);

            horizontalScrollProductModelList = new ArrayList<>();
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
            ////HorizontalScrollProductLayout//////

            HorizontalScrollProductAdapter horizontalScrollProductAdapter = new HorizontalScrollProductAdapter(horizontalScrollProductModelList,false);
            SeeAll_RecyclerView.setAdapter(horizontalScrollProductAdapter);
            horizontalScrollProductAdapter.notifyDataSetChanged();

        }
    }
}
package com.example.flxvay.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flxvay.CategoryActivity;
import com.example.flxvay.Models.CategoryModel;
import com.example.flxvay.R;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    List<CategoryModel> categoryModelList;

    public CategoryAdapter(List<CategoryModel> categoryModelList) {
        this.categoryModelList = categoryModelList;
    }


    @NonNull
    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_one_item_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.ViewHolder holder, int position) {
        String Category_item_title = categoryModelList.get(position).getCategory_Name();
        int category_image = categoryModelList.get(position).getCategory_image();
        String image_color = categoryModelList.get(position).getColor();

        holder.setData(category_image,Category_item_title,image_color);

    }

    @Override
    public int getItemCount() {
//        if (categoryModelList.size() > 3) {
//            return 3;
//        } else {
//            return categoryModelList.size();
//        }
       return categoryModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView Category_item_title;
        private ImageView category_image;
        private View image_color;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            Category_item_title = itemView.findViewById(R.id.Category_item_title);
            category_image = itemView.findViewById(R.id.Category_Image);
            image_color = itemView.findViewById(R.id.Image_color);
        }
        private void setData(int Category_image,String Category_Title,String category_image_color){
            category_image.setImageResource(Category_image);
            Category_item_title.setText(Category_Title);
            image_color.setBackgroundColor(Color.parseColor(category_image_color));

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent CategoryIntent =  new Intent(itemView.getContext(), CategoryActivity.class);
                    CategoryIntent.putExtra("Category_Name",Category_Title);
                    itemView.getContext().startActivity(CategoryIntent);
                }
            });

        }
    }
}

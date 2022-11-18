package com.example.flxvay.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flxvay.Models.Product_detail_sliderImageView;
import com.example.flxvay.R;

import java.util.List;

public class ProductDetailSliderImageviewAdapter extends RecyclerView.Adapter<ProductDetailSliderImageviewAdapter.ViewHolder> {

    List<Product_detail_sliderImageView> product_detail_sliderImageViewList;


    public ProductDetailSliderImageviewAdapter(List<Product_detail_sliderImageView> product_detail_sliderImageViewList) {
        this.product_detail_sliderImageViewList = product_detail_sliderImageViewList;
    }

    @NonNull
    @Override
    public ProductDetailSliderImageviewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_detail_item_imageview_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductDetailSliderImageviewAdapter.ViewHolder holder, int position) {
        int banner_img = product_detail_sliderImageViewList.get(position).getImageView_slider();

        holder.setProduct_detail_slider_image_data(banner_img);
    }

    @Override
    public int getItemCount() {
        return product_detail_sliderImageViewList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView product_detail_slider_image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            product_detail_slider_image = itemView.findViewById(R.id.Product_Detail_Item_imageView);
        }

        private void setProduct_detail_slider_image_data(int banner_image) {
            product_detail_slider_image.setImageResource(banner_image);
        }
    }
}

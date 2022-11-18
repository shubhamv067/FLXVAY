package com.example.flxvay.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flxvay.Models.bannerSliderModel;
import com.example.flxvay.R;

import java.util.List;

public class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.ViewHolder> {

    List<bannerSliderModel> bannerSliderModelList;

    public SliderAdapter(List<bannerSliderModel> bannerSliderModelList) {
        this.bannerSliderModelList = bannerSliderModelList;
    }

    @NonNull
    @Override
    public SliderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.banner_slider_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SliderAdapter.ViewHolder holder, int position) {
        int banner_img = bannerSliderModelList.get(position).getBanner_image_view();
        String banner_offer = bannerSliderModelList.get(position).getBanner_offers();
        //String banner_btn = bannerSliderModelList.get(position).getBanner_button();

        holder.setdata(banner_img,banner_offer);


    }

    @Override
    public int getItemCount() {
        return bannerSliderModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView banner_product_image;
        TextView banner_product_offer;
        TextView banner_shop_now_btn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            banner_product_image = itemView.findViewById(R.id.banner_product_image);
            banner_product_offer = itemView.findViewById(R.id.banner_product_offer);
            banner_shop_now_btn = itemView.findViewById(R.id.banner_shop_now_btn);
        }
        private void setdata(int banner_image,String banner_text){
            banner_product_image.setImageResource(banner_image);
            banner_product_offer.setText(banner_text);
            banner_shop_now_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(itemView.getContext(), "buy now click", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}

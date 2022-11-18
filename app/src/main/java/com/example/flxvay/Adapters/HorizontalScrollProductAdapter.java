package com.example.flxvay.Adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flxvay.Models.HorizontalScrollProductModel;
import com.example.flxvay.ProductDetailActivity;
import com.example.flxvay.R;
import com.example.flxvay.SeeAllActivity;

import java.util.List;

public class HorizontalScrollProductAdapter extends RecyclerView.Adapter<HorizontalScrollProductAdapter.ViewHolder> {

    List<HorizontalScrollProductModel> horizontalScrollProductModelList;
     boolean FromFavorite;

    public HorizontalScrollProductAdapter(List<HorizontalScrollProductModel> horizontalScrollProductModelList,boolean fromFavorite) {
        this.horizontalScrollProductModelList = horizontalScrollProductModelList;
        this.FromFavorite = fromFavorite;
    }

    @NonNull
    @Override
    public HorizontalScrollProductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontalscrollproductitem,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalScrollProductAdapter.ViewHolder holder, int position) {
    int ProductImage = horizontalScrollProductModelList.get(position).getProductImage();
    String ProductPrice = horizontalScrollProductModelList.get(position).getProductPrice();
    String ProductTitle = horizontalScrollProductModelList.get(position).getProductTitle();

    holder.setHorizontalData(ProductImage,ProductPrice,ProductTitle);

    }

    @Override
    public int getItemCount() {
//        if (horizontalScrollProductModelList.size() > 8){
//            return 8;
//        }else {
//            return horizontalScrollProductModelList.size();
//        }
       return horizontalScrollProductModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView H_S_P_I_Product_Image;
        TextView H_S_P_I_Price;
        TextView H_S_P_I_Title;
        ImageView H_S_P_I_Product_fav_remove_btn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            H_S_P_I_Product_Image = itemView.findViewById(R.id.H_S_P_I_Product_Image);
            H_S_P_I_Price = itemView.findViewById(R.id.H_S_P_I_Price);
            H_S_P_I_Title = itemView.findViewById(R.id.H_S_P_I_Title);
            H_S_P_I_Product_fav_remove_btn = itemView.findViewById(R.id.delet_fav_btn);


        }
        private void setHorizontalData(int ProductImage,String ProductPrice,String ProductTitle){
            H_S_P_I_Product_Image.setImageResource(ProductImage);
            H_S_P_I_Price.setText(ProductPrice);
            H_S_P_I_Title.setText(ProductTitle);

            if (FromFavorite){
                H_S_P_I_Product_fav_remove_btn.setVisibility(View.VISIBLE);
                H_S_P_I_Product_fav_remove_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(itemView.getContext(), "delete fav", Toast.LENGTH_SHORT).show();
                    }
                });

            }else {
                H_S_P_I_Product_fav_remove_btn.setVisibility(View.GONE);
            }


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent ProductDetailActivityIntent = new Intent(itemView.getContext(), ProductDetailActivity.class);
                    itemView.getContext().startActivity(ProductDetailActivityIntent);
                }
            });
        }
    }
}

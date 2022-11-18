package com.example.flxvay.Adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.flxvay.Models.MyOrderModel;
import com.example.flxvay.OrderDetailActivity;
import com.example.flxvay.R;

import java.util.List;

public class MyOrderAdapter extends RecyclerView.Adapter<MyOrderAdapter.ViewHolder> {

    List<MyOrderModel> myOrderModelList;

    public MyOrderAdapter(List<MyOrderModel> myOrderModelList) {
        this.myOrderModelList = myOrderModelList;
    }

    @NonNull
    @Override
    public MyOrderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_order_item_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyOrderAdapter.ViewHolder holder, int position) {
        int imageView = myOrderModelList.get(position).getOrder_Image();
        String title = myOrderModelList.get(position).getOrder_Title();
        String shop_name = myOrderModelList.get(position).getOrder_Shop_Name();
        String price = myOrderModelList.get(position).getOrder_Price();

        holder.setOrderData(imageView,title,shop_name,price);
    }

    @Override
    public int getItemCount() {
        return myOrderModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView Oder_image;
        TextView Oder_title;
        TextView Oder_shop_name;
        TextView Oder_price;
        Button Order_Again_btn;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            Oder_image = itemView.findViewById(R.id.Order_ImageView);
            Oder_title = itemView.findViewById(R.id.Order_Title);
            Oder_shop_name = itemView.findViewById(R.id.Order_Shop_Name);
            Oder_price = itemView.findViewById(R.id.Order_Price);
            Order_Again_btn = itemView.findViewById(R.id.Order_Again_);
        }
        private void setOrderData(int Order_ImageView,String Order_Title,String Order_Shop_Name,String Order_Price){
            Oder_image.setImageResource(Order_ImageView);
            Oder_title.setText(Order_Title);
            Oder_shop_name.setText(Order_Shop_Name);
            Oder_price.setText(Order_Price);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent orderDetailIntent = new Intent(itemView.getContext(), OrderDetailActivity.class);
                    itemView.getContext().startActivity(orderDetailIntent);
                }
            });

        }
    }
}

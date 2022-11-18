package com.example.flxvay.Adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flxvay.AddressActivity;
import com.example.flxvay.Models.CartModel;
import com.example.flxvay.ProductDetailActivity;
import com.example.flxvay.R;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {

    List<CartModel> cartModelList;
    int count = 0;

    public CartAdapter(List<CartModel> cartModelList) {
        this.cartModelList = cartModelList;
    }

    @NonNull
    @Override
    public CartAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.ViewHolder holder, int position) {
        int imageView = cartModelList.get(position).getCart_Image();
        String title = cartModelList.get(position).getCart_Title();
        String shop_name = cartModelList.get(position).getCart_Shop_Name();
        String price = cartModelList.get(position).getCart_Price();

        holder.setCartData(imageView,title,shop_name,price);
    }

    @Override
    public int getItemCount() {
        return cartModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView cart_image;
        TextView cart_title;
        TextView cart_shop_name;
        TextView cart_price;
        TextView cart_Decrement;
        TextView cart_Increment;
        TextView Cart_No_Of_Product;
        ImageView cart_remove_btn;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cart_image = itemView.findViewById(R.id.Order_ImageView);
            cart_title = itemView.findViewById(R.id.Order_Title);
            cart_shop_name = itemView.findViewById(R.id.Order_Shop_Name);
            cart_price = itemView.findViewById(R.id.Order_Price);
            cart_Decrement = itemView.findViewById(R.id.order_detail_Decrement);
            cart_Increment = itemView.findViewById(R.id.Cart_Increment);
            Cart_No_Of_Product = itemView.findViewById(R.id.Cart_No_Of_Product);
            cart_remove_btn = itemView.findViewById(R.id.Cart_Remove_Button);
        }
        private void setCartData(int Cart_ImageView,String Cart_Title,String Cart_Shop_Name,String Cart_Price){
           cart_image.setImageResource(Cart_ImageView);
           cart_title.setText(Cart_Title);
           cart_shop_name.setText(Cart_Shop_Name);
           cart_price.setText(Cart_Price);


           cart_Increment.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   count++;
                   SetText();
               }
           });


            cart_Decrement.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    count--;
                    SetText();
                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent AddressIntent = new Intent(itemView.getContext(), ProductDetailActivity.class);
                    itemView.getContext().startActivity(AddressIntent);
                }
            });

        }
        private void SetText(){
            Cart_No_Of_Product.setText(String.valueOf(count));
            if (count < 1){
                count = 1;
                Cart_No_Of_Product.setText(String.valueOf(count));
            }else if (count == 6){
                count = 1;
                Cart_No_Of_Product.setText(String.valueOf(count));
            }

        }
    }
}

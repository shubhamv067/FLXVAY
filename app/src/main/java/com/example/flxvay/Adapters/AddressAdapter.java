package com.example.flxvay.Adapters;

import static com.example.flxvay.AddressActivity.refreshitem;
import static com.example.flxvay.CheckoutActivity.SELECT_ADDRESS;
import static com.example.flxvay.UI.SettingsFragment.MANAGE_ADDRESS;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flxvay.Models.AddressModel;
import com.example.flxvay.R;

import java.util.List;

public class AddressAdapter extends RecyclerView.Adapter<AddressAdapter.ViewHolder> {
    List<AddressModel> addressModelList;
    private int MODE;
    private int priSelectedPosition = -1;


    public AddressAdapter(List<AddressModel> addressModelList, int MODE) {
        this.addressModelList = addressModelList;
        this.MODE = MODE;
    }


    @NonNull
    @Override
    public AddressAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_detail_address_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AddressAdapter.ViewHolder holder, int position) {
        String address = addressModelList.get(position).getAddress();
        Boolean Selected = addressModelList.get(position).getSelected();
        holder.setData(address, position,Selected);

    }

    @Override
    public int getItemCount() {
        return addressModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView address;
        RadioButton Address_radio_Button;
        ImageView Icon;
        LinearLayout option_container;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            address = itemView.findViewById(R.id.order_detail_Address);
            Address_radio_Button = itemView.findViewById(R.id.Address_radio_Button);
            Icon = itemView.findViewById(R.id.menu_icon);
            option_container = itemView.findViewById(R.id.option_container);
        }

        private void setData(String Address, int position, Boolean Selected) {
            address.setText(Address);


            if (MODE == SELECT_ADDRESS) {
                Address_radio_Button.setVisibility(View.VISIBLE);
                Address_radio_Button.setEnabled(true);
                if (Selected) {
                    option_container.setVisibility(View.GONE);
                    Icon.setVisibility(View.GONE);
                    Address_radio_Button.setChecked(true);
                    priSelectedPosition = position;
                } else {
                    Address_radio_Button.setChecked(false);
                }
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (priSelectedPosition != position) {
                            addressModelList.get(position).setSelected(true);
                            addressModelList.get(priSelectedPosition).setSelected(false);
                            refreshitem(priSelectedPosition, position);
                            priSelectedPosition = position;
                        }
                    }
                });


            }else if (MODE == MANAGE_ADDRESS){
                Address_radio_Button.setVisibility(View.GONE);
                option_container.setVisibility(View.GONE);
                Icon.setVisibility(View.VISIBLE);
                Icon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        option_container.setVisibility(View.VISIBLE);
                        refreshitem(priSelectedPosition, priSelectedPosition);
                        priSelectedPosition = position;
                    }
                });

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        refreshitem(priSelectedPosition, priSelectedPosition);
                        priSelectedPosition = -1;
                    }
                });

            }
        }
    }
}

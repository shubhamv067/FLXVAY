package com.example.flxvay.Adapters;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flxvay.Models.SelectedSizeModel;
import com.example.flxvay.R;

import java.util.List;

public class SelectedSizeAdapter extends RecyclerView.Adapter<SelectedSizeAdapter.ViewHolder> {


    private int lastPosition = -1;
    int row_index = -1;

    List<SelectedSizeModel> selectedSizeModelList;

    public SelectedSizeAdapter(List<SelectedSizeModel> selectedSizeModelList) {
        this.selectedSizeModelList = selectedSizeModelList;
    }

    @NonNull
    @Override
    public SelectedSizeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.selected_size_container_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SelectedSizeAdapter.ViewHolder holder, int position) {
        String size_name = selectedSizeModelList.get(position).getSize_Name();

        holder.setSizeData(size_name,position);


        setAnimations(position,holder.itemView);

    }

    @Override
    public int getItemCount() {
        return selectedSizeModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        View view_container;
        TextView size_text;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view_container = itemView.findViewById(R.id.view_container);
            size_text = itemView.findViewById(R.id.Size_text);
        }
        private void setSizeData(String size_name , int position){
            size_text.setText(size_name);
            view_container.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    row_index = position;
                    notifyDataSetChanged();
                }
            });

            if (row_index == position){
               view_container.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#667EEA")));
                size_text.setTextColor(itemView.getResources().getColor(R.color.white));
                view_container.setElevation(10.0f);
                size_text.setElevation(11.0f);
            }else {
               view_container.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#F3F3F3")));
               // size_text.setTextColor(ContextCompat.getColor(itemView.getContext(), R.color.black));
                size_text.setTextColor(itemView.getResources().getColor(R.color.black));
                view_container.setElevation(1.0f);
                size_text.setElevation(2.0f);
            }



        }
    }

    private void setAnimations(int position,View viewToAnimate) {

        if (position > lastPosition) {
            //TranslateAnimation anim = new TranslateAnimation(0,-1000,0,-1000);
            ScaleAnimation anim = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            //anim.setDuration(new Random().nextInt(501));//to make duration random number between [0,501)
            anim.setDuration(550);//to make duration random number between [0,501)
            viewToAnimate.startAnimation(anim);
            lastPosition = position;

        }
    }
}

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

import com.example.flxvay.Models.SelectedColorModel;
import com.example.flxvay.Models.SelectedSizeModel;
import com.example.flxvay.R;

import java.util.List;

public class SelectedColorAdapter extends RecyclerView.Adapter<SelectedColorAdapter.ViewHolder> {


    private int lastPosition = -1;
    int row_index = -1;

    List<SelectedColorModel> selectedColorModelList;

    public SelectedColorAdapter(List<SelectedColorModel> selectedColorModelList) {
        this.selectedColorModelList = selectedColorModelList;
    }

    @NonNull
    @Override
    public SelectedColorAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.selected_color_item_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SelectedColorAdapter.ViewHolder holder, int position) {
        String Color_selected = selectedColorModelList.get(position).getSelected_Color();

        holder.setColorData(Color_selected,position);


        setAnimations(position,holder.itemView);

    }

    @Override
    public int getItemCount() {
        return selectedColorModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        View view_container;
        View view_container_border;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view_container = itemView.findViewById(R.id.view_selected_color_container);
            view_container_border = itemView.findViewById(R.id.view_selected_color_container_border);
        }
        private void setColorData(String Color_Selected , int position){
            view_container.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(Color_Selected)));
            view_container.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    row_index = position;
                    notifyDataSetChanged();
                }
            });

            if (row_index == position){
                view_container_border.setBackground(ContextCompat.getDrawable(itemView.getContext(), R.drawable.corner_transparent_bg));
                view_container.setElevation(11.0f);
                view_container_border.setElevation(10.0f);
            }else {
                view_container_border.setBackground(ContextCompat.getDrawable(itemView.getContext(), R.drawable.search_bg));

                view_container.setElevation(2.0f);
                view_container_border.setElevation(0.0f);
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

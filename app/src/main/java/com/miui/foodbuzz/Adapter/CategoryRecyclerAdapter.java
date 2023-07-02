package com.miui.foodbuzz.Adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryRecyclerAdapter {

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView categoryItemImage;
        TextView categoryItemText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}

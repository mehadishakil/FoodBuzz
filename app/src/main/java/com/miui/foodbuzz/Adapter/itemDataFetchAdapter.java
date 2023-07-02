package com.miui.foodbuzz.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.miui.foodbuzz.R;
import com.miui.foodbuzz.dataFetch.responseModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class itemDataFetchAdapter extends RecyclerView.Adapter<itemDataFetchAdapter.myviewholder> {

    List<responseModel>data;

    public itemDataFetchAdapter(List<responseModel> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public itemDataFetchAdapter.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.display_item_design, parent, false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull itemDataFetchAdapter.myviewholder holder, int position) {
        holder.title.setText(data.get(position).getTitle());
        holder.price.setText(data.get(position).getPrice());

        // Picasso.get().load("http://10.0.2.2/foodbuzz/popular/"+data.get(position)).into(holder.image);
        Glide.with(holder.image.getContext()).load("http://10.0.2.2/foodbuzz/popular/"+data.get(position).getImage()).into(holder.image);
        // Picasso.get().load(data.get(position).getImage()).placeholder(R.drawable.ic_launcher_background).fit().into(holder.image);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder {
        TextView title, price;
        ImageView image;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.id_itemTitle);
            price = itemView.findViewById(R.id.id_itemPrice);
            image = itemView.findViewById(R.id.id_itemImage);
        }
    }
}

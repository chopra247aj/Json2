package com.example.json2;

import android.app.Activity;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;

import java.util.List;

public class RecycleAdapt extends RecyclerView.Adapter<RecycleAdapt.ViewHolder>
{

    Activity context;
    List<Category> list;
    public RecycleAdapt(Activity context, List<Category> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = context.getLayoutInflater().inflate(R.layout.recycle_layout,parent,false);
        ViewHolder holder =new ViewHolder(v);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Categories pojoData = list.get(position).getCategories();
       holder.Id.setText(pojoData.getId()+"");
        holder.login.setText(pojoData.getName());
        //Glide.with(context).load(pojoData.getAvatarUrl()).into(holder.img);
    }


    @Override
    public int getItemCount() {
        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView login,Id;
        ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            Id= itemView.findViewById(R.id.Id);
            login= itemView.findViewById(R.id.Login);
            img = itemView.findViewById(R.id.image);
        }

    }
}

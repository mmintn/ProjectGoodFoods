package com.example.goodfoods.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.goodfoods.R;
import com.example.goodfoods.room_db.menu;

import java.util.List;

public class adapterRecyclerView extends RecyclerView.Adapter<adapterRecyclerView.MyViewHolder>{

    private Context mContext;
    private int mLayoutResId;
    private List<menu> menuItemList;


    public adapterRecyclerView(Context mContext, int mLayoutResId, List<menu> menuItemList) {
        this.mContext = mContext;
        this.mLayoutResId = mLayoutResId;
        this.menuItemList = menuItemList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(mLayoutResId, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        menu item  = menuItemList.get(position);

        holder.menu=item;
        holder.nameTextView.setText(item.name);
        holder.amountTextView.setText(String.valueOf(item.amount));

    }

    @Override
    public int getItemCount() {
        return menuItemList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView nameTextView;
        private TextView amountTextView;
        private menu menu;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            this.nameTextView = itemView.findViewById(R.id.food_name_text_view);
            this.amountTextView = itemView.findViewById(R.id.textView2);


        }
    }
}

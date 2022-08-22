package com.example.madlabminiproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder>
{
    ArrayList<Items> itemList;
    Context context;
    RecyclerView rv;
    final View.OnClickListener onClickListener = new MyOnClickListener();
    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        EditText name,contact,bloodgroup;
        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            name= itemView.findViewById(R.id.rname);
            contact = itemView.findViewById(R.id.rcontact);
            bloodgroup = itemView.findViewById(R.id.rbloodgroup);
        }
    }
    public ItemsAdapter(Context context, ArrayList<Items> itemList, RecyclerView rv)
    {
        this.context = context;
        this.itemList = itemList;
        this.rv = rv;
    }
    @NonNull
    @Override
    public ItemsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row,parent,false);
        view.setOnClickListener(onClickListener);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull ItemsAdapter.ViewHolder holder, int position)
    {
        Items item = itemList.get(position);
        holder.name.setText(item.getName());
        holder.contact.setText(item.getBloodgroup());
        holder.bloodgroup.setText(item.getContact());
    }
    @Override
    public int getItemCount() {
        return itemList.size();
    }
    public class MyOnClickListener implements View.OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            int itemPosition = rv.getChildLayoutPosition(v);
            String item = itemList.get(itemPosition).getName();
            Toast.makeText(context,item,Toast.LENGTH_LONG).show();
        }
    }
}
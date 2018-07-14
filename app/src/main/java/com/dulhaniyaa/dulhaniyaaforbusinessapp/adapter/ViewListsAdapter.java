package com.dulhaniyaa.dulhaniyaaforbusinessapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dulhaniyaa.dulhaniyaaforbusinessapp.R;
import com.dulhaniyaa.dulhaniyaaforbusinessapp.activities.ViewlistsDescription;
import com.dulhaniyaa.dulhaniyaaforbusinessapp.bean.VendorViews;

import java.util.ArrayList;

public class ViewListsAdapter extends RecyclerView.Adapter<ViewListsAdapter.MyViewViewlistsHolder> {

    private ArrayList<VendorViews> vendorViewArrayList;
    Context context;
    ArrayList<String> arrayList = new ArrayList<>();

    public ViewListsAdapter(Context context, ArrayList<VendorViews> homeResponseArrayList) {
        this.context = context;
        this.vendorViewArrayList = vendorViewArrayList;

    }

    @NonNull
    @Override
    public ViewListsAdapter.MyViewViewlistsHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View itemview = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_viewlist, viewGroup, false);
        return new MyViewViewlistsHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewListsAdapter.MyViewViewlistsHolder holder, final int position) {

        holder.profile_pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ViewlistsDescription.class);
                intent.putExtra("profile_pic", vendorViewArrayList.get(position).getPictureUrl());
                intent.putExtra("name", vendorViewArrayList.get(position).getName());
                intent.putExtra("email", vendorViewArrayList.get(position).getEmail());
                intent.putExtra("phone", vendorViewArrayList.get(position).getPhone());
                intent.putExtra("vuv_id", vendorViewArrayList.get(position).getId());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewViewlistsHolder extends RecyclerView.ViewHolder {

        ImageView profile_pic;
        TextView name, email, phone;

        public MyViewViewlistsHolder(@NonNull View itemView) {
            super(itemView);

            profile_pic = itemView.findViewById(R.id.profile_pic);
            name =  itemView.findViewById(R.id.name);
            email = itemView.findViewById(R.id.email);
            phone = itemView.findViewById(R.id.phone);

        }
    }


}

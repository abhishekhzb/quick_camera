package com.quickcamera.android.adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.quickcamera.android.R;
import com.quickcamera.android.pojo.FolderPojo;
import com.quickcamera.android.utils.Constants;
import com.quickcamera.android.utils.ProjectUtils;

import java.util.ArrayList;


public class FolderRecyclerAdapter extends RecyclerView.Adapter<FolderRecyclerAdapter.MyViewHolder> {
    Context context;
    ArrayList<FolderPojo> list;
    String path = "/storage/emulated/0/QuickScan/";
    ProjectUtils utils;


    public FolderRecyclerAdapter(Context context, ArrayList<FolderPojo> list) {
        this.context = context;
        this.list =list;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.folders_row, parent, false);
        utils = new ProjectUtils(context);
        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        if(list.get(position)!=null){
            final FolderPojo pojo = list.get(position);
            holder.textView.setText(list.get(position).getName());


            holder.delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if( utils.deleteFiles(Constants.PATH+pojo.getName())){
                        Log.e("DELETE","YES -->      "+Constants.PATH+pojo.getName());
                        list.remove(position);
                        notifyItemRemoved(position);
                        notifyItemRangeChanged(position, list.size());
                    }else{
                        Log.e("DELETE","NO -->       "+Constants.PATH+pojo.getName());
                    }
                }
            });


        }



    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView,delete;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textview_folder);
            delete = itemView.findViewById(R.id.delete_btn);
        }
    }




}

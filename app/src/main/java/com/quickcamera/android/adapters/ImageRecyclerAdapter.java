package com.quickcamera.android.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.quickcamera.android.R;
import com.quickcamera.android.activity.CameraActivity;
import com.quickcamera.android.pojo.ImageModel;

import java.io.File;
import java.util.ArrayList;


public class ImageRecyclerAdapter extends RecyclerView.Adapter<ImageRecyclerAdapter.MyViewHolder> {
    Context context;
    ArrayList<ImageModel> list;


    public ImageRecyclerAdapter(Context context, ArrayList<ImageModel> list) {
        this.context = context;
        this.list =list;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_row, parent, false);
        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        if(list.get(position)!=null){
         //   Bitmap bitmap = ImageUtils.getInstant().getCompressedBitmap(list.get(position).getUri());
           // Bitmap bitmap = ImageUtils.getInstant().getResizedBitmap(list.get(position).getBitmap(),100);
          //  holder.imageView.setImageBitmap(bitmap);
            Bitmap  bitmap0 = BitmapFactory.decodeFile(list.get(position).getUri());
          //  Bitmap bitmap = ImageUtils.getInstant().getCompressedBitmap(list.get(position).getUri());
           // holder.imageView.setImageBitmap(bitmap);
           // holder.imageView.setImageBitmap(list.get(position).getBitmap());
         //   holder.imageView.setRotation(holder.imageView.getRotation()- 270f);

            //holder.imageView.setRotation(holder.imageView.getRotation()- 90f);

            Glide.with(context)
                    .load(new File(list.get(position).getUri())) // Uri of the picture
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .skipMemoryCache(true)
                    .into(holder.imageView);

        }





//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                lastSelectedPosition = position;
//                ((AllReviewsActivity) context).selectedCall(list.get(position).getActualTxt());
//                notifyDataSetChanged();
//            }
//        });
//
//        if (lastSelectedPosition == position) {
//            holder.linearLayout.setBackgroundResource(R.drawable.bg_edittext_selected_icon);
//        } else {
//            holder.linearLayout.setBackgroundResource(R.drawable.bg_edittext_icon);
//        }

    }

    @Override
    public int getItemCount() {
       // return list.size();
       /* if (list.size()>5){
            return 5;
        }*/
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
        }
    }




}

package com.example.projetoapollo.activity.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetoapollo.R;
import com.google.android.material.imageview.ShapeableImageView;

public class ImagePagerAdapter extends RecyclerView.Adapter<ImagePagerAdapter.ImageViewHolder> {

    private static final int VIEW_TYPE_HOTEL = 0;
    private static final int VIEW_TYPE_TURISMO = 1;

    private int[] imageResources;
    private Context context;

    public ImagePagerAdapter(Context context, int[] imageResources) {
        this.context = context;
        this.imageResources = imageResources;
    }

    @Override
    public int getItemViewType(int position) {
        // Determine the type of image (hotel or tourism) based on its position or resource
        if (isTourismImage(imageResources[position])) {
            return VIEW_TYPE_TURISMO;
        } else {
            return VIEW_TYPE_HOTEL;
        }
    }

    private boolean isTourismImage(int resourceId) {
        // Add logic to determine if the image is a tourism image
        return resourceId == R.drawable.tourist_sp1 || resourceId == R.drawable.tourist_sp2 || resourceId == R.drawable.tourist_sp3;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == VIEW_TYPE_HOTEL) {
            view = LayoutInflater.from(context).inflate(R.layout.item_image_hotel, parent, false);
        } else {
            view = LayoutInflater.from(context).inflate(R.layout.item_image_turismo, parent, false);
        }
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        holder.imageView.setImageResource(imageResources[position]);
    }

    @Override
    public int getItemCount() {
        return imageResources.length;
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder {
        ShapeableImageView imageView;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.itemImage);
        }
    }
}

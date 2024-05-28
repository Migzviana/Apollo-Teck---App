package com.example.projetoapollo.activity.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetoapollo.R;

public class ImagesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private int[] imageResources;
    private static final int VIEW_TYPE_LARGE = 0;
    private static final int VIEW_TYPE_SMALL = 1;

    public ImagesAdapter(Context context, int[] imageResources) {
        this.context = context;
        this.imageResources = imageResources;
    }

    @Override
    public int getItemViewType(int position) {
        // Define the view type based on the position
        if (position == 0 || position == 1) {
            return VIEW_TYPE_LARGE;
        } else {
            return VIEW_TYPE_SMALL;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        if (viewType == VIEW_TYPE_LARGE) {
            View view = inflater.inflate(R.layout.item_image_large, parent, false);
            return new LargeImageViewHolder(view);
        } else {
            View view = inflater.inflate(R.layout.item_image_small, parent, false);
            return new SmallImageViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int imageResId = imageResources[position];
        if (holder instanceof LargeImageViewHolder) {
            ((LargeImageViewHolder) holder).imageView.setImageResource(imageResId);
        } else {
            ((SmallImageViewHolder) holder).imageView.setImageResource(imageResId);
        }
    }

    @Override
    public int getItemCount() {
        return imageResources.length;
    }

    static class LargeImageViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        LargeImageViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageViewItem);
        }
    }

    static class SmallImageViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        SmallImageViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageViewItem);
        }
    }
}



package com.example.projetoapollo.activity.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.projetoapollo.R;

public class BrasiliaFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_brasilia, container, false);

        // Set OnClickListeners for hotel images
        int[] hotelImageIds = {R.id.imgHotelBrasilia1, R.id.imgHotelBrasilia2, R.id.imgHotelBrasilia3, R.id.imgHotelBrasilia4};
        int[] hotelImages = {R.drawable.hotel_brasilia1, R.drawable.hotel_brasilia2, R.drawable.hotel_brasilia3, R.drawable.hotel_brasilia4};
        setImageClickListeners(view, hotelImageIds, hotelImages);

        // Set OnClickListeners for tourist images
        int[] touristImageIds = {R.id.imgTouristBrasilia1, R.id.imgTouristBrasilia2, R.id.imgTouristBrasilia3, R.id.imgTouristBrasilia4};
        int[] touristImages = {R.drawable.tourist_brasilia1, R.drawable.tourist_brasilia2, R.drawable.tourist_brasilia3, R.drawable.tourist_brasilia4};
        setImageClickListeners(view, touristImageIds, touristImages);

        return view;
    }

    private void setImageClickListeners(View view, int[] imageIds, int[] imageResIds) {
        for (int i = 0; i < imageIds.length; i++) {
            final int imageResId = imageResIds[i];
            ImageView imageView = view.findViewById(imageIds[i]);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ImageDialogFragment.newInstance(imageResId).show(getParentFragmentManager(), "imageDialog");
                }
            });
        }
    }
}


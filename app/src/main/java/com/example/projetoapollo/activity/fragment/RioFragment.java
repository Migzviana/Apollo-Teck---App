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

public class RioFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_brasilia, container, false);

        int[] hotelImageIds = {R.id.imgHotelRio1, R.id.imgHotelRio2, R.id.imgHotelRio3, R.id.imgHotelRio4};
        int[] hotelImages = {R.drawable.hotel_rio1, R.drawable.hotel_rio2, R.drawable.hotel_rio3, R.drawable.hotel_rio4};
        setImageClickListeners(view, hotelImageIds, hotelImages);

        int[] touristImageIds = {R.id.imgTouristRio1, R.id.imgTouristRio2, R.id.imgTouristRio3, R.id.imgTouristRio4};
        int[] touristImages = {R.drawable.tourist_Rio1, R.drawable.tourist_Rio2, R.drawable.tourist_Rio3, R.drawable.tourist_Rio4};
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
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

public class SaoPauloFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_brasilia, container, false);

        int[] hotelImageIds = {R.id.imgHotelSP1, R.id.imgHotelSP2, R.id.imgHotelSP3, R.id.imgHotelSP4};
        int[] hotelImages = {R.drawable.hotel_sp1, R.drawable.hotel_sp2, R.drawable.hotel_sp3, R.drawable.hotel_brasilia4};
        setImageClickListeners(view, hotelImageIds, hotelImages);

        int[] touristImageIds = {R.id.imgTouristSP1, R.id.imgTouristSP2, R.id.imgTouristSP3, R.id.imgTouristSP};
        int[] touristImages = {R.drawable.tourist_sp1, R.drawable.tourist_sp2, R.drawable.tourist_sp3, R.drawable.tourist_sp4};
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

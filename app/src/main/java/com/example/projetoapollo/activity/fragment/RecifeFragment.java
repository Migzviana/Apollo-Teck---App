package com.example.projetoapollo.activity.fragment;

import com.example.projetoapollo.R;

public class RecifeFragment extends BaseImageFragment {

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_recife;
    }

    @Override
    protected int[] getImageViewIds() {
        return new int[] {R.id.hotelre1, R.id.hotelre2, R.id.hotelre3, R.id.turismore1, R.id.turismore2, R.id.turismore3};
    }

    @Override
    protected int[] getImageResources() {
        return new int[] {R.drawable.hotel_recife2, R.drawable.hotel_recife5, R.drawable.hotel_recife1, R.drawable.tourist_recife1, R.drawable.tourist_recife2, R.drawable.tourist_recife3};
    }
}

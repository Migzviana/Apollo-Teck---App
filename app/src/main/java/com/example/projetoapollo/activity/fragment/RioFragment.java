package com.example.projetoapollo.activity.fragment;

import com.example.projetoapollo.R;

public class RioFragment extends BaseImageFragment {

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_rio;
    }

    @Override
    protected int[] getImageViewIds() {
        return new int[] {R.id.hotelrio1, R.id.hotelrio2, R.id.hotelrio3, R.id.turismorio1, R.id.turismorio2, R.id.turismorio3};
    }

    @Override
    protected int[] getImageResources() {
        return new int[] {R.drawable.hotel_rio1, R.drawable.hotel_rio2, R.drawable.hotel_rio3, R.drawable.tourist_rio1, R.drawable.tourist_rio2, R.drawable.tourist_rio3};
    }
}

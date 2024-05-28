package com.example.projetoapollo.activity.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.projetoapollo.R;
import com.example.projetoapollo.activity.fragment.ImageDialogFragment;

public class RioFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rio, container, false);

        // Referências aos GridLayouts
        GridLayout gridLayoutHotels = view.findViewById(R.id.gridLayoutHotels);
        GridLayout gridLayoutTourist = view.findViewById(R.id.gridLayoutTourist);

        // Arrays de IDs e imagens para hotéis
        int[] hotelImages = {R.drawable.hotel_rio1, R.drawable.hotel_rio2, R.drawable.hotel_rio3, R.drawable.hotel_rio4};
        addImagesToGridLayout(gridLayoutHotels, hotelImages);

        // Arrays de IDs e imagens para pontos turísticos
        int[] touristImages = {R.drawable.tourist_rio1, R.drawable.tourist_rio2, R.drawable.tourist_rio3, R.drawable.tourist_rio4};
        addImagesToGridLayout(gridLayoutTourist, touristImages);

        return view;
    }

    private void addImagesToGridLayout(GridLayout gridLayout, int[] imageResIds) {
        for (final int imageResId : imageResIds) {
            ImageView imageView = new ImageView(getContext());
            imageView.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            ));
            imageView.setImageResource(imageResId);
            imageView.setPadding(8, 8, 8, 8);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ImageDialogFragment.newInstance(imageResId).show(getParentFragmentManager(), "imageDialog");
                }
            });
            gridLayout.addView(imageView);
        }
    }
}

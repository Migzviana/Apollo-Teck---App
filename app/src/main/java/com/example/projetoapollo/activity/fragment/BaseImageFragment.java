package com.example.projetoapollo.activity.fragment;

import android.app.Dialog;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewpager2.widget.ViewPager2;
import com.example.projetoapollo.R;
import com.example.projetoapollo.activity.adapters.ImagePagerAdapter;

public abstract class BaseImageFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutResId(), container, false);

        int[] imageViewIds = getImageViewIds();
        for (int i = 0; i < imageViewIds.length; i++) {
            ImageView imageView = view.findViewById(imageViewIds[i]);
            final int position = i;
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showImagesModal(position);
                }
            });
        }

        return view;
    }

    private void showImagesModal(int initialPosition) {
        Dialog dialog = new Dialog(getActivity(), R.style.TemaDialog);
        dialog.setContentView(R.layout.dialog_images_pager);

        ViewPager2 viewPager = dialog.findViewById(R.id.viewPager);
        int[] images = getImageResources();
        ImagePagerAdapter adapter = new ImagePagerAdapter(getActivity(), images);
        viewPager.setAdapter(adapter);

        // Set the initial position
        viewPager.setCurrentItem(initialPosition, false);

        dialog.show();
    }

    protected abstract int getLayoutResId();

    protected abstract int[] getImageViewIds();

    protected abstract int[] getImageResources();
}

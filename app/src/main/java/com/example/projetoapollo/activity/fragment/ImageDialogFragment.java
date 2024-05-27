package com.example.projetoapollo.activity.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import com.example.projetoapollo.R;

public class ImageDialogFragment extends DialogFragment {

    private static final String ARG_IMAGE_RES_ID = "image_res_id";

    public static ImageDialogFragment newInstance(int imageResId) {
        ImageDialogFragment fragment = new ImageDialogFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_IMAGE_RES_ID, imageResId);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image_dialog, container, false);
        ImageView imageView = view.findViewById(R.id.imageView);
        int imageResId = getArguments().getInt(ARG_IMAGE_RES_ID);
        imageView.setImageResource(imageResId);
        return view;
    }
}


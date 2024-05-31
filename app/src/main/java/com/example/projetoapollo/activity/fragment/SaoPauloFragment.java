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


import com.example.projetoapollo.R;
import com.google.android.material.imageview.ShapeableImageView;

public class SaoPauloFragment extends Fragment {

    private String city = "SaoPaulo"; // Defina a cidade baseada na sua lógica

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sao_paulo, container, false);

        // Configurar listeners para os ImageViews
        view.findViewById(R.id.imageView1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showImagesModal();
            }
        });

        view.findViewById(R.id.imageView2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showImagesModal();
            }
        });

        view.findViewById(R.id.imageView3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showImagesModal();
            }
        });

        view.findViewById(R.id.imageView4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showImagesModal();
            }
        });

        view.findViewById(R.id.imageView5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showImagesModal();
            }
        });

        view.findViewById(R.id.imageView6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showImagesModal();
            }
        });

        return view;
    }

    private void showImagesModal() {
        Dialog dialog = new Dialog(getActivity());

        int layoutId;
        switch (city) {
            case "SaoPaulo":
                layoutId = R.layout.dialog_sao_paulo;
                break;
            case "Brasilia":
                layoutId = R.layout.dialog_brasilia;
                break;
            case "RioDeJaneiro":
                layoutId = R.layout.dialog_rio;
                break;
            default:
                layoutId = R.layout.dialog_sao_paulo;
                break;
        }
        dialog.setContentView(layoutId);

        switch (city) {
            case "SaoPaulo":
                ((ShapeableImageView) dialog.findViewById(R.id.modalImage1)).setImageResource(R.drawable.hotel_sp4);
                ((ShapeableImageView) dialog.findViewById(R.id.modalImage2)).setImageResource(R.drawable.hotel_sp1);
                ((ShapeableImageView) dialog.findViewById(R.id.modalImage3)).setImageResource(R.drawable.hotel_sp2);
                ((ShapeableImageView) dialog.findViewById(R.id.modalImage4)).setImageResource(R.drawable.tourist_sp1);
                ((ShapeableImageView) dialog.findViewById(R.id.modalImage5)).setImageResource(R.drawable.tourist_sp2);
                ((ShapeableImageView) dialog.findViewById(R.id.modalImage6)).setImageResource(R.drawable.tourist_sp3);
                break;
            case "Brasilia":
                ((ShapeableImageView) dialog.findViewById(R.id.modalImage1)).setImageResource(R.drawable.hotel_brasilia1);
                ((ShapeableImageView) dialog.findViewById(R.id.modalImage2)).setImageResource(R.drawable.hotel_brasilia2);
                // Definir outras imagens para Brasília
                break;
            case "RioDeJaneiro":
                ((ShapeableImageView) dialog.findViewById(R.id.modalImage1)).setImageResource(R.drawable.hotel_rio1);
                ((ShapeableImageView) dialog.findViewById(R.id.modalImage2)).setImageResource(R.drawable.hotel_rio2);
                // Definir outras imagens para Rio de Janeiro
                break;
        }

        dialog.show();
    }
}


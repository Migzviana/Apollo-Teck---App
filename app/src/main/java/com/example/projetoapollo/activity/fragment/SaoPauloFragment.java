package com.example.projetoapollo.activity.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;


import com.example.projetoapollo.R;
import com.example.projetoapollo.activity.activity.PagamentoActivity;

public class SaoPauloFragment extends BaseImageFragment {

    private AppCompatButton buttonTelaCompra;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_sao_paulo;
    }

    @Override
    protected int[] getImageViewIds() {
        return new int[] {
                R.id.hotelsp1, R.id.hotelsp2, R.id.hotelsp3,
                R.id.turismosp1, R.id.turismosp2, R.id.turismosp3
        };
    }

    @Override
    protected int[] getImageResources() {
        return new int[] {
                R.drawable.hotel_sp4, R.drawable.hotel_sp1, R.drawable.hotel_sp2,
                R.drawable.tourist_sp1, R.drawable.tourist_sp2, R.drawable.tourist_sp3
        };
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);

        buttonTelaCompra = view.findViewById(R.id.buttontelaCompra);
        buttonTelaCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPurchaseScreen();
            }
        });

        return view;
    }

    private void openPurchaseScreen() {
        Intent intent = new Intent(getActivity(), PagamentoActivity.class);
        intent.putExtra("packageName", "São Paulo");
        startActivity(intent);
    }
}

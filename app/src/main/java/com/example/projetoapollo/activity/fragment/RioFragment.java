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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetoapollo.R;
import com.example.projetoapollo.activity.adapters.ImagesAdapter;
import com.example.projetoapollo.activity.fragment.ImageDialogFragment;

public class RioFragment extends Fragment {

    private final int[] imageResources = {
            R.drawable.hotel_brasilia1,
            R.drawable.hotel_brasilia2,
            R.drawable.hotel_brasilia3,
            R.drawable.tourist_brasilia1,
            R.drawable.tourist_brasilia2,
            R.drawable.tourist_brasilia3,
            R.drawable.tourist_brasilia4
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_brasilia, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewImages);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2)); // Define 2 colunas
        ImagesAdapter adapter = new ImagesAdapter(getContext(), imageResources);
        recyclerView.setAdapter(adapter);

        return view;
    }
}

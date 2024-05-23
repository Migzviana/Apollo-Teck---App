package com.example.projetoapollo.activity.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetoapollo.R;
import com.example.projetoapollo.activity.activity.AdaptadorPacote;
import com.example.projetoapollo.activity.model.PacoteViagem;

import java.util.ArrayList;
import java.util.List;

public class ComprarPacotesFragment extends Fragment {

    private RecyclerView recyclerViewPacotes;
    private AdaptadorPacote pacoteAdapter;
    private List<PacoteViagem> listaPacotes;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_comprar_pacotes, container, false);

        recyclerViewPacotes = view.findViewById(R.id.recyclerViewPacotes);
        recyclerViewPacotes.setLayoutManager(new LinearLayoutManager(getContext()));

        listaPacotes = new ArrayList<>();
        listaPacotes.add(new PacoteViagem(R.drawable.sample_image, "R$ 1200,00", "7 dias"));
        listaPacotes.add(new PacoteViagem(R.drawable.sample_image, "R$ 1500,00", "10 dias"));
        listaPacotes.add(new PacoteViagem(R.drawable.sample_image, "R$ 2000,00", "14 dias"));

        pacoteAdapter = new AdaptadorPacote(getContext(), listaPacotes);
        recyclerViewPacotes.setAdapter(pacoteAdapter);

        return view;
    }
}


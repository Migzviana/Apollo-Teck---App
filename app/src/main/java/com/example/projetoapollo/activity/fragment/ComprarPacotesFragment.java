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
import com.example.projetoapollo.activity.activity.PacoteAdapter;
import com.example.projetoapollo.activity.model.PacoteViagem;

import java.util.ArrayList;
import java.util.List;

public class ComprarPacotesFragment extends Fragment {

    private RecyclerView recyclerViewPacotes;
    private PacoteAdapter pacoteAdapter;
    private List<PacoteViagem> listaPacotes;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_comprar_pacotes, container, false);

        recyclerViewPacotes = view.findViewById(R.id.recyclerViewPacotes);
        recyclerViewPacotes.setLayoutManager(new LinearLayoutManager(getContext()));

        listaPacotes = new ArrayList<>();
        listaPacotes.add(new PacoteViagem(R.drawable.brasilia, "Brasilia", "R$ 1500", "Tempo de Estadia: 5 dias"));
        listaPacotes.add(new PacoteViagem(R.drawable.rio_de_janeiro, "Rio de Janeiro", "R$ 2000", "Tempo de Estadia: 7 dias"));
        listaPacotes.add(new PacoteViagem(R.drawable.sao_paulo, "São Paulo", "R$ 1800", "Tempo de Estadia: 6 dias"));
        listaPacotes.add(new PacoteViagem(R.drawable.sample_image, "China", "2500", "Tempo de Estadia: 1 mês"));


        pacoteAdapter = new PacoteAdapter(getContext(), listaPacotes);
        recyclerViewPacotes.setAdapter(pacoteAdapter);

        return view;
    }
}


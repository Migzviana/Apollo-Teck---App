package com.example.projetoapollo.activity.activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetoapollo.R;
import com.example.projetoapollo.activity.adapters.AdaptadorCompra;
import com.example.projetoapollo.activity.fragment.ComprarPacotesFragment;
import com.example.projetoapollo.activity.model.PacoteCompra;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class PagamentoActivity extends AppCompatActivity implements AdaptadorCompra.AoClicarNoPacote {

    private RecyclerView recyclerView;
    private AdaptadorCompra adaptador;
    private List<PacoteCompra> listaPacotes;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            getWindow().setStatusBarColor(Color.BLACK);
        }

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        fragment = new ComprarPacotesFragment();
                        break;
                    case R.id.nav_comprar_pacotes:
                        fragment = new ComprarPacotesFragment();
                        break;
                    case R.id.nav_usuarios:
                        // Aqui você implementaria a lógica para abrir a tela de usuários
                        break;
                }

                if (fragment != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
                }

                drawerLayout.closeDrawers();
                return true;
            }
        });

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listaPacotes = new ArrayList<>();
        listaPacotes.add(new PacoteCompra("Econômica", 50));
        listaPacotes.add(new PacoteCompra("Executiva", 300));
        listaPacotes.add(new PacoteCompra("Primeira Classe", 400));

        adaptador = new AdaptadorCompra(this, listaPacotes, this);
        recyclerView.setAdapter(adaptador);
    }

    @Override
    public void aoClicarEmComprar(PacoteCompra pacoteModelo) {
        Toast.makeText(this, "Boleto para " + pacoteModelo.getTitulo() + ": R$ " + pacoteModelo.calcularPrecoTotal(), Toast.LENGTH_LONG).show();
        gerarBoleto(pacoteModelo);
    }

    private void gerarBoleto(PacoteCompra pacoteModelo) {
        double preco = pacoteModelo.calcularPrecoTotal();
        // Implemente a lógica para gerar o boleto
    }
}

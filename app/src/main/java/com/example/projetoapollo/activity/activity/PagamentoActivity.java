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
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import com.example.projetoapollo.R;
import com.example.projetoapollo.activity.adapters.AdaptadorCompra;
import com.example.projetoapollo.activity.fragment.ComprarPacotesFragment;
import com.example.projetoapollo.activity.fragment.HomeFragment;
import com.example.projetoapollo.activity.model.PacoteCompra;
import com.google.android.material.navigation.NavigationView;
import com.stripe.android.PaymentConfiguration;
import com.stripe.android.paymentsheet.PaymentSheet;
import com.stripe.android.paymentsheet.PaymentSheetResult;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PagamentoActivity extends AppCompatActivity implements AdaptadorCompra.AoClicarNoPacote {

    private RecyclerView recyclerView;
    private AdaptadorCompra adaptador;
    private List<PacoteCompra> listaPacotes;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    private PaymentSheet paymentSheet;
    private String paymentIntentClientSecret;

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

        PaymentConfiguration.init(
                getApplicationContext(),
                "pk_test_51POPkhDNyb8RcS3B3AwpXhyRCNT8HsyMS1hOKMTYCEB6LPQT7D7UWTxAp0rVNB8MAcOF4Sfn1ha0enp3ZlmrsrLn00kGBfZWO2"
        );

        paymentSheet = new PaymentSheet(this, this::onPaymentSheetResult);

        // Configurar o layout e a toolbar
        setupLayout();

        // Configurar o RecyclerView
        setupRecyclerView();
    }

    private void onPaymentSheetResult(PaymentSheetResult paymentSheetResult) {
    }

    private void setupLayout() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(item -> {
            Fragment fragment = null;
            switch (item.getItemId()) {
                case R.id.nav_home:
                    fragment = new HomeFragment(); // Substitua pelo seu fragmento real
                    break;
                case R.id.nav_comprar_pacotes:
                    fragment = new ComprarPacotesFragment();
                    break;
                case R.id.nav_usuarios:
                    // Implementar a lógica para abrir a tela de usuários
                    break;
            }

            if (fragment != null) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
            }

            drawerLayout.closeDrawers();
            return true;
        });
    }

    private void setupRecyclerView() {
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
        Toast.makeText(this, "Processando pagamento para " + pacoteModelo.getTitulo() + ": R$ " + pacoteModelo.calcularPrecoTotal(), Toast.LENGTH_LONG).show();
        createPaymentIntent(pacoteModelo);
    }

    private void createPaymentIntent(PacoteCompra pacoteModelo) {
        String url = "https://cf95-143-137-219-148.ngrok-free.app/create-payment-intent";
        try {
            JSONObject paymentData = new JSONObject();
            paymentData.put("amount", pacoteModelo.calcularPrecoTotal() * 100); // Stripe usa centavos
            paymentData.put("currency", "brl"); // Moeda brasileira

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                    Request.Method.POST,
                    url,
                    paymentData,
                    response -> {
                        try {
                            paymentIntentClientSecret = response.getString("clientSecret");
                            PaymentSheet.Configuration configuration = new PaymentSheet.Configuration.Builder("Exemplo de App")
                                    .defaultBillingDetails(new PaymentSheet.BillingDetails.Builder()
                                            .email("email@exemplo.com")
                                            .build())
                                    .build();
                            paymentSheet.presentWithPaymentIntent(paymentIntentClientSecret, configuration);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    },
                    error -> {
                        error.printStackTrace();
                        Toast.makeText(this, "Erro ao criar PaymentIntent", Toast.LENGTH_SHORT).show();
                    }
            );
            Volley.newRequestQueue(this).add(jsonObjectRequest);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}

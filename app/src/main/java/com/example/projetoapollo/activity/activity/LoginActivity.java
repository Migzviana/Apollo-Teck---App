package com.example.projetoapollo.activity.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.projetoapollo.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }








    public void Castrate(View view) {
        Intent i = new Intent(this, CadastroActivity.class);
        startActivity(i);
    }
    }

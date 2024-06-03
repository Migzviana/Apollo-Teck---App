package com.example.projetoapollo.activity.model;

public class PacoteCompra {
    private String titulo;
    private double precoBase;
    private boolean alimentacao;
    private boolean wifi;
    private boolean guia;
    private boolean acessibilidade;

    public PacoteCompra(String titulo, double precoBase) {
        this.titulo = titulo;
        this.precoBase = precoBase;
        this.alimentacao = false;
        this.wifi = false;
        this.guia = false;
        this.acessibilidade = false;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public void setAlimentacao(boolean alimentacao) {
        this.alimentacao = alimentacao;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    public void setGuia(boolean guia) {
        this.guia = guia;
    }

    public void setAcessibilidade(boolean acessibilidade) {
        this.acessibilidade = acessibilidade;
    }

    public double calcularPrecoTotal() {
        double precoTotal = precoBase;
        if (alimentacao) precoTotal += 35;
        if (wifi) precoTotal += 20;
        if (guia) precoTotal += 30;
        if (acessibilidade) precoTotal += 50;
        return precoTotal;
    }
}

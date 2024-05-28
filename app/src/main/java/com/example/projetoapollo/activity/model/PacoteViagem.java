package com.example.projetoapollo.activity.model;

public class PacoteViagem {

    private int imagemLocal;
    private String nomeLocal;
    private String valor;
    private String tempoEstadia;
    private int imageResourceId;

    public PacoteViagem(int imagemLocal, String nomeLocal, String valor, String tempoEstadia) {
        this.imagemLocal = imagemLocal;
        this.nomeLocal = nomeLocal;
        this.valor = valor;
        this.tempoEstadia = tempoEstadia;
        this.imageResourceId = imageResourceId;
    }

    public int getImagemLocal() {
        return imagemLocal;
    }

    public void setImagemLocal(int imagemLocal) {
        this.imagemLocal = imagemLocal;
    }

    public String getNomeLocal() {
        return nomeLocal;
    }

    public void setNomeLocal(String nomeLocal) {
        this.nomeLocal = nomeLocal;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getTempoEstadia() {
        return tempoEstadia;
    }

    public void setTempoEstadia(String tempoEstadia) {
        this.tempoEstadia = tempoEstadia;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}


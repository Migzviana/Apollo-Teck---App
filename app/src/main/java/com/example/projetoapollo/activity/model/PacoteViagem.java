package com.example.projetoapollo.activity.model;

public class PacoteViagem {

    private int imagemLocal;
    private String valor;
    private String tempoEstadia;

    private PacoteViagem(int imagemLocal, String valor, String tempoEstadia){
        this.imagemLocal = imagemLocal;
        this.valor = valor;
        this.tempoEstadia = tempoEstadia;
    }

    public int getImagemLocal() {
        return imagemLocal;
    }

    public void setImagemLocal(int imagemLocal) {
        this.imagemLocal = imagemLocal;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getTempoEstadia(){
        return tempoEstadia;
    }

    public void setTempoEstadia(String tempoEstadia) {
        this.tempoEstadia = tempoEstadia;
    }
}

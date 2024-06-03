package com.example.projetoapollo.activity.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetoapollo.R;
import com.example.projetoapollo.activity.model.PacoteCompra;

import java.util.List;

public class AdaptadorCompra extends RecyclerView.Adapter<AdaptadorCompra.PacoteViewHolder> {

    private Context contexto;
    private List<PacoteCompra> listaPacotes;
    private AoClicarNoPacote aoClicarNoPacote;

    public AdaptadorCompra(Context contexto, List<PacoteCompra> listaPacotes, AoClicarNoPacote aoClicarNoPacote) {
        this.contexto = contexto;
        this.listaPacotes = listaPacotes;
        this.aoClicarNoPacote = aoClicarNoPacote;
    }

    @NonNull
    @Override
    public PacoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(contexto).inflate(R.layout.item_pacote, parent, false);
        return new PacoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PacoteViewHolder holder, int position) {
        PacoteCompra pacoteModelo = listaPacotes.get(position);
        holder.tituloPacote.setText(pacoteModelo.getTitulo());
        holder.precoPacote.setText("R$ " + pacoteModelo.getPrecoBase());

        holder.checkboxAlimentacao.setOnCheckedChangeListener((buttonView, isChecked) -> {
            pacoteModelo.setAlimentacao(isChecked);
            holder.precoPacote.setText("R$ " + pacoteModelo.calcularPrecoTotal());
        });

        holder.checkboxWifi.setOnCheckedChangeListener((buttonView, isChecked) -> {
            pacoteModelo.setWifi(isChecked);
            holder.precoPacote.setText("R$ " + pacoteModelo.calcularPrecoTotal());
        });

        holder.checkboxGuia.setOnCheckedChangeListener((buttonView, isChecked) -> {
            pacoteModelo.setGuia(isChecked);
            holder.precoPacote.setText("R$ " + pacoteModelo.calcularPrecoTotal());
        });

        holder.checkboxAcessibilidade.setOnCheckedChangeListener((buttonView, isChecked) -> {
            pacoteModelo.setAcessibilidade(isChecked);
            holder.precoPacote.setText("R$ " + pacoteModelo.calcularPrecoTotal());
        });

        holder.botaoComprar.setOnClickListener(v -> aoClicarNoPacote.aoClicarEmComprar(pacoteModelo));
    }

    @Override
    public int getItemCount() {
        return listaPacotes.size();
    }

    public static class PacoteViewHolder extends RecyclerView.ViewHolder {
        TextView tituloPacote, precoPacote;
        CheckBox checkboxAlimentacao, checkboxWifi, checkboxGuia, checkboxAcessibilidade;
        Button botaoComprar;

        public PacoteViewHolder(@NonNull View itemView) {
            super(itemView);
            tituloPacote = itemView.findViewById(R.id.tituloPacote);
            precoPacote = itemView.findViewById(R.id.precoPacote);
            checkboxAlimentacao = itemView.findViewById(R.id.checkboxAlimentacao);
            checkboxWifi = itemView.findViewById(R.id.checkboxWifi);
            checkboxGuia = itemView.findViewById(R.id.checkboxGuia);
            checkboxAcessibilidade = itemView.findViewById(R.id.checkboxAcessibilidade);
            botaoComprar = itemView.findViewById(R.id.botaoComprar);
        }
    }

    public interface AoClicarNoPacote {
        void aoClicarEmComprar(PacoteCompra pacoteModelo);
    }
}

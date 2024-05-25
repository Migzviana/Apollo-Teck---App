package com.example.projetoapollo.activity.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.AppCompatButton;
import com.example.projetoapollo.R;
import com.example.projetoapollo.activity.model.PacoteViagem;

import java.util.List;

public class PacoteAdapter extends RecyclerView.Adapter<PacoteAdapter.PacoteViewHolder> {

    private Context context;
    private List<PacoteViagem> pacotes;

    public PacoteAdapter(Context context, List<PacoteViagem> pacotes) {
        this.context = context;
        this.pacotes = pacotes;
    }

    @NonNull
    @Override
    public PacoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_pacote_viagem, parent, false);
        return new PacoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PacoteViewHolder holder, int position) {
        PacoteViagem pacote = pacotes.get(position);
        holder.imageViewLocal.setImageResource(pacote.getImagemLocal());
        holder.textViewNomeLocal.setText(pacote.getNomeLocal());
        holder.textViewValor.setText(pacote.getValor());
        holder.textViewTempoEstadia.setText(pacote.getTempoEstadia());

        holder.buttonProsseguir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return pacotes.size();
    }

    public static class PacoteViewHolder extends RecyclerView.ViewHolder {

        ImageView imageViewLocal;
        TextView textViewNomeLocal;
        TextView textViewValor;
        TextView textViewTempoEstadia;
        AppCompatButton buttonProsseguir;

        public PacoteViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewLocal = itemView.findViewById(R.id.imageViewLocal);
            textViewNomeLocal = itemView.findViewById(R.id.textViewNomeLocal);
            textViewValor = itemView.findViewById(R.id.textViewValor);
            textViewTempoEstadia = itemView.findViewById(R.id.textViewTempoEstadia);
            buttonProsseguir = itemView.findViewById(R.id.buttonProsseguir);
        }
    }
}

package com.jrpascual.protodermcam.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jrpascual.protodermcam.R;
import com.jrpascual.protodermcam.activities.PacienteActivity;
import com.jrpascual.protodermcam.pojo.Cita;
import com.jrpascual.protodermcam.restApi.ConstantesRestApi;
import com.jrpascual.protodermcam.restApi.JsonKeys;

import java.util.ArrayList;

/**
 * Created by Eversor on 02/05/2017.
 */

public class CitaAdaptador extends RecyclerView.Adapter<CitaAdaptador.CitaViewHolder> {
    ArrayList<Cita> citas;
    Activity activity;

    public CitaAdaptador(ArrayList<Cita> lcitas, Activity activity){
        this.citas = lcitas;
        this.activity = activity;
    }

    @Override
    public CitaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_cita, parent,false);
        return  new CitaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CitaViewHolder holder, int position) {
        final Cita cita = citas.get(position);
        holder.tvNombrePac.setText(cita.getNombrePaciente());
        holder.tvNhc.setText(cita.getNhc());
        holder.tvFechaCita.setText(cita.getFechaHoraCita());
        holder.tvDiagnostico.setText(cita.getDiagnostico());
        holder.tvTipoCons.setText(cita.getTipoConsulta());
        // Al pulsar en la cita abrir la activity del paciente
        holder.tvFechaCita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity,PacienteActivity.class);
                intent.putExtra(JsonKeys.CITA_NHC, cita.getNhc());
                intent.putExtra(JsonKeys.CITA_FECHAHORA, cita.getFechaHoraCita());
                intent.putExtra(JsonKeys.CITA_NOMPAC, cita.getNombrePaciente());
                intent.putExtra(JsonKeys.CITA_DIAGNOSTICO, cita.getDiagnostico());
                intent.putExtra(JsonKeys.CITA_TIPOCONS, cita.getTipoConsulta());
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return citas.size();
    }

    public class CitaViewHolder extends RecyclerView.ViewHolder {
        private TextView tvNombrePac;
        private TextView tvTipoCons;
        private TextView tvFechaCita;
        private TextView tvNhc;
        private TextView tvDiagnostico;

        public CitaViewHolder(View itemView) {
            super(itemView);
            tvNombrePac = (TextView) itemView.findViewById(R.id.tvNombrePac);
            tvTipoCons = (TextView) itemView.findViewById(R.id.tvTipoCons);
            tvFechaCita = (TextView) itemView.findViewById(R.id.tvFechaCita);
            tvNhc = (TextView) itemView.findViewById(R.id.tvNhc);
            tvDiagnostico = (TextView) itemView.findViewById(R.id.tvDiagnostico);

        }
    }

}

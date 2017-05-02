package com.jrpascual.protodermcam.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.jrpascual.protodermcam.R;
import com.jrpascual.protodermcam.adapter.CitaAdaptador;
import com.jrpascual.protodermcam.pojo.Cita;
import com.jrpascual.protodermcam.restApi.EndPointsApi;
import com.jrpascual.protodermcam.restApi.adapter.RestApiAdapter;
import com.jrpascual.protodermcam.restApi.model.CitaResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CitasActivity extends AppCompatActivity {
    private ArrayList<Cita> citas;
    private RecyclerView listaCitas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citas);
        listaCitas = (RecyclerView) findViewById(R.id.rvCitas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaCitas.setLayoutManager(llm);
        obtenerCitas();
        //Toast.makeText(CitasActivity.this,"Se han cargado " + citas.size() + " citas." , Toast.LENGTH_SHORT).show();
       // inicializarAdaptador(citas);


    }


    public void obtenerCitas(){
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonCitas =  restApiAdapter.construyeGsonDeserializador();
        EndPointsApi endPointsApi =  restApiAdapter.establecerConexionRestApiMirth(gsonCitas);
        Call<CitaResponse> citaResponseCall = endPointsApi.getCitasUsuario();

        citaResponseCall.enqueue(new Callback<CitaResponse>() {
            @Override
            public void onResponse(Call<CitaResponse> call, Response<CitaResponse> response) {
                CitaResponse citaResponse =  response.body();
                CitasActivity.this.inicializarAdaptador(citaResponse.getCitas());
                //Toast.makeText(CitasActivity.this,"Se han cargado " + citas.size() + " citas. La primera: " + citas.get(1).getNhc() , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<CitaResponse> call, Throwable t) {
                Toast.makeText(CitasActivity.this,"Se produjo un error en la conexion", Toast.LENGTH_SHORT).show();
                Log.e("Error en conexion", t.toString());
            }
        });

    }


    public void inicializarAdaptador(ArrayList<Cita> citas){
        CitaAdaptador adaptador = new CitaAdaptador(citas,this);
        listaCitas.setAdapter(adaptador);
        //Toast.makeText(CitasActivity.this,"Se han cargado " + citas.size() + " citas." , Toast.LENGTH_SHORT).show();
    }
}

package com.jrpascual.protodermcam.activities;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;
import com.jrpascual.protodermcam.R;
import com.jrpascual.protodermcam.pojo.Cita;
import com.jrpascual.protodermcam.restApi.EndPointsApi;
import com.jrpascual.protodermcam.restApi.adapter.RestApiAdapter;
import com.jrpascual.protodermcam.restApi.model.CitaResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ArrayList<Cita> citas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Orientar en landscape
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        // Ocultar la barra de titulo
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        Button btLogin = (Button) findViewById(R.id.btLogin);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Al pulsar boton Siguiente, crear la nueva activity
                Intent intent = new Intent(MainActivity.this,CitasActivity.class);
                startActivity(intent);
            }
        });

    }


}

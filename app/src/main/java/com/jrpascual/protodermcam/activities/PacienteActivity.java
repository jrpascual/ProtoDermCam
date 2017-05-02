package com.jrpascual.protodermcam.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jrpascual.protodermcam.R;
import com.jrpascual.protodermcam.restApi.JsonKeys;

import java.io.File;

import static android.graphics.BitmapFactory.decodeFile;

public class PacienteActivity extends AppCompatActivity {

    private TextView tvNombrePac;
    private TextView tvNhc;
    private TextView tvFechora;
    private TextView tvDiagnostico;
    private TextView tvTipocons;

    double aleatorio = 0;
    private static final int TAKE_PICTURE = 1;
    private ImageButton btnCamara;
    private String foto;  // ruta local de la foto temporal

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paciente);

        //Recuperar datos del activity anterior

        Bundle extras      = getIntent().getExtras();
        String nombrePac      = extras.getString(JsonKeys.CITA_NOMPAC);
        String nhc      = extras.getString(JsonKeys.CITA_NHC);
        String fechora      = extras.getString(JsonKeys.CITA_FECHAHORA);
        String diagnostico      = extras.getString(JsonKeys.CITA_DIAGNOSTICO);
        String tipocons      = extras.getString(JsonKeys.CITA_TIPOCONS);

        tvNombrePac = (TextView) findViewById(R.id.tvPacienteNombrePac);
        tvNhc = (TextView) findViewById(R.id.tvPacienteNhc);
        tvFechora = (TextView) findViewById(R.id.tvPacienteFechaCita);
        tvDiagnostico = (TextView) findViewById(R.id.tvPacienteDiagnostico);
        tvTipocons = (TextView) findViewById(R.id.tvPacienteTipoCons);

        tvNombrePac.setText(nombrePac);
        tvNhc.setText(nhc);
        tvFechora.setText(fechora);
        tvDiagnostico.setText(diagnostico);
        tvTipocons.setText(tipocons);

        //Preparaar la ruta de almacenamiento local de la foto temporal
        aleatorio = new Double(Math.random() * 100).intValue();
        foto = Environment.getExternalStorageDirectory() + "/imagen"+ aleatorio +".jpg";
        //Boton de la camara hacer nueva foto
        btnCamara = (ImageButton) findViewById(R.id.ibPacienteCamara);
        btnCamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                Uri output = Uri.fromFile(new File(foto));
                intent.putExtra(MediaStore.EXTRA_OUTPUT, output);
                startActivityForResult(intent, TAKE_PICTURE);
            }
        });
        }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        ImageView iv = (ImageView) findViewById(R.id.ivPacienteFoto);
        iv.setImageBitmap(decodeFile(foto));
        File file = new File(foto);
        if (file.exists()) {
            // La foto se ha hecho
            Toast.makeText(getApplicationContext(), "La foto se ha almacenado solo en el dispositivo", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(getApplicationContext(), "No se aceptó la foto", Toast.LENGTH_SHORT).show();
    }
}

package com.martelopez.contactapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailContact extends AppCompatActivity {

    Button btnEditar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_contact);

        final Bundle parametros = getIntent().getExtras();

        String nombre       = parametros.getString(getResources().getString(R.string.pnombre));
        String fecha        = parametros.getString(getResources().getString(R.string.pfecha));
        String telefono     = parametros.getString(getResources().getString(R.string.ptelefono));
        String correo       = parametros.getString(getResources().getString(R.string.pcorreo));
        String descripcion  = parametros.getString(getResources().getString(R.string.pdescripcion));

        final TextView tvNombre       = (TextView) findViewById(R.id.tvNombre);
        final TextView tvFecha        = (TextView) findViewById(R.id.tvFecha);
        final TextView tvTelefono     = (TextView) findViewById(R.id.tvTelefono);
        final TextView tvCorreo       = (TextView) findViewById(R.id.tvCorreo);
        final TextView tvDescripcion  = (TextView) findViewById(R.id.tvDescripcion);

        btnEditar = (Button) findViewById(R.id.btnEditar);

        tvNombre.setText(nombre);
        tvFecha.setText(fecha);
        tvTelefono.setText(telefono);
        tvCorreo.setText(correo);
        tvDescripcion.setText(descripcion);

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}

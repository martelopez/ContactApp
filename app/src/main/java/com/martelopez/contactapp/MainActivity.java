package com.martelopez.contactapp;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout tilNombre, tilTelefono, tilCorreo, tilDescripcion;
    private EditText etNombre, etTelefono, etCorreo, etDescripcion;

    Button btnSiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tilNombre = (TextInputLayout) findViewById(R.id.tilNombre);
        tilTelefono = (TextInputLayout) findViewById(R.id.tilTelefono);
        tilCorreo = (TextInputLayout) findViewById(R.id.tilCorreo);
        tilDescripcion = (TextInputLayout) findViewById(R.id.tilDescripcion);

        etNombre = (EditText) findViewById(R.id.etNombre);
        etTelefono = (EditText) findViewById(R.id.etTelefono);
        etCorreo = (EditText) findViewById(R.id.etCorreo);
        etDescripcion = (EditText) findViewById(R.id.etDescripcion);

        btnSiguiente = (Button) findViewById(R.id.btnSiguiente);

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DetailContact.class);
                intent.putExtra(getResources().getString(R.string.pnombre), etNombre.getText().toString());
                intent.putExtra(getResources().getString(R.string.ptelefono), etTelefono.getText().toString());
                intent.putExtra(getResources().getString(R.string.pcorreo), etCorreo.getText().toString());
                intent.putExtra(getResources().getString(R.string.pdescripcion), etDescripcion.getText().toString());
                startActivity(intent);
            }
        });

    }
}

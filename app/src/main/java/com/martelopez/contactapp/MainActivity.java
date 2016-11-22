package com.martelopez.contactapp;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextInputLayout tilNombre, tilFecha, tilTelefono, tilCorreo, tilDescripcion;
    private EditText etNombre, etFecha, etTelefono, etCorreo, etDescripcion;

    Button btnSiguiente;

    private DatePickerDialog fechaDatePickerDialog;
    private SimpleDateFormat dateFormatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tilNombre       = (TextInputLayout) findViewById(R.id.tilNombre);
        tilFecha        = (TextInputLayout) findViewById(R.id.tilFecha);
        tilTelefono     = (TextInputLayout) findViewById(R.id.tilTelefono);
        tilCorreo       = (TextInputLayout) findViewById(R.id.tilCorreo);
        tilDescripcion  = (TextInputLayout) findViewById(R.id.tilDescripcion);

        dateFormatter = new SimpleDateFormat("dd-MM-yy", Locale.getDefault());

        etNombre = (EditText) findViewById(R.id.etNombre);
        etFecha  = (EditText) findViewById(R.id.etFecha);
        etTelefono = (EditText) findViewById(R.id.etTelefono);
        etCorreo = (EditText) findViewById(R.id.etCorreo);
        etDescripcion = (EditText) findViewById(R.id.etDescripcion);

        etFecha.setInputType(InputType.TYPE_NULL);
        etFecha.setOnClickListener(this);

        Calendar newCalendar = Calendar.getInstance();
        fechaDatePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener(){
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth){
                Calendar newDate = Calendar.getInstance();
                newDate.set(year,monthOfYear,dayOfMonth);
                etFecha.setText(dateFormatter.format(newDate.getTime()));
            }
        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));


        btnSiguiente = (Button) findViewById(R.id.btnSiguiente);

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DetailContact.class);
                intent.putExtra(getResources().getString(R.string.pnombre), etNombre.getText().toString());
                intent.putExtra(getResources().getString(R.string.pfecha), etFecha.getText().toString());
                intent.putExtra(getResources().getString(R.string.ptelefono), etTelefono.getText().toString());
                intent.putExtra(getResources().getString(R.string.pcorreo), etCorreo.getText().toString());
                intent.putExtra(getResources().getString(R.string.pdescripcion), etDescripcion.getText().toString());
                startActivity(intent);
            }
        });

    }

    @Override
    public void onClick(View view) {
        fechaDatePickerDialog.show();
    }
}

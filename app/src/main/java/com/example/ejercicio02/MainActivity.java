package com.example.ejercicio02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.ejercicio02.modelos.Nota;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final int AGREGAR_NOTA = 1;
    private LinearLayout contenedor;
    private Button btnAgregar;

    private ArrayList<Nota> listaNotas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contenedor=findViewById(R.id.contenedorMain);
        btnAgregar=findViewById(R.id.btnAgregarMain);
        listaNotas=new ArrayList<>();
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, AgregarActivity.class);
                startActivityForResult(intent,AGREGAR_NOTA);
            }
        });
    }
}
package com.example.ejercicio02;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == AGREGAR_NOTA && resultCode == RESULT_OK){
            if (data != null){
                Nota nota = data.getExtras().getParcelable("nota");
                listaNotas.add(nota);
                final int posicion= listaNotas.size()-1;

                TextView txtTitulo = new TextView(this);
                txtTitulo.setText(nota.getTitulo());
                txtTitulo.setTextSize(24);
                txtTitulo.setTextColor(Color.BLUE);
                LinearLayout.LayoutParams paramsTXT= new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT,3);
                paramsTXT.setMargins(15,15,15,15);
                txtTitulo.setLayoutParams(paramsTXT);
                txtTitulo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                Button button = new Button(this);
                button.setText("Eliminar");
                button.setBackgroundColor(Color.GREEN);
                LinearLayout.LayoutParams paramsBTN= new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT,1);
                paramsBTN.setMargins(15,15,15,15);
                button.setLayoutParams(paramsBTN);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        listaNotas.remove(posicion);
                        repintaNotas();
                    }
                });
                LinearLayout contenedorNota = new LinearLayout(this);
                contenedorNota.addView(txtTitulo);
                contenedorNota.addView(button);
                contenedor.addView(contenedorNota);
            }
        }
    }

    private void repintaNotas() {
        contenedor.removeAllViews();
        for (int i = 0; i <listaNotas.size() ; i++) {
            Nota nota = listaNotas.get(i);
            final int posicion= i;
            TextView txtTitulo = new TextView(this);
            txtTitulo.setText(nota.getTitulo());
            txtTitulo.setTextSize(24);
            txtTitulo.setTextColor(Color.BLUE);
            LinearLayout.LayoutParams paramsTXT= new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT,3);
            paramsTXT.setMargins(15,15,15,15);
            txtTitulo.setLayoutParams(paramsTXT);
            txtTitulo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            Button button = new Button(this);
            button.setText("Eliminar");
            button.setBackgroundColor(Color.GREEN);
            LinearLayout.LayoutParams paramsBTN= new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT,1);
            paramsBTN.setMargins(15,15,15,15);
            button.setLayoutParams(paramsBTN);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listaNotas.remove(posicion);
                    repintaNotas();
                }
            });
            LinearLayout contenedorNota = new LinearLayout(this);
            contenedorNota.addView(txtTitulo);
            contenedorNota.addView(button);
            contenedor.addView(contenedorNota);
        }
    }
}
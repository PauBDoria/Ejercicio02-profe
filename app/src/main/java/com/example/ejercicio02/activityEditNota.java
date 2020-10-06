package com.example.ejercicio02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ejercicio02.modelos.Nota;

public class activityEditNota extends AppCompatActivity {

    private EditText txtTitulo, txtContenido;
    private Button btnguardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_nota);
        txtTitulo=findViewById(R.id.txtTituloEdit);
        txtContenido=findViewById(R.id.txtContenidoEdit);
        btnguardar=findViewById(R.id.btnGuardarEdit);

        Nota nota = getIntent().getExtras().getParcelable("nota");
        final int posicion = getIntent().getExtras().getInt("pos");
        if (nota != null){
            txtTitulo.setText(nota.getTitulo());
            txtContenido.setText(nota.getContenido());
        }else{
            nota = new Nota();
        }

        final Nota finalNota = nota;
        btnguardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalNota.setTitulo(txtTitulo.getText().toString());
                finalNota.setContenido(txtContenido.getText().toString());
                Bundle bundle = new Bundle();
                bundle.putParcelable("nota",finalNota);
                bundle.putInt("pos",posicion);
                Intent intent=new Intent();
                intent.putExtras(bundle);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}
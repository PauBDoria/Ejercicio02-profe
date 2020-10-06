package com.example.ejercicio02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ejercicio02.modelos.Nota;

public class AgregarActivity extends AppCompatActivity {

    private EditText txtTitulo, txtContenido;
    private Button btnAgregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);
        txtTitulo=findViewById(R.id.txtTituloAgregar);
        txtContenido=findViewById(R.id.txtContenidoAgregar);
        btnAgregar=findViewById(R.id.btnGuardarAgregar);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!txtTitulo.getText().toString().isEmpty() && !txtContenido.getText().toString().isEmpty()){
                    Nota nota = new Nota(txtTitulo.getText().toString(), txtContenido.getText().toString());
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("nota",nota);
                    Intent intent= new Intent();
                    intent.putExtras(bundle);
                    setResult(RESULT_OK, intent);
                    finish();
                }else{
                    Toast.makeText(AgregarActivity.this,"Todos son obligatorios", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
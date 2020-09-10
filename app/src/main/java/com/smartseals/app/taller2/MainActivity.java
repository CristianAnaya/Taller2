package com.smartseals.app.taller2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button btnPendiente, btnCuadrante, btnPuntoMedio;
    EditText edtX1, edtX2, edtY1, edtY2;
    TextView txtResultado;
    double x1, x2, y1, y2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCuadrante = findViewById(R.id.btnCuadrante);
        btnPendiente = findViewById(R.id.btnPendiente);
        btnPuntoMedio = findViewById(R.id.btnPuntoMedio);
        edtX1 = findViewById(R.id.edtX1);
        edtX2 = findViewById(R.id.edtX2);
        edtY1 = findViewById(R.id.edtY1);
        edtY2 = findViewById(R.id.edtY2);
        txtResultado = findViewById(R.id.txtResultado);

        btnPuntoMedio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double resultado1 = x1+x2;
                double resultadoY = y1+y2;
                txtResultado.setText("("+String.valueOf(resultado1/2)+", "+String.valueOf(resultadoY/2)+")");
            }
        });

        btnPendiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double resultadoX = x1-x2;
                double resultadoY = y1-y2;

                txtResultado.setText(String.valueOf(resultadoY/resultadoX));

            }
        });

        btnCuadrante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {

            case R.id.btnAleatorio:
                Random Rand = new Random();
                x1 = Math.floor(Math.random()*1000) + 1;
                x2 = Math.floor(Math.random()*1000) + 1;
                y1 = Math.floor(Math.random()*1000) + 1;
                y2 = Math.floor(Math.random()*1000) + 1;

                x1 *= Math.floor(Math.random()*2) == 1 ? 1 : -1;
                x2 *= Math.floor(Math.random()*2) == 1 ? 1 : -1;
                y1 *= Math.floor(Math.random()*2) == 1 ? 1 : -1;
                y2 *= Math.floor(Math.random()*2) == 1 ? 1 : -1;

                edtX1.setText(String.valueOf(x1));
                edtX2.setText(String.valueOf(x2));
                edtY1.setText(String.valueOf(y1));
                edtY2.setText(String.valueOf(y2));
                break;
            case R.id.btnDistancia:
                double resultadoX = x2-x1;
                double resultadoXCuadrado = resultadoX * resultadoX;

                double resultadoY = y2-y1;
                double resultadoYCuadrado = resultadoY * resultadoY;

                double resultadoFinal = resultadoXCuadrado + resultadoYCuadrado;
                txtResultado.setText(String.valueOf(Math.sqrt(resultadoFinal)));
                break;

        }
        return super.onOptionsItemSelected(item);
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


}
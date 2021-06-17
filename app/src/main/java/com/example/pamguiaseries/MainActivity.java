package com.example.pamguiaseries;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void abrirSerie(View view){
        Intent intent = new Intent(this, WandaVision.class);
        startActivity(intent);
    }
    public void abrirEventos(View view){
        Intent eventos = new Intent(this, Eventos.class);
        startActivity(eventos);
    }
}
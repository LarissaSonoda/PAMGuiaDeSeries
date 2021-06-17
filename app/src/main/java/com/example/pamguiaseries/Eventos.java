package com.example.pamguiaseries;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Eventos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos);
    }

    //Método para voltar da tela de eventos para a Main Activity, que é a tela principal/inicial
    public void voltar(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void verLocal(View view){
        

    }
}
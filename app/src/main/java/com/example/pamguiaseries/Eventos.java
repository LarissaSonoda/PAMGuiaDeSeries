package com.example.pamguiaseries;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;

import java.util.GregorianCalendar;

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

    //método onClick para ver o local do evento CCXP
    public void verLocal(View view){
        Uri location = Uri.parse("geo:0,0?q=São+Paulo+Expo+-+Rod.+dos+Imigrantes+-+Vila+Água+Funda,+São+Paulo+-+SP");
        Intent mapaLocal = new Intent(Intent.ACTION_VIEW, location);
        startActivity(Intent.createChooser(mapaLocal, "Mapa"));
    }

    public void abrirAgenda(View view){
       Intent intent = new Intent(Intent.ACTION_INSERT);
        intent.setData(CalendarContract.Events.CONTENT_URI);
        startActivity(intent);
    }
}
package com.example.pamguiaseries;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class WandaVision extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wanda_vision);
    }
    public void sendMessage(View view){
        Intent voltar = new Intent(this, MainActivity.class);
        startActivity(voltar);
    }

    public void abrirTrailer(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/sj9J2ecsSpo"));
        startActivity(Intent.createChooser(browserIntent, "Abra o trailer"));
    }
    public void abrirDisney(View view){
        Intent watchSeries = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.disneyplus.com/pt-br/series/wandavision/4SrN28ZjDLwH"));
        startActivity(Intent.createChooser(watchSeries, "Abrir player"));
    }
}
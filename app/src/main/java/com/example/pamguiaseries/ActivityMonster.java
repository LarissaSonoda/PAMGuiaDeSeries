package com.example.pamguiaseries;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class ActivityMonster extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monster);
    }
    public void voltar(View view){
        Intent voltar = new Intent(this, MainActivity.class);
        startActivity(voltar);
    }
    public void abrirTrailer(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/msTB5r8nUHU"));
        startActivity(browserIntent);
    }
    public void abrirCrunchyroll(View view){
        Intent watchSeries = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.crunchyroll.com/interstitial/android"));
        startActivity(Intent.createChooser(watchSeries, "Abrir player"));
    }
}
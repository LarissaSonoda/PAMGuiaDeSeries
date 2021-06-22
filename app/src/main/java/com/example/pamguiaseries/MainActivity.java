package com.example.pamguiaseries;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

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

    //método para fazer a busca online de acordo com o que o usuário digitou
    public void search (View view){
        EditText tv_Pesquisa = (EditText) findViewById(R.id.edtPesquisa);
        tv_Pesquisa.getText();
        Intent busca = new Intent(Intent.ACTION_WEB_SEARCH);
        Editable pesq = tv_Pesquisa.getText();
        //convertendo o texto digitado (editable) para string para efetuar a busca
        String query = pesq.toString();
        busca.putExtra(SearchManager.QUERY, query);
        startActivity(busca);
    }

    public void abrirPerfil(View view){
        Intent perfil = new Intent(this, perfilUser.class);
        startActivity(perfil);
    }

    public void abrirAnime(View view){
        Intent monster=new Intent(this, ActivityMonster.class);
        startActivity(monster);
    }

}
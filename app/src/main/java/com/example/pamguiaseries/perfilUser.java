package com.example.pamguiaseries;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class perfilUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_user);
    }
    public void voltar(View view){
        Intent voltar = new Intent(this, MainActivity.class);
        startActivity(voltar);
    }
    public void btnSair(View view){
        Intent sair = new Intent(this, cadastro.class);
        startActivity(sair);
    }
}

package com.example.pamguiaseries;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class CommentsPro extends AppCompatActivity {

     EditText edtComment;
     EditText edtNomeSerie;
     Button button;
    private int EXTERNAL_STORAGE_PERMISSION_CODE = 23;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments_pro);

        edtNomeSerie = (EditText) findViewById(R.id.edtNome_serie2);
        edtComment = (EditText) findViewById(R.id.edtComment2);
        edtNomeSerie = (EditText) findViewById(R.id.edtNome_serie2);
        button = (Button) findViewById(R.id.btnSave2);


    }

    public void savePublicly(View view) {
        // Pede a permissão para acessar o armazenamento externo
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                EXTERNAL_STORAGE_PERMISSION_CODE);
        String editTextData = edtComment.getText().toString()+ " - " + edtNomeSerie.getText().toString();

        // getExternalStoragePublicDirectory() - Pega o diretório público de Downloads.
        File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);

        // Armazena os dados obtidos num arquivo nomeado comentario.txt
        File file = new File(folder, "comentario.txt");
        writeTextData(file, editTextData);
        edtComment.setText("");
    }


    private void writeTextData(File file, String data) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(data.getBytes());
            Toast.makeText(this, "Done" + file.getAbsolutePath(), Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void viewInformation(View view) {
        // Creating an intent to start a new activity
        Intent intent = new Intent(CommentsPro.this, VisualizarComments.class);
        startActivity(intent);
    }

    public void back(View view){
        Intent voltar = new Intent(this, perfilUser.class);
        startActivity(voltar);
    }

}
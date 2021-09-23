package com.example.pamguiaseries;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class seriesVistas extends AppCompatActivity {
    EditText edtNomeSerie;
    EditText edtComment;
   TextView edtFinal;
    SwitchCompat switcher;


    private static final String ARQUIVO_SERIES = "comments_serie.txt";
    private static final String KEY_COMMENTS = "commentsKey";
    Button button;
    private static final String FILE_NAME = "comentário.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_series_vistas);

        //Views da activity utilizadas na classe
        switcher = findViewById(R.id.switch1);
        edtComment = (EditText) findViewById(R.id.edtComment);
        button = (Button) findViewById(R.id.btnSave);

        //Método usado para carregar os valores gravados
            load(edtComment);
    }

    // ARMAZENAMENTO INTERNO

    public void save(View v){
        String text = edtComment.getText().toString();
        FileOutputStream fos = null;

        try{
            fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
            fos.write(text.getBytes());

            edtComment.getText().clear();
            Toast.makeText(this, "Seu comentário foi salvo!", Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException x){
            x.printStackTrace();
        } catch (IOException x){
            x.printStackTrace();
        } finally{
            if(fos != null){
                try{
                    fos.close();
                } catch (IOException x){
                    x.printStackTrace();
                }
            }
        }
    }
    public void load (View v) {
        FileInputStream y = null;

        try {
            y = openFileInput(FILE_NAME);
            InputStreamReader a = new InputStreamReader(y);
            BufferedReader b = new BufferedReader(a);
            StringBuilder c = new StringBuilder();
            String text;
            while ((text = b.readLine()) != null) {
                c.append(text).append("\n");
                edtComment.setText(c.toString());
            }
        } catch(FileNotFoundException x){
            x.printStackTrace();
        } catch(IOException x){
            x.printStackTrace();
        }finally{
            if(y != null){
                try {
                    y.close();
                } catch (IOException x) {
                    x.printStackTrace();
                }
            }
        }


    }
    public void switchClick(View v){
        if(switcher.isChecked()) {
            Intent it = new Intent(this, CommentsPro.class);
            startActivity(it);
        }

    }




}
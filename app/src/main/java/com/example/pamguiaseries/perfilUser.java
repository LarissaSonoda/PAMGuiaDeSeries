package com.example.pamguiaseries;

import android.app.Service;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class perfilUser extends AppCompatActivity implements SensorEventListener {
    TextView textView1;
    Button button;
    ImageView imageView;
    SensorEventListener sensorEventListener;
    SensorManager sensorManager;
    Sensor sensor;
    ConstraintLayout activity;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    ImageButton btn_voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_user);
        activity = (ConstraintLayout) findViewById(R.id.acPerfil);
        textView1=(TextView) findViewById(R.id.email_user);
        textView2=(TextView) findViewById(R.id.emailUser);
        textView3=(TextView) findViewById(R.id.username);
        textView4=(TextView) findViewById(R.id.nameUser);
        button=(Button) findViewById(R.id.btnsair);
        btn_voltar = (ImageButton) findViewById(R.id.btnVoltar4);
        imageView= (ImageView) findViewById(R.id.imgUser);
        sensorManager= (SensorManager) getSystemService(Service.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    public void voltar(View view){
        Intent voltar = new Intent(this, MainActivity.class);
        startActivity(voltar);
    }
    public void btnSair(View view){
        Intent sair = new Intent(this, cadastro.class);
        startActivity(sair);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType() == Sensor.TYPE_LIGHT){
            if(event.values[0] > 2000){
                textView1.setTextColor(getResources().getColor(R.color.white));
                textView2.setTextColor(getResources().getColor(R.color.white));
                textView3.setTextColor(getResources().getColor(R.color.white));
                textView4.setTextColor(getResources().getColor(R.color.white));
                activity.setBackgroundResource(R.color.bg2);
                button.setBackgroundColor(getResources().getColor(R.color.amarelo_darkmode));
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}

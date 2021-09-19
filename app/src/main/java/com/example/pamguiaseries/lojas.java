package com.example.pamguiaseries;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

public class lojas extends AppCompatActivity implements SensorEventListener, FetchAddressTask.OnTaskCompleted {
    // Arquivo shared preferences
    public static final String PREFERENCIAS_NAME = "com.example.android.localizacao";
    private static final String TRACKING_LOCATION_KEY = "tracking_location";
    // Constantes
    private static final int REQUEST_LOCATION_PERMISSION = 1;
    private static final String LATITUDE_KEY = "latitude";
    private static final String LONGITUDE_KEY = "longitude";
    private static final String LASTDATE_KEY = "data";

    // classes Location
    private boolean mTrackingLocation;

//Acelerometro

    private SensorManager sensorManager;

    private Sensor acelerometro;
    // Shared preferences
    private SharedPreferences mPreferences;
    private String lastLatitude = "";
    private String lastLongitude = "";
    private String lastAdress = "";
    private FusedLocationProviderClient mFusedLocationClient;
    private LocationCallback mLocationCallback;
    private TextView mLocationTextView;
    private WebView mWebView;
    private Button mLocationBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lojas);
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(
                this);
        mLocationTextView = (TextView) findViewById(R.id.infosLocal);
        mWebView = (WebView) findViewById(R.id.webView_lojas);
        mLocationBtn = (Button) findViewById(R.id.btn_buscarlojas);

        mLocationBtn.setOnClickListener(new View.OnClickListener() {
            /**
             * Toggle the tracking state.
             * @param v The track location button.
             */
            @Override
            public void onClick(View v) {
                if (!mTrackingLocation) {
                    iniciarLocal();
                } else {
                    pararLocal();
                }
            }
        });
        //recupera o sensor default e chama o meto de listagem de sensores
      //  sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
       // acelerometro = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

       // sensorManager.registerListener(this, acelerometro, SensorManager.SENSOR_DELAY_NORMAL);


    }


    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQUEST_LOCATION_PERMISSION:
                // Permissão garantida
                if (grantResults.length > 0
                        && grantResults[0]
                        == PackageManager.PERMISSION_GRANTED) {
                   iniciarLocal();
                } else {
                    Toast.makeText(this,
                            R.string.permissao_negada,
                            Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    private LocationRequest getLocationRequest() {
        LocationRequest locationRequest = new LocationRequest();
        locationRequest.setInterval(10000);
        locationRequest.setFastestInterval(5000);
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        return locationRequest;
    }

    @SuppressLint({"StringFormatInvalid", "StringFormatMatches"})
    private void iniciarLocal(){
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, REQUEST_LOCATION_PERMISSION);
        }else{
            mLocationTextView.setText(getString(R.string.endereco_text,
                    getString(R.string.loading), null, null,
                    System.currentTimeMillis()));

            String local_pesq = getString(R.string.endereco_text);
            local_pesq.replace(" ", "+");
           // Intent busca = new Intent(Intent.ACTION_WEB_SEARCH);
            //Uri localLoja = Uri.parse("https://www.google.com.br/search?q=lojas+geek+" + local_pesq);
            mWebView.loadUrl("https://www.google.com.br/search?q=lojas+geek+" + local_pesq);
        }
    }

    private void pararLocal() {
        if (mTrackingLocation) {
            mTrackingLocation = false;
            mLocationBtn.setText(R.string.cancel_busca);
        }
    }

    @Override
    public void onTaskCompleted(String[] result) {
        if (mTrackingLocation) {
            // Update the UI
            lastAdress = result[0];
            mLocationTextView.setText(getString(R.string.endereco_text,
                    lastAdress));
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
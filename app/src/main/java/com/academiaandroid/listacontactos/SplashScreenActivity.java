package com.academiaandroid.listacontactos;

//Aplicación Android en el que utilizamos un componente de tipo selección
//ListView para mostrar datos de contactos almacenados.
//
//academiaandroid.com
//
//by José Antonio Gázquez Rodríguez

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import java.util.Timer;
import java.util.TimerTask;


public class SplashScreenActivity extends Activity {

    private static final long SPLASH_SCREEN_DELAY = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash_screen);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);
    }
}

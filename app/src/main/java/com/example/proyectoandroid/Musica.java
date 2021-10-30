package com.example.proyectoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Musica extends AppCompatActivity {

    MediaPlayer mp;
    Button btnMusica, btnStop, btnPause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musica);

        btnMusica = (Button) findViewById(R.id.btnMusica);
        btnStop = (Button) findViewById(R.id.btnStop);
        btnPause = (Button)findViewById(R.id.btnPause);

        mp = MediaPlayer.create(this, R.raw.sagrado);

        btnMusica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.stop();
            }
        });

        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.pause();
            }
        });
    }
}
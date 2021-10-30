package com.example.proyectoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

    public void Registro(View view){
        Intent registro = new Intent(this, registro.class);
        startActivity(registro);
    }

    public void galeria(View view) {
        Intent galeria = new Intent(this, Galeria.class);
        startActivity(galeria);
    }

    public void video(View view) {
        Intent video = new Intent(this, Video.class);
        startActivity(video);
    }

    public void musica(View view) {
        Intent musica = new Intent(this, Musica.class);
        startActivity(musica);
    }

    public void mapa(View view) {
        Intent mapa = new Intent(this, MapsActivity.class);
        startActivity(mapa);
    }

    public void home(View view) {
        Intent home = new Intent(this, MainActivity.class);
        startActivity(home);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu mimenu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mimenu, mimenu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.main:
                galeria(null);
                return true;
            case R.id.video:
                video(null);
                return true;
            case R.id.audio:
                musica(null);
                return true;
            case R.id.mapa:
                mapa(null);
                return true;
            case R.id.home:
                home(null);
                return true;
            default:
                throw new IllegalStateException("Unexpected value: " + item.getItemId());
        }
    }
}
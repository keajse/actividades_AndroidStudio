package com.example.proyectoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
            default:
                throw new IllegalStateException("Unexpected value: " + item.getItemId());
        }
    }
}
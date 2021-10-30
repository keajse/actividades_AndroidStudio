package com.example.proyectoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class Video extends AppCompatActivity {

    VideoView videoView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);


        videoView = (VideoView) findViewById(R.id.videoView);

        //Insertar video desde Programa
        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.vivir));

        // create an object of media controller
        MediaController mediaController = new MediaController(this);
        // initiate a video view

        videoView.setMediaController(mediaController);
        videoView.requestFocus();
        videoView.start();

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
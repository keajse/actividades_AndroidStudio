package com.example.proyectoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.editTextUsuario);
        et2 = (EditText) findViewById(R.id.editTextContrasenia);
    }

    public void iniciar(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "users", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String identificacion = et1.getText().toString();
        Cursor fila = bd.rawQuery(
                "select identificacion  from usuarios where identificacion=" + identificacion, null);
        if (fila.moveToFirst()) {
            Toast.makeText(this, "Bienvenido",
                    Toast.LENGTH_SHORT).show();
                    galeria(null);

        } else
            Toast.makeText(this, "No existe una persona con dicha identificación",
                    Toast.LENGTH_SHORT).show();
        bd.close();

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

   /* @Override
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
    }*/
}
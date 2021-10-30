package com.example.proyectoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class registro extends AppCompatActivity {
    private EditText et1, et2, et3, et4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        et1 = (EditText) findViewById(R.id.editIden);
        et2 = (EditText) findViewById(R.id.editTexNombre);
        et3 = (EditText) findViewById(R.id.editTextCorreo);
        et4 = (EditText) findViewById(R.id.editTextUser);
    }

    public void registroDatos(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "users", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String identification = et1.getText().toString();
        String nombre = et2.getText().toString();
        String correo = et3.getText().toString();
        String usuario= et4.getText().toString();
        ContentValues registrar = new ContentValues();
        registrar.put("identificacion", identification);
        registrar.put("nombre", nombre);
        registrar.put("correo", correo);
        registrar.put("usuario", usuario);
        bd.insert("usuarios", null, registrar);
        bd.close();
        et1.setText("");
        et2.setText("");
        et3.setText("");
        et4.setText("");
        Toast.makeText(this, "Se cargaron los datos de la persona",
                Toast.LENGTH_SHORT).show();
    }

    public void Consultar(View view){
        Intent consultar = new Intent(this, Consulta.class);
        startActivity(consultar);
    }


}
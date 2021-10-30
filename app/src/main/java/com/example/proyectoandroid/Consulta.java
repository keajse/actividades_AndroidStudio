package com.example.proyectoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Consulta extends AppCompatActivity {
    private EditText et1, et2, et3, et4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);

        et1 = (EditText) findViewById(R.id.editIden);
        et2 = (EditText) findViewById(R.id.editTexNombre);
        et3 = (EditText) findViewById(R.id.editTextCorreo);
        et4 = (EditText) findViewById(R.id.editTextUser);
    }

    public void consulta(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "users", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String identificacion = et1.getText().toString();
        Cursor fila = bd.rawQuery(
                "select nombre,correo,usuario  from usuarios where identificacion=" + identificacion, null);
        if (fila.moveToFirst()) {
            et2.setText(fila.getString(0));
            et3.setText(fila.getString(1));
            et4.setText(fila.getString(2));
        } else
            Toast.makeText(this, "No existe una persona con dicha identificación",
                    Toast.LENGTH_SHORT).show();
        bd.close();

    }

    public void borrar(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "users", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String identificacion = et1.getText().toString();
        int cant = bd.delete("usuarios", "identificacion=" + identificacion, null);
        bd.close();
        et1.setText("");
        et2.setText("");
        et3.setText("");
        et4.setText("");
        if (cant == 1)
            Toast.makeText(this, "Se borró la persona con dicho documento",
                    Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "No existe una persona con dicho documento",
                    Toast.LENGTH_SHORT).show();
    }

    public void modificacion(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "users", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String identificacion = et1.getText().toString();
        String nombre = et2.getText().toString();
        String correo = et3.getText().toString();
        String usuario = et4.getText().toString();
        ContentValues registro = new ContentValues();
        registro.put("nombre", nombre);
        registro.put("correo", correo);
        registro.put("usuario", usuario);
        int cant = bd.update("usuarios", registro, "identificacion=" + identificacion, null);
        bd.close();
        if (cant == 1)
            Toast.makeText(this, "se modificaron los datos", Toast.LENGTH_SHORT)
                    .show();
        else
            Toast.makeText(this, "no existe una persona con dicho documento",
                    Toast.LENGTH_SHORT).show();
    }
}
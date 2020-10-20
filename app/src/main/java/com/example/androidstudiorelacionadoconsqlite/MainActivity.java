package com.example.androidstudiorelacionadoconsqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import Datos.ConexionSQLite;

public class MainActivity extends AppCompatActivity {
    Button btnAceptar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAceptar = findViewById(R.id.btnAceptar);

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConexionSQLite objConexion = new ConexionSQLite(getApplicationContext());
                SQLiteDatabase objBase = objConexion.getWritableDatabase();

                Log.i("Mensaje","Se creo la BD Perfectamente");
                String n="Jose Daniel";
                String p="Pascasio Calderon";
                String c="25-1670-2016";
                int e = 22;

                String consultSQL= "INSERT INTO Alumno(Carnet,Nombre,Apellido,Edad) VALUES('"+c+"','"+n+"','"+p+"',"+e+")";
                objBase.execSQL(consultSQL);

                Log.i("Sentencia INSERT",consultSQL);
                Log.i("Mensaje INSERT:","Se inserto correctamente");

                String consultaa = "SELECT * FROM Alumno";
                Cursor datos = objBase.rawQuery(consultaa,null);
                Log.i("Mensaje SELECT","Mostrando los registros almacenados en la tabla");
                while(datos.moveToNext()){
                    Log.i("Datos:","-----------------------------------------------------------------");
                    Log.i("Carnet:",datos.getString(0));
                    Log.i("Nombre:",datos.getString(1));
                    Log.i("Apellidos:",datos.getString(2));
                    Log.i("Edad:",datos.getString(3));
                    Log.i("FIN","REGISTROS MOSTRADOS");
                }
            }
        });
    }
}
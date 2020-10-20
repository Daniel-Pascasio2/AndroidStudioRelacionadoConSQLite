package Datos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ConexionSQLite extends SQLiteOpenHelper {

    public ConexionSQLite(@Nullable Context context) {
        super(context, DatosConexion.BD, null, DatosConexion.VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase bd) {
        String crearTb ="CREATE TABLE Alumno(" +
                "Carnet TEXT," +
                "Nombre TEXT," +
                "Apellido TEXT," +
                "Edad INTEGER);";
        bd.execSQL(crearTb);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

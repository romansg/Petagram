package com.romansg.petagram.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "mascotas";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLA_MASCOTA = "mascota";
    public static final String TABLA_MASCOTA_ID = "id";
    public static final String TABLA_MASCOTA_NOMBRE = "nombre";
    public static final String TABLA_MASCOTA_FOTO = "foto";
    public static final String TABLA_MASCOTA_LIKES = "likes";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlCrearTablaMascota = String.format(
                "CREATE TABLE %s (" +
                    "%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "%S TEXT," +
                    "%s INTEGER," +
                    "%s INTEGER" +
                ")",
                TABLA_MASCOTA,
                TABLA_MASCOTA_ID,
                TABLA_MASCOTA_NOMBRE,
                TABLA_MASCOTA_FOTO,
                TABLA_MASCOTA_LIKES
        );

        db.execSQL(sqlCrearTablaMascota);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLA_MASCOTA);
        onCreate(db);
    }

    public void agregarMascota(ContentValues values) {
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLA_MASCOTA, null, values);
        db.close();
    }
}

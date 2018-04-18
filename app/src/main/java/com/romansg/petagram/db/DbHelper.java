package com.romansg.petagram.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.romansg.petagram.pojo.Mascota;

import java.util.ArrayList;
import java.util.Locale;

public class DbHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "mascotas";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLA_MASCOTA = "mascota";
    public static final String TABLA_MASCOTA_ID = "id";
    public static final String TABLA_MASCOTA_NOMBRE = "nombre";
    public static final String TABLA_MASCOTA_FOTO = "foto";
    public static final String TABLA_MASCOTA_LIKES = "likes";

    private Context context;

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlCrearTablaMascota = String.format(
                "CREATE TABLE %s (" +
                    "%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "%S TEXT," +
                    "%s INTEGER," +
                    "%s INTEGER DEFAULT 0" +
                ")",
                TABLA_MASCOTA,
                TABLA_MASCOTA_ID,
                TABLA_MASCOTA_NOMBRE,
                TABLA_MASCOTA_FOTO,
                TABLA_MASCOTA_LIKES);

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

    public void darLikeMascota(int id) {
        String sqlAgregarLike = String.format(
                Locale.getDefault(),
                "UPDATE %s SET %s=%s+1 WHERE id=%d",
                TABLA_MASCOTA,
                TABLA_MASCOTA_LIKES,
                TABLA_MASCOTA_LIKES,
                id);

        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sqlAgregarLike);
        db.close();
    }

    public int obtenerLikesMascota(int id) {
        int likes = 0;

        String sqlNumeroLikes = String.format(
                Locale.getDefault(),
                "SELECT %s FROM %s WHERE id = %d",
                TABLA_MASCOTA_LIKES, TABLA_MASCOTA, id);

        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery(sqlNumeroLikes, null);

        if (cursor.moveToNext()) {
            likes = cursor.getInt(0);
        }

        db.close();

        return likes;
    }

    public ArrayList<Mascota> obtenerTodasLasMascotas() {
        String sqlObtenerMascotas = "SELECT * FROM " + TABLA_MASCOTA;

        return obtenerMascotas(sqlObtenerMascotas);
    }

    public ArrayList<Mascota> obtenerMascotasFavoritas(int cuantas) {
        String sqlObtenerMascotas = String.format(
                Locale.getDefault(),
                "SELECT * FROM %s ORDER BY %s DESC LIMIT %d",
                TABLA_MASCOTA,
                TABLA_MASCOTA_LIKES,
                cuantas);

        return obtenerMascotas(sqlObtenerMascotas);
    }

    private ArrayList<Mascota> obtenerMascotas(String sql) {
        ArrayList<Mascota> mascotas = new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        while (cursor.moveToNext()) {
            Mascota mascota = new Mascota();

            mascota.setId(cursor.getInt(0));
            mascota.setNombre(cursor.getString(1));
            mascota.setFoto(cursor.getInt(2));
            mascota.setLikes(cursor.getInt(3));

            mascotas.add(mascota);
        }

        db.close();

        return mascotas;
    }

    public void reiniciarLikes() {
        String sqlReiniciarLikes = String.format(
                Locale.getDefault(),
                "UPDATE %s SET %s = 0",
                TABLA_MASCOTA,
                TABLA_MASCOTA_LIKES);

        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sqlReiniciarLikes);

        db.close();
    }
}

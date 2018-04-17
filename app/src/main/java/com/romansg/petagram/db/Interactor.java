package com.romansg.petagram.db;

import android.content.ContentValues;
import android.content.Context;

import com.romansg.petagram.R;
import com.romansg.petagram.pojo.Mascota;

import java.util.ArrayList;

public class Interactor {
    private Context context;

    public Interactor(Context context) {
        this.context  = context;
    }

    public void agregarMascotas() {
        DbHelper db = new DbHelper(context);

        ContentValues values = new ContentValues();
        values.put(DbHelper.TABLA_MASCOTA_NOMBRE, "Abby");
        values.put(DbHelper.TABLA_MASCOTA_FOTO, R.drawable.abby);
        db.agregarMascota(values);

        values = new ContentValues();
        values.put(DbHelper.TABLA_MASCOTA_NOMBRE, "Bunny");
        values.put(DbHelper.TABLA_MASCOTA_FOTO, R.drawable.bunny);
        db.agregarMascota(values);

        values = new ContentValues();
        values.put(DbHelper.TABLA_MASCOTA_NOMBRE, "Carrot");
        values.put(DbHelper.TABLA_MASCOTA_FOTO, R.drawable.carrot);
        db.agregarMascota(values);

        values = new ContentValues();
        values.put(DbHelper.TABLA_MASCOTA_NOMBRE, "Clifford");
        values.put(DbHelper.TABLA_MASCOTA_FOTO, R.drawable.clifford);
        db.agregarMascota(values);

        values = new ContentValues();
        values.put(DbHelper.TABLA_MASCOTA_NOMBRE, "Dakota");
        values.put(DbHelper.TABLA_MASCOTA_FOTO, R.drawable.dakota);
        db.agregarMascota(values);

        values = new ContentValues();
        values.put(DbHelper.TABLA_MASCOTA_NOMBRE, "Dexter");
        values.put(DbHelper.TABLA_MASCOTA_FOTO, R.drawable.dexter);
        db.agregarMascota(values);

        values = new ContentValues();
        values.put(DbHelper.TABLA_MASCOTA_NOMBRE, "Fiona");
        values.put(DbHelper.TABLA_MASCOTA_FOTO, R.drawable.fiona);
        db.agregarMascota(values);

        values = new ContentValues();
        values.put(DbHelper.TABLA_MASCOTA_NOMBRE, "Loki");
        values.put(DbHelper.TABLA_MASCOTA_FOTO, R.drawable.loki);
        db.agregarMascota(values);

        values = new ContentValues();
        values.put(DbHelper.TABLA_MASCOTA_NOMBRE, "Milo");
        values.put(DbHelper.TABLA_MASCOTA_FOTO, R.drawable.milo);
        db.agregarMascota(values);

        values = new ContentValues();
        values.put(DbHelper.TABLA_MASCOTA_NOMBRE, "Morgan");
        values.put(DbHelper.TABLA_MASCOTA_FOTO, R.drawable.morgan);
        db.agregarMascota(values);

        values = new ContentValues();
        values.put(DbHelper.TABLA_MASCOTA_NOMBRE, "Oscar");
        values.put(DbHelper.TABLA_MASCOTA_FOTO, R.drawable.oscar);
        db.agregarMascota(values);

        values = new ContentValues();
        values.put(DbHelper.TABLA_MASCOTA_NOMBRE, "Puffy");
        values.put(DbHelper.TABLA_MASCOTA_FOTO, R.drawable.puffy);
        db.agregarMascota(values);

        values = new ContentValues();
        values.put(DbHelper.TABLA_MASCOTA_NOMBRE, "Rabito");
        values.put(DbHelper.TABLA_MASCOTA_FOTO, R.drawable.rabito);
        db.agregarMascota(values);

        values = new ContentValues();
        values.put(DbHelper.TABLA_MASCOTA_NOMBRE, "Rex");
        values.put(DbHelper.TABLA_MASCOTA_FOTO, R.drawable.rex);
        db.agregarMascota(values);

        values = new ContentValues();
        values.put(DbHelper.TABLA_MASCOTA_NOMBRE, "Scooter");
        values.put(DbHelper.TABLA_MASCOTA_FOTO, R.drawable.scooter);
        db.agregarMascota(values);

        values = new ContentValues();
        values.put(DbHelper.TABLA_MASCOTA_NOMBRE, "Squirtle");
        values.put(DbHelper.TABLA_MASCOTA_FOTO, R.drawable.squirtle);
        db.agregarMascota(values);

        values = new ContentValues();
        values.put(DbHelper.TABLA_MASCOTA_NOMBRE, "Tiger");
        values.put(DbHelper.TABLA_MASCOTA_FOTO, R.drawable.tiger);
        db.agregarMascota(values);

        values = new ContentValues();
        values.put(DbHelper.TABLA_MASCOTA_NOMBRE, "Tucky");
        values.put(DbHelper.TABLA_MASCOTA_FOTO, R.drawable.tucky);
        db.agregarMascota(values);

        values = new ContentValues();
        values.put(DbHelper.TABLA_MASCOTA_NOMBRE, "Wilson");
        values.put(DbHelper.TABLA_MASCOTA_FOTO, R.drawable.wilson);
        db.agregarMascota(values);
    }

    public void darLikeMascota(Mascota mascota) {
        DbHelper db = new DbHelper(context);
        db.darLikeMascota(mascota.getId());
    }

    public int obtenerLikesMascota(Mascota mascota) {
        DbHelper db = new DbHelper(context);

        return db.obtenerLikesMascota(mascota.getId());
    }

    public ArrayList<Mascota> obtenerTodasLasMascotas() {
        DbHelper db = new DbHelper(context);

        return db.obtenerTodasLasMascotas();
    }

    public ArrayList<Mascota> obtenerMascotasFavoritas(int cuantas) {
        DbHelper db = new DbHelper(context);

        return db.obtenerMascotasFavoritas(cuantas);
    }
}

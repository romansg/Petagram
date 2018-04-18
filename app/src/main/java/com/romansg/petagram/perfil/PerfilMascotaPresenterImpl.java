package com.romansg.petagram.perfil;

import android.content.Context;

import com.romansg.petagram.R;
import com.romansg.petagram.db.Interactor;
import com.romansg.petagram.listado.ListaMascotasView;
import com.romansg.petagram.pojo.Mascota;

import java.util.ArrayList;

public class PerfilMascotaPresenterImpl implements PerfilMascotaPresenter {
    private PerfilMascotaView view;
    private Interactor interactor;
    private ArrayList<Mascota> mascotas;
    private Context context;

    public PerfilMascotaPresenterImpl(Context context, PerfilMascotaView view) {
        this.context = context;
        this.view = view;

        mascotas = obtenerMascotas();
        mostrarMascotas(mascotas);
    }

    public ArrayList<Mascota> obtenerMascotas() {
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Fiona", R.drawable.fiona, 3));
        mascotas.add(new Mascota("Fiona", R.drawable.fiona, 0));
        mascotas.add(new Mascota("Fiona", R.drawable.fiona, 5));
        mascotas.add(new Mascota("Fiona", R.drawable.fiona, 2));
        mascotas.add(new Mascota("Fiona", R.drawable.fiona, 1));
        mascotas.add(new Mascota("Fiona", R.drawable.fiona, 0));
        mascotas.add(new Mascota("Fiona", R.drawable.fiona, 4));
        mascotas.add(new Mascota("Fiona", R.drawable.fiona, 2));

        return mascotas;
    }

    public void mostrarMascotas(ArrayList<Mascota> mascotas) {
        view.setupRecyclerView(mascotas);
    }
}

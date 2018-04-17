package com.romansg.petagram.listado;

import android.content.Context;

import com.romansg.petagram.db.Interactor;
import com.romansg.petagram.pojo.Mascota;

import java.util.ArrayList;

public class ListaMascotasPresenterImpl implements ListaMascotasPresenter {
    private ListaMascotasView view;
    private Interactor interactor;
    private ArrayList<Mascota> mascotas;
    private Context context;

    public ListaMascotasPresenterImpl(Context context, ListaMascotasView view) {
        this.context = context;
        this.view = view;

        mascotas = obtenerMascotas();
        mostrarMascotas(mascotas);
    }

    @Override
    /*
        Se comunica con el modelo para obtener datos
     */
    public ArrayList<Mascota> obtenerMascotas() {
        /*
            Usa un interactor para obtener datos de la base de datos
         */
        interactor = new Interactor(context);
        return interactor.obtenerTodasLasMascotas();
    }

    @Override
    /*
        Actualiza la vista con los datos
     */
    public void mostrarMascotas(ArrayList<Mascota> mascotas) {
        view.setupRecyclerView(mascotas);
    }
}

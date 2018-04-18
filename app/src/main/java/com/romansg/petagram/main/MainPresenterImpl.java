package com.romansg.petagram.main;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.romansg.petagram.biografia.BiografiaActivity;
import com.romansg.petagram.contacto.ContactoActivity;
import com.romansg.petagram.db.Interactor;
import com.romansg.petagram.favoritas.MascotasFavoritasActivity;
import com.romansg.petagram.listado.ListaMascotasFragment;
import com.romansg.petagram.perfil.PerfilMascotaFragment;

public class MainPresenterImpl implements MainPresenter {
    private Context context;
    private MainView view;

    public MainPresenterImpl(Context context, MainView view) {
        this.context = context;
        this.view = view;

        view.setupPagerAdapter(
                new Fragment[]{new ListaMascotasFragment(), new PerfilMascotaFragment()},
                new String[]{"Mascotas", "Perfil"}
        );
    }

    @Override
    public void agregarMuestraMascotas() {
        Interactor interactor = new Interactor(context);
        interactor.agregarMascotas();
    }

    @Override
    public void reiniciarLikesMascotas() {
        Interactor interactor = new Interactor(context);
        interactor.reiniciarLikesMascotas();
    }

    @Override
    public void verContacto() {
        Intent intent = new Intent(context, ContactoActivity.class);
        context.startActivity(intent);

    }

    @Override
    public void verBiografia() {
        Intent intent = new Intent(context, BiografiaActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void verMascotasFavoritas() {
        Intent intent = new Intent(context, MascotasFavoritasActivity.class);
        context.startActivity(intent);
    }
}

package com.romansg.petagram.favoritas;

import com.romansg.petagram.pojo.Mascota;

import java.util.ArrayList;

public interface MascotasFavoritasPresenter {
    ArrayList<Mascota> obtenerMascotas();
    void mostrarMascotas(ArrayList<Mascota> mascotas);
}

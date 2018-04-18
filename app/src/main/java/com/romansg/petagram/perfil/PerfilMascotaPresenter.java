package com.romansg.petagram.perfil;

import com.romansg.petagram.pojo.Mascota;

import java.util.ArrayList;

public interface PerfilMascotaPresenter {
    ArrayList<Mascota> obtenerMascotas(); // Obtiene datos del modelo
    void mostrarMascotas(ArrayList<Mascota> mascotas); // Proporciona datos a la vista
}

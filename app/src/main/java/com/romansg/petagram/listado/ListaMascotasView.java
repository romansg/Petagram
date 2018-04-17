package com.romansg.petagram.listado;

import com.romansg.petagram.pojo.Mascota;

import java.util.ArrayList;

public interface ListaMascotasView {
    void setupRecyclerView(ArrayList<Mascota> mascotas);
}

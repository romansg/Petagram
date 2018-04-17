package com.romansg.petagram.favoritas;

import com.romansg.petagram.pojo.Mascota;

import java.util.ArrayList;

public interface MascotasFavoritasView {
    void setToolbar();
    void setupRecyclerView(ArrayList<Mascota> mascotas);
}

package com.romansg.petagram.favoritas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.romansg.petagram.R;
import com.romansg.petagram.adapter.MascotaAdapter;
import com.romansg.petagram.pojo.Mascota;

import java.util.ArrayList;

public class MascotasFavoritasActivity extends AppCompatActivity implements MascotasFavoritasView {
    private RecyclerView rvMascotas;
    private MascotasFavoritasPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);

        rvMascotas = findViewById(R.id.rvMascotasFavoritas);
        presenter = new MascotasFavoritasPresenterImpl(this,this);
    }

    @Override
    public void setToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void setupRecyclerView(ArrayList<Mascota> mascotas) {
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        MascotaAdapter adapter = new MascotaAdapter(mascotas, this);

        rvMascotas.setLayoutManager(manager);
        rvMascotas.setAdapter(adapter);
    }
}

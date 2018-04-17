package com.romansg.petagram.listado;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.romansg.petagram.R;
import com.romansg.petagram.adapter.MascotaAdapter;
import com.romansg.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListaMascotasFragment extends Fragment implements ListaMascotasView {
    private RecyclerView rvMascotas;
    private ListaMascotasPresenter presenter;

    public ListaMascotasFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lista_mascotas, container, false);

        rvMascotas = view.findViewById(R.id.rvMascotas);
        presenter = new ListaMascotasPresenterImpl(getContext(), this);

        return view;
    }

    public void setupRecyclerView(ArrayList <Mascota> mascotas) {
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        MascotaAdapter adapter = new MascotaAdapter(mascotas, getContext());

        rvMascotas.setLayoutManager(manager);
        rvMascotas.setAdapter(adapter);
    }
}

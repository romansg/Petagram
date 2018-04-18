package com.romansg.petagram.perfil;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.romansg.petagram.R;
import com.romansg.petagram.adapter.MiniaturaAdapter;
import com.romansg.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilMascotaFragment extends Fragment implements PerfilMascotaView {
    private RecyclerView rvMascotaFotos;
    private PerfilMascotaPresenter presenter;

    public PerfilMascotaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_perfil_mascota, container, false);

        rvMascotaFotos = view.findViewById(R.id.rvMascotaFotos);
        presenter = new PerfilMascotaPresenterImpl(getContext(), this);

        return view;
    }

    public void setupRecyclerView(ArrayList<Mascota> mascotas) {
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 3);
        MiniaturaAdapter adapter = new MiniaturaAdapter(mascotas, getContext());

        rvMascotaFotos.setLayoutManager(manager);
        rvMascotaFotos.setAdapter(adapter);
    }
}

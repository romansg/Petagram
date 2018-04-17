package com.romansg.petagram.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.romansg.petagram.R;
import com.romansg.petagram.db.Interactor;
import com.romansg.petagram.pojo.Mascota;

import java.util.ArrayList;

public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder> {
    private ArrayList<Mascota> mascotas;
    private Context context;

    public MascotaAdapter(ArrayList<Mascota> mascotas, Context context) {
        this.mascotas = mascotas;
        this.context = context;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflates the CardView's XML into a View object
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.mascota, parent, false);

        // and passes it to a new ViewHolder
        return new MascotaViewHolder(view);
    }

    @Override
    /*
        Transfer data from model to view's widgets
     */
    public void onBindViewHolder(final MascotaViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);

        holder.ivPetPhoto.setImageResource(mascota.getFoto());
        holder.tvPetName.setText(mascota.getNombre());
        holder.tvPetLikes.setText(mascota.getLikes() + "");

        // Botón "like"
        holder.btnPetLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Interactor interactor = new Interactor(context);
                interactor.darLikeMascota(mascota);
                holder.tvPetLikes.setText(interactor.obtenerLikesMascota(mascota) + "");

                Toast.makeText(context, "Diste like a " + mascota.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    /*
        A holder for every widget in item
     */
    public class MascotaViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivPetPhoto;
        private ImageButton btnPetLike;
        private TextView tvPetName;
        private TextView tvPetLikes;

        public MascotaViewHolder(View itemView) {
            super(itemView);

            ivPetPhoto = itemView.findViewById(R.id.ivPetPhoto);
            btnPetLike = itemView.findViewById(R.id.btnPetLike);
            tvPetName = itemView.findViewById(R.id.tvPetName);
            tvPetLikes  = itemView.findViewById(R.id.tvPetLikes);
        }
    }
}

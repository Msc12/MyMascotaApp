package com.mascware.app.mymascotaappp;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by MASC on 12-05-2016.
 */
public class Top5MascotaAdapter extends  RecyclerView.Adapter<Top5MascotaAdapter.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;

    Activity activity;
    public Top5MascotaAdapter(ArrayList<Mascota> mascotas, Activity activityw){
        this.mascotas=mascotas;
        this.activity=activityw;
    }
    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) { //inflamos las vistas para el viewHolder
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotaaa,parent,false);
        return new MascotaViewHolder(v);

    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder holder, int position) { //pasar lista de mascotas a los elementos
        final Mascota mascota= mascotas.get(position);
        holder.nombre.setText(mascota.getNombre());
        holder.raiting.setText(mascota.getRaiting());
        holder.imgFoto.setImageResource(mascota.getFoto());
    }

    @Override
    public int getItemCount() { //cantidad de elementos que contien mi lista.
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgFoto;
        private TextView nombre;
        private TextView raiting;
        private ImageView huesoB;
        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            nombre = (TextView)  itemView.findViewById(R.id.textViewNombre);
            raiting = (TextView)  itemView.findViewById(R.id.textViewRaiting);
            huesoB=(ImageView)itemView.findViewById(R.id.imgHuesoBlanco);
        }


    }

}

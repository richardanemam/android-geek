package com.example.richard.myrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Richard on 8/27/2018.
 */

class DestinoAdapter extends RecyclerView.Adapter {

    private List<Destinos> destinos;
    private Context context;

    public DestinoAdapter(List<Destinos> destinos, Context context) {
        this.setDestinos(destinos);
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_destino, parent, false);

        DestinosViewHolder holderDestinos = new DestinosViewHolder(view);

        return holderDestinos;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        DestinosViewHolder destinosHolder = (DestinosViewHolder) viewHolder;

        // DestinosViewHolder destinosHolder =
        //destinosHolder.iv_foto.setImageResource(destinos.get(position).getFoto());
        Picasso.with(context).load(destinos.get(position).getFoto()).resize(240, 120).into(((DestinosViewHolder) viewHolder).iv_foto);
        destinosHolder.tv_pais.setText(destinos.get(position).getPais());
        destinosHolder.tv_cidade.setText(destinos.get(position).getCidade());
        destinosHolder.tv_photoBy.setText(destinos.get(position).getPhotoBy());

    }

    @Override
    public int getItemCount() {
        return this.getDestinos().size();
    }

    public void setDestinos(List<Destinos> destinos) {
        this.destinos = destinos;
    }

    public List<Destinos> getDestinos(){
        return this.destinos;
    }

    public class DestinosViewHolder extends RecyclerView.ViewHolder {

        public TextView tv_pais;
        public TextView tv_cidade;
        public TextView tv_photoBy;
        public ImageView iv_foto;

        public DestinosViewHolder(View itemView) {
            super(itemView);
            tv_pais    = itemView.findViewById(R.id.tv_pais);
            tv_cidade  = itemView.findViewById(R.id.tv_cidade);
            tv_photoBy = itemView.findViewById(R.id.tv_photoBy);
            iv_foto    = itemView.findViewById(R.id.iv_destino);
        }
    }
}
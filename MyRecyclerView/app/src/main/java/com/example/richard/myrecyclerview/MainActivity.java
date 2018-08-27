package com.example.richard.myrecyclerview;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerview = (RecyclerView) findViewById(R.id.my_rv);
        List<Destinos> destinos = destinosInfo();
        recyclerview.setAdapter(new DestinoAdapter(destinos, this));

        RecyclerView.LayoutManager layout = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recyclerview.setLayoutManager(layout);
    }

    public List<Destinos> destinosInfo(){
        String paises [] = {"Brazil", "China", "Usa"};
        String cidades[] = {"Sao Paulo", "Rio de Janeiro", "Beijing", "Shanghai", "New York City", "Maimi"};
        String photoBy[] = {"Sergio Souza","Cerqueira", "Raj Eiamworakul", "Usukhbayar", "Mike Chavarri", "Aurora Kreativ"};
        int    fotos  [] = {R.drawable.sergio_souza_sp, R.drawable.cerqueira_rj, R.drawable.raj_eiamworakul_beijing,
                            R.drawable.usukhbayar_gankhuyag_shanghai, R.drawable.mike_chavarri_nyc, R.drawable.aurora_kreativ_miami};

        List<Destinos> listAux = new ArrayList<>();
        for(int i = 0; i < listAux.size(); i++){
            Destinos destino = new Destinos(paises[i], cidades[i], photoBy[i], fotos[i]);
            listAux.add(destino);
        }
        return listAux;
    }
}
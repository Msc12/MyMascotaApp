package com.mascware.app.mymascotaappp;

import android.content.Intent;
import android.os.Bundle;
import android.R.layout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class Top5Activity extends AppCompatActivity {

    private ArrayList<Mascota> mascotas;
    RecyclerView listaMascotaTop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top5);
        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        listaMascotaTop= (RecyclerView) findViewById(R.id.recycleviewMascotastop5);
        LinearLayoutManager llm =new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotaTop.setLayoutManager(llm);
        ArrayList<String> datos=getIntent().getStringArrayListExtra("datos");
        inicializarListaMascotaTop5(datos);
        inicializarAdapter();
    }

    public void inicializarAdapter(){
        Top5MascotaAdapter adapter= new Top5MascotaAdapter(mascotas,Top5Activity.this);
        listaMascotaTop.setAdapter(adapter);

    }
    public void inicializarListaMascotaTop5(ArrayList<String> datos){
        mascotas =new ArrayList<Mascota>();
        String[] auxlist;
        for(String aux:datos){
            auxlist=aux.split(",");
            mascotas.add(new Mascota(auxlist[0],auxlist[1],Integer.parseInt(auxlist[2])));
        }
    }
}

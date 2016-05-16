package com.mascware.app.mymascotaappp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascota;
    ArrayList<Mascota> mascotasAlTop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarListaMascota();
        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        listaMascota= (RecyclerView) findViewById(R.id.recycleviewMascotasPrin);
        LinearLayoutManager llm =new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascota.setLayoutManager(llm);
        inicializarAdapter();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_favorite:
                Intent intent=new Intent(MainActivity.this,Top5Activity.class);
                //cargamos datos del top 5, agregando las mascoas que le dimos like. nombre, raiting foto en orden
                ArrayList<String> datos=cargandoDatosApasar();
                intent.putStringArrayListExtra("datos",datos);
                startActivity(intent);

                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }

    private ArrayList cargandoDatosApasar() {
        ArrayList<String> datos=new ArrayList<>();
        int v=mascotasAlTop.size()-5;
        for(int i=v;i<mascotasAlTop.size();i++){
            datos.add(mascotasAlTop.get(i).getNombre()+","+mascotasAlTop.get(i).getRaiting()+","+Integer.toString(mascotasAlTop.get(i).getFoto()));
        }
        return datos;
    }


    public void inicializarAdapter(){
        MascotaAdapter adapter= new MascotaAdapter(mascotas,MainActivity.this);
        listaMascota.setAdapter(adapter);

    }
    public void inicializarListaMascota(){
        mascotas =new ArrayList<Mascota>();
        mascotas.add(new Mascota("Lucas","3",R.drawable.perro1));
        mascotas.add(new Mascota("Brook","2",R.drawable.perro2));
        mascotas.add(new Mascota("Luna","4",R.drawable.gatapato));
        mascotas.add(new Mascota("Peke","1",R.drawable.chihuahua));
        mascotas.add(new Mascota("Rhyno","2",R.drawable.hamster));
        mascotas.add(new Mascota("Linda","3",R.drawable.perrita));

        inicializarMascotasAltop();
    }

    public void inicializarMascotasAltop(){
        mascotasAlTop=new ArrayList<Mascota>();
        mascotasAlTop.addAll(mascotas);
    }


    public void agregarAlTop(Mascota mascota){
        mascotasAlTop.add(mascota);
    }

    public void quitarAlTop(Mascota mascota){
        mascotasAlTop.remove(mascotas.size()-1);
    }
}

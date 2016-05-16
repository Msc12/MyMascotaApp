package com.mascware.app.mymascotaappp;

/**
 * Created by MASC on 12-05-2016.
 */
public class Mascota {
    private String nombre;
    private String raiting;
    private int foto;
    private boolean like;
    public Mascota(String nombre, String raiting, int foto) {
        this.nombre = nombre;
        this.raiting = raiting;
        this.foto = foto;
        this.like=false;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }



    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaiting() {
        return raiting;
    }

    public void setRaiting(String raiting) {
        this.raiting = raiting;
    }

    public boolean isLike() {
        return like;
    }

    public void setLike(boolean like) {
        this.like = like;
    }
}

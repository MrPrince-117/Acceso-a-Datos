package Cancion;

import java.io.Serializable;

public class Cancion implements Serializable {
    String titulo;
    String autor;
    String duracion;
    int id;
    int año;
    boolean cancionEspañola;

    public Cancion(int id, int añoEntero, String titulo, String autor, String duracion, boolean cancionEsp) {
        this.titulo = titulo;
        this.autor = autor;
        this.duracion = duracion;
        this.id = 0;
        this.año = this.año;
        this.cancionEspañola = false;

    }

    public Cancion() {

    }

//    public Cancion(String titulo, String autor, Double duracion, int id, boolean cancionEsp) {
//        this.titulo = titulo;
//        this.autor = autor;
//        this.duracion = duracion;
//        this.id = id;
//        this.añoEntero = añoEntero;
//        this.cancionEsp = cancionEsp;
//
//
//    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDuracion() {
        return duracion;
    }
    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getAño(){
        return año;
    }
    public void setAño(int año){
        this.año = año;
    }

    public boolean getCancionEspañola() {
        return cancionEspañola;
    }
    public void setCancionEspañola(boolean cancionEsp) {
        this.cancionEspañola = cancionEsp;
    }
    @Override
    public String toString() {
        return "ID: " + id + "\nAño: " + año + "\nTítulo: " + titulo.trim() + "\nAutor: " + autor +
                "\nDuración: " + duracion + "\nCanción Española: " + cancionEspañola;
    }



}

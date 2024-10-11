package Personas;

import java.io.Serializable;

public class Persona implements Serializable {
    private String nombres;
    private int edades;
    public Persona(String nombres, int edades) {
        this.nombres = nombres;
        this.edades = edades;

    }
    public String getNombre() {
        return nombres;
    }
    public void setNombre(String nombres) {
        this.nombres = nombres;
    }
    public int getEdad() {
        return edades;
    }
    public void setEdad(int edades) {
        this.edades = edades;
    }
}

package Personas;

import java.util.*;

public class ListaPersonas {
    private List<Persona> lista = new ArrayList<Persona>();

    public ListaPersonas() {}
    public void add (Persona per) {
        lista.add(per);
    }
    public List<Persona> getListaPersonas() {
        return lista;
    }
}

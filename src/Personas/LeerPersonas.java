package Personas;

import com.thoughtworks.xstream.XStream;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LeerPersonas {
    public static void main(String[] args) throws IOException {
        XStream xstream = new XStream();

        xstream.alias("ListaPersonasMunicipio", ListaPersonas.class);
        xstream.alias("DatosPersonas", Persona.class);
        xstream.addImplicitCollection(ListaPersonas.class, "ListaPersonas", Persona.class);

        ListaPersonas listadoTodas = (ListaPersonas)
                xstream.fromXML(new FileReader("Personas.xml"));

        System.out.println("Numero de Personas: " + listadoTodas.getListaPersonas().size());

        List<Persona> listaPersonas = new ArrayList<Persona>();
        listaPersonas = listadoTodas.getListaPersonas();

        Iterator iterador = listaPersonas.listIterator();
    }
}

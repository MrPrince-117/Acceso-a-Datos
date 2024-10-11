package Personas;

import com.thoughtworks.xstream.XStream;

import java.io.*;

public class EscribirPersonas {
    public static void main(String[] args)throws IOException, ClassNotFoundException {
        File fichero = new File("C:\\Users\\aludam2\\Desktop\\DAT\\FichData.dat");
        FileInputStream filein = new FileInputStream(fichero);
        ObjectInputStream dataIs = new ObjectInputStream(filein);


        System.out.println("Comienza el proceso....");

        ListaPersonas listaPer = new ListaPersonas();
        try{
            while (true) {
                Persona persona = (Persona) dataIs.readObject();
                listaPer.add(persona);
            }
        } catch (EOFException eo) {}
        dataIs.close();

        try{
            XStream xstream = new XStream();

            xstream.alias("ListaPersonasMunicipio", ListaPersonas.class);
            xstream.alias("Persona", Persona.class);

            xstream.addImplicitCollection(ListaPersonas.class, "lista");

            xstream.toXML(listaPer, new FileOutputStream("Personas.xml"));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

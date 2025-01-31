package UD3;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;

public class EjemploNeodatis {

    public static void main(String[] args) {

        // Creo los paises
        Paises pais1 = new Paises(1, "Espana");
        Paises pais2 = new Paises(2, "Mexico");
        // Crear instancias para almacenar en BD
        Jugadores j1 = new Jugadores("María", "Voleibol", "Madrid", 14, pais1);
        Jugadores j2 = new Jugadores("Miguel", "Tenis", "Madrid", 15, pais1);
        Jugadores j3 = new Jugadores("Alicia", "Tenis", "Madrid", 15, pais1);
        Jugadores j4 = new Jugadores("Mario", "Baloncesto", "Guadalajara", 15, pais1);

        // Abrir BD
        ODB odb = ODBFactory.open("neodatis.test");

        // Almacenar objetos
        odb.store(j1);
        odb.store(j2);
        odb.store(j3);
        odb.store(j4);

        // Recuperar todos los objetos
        Objects<Jugadores> objetos = odb.getObjects(Jugadores.class);
        System.out.println("# Jugadores: " + objetos.size());

        int i = 1;
        while (objetos.hasNext()) {
            Jugadores jug = objetos.next();
            System.out.println(i + ": " + jug.getNombre() + ", " + jug.getDeporte() + ", " + jug.getCiudad() + ", " + jug.getEdad());
            i++;
        }

        odb.close(); // Cerrar BD
    }
}

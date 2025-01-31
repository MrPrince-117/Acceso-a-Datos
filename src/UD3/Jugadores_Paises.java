package UD3;

import java.io.File;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.Values;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.And;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;

public class Jugadores_Paises {

    public static void main(String[] args) {
        //creo la conexion
        ODB odb = ODBFactory.open("Equipos.db");

        // Creo los paises
        Paises pais1 = new Paises(1, "Espana");
        Paises pais2 = new Paises(2, "Mexico");
        // Creo los equipos
        Jugadores j1= new Jugadores ("Marta", "voleibol", "Madrid", 14, pais1);
        Jugadores j2= new Jugadores ("Miguel", "tenis", "Madrid", 15, pais1);
        Jugadores j3= new Jugadores ("Mario", "baloncesto", "Guadalajara", 15, pais2);
        Jugadores j4= new Jugadores ("Alicia", "tenis", "Madrid", 14, pais1);

        // Inserto los objetos
//		odb.store(j1);
//		odb.store(j2);
//		odb.store(j3);
//		odb.store(j4);
//		odb.store(pais1);
//		odb.store(pais2);

        // sacar los datos de todos los jugadores
        Objects<Jugadores> objects = odb.getObjects(Jugadores.class);
        int i = 1;

        System.out.println(objects.size() + " jugadores:");

        while(objects.hasNext()){
            Jugadores jug= objects.next();

            System.out.println((i++) + "\t: " + jug.getNombre() + "*" +
                    jug.getDeporte() + "*" + jug.getCiudad() + "*" + jug.getEdad());
        }
        System.out.println("------------");

        ///////CONSULTA 1//////////

        IQuery query = new CriteriaQuery(Jugadores.class, Where.equal("deporte", "tenis"));
        query.orderByDesc("edad");
        i = 1;

        Objects<Jugadores> objects1 = odb.getObjects(query);

        System.out.println("Jugadores que juegan al tenis: ");

        while(objects1.hasNext()){
            Jugadores jug = objects1.next();

            System.out.println((i++) + "\t: " + jug.getNombre() + "*" +
                    jug.getDeporte() + "*" + jug.getCiudad() + "*" + jug.getEdad());
        }
        System.out.println("------------");

        //////CONSULTA 2 CON criterio///////

        ICriterion criterio2 = new And().add(Where.equal("ciudad", "Madrid")).
                add(Where.ge("edad",15));

        query = new CriteriaQuery(Jugadores.class, criterio2);

        Objects<Jugadores> objects2 = odb.getObjects(query);

        mostrarDatos(objects2, "Jugadores que son de Madrid y tienen 15 años");

        //////CONSULTA 3 CON jugadores que hay en un pais///////

        String pais = "Mexico";

        ICriterion criterio3 = new And().add(Where.equal("pais.nombrePais", pais));
        query = new CriteriaQuery(Jugadores.class, criterio3);
        Objects<Jugadores> jugadores = odb.getObjects(query);

        mostrarDatos(jugadores, "Jugadores que son de " + pais);

        ///////BORRAR UN PAIS///////

//		query = new CriteriaQuery(Jugadores.class, Where.equal("nombre", "Miguel"));
//		Jugadores jugadorborrar = (Jugadores) odb.getObjects(query).getFirst();
//
//		odb.delete(jugadorborrar);

        ///////CONSULTA ESPAÑA////////
        Values valores = odb.getValues(new ValuesCriteriaQuery(
                Jugadores.class,
                new And().add(Where.equal("pais.nombrePais", "ESPAÑA"))
                        .add(Where.equal("edad",15))
                        )
                .field("nombre")
                .field("ciudad")
        );



        odb.close();
    }

    public static void mostrarDatos(Objects<Jugadores> objects, String mensaje) {
        System.out.println(mensaje);
        int i = 1;
        while(objects.hasNext()){
            Jugadores jug = objects.next();

            System.out.println((i++) + "\t: " + jug.getNombre() + "*" +
                    jug.getDeporte() + "*" + jug.getCiudad() + "*" + jug.getEdad()
                    + "*" + jug.getPais().getNombrePais());
        }
        System.out.println("------------");
    }
}

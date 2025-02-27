package UD5;


import com.mongodb.client.*;

import org.bson.Document;

public class EJ1_Conexion_MondongoDB {


    public static void main(String[] args) {
        String uri = "mongodb://localhost:27017";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            // Conectar a MongoDB en localhost y puerto 27017


            // Seleccionar la base de datos
            MongoDatabase database = mongoClient.getDatabase("mibasededatos");

            // Mostrar mensaje de conexión exitosa
            System.out.println("Conexión exitosa a la base de datos: " + database.getName());

            System.out.println("Colecciones: "+ database.listCollections());

            // Cerrar conexión
            mongoClient.close();
        } catch (Exception e) {
            System.err.println("Error en la conexión: " + e.getMessage());
        }

    }


}

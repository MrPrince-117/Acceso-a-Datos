package Cancion;

import java.io.*;

import java.util.Scanner;

public class CrearFicheroCancion {
    public static void main(String[] args) throws IOException {
        Cancion cancion;
        Scanner teclado = new Scanner(System.in);
        File archivo = new File("C:\\Users\\aludam2\\Desktop\\DAT\\Canciones.dat");
        FileOutputStream fos = new FileOutputStream(archivo);
        ObjectOutputStream dataOs = new ObjectOutputStream(fos);
        int id= 1;
        int año;
        int decision=1;
        String titulo;
        String artista;
        String duracion;
        boolean cancionEspañola;
        while (decision == 1) {
            System.out.println("Escribe el año de la cancion");
            año= teclado.nextInt();
            System.out.println("Escribe el titulo de la cancion");
            titulo= teclado.next();
            teclado.nextLine();
            System.out.println("Escribe su artista");
            artista= teclado.next();
            teclado.nextLine();
            System.out.println("Escribe su duracion");
            duracion= teclado.next();
            System.out.println("""
                         ¿Es una cancion española?
                         True / False""");
            cancionEspañola= Boolean.parseBoolean(teclado.next());
            cancion= new Cancion(id,año,titulo,artista,duracion,cancionEspañola);
            dataOs.writeObject(cancion);
            System.out.println("""
                     Pulsa 1 si quieres añadir una cancion
                     Pulsa cualquier otro numero si ya no quieres añadir más""");
            decision= teclado.nextInt();
            id +=1;
        }//Fin while
        dataOs.close();
    }//Fin main
}

package Cancion;

import java.io.*;
import java.util.Scanner;

public class EscriFichCancionesObj {
    public static void main(String[] args) throws IOException {
        File fichero = new File("C:\\Users\\aludam2\\Desktop\\DAT\\Canciones.dat");//declara el fichero
        FileOutputStream fileout = new FileOutputStream(fichero);
        DataOutputStream dataOS = new DataOutputStream(fileout);
        FileInputStream fileIn = new FileInputStream(fichero);
        ObjectInputStream dataIS = new ObjectInputStream(fileIn);


        Cancion cancion = new Cancion();



        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.print("ID de la canción: ");
        cancion.setTitulo(sc.nextLine());
        System.out.print("Año de la canción: ");
        //cancion.setAñoEntero();

        System.out.print("Título de la canción: ");
        cancion.setTitulo(sc.nextLine());

        System.out.print("Artista de la canción: ");
        cancion.setAutor(sc.nextLine());

        System.out.print("Duración de la canción: ");
        cancion.setDuracion(sc.nextLine());

        System.out.print("¿Es una canción española? (true/false): ");
        cancion.setCancionEspañola(sc.nextBoolean());
    }
}

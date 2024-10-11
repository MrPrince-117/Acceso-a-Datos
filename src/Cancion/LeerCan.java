package Cancion;

import java.io.*;
import java.util.Scanner;

public class LeerCan {
    public static void main(String[] args) throws IOException {
        File fichero = new File("C:\\Users\\aludam2\\Desktop\\DAT\\Canciones.dat");
        FileInputStream fileIn = new FileInputStream(fichero);
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);

        Cancion cancion;

        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el autor de la canción a buscar: ");
        String autor = sc.nextLine();

        try {
            while (true){
                cancion =(Cancion) objectIn.readObject();
                if (autor.equals((cancion.getAutor()))){
                    System.out.println(cancion);
                }
            }//Fin while
        }catch (EOFException | ClassNotFoundException e){
            System.out.println("Fin de lectura");
        }//Fin try-catch
        objectIn.close();


    }
}

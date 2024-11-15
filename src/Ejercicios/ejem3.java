package Ejercicios;

import java.io.File;
import java.io.IOException;

public class ejem3 {
	public static void main(String[] args) {
		 File d = new File("NUEVODIR");
		 File f1 = new File(d, "Fichero1.txt");
		 File f2 = new File(d, "Fichero2.txt");
		 
		 d.mkdir();
		 
		 try {
			 if (f1.createNewFile()) {
				 System.out.println("FICHERO1 creado correctamente. . .");
			 } else {
				 System.out.println("No se ha podido crear FICHERO1. . .");
			 }
			 if(f2.createNewFile()) {
				 System.out.println("FICHERO2 creado correctamente. . .");
			 } else {
				 System.out.println("No se ha podido crear FICHERO2. . .");
			 }

		 } catch (IOException ioe) { ioe.printStackTrace();}
    }
}

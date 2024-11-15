package Ejercicios;

import java.io.File;

public class ejem2 {
	public static void main(String[] args) {
		System.out.println("INFORMACION SOBRE EL FICHERO:");
		File f = new File ("D:\\UNIDAD1\\ejVerdir\\ejem1.java");
		if (f.exists()) {
			System.out.println("NOMBRE DEL FICHERO : "+f.getName());
			System.out.println("Ruta: "+f.getPath());
			System.out.println("Ruta Absoluta: "+f.getAbsolutePath());
			System.out.println();
			System.out.println();
		}
	}
}

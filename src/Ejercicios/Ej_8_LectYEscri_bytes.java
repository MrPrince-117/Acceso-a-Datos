package Ejercicios;
import java.io.*;

public class Ej_8_LectYEscri_bytes {

	
		public static void main(String[] args) throws IOException {
			
			
			File fichero = 
					new File("C:\\Users\\aludam2\\Desktop\\FichBytes.dat");//declara el fichero
			
			FileOutputStream fileout = new FileOutputStream(fichero);
			
			
			FileInputStream filein = new FileInputStream(fichero);
			int i ;
			
			for (i=1; i<100; i++) {
				fileout.write(i);
			}
			fileout.close();//cerrar stream de salida
			
			while ((i= filein.read()) != -1) {
				System.out.println(i);
			} filein.close(); //cerrar stream de entrada
			
		}
}

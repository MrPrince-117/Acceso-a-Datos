package Ejercicios;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class ejem3_2 {
	public static void main(String[] args) throws IOException {
		File fichero = new
			File("C:\\Users\\aludam2\\Desktop\\FichTexto.txt");
		//crear flujo de salida
		FileWriter fic = new FileWriter(fichero, true);
		
		//String cadena = "Esto es una prueba con FileWriter";
		//convierte la cadena en array de caracteres para extraerlos
		
		//String prov[] = {"Albacete", "Badajoz", "Huelva", "Madrid", "Segovia", "Soria", "Toledo", "Valladolid", "Zamora"};
		Arrays.sort(args, Collections.reverseOrder());
		
		//for (int i=0; i<prov.length; i++) {
		//	fic.write(prov[i]);
		//	fic.append(' ');
			
		//};
		fic.append("Valencia");
		
		
		fic.close();

		
	//char[] cad = cadena.toCharArray();
//for(int i=0; i<cad.length; i++) {
//	fic.write(cad[i]); // se va escribirndo el cararacter
//}
		
		
	}
}

package Ejercicios;
import java.io.*;

public class EscribirFichTexto {
	static void arrayReverse(String[] array) {
		for(int i=0; i<array.length/2;i++) {
			String temp=array[i];
			array[i]=array[array.length-i-1];
			array[array.length-i-1]=temp;
		}
	}
	
	public static void main(String[] args) throws IOException {
		File fichero = new
			File("C:\\Users\\aludam2\\Desktop\\FichTexto.txt");
		//crear flujo de salida
		FileWriter fic = new FileWriter(fichero, true);
		
		//String cadena = "Esto es una prueba con FileWriter";
		//convierte la cadena en array de caracteres para extraerlos
		
		String[] prov =
			{"Albacete", "Badajoz", "Huelva", "Madrid", "Segovia", "Soria", "Toledo", "Valladolid"
				, "Zamora, Valencia"};
		arrayReverse(prov);
		
		String[] prov2 = new String[prov.length];
        System.arraycopy(prov, 0, prov2, 0, prov.length);
        for (int i=0; i<prov.length;i++) {
            System.out.println(prov2[i]);
        }

		
	//char[] cad = cadena.toCharArray();
//for(int i=0; i<cad.length; i++) {
//	fic.write(cad[i]); // se va escribirndo el cararacter
//}
		
		for (int i=0; i<prov.length; i++) {
			fic.write(prov[i]);
			fic.append(' ');
		}


        //fic.append('*');
		fic.close();
	}
	
	//public static void Array2(String[] array) {
	//	File fichero = new 
	//			File ("C:\\Users\\aludam2\\Desktop\\");
		//FileWriter fic = new FileWriter(fichero, true);
		//String 
	//}
}

//Realizar un programa que abra para añadir el fichero de ciudades creado anteriormente y añada al final una nueva ciudad
//Realizar un proceso que lea el fichero resultante, lo guarde en un array que lo vuelva a ordenar descende y escriba de nueva el srrsy
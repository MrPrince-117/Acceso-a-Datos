package ejVerdir;

import java.io.*;
import java.util.ArrayList;




public class ejEnunciado {
	
	public static void main(String[] args) throws IOException {
		File fichero = new File("C:\\Users\\aludam2\\Desktop\\FichTexto.txt");
		
		//crear flujo de salida
		FileWriter fic = new FileWriter(fichero, true);
		String cadena = "Melilla";
		fic.append(cadena);
		
		
		fic.close();//Cerramos  
		
		
		
	}//Fin main
	
	
	
	public static void Segundo(String[] args) throws FileNotFoundException  {
		BufferedReader fichero = new BufferedReader(new FileReader("FichTexto.txt"));
		 ArrayList<String> provi = new ArrayList<>();   
		String linea; 
		try {
			while((linea = fichero.readLine()) !=null) {
				provi.add(linea);
				fichero.close();
			}
		}catch (IOException e) {
			System.out.print("error");
		}
	}
}


//Realizar un pro java que lea un fichero de texto y compruebe que no sobrepase unos caracteres 10mil*****
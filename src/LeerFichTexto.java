
import java.io.*;
public class LeerFichTexto {
	public static void main(String[] args) throws IOException {
		File fichero = 
				new File("C:\\Users\\aludam2\\Desktop\\Hola.txt");
		FileReader fic = new FileReader(fichero);
		int i;
		while ((i = fic.read()) != -1) { //se va leyendo el caracter
			System.out.println((char) i);
		}	
		fic.close(); //cerrar fichero
	}
}

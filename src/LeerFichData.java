package ejVerdir;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class LeerFichData {

	public static void main(String[] args) throws IOException {
		File fichero = 
				new File("C:\\Users\\aludam2\\Desktop\\FichData.dat");//declara el fichero
		
		FileInputStream filein = new FileInputStream(fichero);
		DataInputStream dataIS = new DataInputStream(filein);
		
		String n;
		int e;
		double a;
		
		try {
			while(true) {
				n = dataIS.readUTF();
				e = dataIS.readInt();
				a = dataIS.readDouble();
				System.out.println("Nombre: " + n + ", edad: " + e + ", altura: " + a);
			}
		} catch(EOFException eo) {
			dataIS.close();
		}
	}

}

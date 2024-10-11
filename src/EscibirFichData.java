package ejVerdir;

import java.io.*;

public class EscibirFichData {

	public static void main(String[] args) throws IOException  {
		File fichero = new File("C:\\Users\\aludam2\\Desktop\\FichData.dat");//declara el fichero
		FileOutputStream fileout = new FileOutputStream(fichero);
		DataOutputStream dataOS = new DataOutputStream(fileout);
		
		String nombres[]= {"Ana","LuisMa", "Ali"};
		int edades[]= {12,9,1};
		Double alturas[] = {1.64,1.80,1.90};
		
		for (int i=0; i<alturas.length; i++) {
			dataOS.writeUTF(nombres[i]);
			dataOS.writeInt(edades[i]);	
			dataOS.writeDouble(alturas[i]);
		}
		dataOS.close(); //cerrar Stream
		
		
	}

}

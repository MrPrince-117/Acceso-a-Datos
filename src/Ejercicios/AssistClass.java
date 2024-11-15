package Ejercicios;

import java.io.*;


public class AssistClass {
	public static void main(String[] args) throws IOException {
		File fichero = new File("C:\\Users\\aludam2\\Desktop\\Asistencia.dat");
        FileOutputStream fileout = new FileOutputStream(fichero);
        DataOutputStream dataOS = new DataOutputStream(fileout);
        
        String[] prov = {"Davis", "Franklin", "Trevor", "Michel"};
        
        boolean[] prov2 = {true, false, true, true};
        for(int i=0; i<prov.length; i++) {
        	dataOS.writeUTF(prov[i]);
        	dataOS.writeBoolean(prov2[i]);
        }
        dataOS.close();
	}
}

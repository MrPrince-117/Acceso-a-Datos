package Personas;

import java.io.*;

public class LecturaEscrituraBytes {
    public static void main(String[] args) throws IOException {
        File fichero = new File("C:\\Users\\aludam2\\Desktop\\DAT\\FichData.dat");
        FileOutputStream fileout = new FileOutputStream(fichero);
        FileInputStream filein = new FileInputStream(fichero);
        DataOutputStream datout = new DataOutputStream(fileout);
        DataInputStream datin = new DataInputStream(filein);
        String[] nombre = {"Sanchez","LuisMi","Chema"};
        int[] edades = {13,14,15,};
        String n;
        int e;
        //Zona de accion
        for(int i=0;i<edades.length;i++) {
            datout.writeUTF(nombre[i]);
            datout.writeInt(edades[i]);
        }//Fin for
        fileout.close();
        try {
            while(true) {
                n= datin.readUTF();
                e=datin.readInt();
                System.out.println("Nombre:"+n+", edad:"+e);
            }//Fin while

        }catch(EOFException eo) {}//Fin try-catch
        datin.close();
    }//Fin main
}

package Ejercicios;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class EscribirFichAleaotrio {
    public static void main(String[] args) throws IOException {
        File fichero = new File("C:\\Users\\alu11dam2\\Desktop\\DAT\\AleatorioEmple2.dat");
        RandomAccessFile file = new RandomAccessFile(fichero, "rw");

        String[] apellido = {"Fer", "Gil", "Ramos"};
        int[] dept = {10, 20, 30};
        Double[] salario = {1000.45, 2230.78, 3002.9};

        StringBuffer buffer = null;
        int n = apellido.length;

        for (int i = 0; i < n; i++) {
            file.writeInt(i+1);

            buffer = new StringBuffer(apellido[i]);
            buffer.setLength(10);
            file.writeChars(buffer.toString());

            file.writeInt(dept[i]);
            file.writeDouble(salario[i]);
        }
        file.close();

    }
}

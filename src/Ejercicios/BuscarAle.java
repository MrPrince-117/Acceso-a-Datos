package Ejercicios;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class BuscarAle {
    public static void main(String[] args) throws IOException {
        File fichero = new File("C:\\Users\\aludam2\\Desktop\\DAT\\AleatorioEmple2.dat");
        RandomAccessFile file = new RandomAccessFile(fichero, "r");

        
        char[] apellido = new char[10];
        char aux;
        int id, dep ;
        double salario;
        
        int identificador = 3;

        long posicion = (identificador - 1)* 36;

        if(posicion >= file.length()) {
            System.out.printf("ID: %d, no existe empleado....", identificador);
        }else {
            file.seek(posicion);
            id = file.readInt();

            for (int i =0; i<apellido.length;i++){
                aux = file.readChar();
                apellido[i] = aux;
            }

            String apellidos = new String(apellido);
            dep = file.readInt();
            salario = file.readDouble();

            if (id>0){
                System.out.printf("ID: %s, Apellido: %s, Departamento: %d, Salario: %.2f %n", id, apellidos.trim(), dep, salario);
            }

        }
        file.close();


    }
}

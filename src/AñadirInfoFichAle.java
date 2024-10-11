import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.*;

public class AñadirInfoFichAle {
    public static void main(String[] args) throws IOException {
        File fichero = new File("C:\\Users\\aludam2\\Desktop\\DAT\\AleatorioEmple2.dat");
        RandomAccessFile file = new RandomAccessFile(fichero, "r");

        StringBuffer buffer = null;

        String apellido = "GONZALEZ";
        Double salario = 1230.67;
        int id = 20;
        int dep = 10;

        long posicion = (id -1) * 36;

        file.seek(posicion);
        file.writeInt(id);
        buffer = new StringBuffer(apellido);
        buffer.setLength(10);
        file.writeChars(buffer.toString());
        file.writeInt(dep);
        file.writeDouble(salario);
    }
}

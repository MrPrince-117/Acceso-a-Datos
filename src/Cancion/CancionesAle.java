package Cancion;

import java.io.*;


public class CancionesAle {

    //Crear fichero aleatorio de canciones
    // y crear clase para añadir una cancion y  que permita buscar cancion por identificador

    public static void main(String[] args) throws IOException {
        File objeto = new File("C:\\Users\\aludam2\\Desktop\\DAT\\Canciones.dat");
        File aleatorio = new File("C:\\Users\\aludam2\\Desktop\\DAT\\CancionesAleatorias.dat");
        RandomAccessFile file= new RandomAccessFile (aleatorio, "rw");
        FileInputStream fis= new FileInputStream(objeto);
        ObjectInputStream datain= new ObjectInputStream(fis);
        StringBuffer buffer =null;
        long logitud;
        int id;
        int añoEntero;
        String titulo;
        String artista;
        String duracion;
        boolean cancionEspañola;
        Cancion c;
        try {
            while (true){
                c =(Cancion) datain.readObject();

                id=c.getId();

                logitud= (id-1)* 129L;

                file.seek(logitud);
                file.writeInt(id);
                int año = c.getAño();
                file.writeInt(año);
                titulo= c.getTitulo();
                buffer=new StringBuffer(titulo);
                buffer.setLength(20);
                file.writeChars(buffer.toString());
                artista= c.getAutor();
                buffer=new StringBuffer(artista);
                buffer.setLength(20);
                file.writeChars(buffer.toString());
                duracion = String.valueOf(c.getDuracion());
                buffer=new StringBuffer(duracion);
                buffer.setLength(20);
                file.writeChars(buffer.toString());
                cancionEspañola= c.getCancionEspañola();
                file.writeBoolean(cancionEspañola);
            }//Fin while
        }catch (EOFException | ClassNotFoundException e){
            System.out.println("Fin de lectura");
        }//Fin try-catch
        datain.close();
        file.close();
    }//Fin main

}

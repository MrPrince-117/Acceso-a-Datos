package Ejercicios;

import Personas.Persona;

import java.io.*;


public class EscribirFichObj {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		Persona persona;
		
		File fichero = new File("C:\\Users\\aludam2\\Desktop\\FichPersona.dat");
		FileOutputStream fileout = new FileOutputStream(fichero);
		ObjectOutputStream dataOS = new ObjectOutputStream(fileout);
		FileInputStream fileIn = new FileInputStream(fichero);
		ObjectInputStream dataIS = new ObjectInputStream(fileIn);
		
		String[] nombres = {"Michel", "Trevor", "Franklin"};
		int[] edades = {25, 50, 45};
		
		for(int i=0; i<edades.length; i++) {
			persona = new Persona(nombres[i], edades[i]);
			dataOS.writeObject(persona);
		}
		dataOS.close();
		try {
			while(true){
				persona = (Persona) dataIS.readObject();
				System.out.printf("Nombre: %s, edad: %d %n " , persona.getNombre(), persona.getEdad());
			}
		} catch (EOFException e) {
			System.out.println("Fin de Lectura");
		}
		dataIS.close();
	}

}

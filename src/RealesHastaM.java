package ejVerdir;

import java.io.*;
import java.util.Scanner;

public class RealesHastaM {

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		

		File fichero = 
				new File("C:\\Users\\aludam2\\Desktop\\FichB.txt");//declara el fichero
		
		FileOutputStream fileout = new FileOutputStream(fichero);
		
		
		FileInputStream filein = new FileInputStream(fichero);
		
		int num;
		System.out.println("Escribe 10 numeros Reales");
		for (int i=0; i<10; i++) {
			num = sc.nextInt();
			System.out.print(" ");
			fileout.write((int) num);
		}
		fileout.close();
		
	}

}

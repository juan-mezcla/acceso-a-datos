package tarea3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner prompt=new Scanner(System.in);
		System.out.println("Elige el archivo de escritura:");
		String archWrite=prompt.nextLine();
		
		File archivoEscritura=new File(archWrite);
		
		System.out.println("Elige el archivo que va a leer:");
		String archRead=prompt.nextLine();
		
		System.out.println("Texto que va a tener el archivo:");
		String contenido=prompt.nextLine();
		
		
		File archivoLectura=new File(archRead);
		
		try {
			FileReader lecturaArchivo=new FileReader(archivoEscritura);
			BufferedReader reader=new BufferedReader(lecturaArchivo);
			
			FileWriter escrituraArchivo=new FileWriter(archivoLectura);
			
			String linea="";
			int cont=1;
			while((linea=reader.readLine())!=null) {
				if(cont%2==0) {
					escrituraArchivo.write(linea+" ");
					System.out.println("par linea:"+ linea);
				}
				cont++;
			}
			escrituraArchivo.close();
			lecturaArchivo.close();
			System.out.println("Fin programa");
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

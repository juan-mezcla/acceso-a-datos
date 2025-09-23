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
		System.out.println("Elige el archivo que se va a escribir:");
		String archWrite=prompt.nextLine();
		
		File archivoEscritura=new File(archWrite);
		
		System.out.println("Elige el archivo que va a leer:");
		String archRead=prompt.nextLine();
		
		System.out.println("Elige el otro archivo que va a leer:");
		String archRead2=prompt.nextLine();
		
		//System.out.println("Texto que va a tener el archivo:");
		//String contenido=prompt.nextLine();
		
		
		File archivoLectura=new File(archRead);
		
		File archivoLectura2=new File(archRead2);
		
		try {
			
			FileReader lecturaArchivo1=new FileReader(archivoLectura);
			
			FileReader lecturaArchivo2=new FileReader(archivoLectura2);
			
			BufferedReader reader1=new BufferedReader(lecturaArchivo1);
			
			BufferedReader reader2=new BufferedReader(lecturaArchivo2);
			
			
			FileWriter escrituraArchivo=new FileWriter(archivoEscritura);
			
			String linea1="";
			String linea2="";
			int vueltas=1;
			while(linea1!=null || linea2!=null) {
				
				linea1=reader1.readLine();
				linea2=reader2.readLine();
				
				System.out.println("Vuelta "+vueltas+"\nLinea de archivo 2: "+linea1+"\n");
				if(linea1!=null) {
				escrituraArchivo.write(linea1+"\n");
				}
				
				System.out.println("\nLinea de archivo 3: "+linea2+"\n");
				if(linea2!=null) {
				escrituraArchivo.write(linea2+"\n");
				}
				vueltas++;
			}
			
			reader1.close();
			reader2.close();
			escrituraArchivo.close();
		
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		 //EJERCICIO 1 y 2
		 
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
		* */
	}

}

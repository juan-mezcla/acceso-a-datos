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
			while((linea1=reader1.readLine())!=null && (linea2=reader2.readLine())!=null) {//Con readLine si el condicional && no llega al segundo se queda sin leer esa linea
				
				escrituraArchivo.write(linea1+"\n");			
				escrituraArchivo.write(linea2+"\n");
				
			}
			
			
			while(linea1!=null) {//Sera null si ya no contiene nada el fichero
				escrituraArchivo.write(linea1+"\n");
				linea1=reader1.readLine();
			}
			
			while((linea2=reader2.readLine())!=null) {//Sera null si ya no contiene nada el fichero, pero comprobamos por si no ha leido en el primer while por que el primer fichero se ha quedado vacio.
				escrituraArchivo.write(linea2+"\n");
				linea2=reader2.readLine();
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
		}finally {
			System.out.println("Find el programa");
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

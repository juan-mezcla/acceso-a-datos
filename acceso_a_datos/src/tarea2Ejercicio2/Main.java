package tarea2Ejercicio2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner prompt=new Scanner(System.in);
		System.out.println("Escribe la ruta del archivo:");
		String ruta=prompt.nextLine();
		
		File archivo=new File(ruta);
		
		String textoCompleto = "";
		String texto=null;
		System.out.println("Introduce el texto que quieres que tenga el archivo");
		
		do {
			System.out.println("Siguiente linea");
			texto=prompt.nextLine();
			if(!texto.trim().equalsIgnoreCase("exit")) {
			textoCompleto+="\n"+texto;
			}
			
			//System.out.println("prompt:"+texto+" es igual que exit? "+(texto.toLowerCase().trim()!="exit"));
		}while(!texto.equalsIgnoreCase("exit"));
	
		
		try {
			FileWriter escribir=new FileWriter(archivo);
			
			escribir.write(textoCompleto);
			
			escribir.close();
			FileReader leerArch=new FileReader(archivo);
			
			BufferedReader buffer=new BufferedReader(leerArch);
			
			String linea;
			
			while((linea=buffer.readLine())!=null) {
				System.out.println(linea);
			}
			
			buffer.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

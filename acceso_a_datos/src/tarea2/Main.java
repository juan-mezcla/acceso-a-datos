package tarea2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner prompt=new Scanner(System.in);
		
		System.out.println("Introduce la ruta del archivo que quieres leer");
		String ruta=prompt.nextLine();
		
		File arch=new File(ruta);
		
		try {
			
			FileReader leerArch=new FileReader(arch);
			
			BufferedReader buffer=new BufferedReader(leerArch);
			
			String linea;
			
			while((linea=buffer.readLine())!=null) {
				System.out.println(linea);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

}

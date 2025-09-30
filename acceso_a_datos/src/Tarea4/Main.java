package Tarea4;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner prompt=new Scanner(System.in);
		System.out.println("Nombre del archivo binario:");
		String nombreArch=prompt.nextLine();
		System.out.println("Ruta del archivo:");
		String rutaArch=prompt.nextLine()+nombreArch+".txt";
		  
		
		try {
			FileOutputStream escrituraArch=new FileOutputStream(new File(rutaArch),true);
			ObjectOutputStream writeObj=new ObjectOutputStream(escrituraArch);
			Alumno alumno=new Alumno();
			writeObj.writeObject(alumno);
			System.out.println("Alumno añadido.");
			writeObj.close();
			escrituraArch.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

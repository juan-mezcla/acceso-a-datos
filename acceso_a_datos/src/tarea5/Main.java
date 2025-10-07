package tarea5;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner prompt = new Scanner(System.in);
		
		System.out.println("Nombre del archivo binario:");
		String nombreArch = prompt.nextLine();
		
		System.out.println("Ruta del archivo:");
		String rutaArch = prompt.nextLine() + nombreArch + ".txt";

		try {
			FileOutputStream escrituraArch = new FileOutputStream(new File(rutaArch), true);
			ObjectOutputStream writeObj = new ObjectOutputStream(escrituraArch);
			
			for (int i = 0; i < 5; i++) {
				Alumno alumno = new Alumno();
				writeObj.writeObject(alumno);
			}
			
			System.out.println("Alumnos añadidos.");
			writeObj.close();
			escrituraArch.flush();
			
			FileInputStream leer=new FileInputStream(new File(rutaArch));
			ObjectInputStream leerObj=new ObjectInputStream(leer);
			
			System.out.println("Alumnos leidos de fichero");
			while(leer.available()>0) {
				Alumno alumnoLeido=(Alumno) leerObj.readObject();
				System.out.println(alumnoLeido.toString());
			}
			
			leerObj.close();
			leer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

package tarea4;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * 
 * <p>
 * Programa en el que le pide al usuario que meta el nombre del archivo y la ruta donde se encuentra, para añadir un alumno al fichero binario {@link Alumno}. Si el archivo ya existe, añade el
 * nuevo alumno al final. (pero a la hora de mostrar daria error por que duplica las cabeceras. Solucionado en Tarea6 sobreescribiendo la clase ObjectOutputStream)
 * </p>
 * 
 * <p>
 * Este programa forma parte del paquete {@code Tarea4} y utiliza
 * {@link java.io.ObjectOutputStream} para la serialización de objetos.
 * </p>
 * 
 * @author Juan
 * @version 1.0
 */
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

			Alumno alumno = new Alumno();

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

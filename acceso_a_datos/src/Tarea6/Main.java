package Tarea6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static Scanner prompt = new Scanner(System.in);
	static List<String> archivos = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void menu() {
		int opcion = 0;
		do {
			System.out.println(
					"Elige la opcion que quieres realizar: 1-Generar fichero nuevo. 2-Selecionar un fichero. 3-Salir");
			opcion = prompt.nextInt();

			switch (opcion) {
			case 1:
				crearArchivo();
				break;

			case 2:
				seleccionarArchivo();
				break;
			default:
				break;
			}

		} while (opcion != 3);
	}

	public static void menuFichero(File arch) {
		int opcion = 0;
		do {
			System.out.println("Elige lo que quieres hacer con el fichero: 1-Añadir alumno. 2-Mostrar alumnos. 3-Salir");
			opcion = prompt.nextInt();

			switch (opcion) {
			case 1:
				anadirAlumno(arch);
				break;

			case 2:
				MostrarAlumnos(arch);
				break;
			
			}

		} while (opcion != 3);
	}

	public static void crearArchivo() {

		File arch = null;
		boolean exists = false;
		do {
			try {
				exists = false;

				System.out.println("Indica la ruta y el nombre del nuevo archivo con su extension:");
				String ruta = prompt.nextLine();

				arch = new File(ruta);

				if (!arch.exists()) {
					arch.createNewFile();
					menuFichero(arch);
					archivos.add(ruta);
				} else {
					System.out.println("Ya existe un archivo con ese nombre");
					exists = true;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} while (exists);

	}

	public static void seleccionarArchivo() {
		int cont = 1;
		System.out.println("Archivos con contenido de alumnos:");
		for (String arch : archivos) {

			System.out.println(cont + "-" + arch);
			cont++;

		}

		System.out.println("Elige un archivo:");
		int opcion = prompt.nextInt();
		if (opcion < archivos.size() - 1 || opcion >= 0) {

			menuFichero(new File(archivos.get(opcion - 1)));

		}else {
			System.out.println("fuera de rango");
		}
	}

	public static void anadirAlumno(File arch) {

	}

	public static void MostrarAlumnos(File arch) {

	}

}

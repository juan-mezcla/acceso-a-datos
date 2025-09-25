package acceso_a_datos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static Scanner prompt = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Alumno> alumnos = new ArrayList<>();
		System.out.println("Mostrar alumnos:");
		for (int i = 0; i < 10; i++) {
			Alumno alumno = new Alumno();
			alumnos.add(alumno);

			System.out.println(alumno.toString() + "\n");
		}

		System.out.println("Mostrar alumnos ordenados por Nia:");
		alumnos.sort(Comparator.comparing(Alumno::getNia));

		for (Alumno alumno : alumnos) {
			System.out.println(alumno.toString() + "\n");
		}
		menu(alumnos);
		
	}

	public static void menu(List<Alumno> alumnos) throws java.util.InputMismatchException{
		
		int opcion=0;
		
		do {
			try {
			System.out.println("Elige una opcion: 1-Añadir Alumno. 2-Mostrar Alumnos ordenados. 3-Salir.");
			opcion=prompt.nextInt();
			prompt.nextLine();
			switch(opcion) {
			case 1:
				
				anadirAlumno(alumnos);
				break;
			case 2:
				
				mostrarAlumnos(alumnos);
				break;
			
			case 3:
				System.out.println("fin del programa");
				break;
			default:
				System.out.println("Fuera de rango.");
			
			}
			}catch(java.util.InputMismatchException e) {
				System.out.println("error no introducido dato numerico");
				opcion=0;
				prompt.nextLine();
			}
				
		}while(opcion!=3);
	}

	public static void mostrarAlumnos(List<Alumno> alumnos) throws  java.util.InputMismatchException {
		int opcion = 0;
		System.out.println(
				"como quieres ordenar los alumnos: 1-Nia. 2-Ciclo. 3-Curso. 4-Grupo. 5-Nombre. 6-Apellidos. 7-Fecha. 8-Genero.");
			opcion=prompt.nextInt();
			
			prompt.nextLine();
		switch (opcion) {
		case 1:
			System.out.println("Mostrar alumnos ordenados por Nia:");
			alumnos.sort(Comparator.comparing(Alumno::getNia));

			for (Alumno alumno : alumnos) {
				System.out.println(alumno.toString() + "\n");
			}
			break;

		case 2:
			System.out.println("Mostrar alumnos ordenados por Ciclo:");
			alumnos.sort(Comparator.comparing(Alumno::getCiclo));

			for (Alumno alumno : alumnos) {
				System.out.println(alumno.toString() + "\n");
			}

			break;

		case 3:
			System.out.println("Mostrar alumnos ordenados por Curso:");
			alumnos.sort(Comparator.comparing(Alumno::getCurso));

			for (Alumno alumno : alumnos) {
				System.out.println(alumno.toString() + "\n");
			}
			break;

		case 4:
			System.out.println("Mostrar alumnos ordenados por Grupo:");
			alumnos.sort(Comparator.comparing(Alumno::getGrupo));

			for (Alumno alumno : alumnos) {
				System.out.println(alumno.toString() + "\n");
			}
			break;
		case 5:
			System.out.println("Mostrar alumnos ordenados por Nombre:");
			alumnos.sort(Comparator.comparing(Alumno::getNombre));

			for (Alumno alumno : alumnos) {
				System.out.println(alumno.toString() + "\n");
			}
			break;
		case 6:
			System.out.println("Mostrar alumnos ordenados por Apellidos:");
			alumnos.sort(Comparator.comparing(Alumno::getApellidos));

			for (Alumno alumno : alumnos) {
				System.out.println(alumno.toString() + "\n");
			}
			break;
		case 7:
			System.out.println("Mostrar alumnos ordenados por Fecha:");
			alumnos.sort(Comparator.comparing(Alumno::getFecha));

			for (Alumno alumno : alumnos) {
				System.out.println(alumno.toString() + "\n");
			}
			break;
			
		case 8:
			System.out.println("Mostrar alumnos ordenados por genero:");
			alumnos.sort(Comparator.comparing(Alumno::getGenero));

			for (Alumno alumno : alumnos) {
				System.out.println(alumno.toString() + "\n");
			}
			break;

		default:
			System.out.println("Fuera de rango.");
		}

	}

	public static void anadirAlumno(List<Alumno> alumnos) throws  java.util.InputMismatchException {
		System.out.println("Introduce el Nia:");
		int nia = prompt.nextInt();
		prompt.nextLine();
		System.out.println("Introduce el nombre:");
		String nombre = prompt.nextLine();

		System.out.println("Introduce el apellidos:");
		String apellidos = prompt.nextLine();

		System.out.println("Introduce el genero:1-M 2-F");
		char genero = (prompt.nextInt() == 1) ? 'M' : 'F';
		prompt.nextLine();
		System.out.println("Introduce el curso:");
		String curso = prompt.nextLine();

		System.out.println("Introduce el ciclo:");
		String ciclo = prompt.nextLine();

		System.out.println("Introduce el grupo:");
		String grupo = prompt.nextLine();

		System.out.println("Introduce la fecha (formato-> xx/xx/xxxx):");
		String fecha = prompt.nextLine();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		alumnos.add(new Alumno(nia, nombre, apellidos, ciclo, curso, grupo, genero, LocalDate.parse(fecha, formatter)));
		System.out.println("Alumno añadido correctamente.");
	}

}

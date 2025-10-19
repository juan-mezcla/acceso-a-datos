package tarea6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static Scanner prompt = new Scanner(System.in);
	static List<String> archivos = new ArrayList<>();
	static File listaArchivosUsados=new File("archivosUsados.txt");
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			if(!listaArchivosUsados.exists()) {
				listaArchivosUsados.createNewFile();
			}
			
			
			FileInputStream leerArch=new FileInputStream(listaArchivosUsados);
			BufferedReader leerArchivosUsados=new BufferedReader(new InputStreamReader(leerArch));
			
			String nombresArchivos;
			
			while((nombresArchivos=leerArchivosUsados.readLine())!=null) {
				if(!archivos.contains(nombresArchivos)) {
					
					archivos.add(nombresArchivos);
				}
			}
			leerArchivosUsados.close();
			leerArch.close();
			
			menu();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			prompt.close();
		}
	}

	public static void menu() {
		int opcion = 0;
		File arch=null;
		do {
			opcion=0;
			System.out.println(
					"Elige la opcion que quieres realizar: 1-Generar fichero nuevo. 2-Selecionar un fichero. 3-Salir");
			opcion = prompt.nextInt();
			prompt.nextLine();
			switch (opcion) {
			case 1:
				
				do {
					System.out.println("Indica la ruta y el nombre del nuevo archivo con su extension:");
					String ruta = prompt.nextLine();
					arch=crearArchivo(ruta);
				}while(!arch.exists());
				menuFichero(arch);
				break;

			case 2:
				System.out.println(archivos.size());
				if(archivos.size()>0) {
					
					int cont = 1;
					System.out.println("Archivos con contenido de alumnos:");
					try {
						if(!listaArchivosUsados.exists()) {
							listaArchivosUsados.createNewFile();
						}
						FileInputStream leerListaArchivos=new FileInputStream(listaArchivosUsados);
						BufferedReader leerArchivosUsados=new BufferedReader(new InputStreamReader(leerListaArchivos));
						
						String nombresArchivos;
						
						while((nombresArchivos=leerArchivosUsados.readLine())!=null) {
							System.out.println(cont + "-" + nombresArchivos);
							cont++;
						}
						leerArchivosUsados.close();
						leerListaArchivos.close();
						
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					System.out.println("Elige un archivo:");
					arch=seleccionarArchivo(prompt.nextInt());
					prompt.nextLine();
					
					if(arch.exists()) {					
						menuFichero(arch);
					}
				}else {System.out.println("No se han creado archivos aun con contenido de alumnos.");}
				break;

			case 3:
				System.out.println("FIN");
				break;
			default:
				System.out.println("Fuera de rango.");
				break;
			}
		} while (opcion != 3);
	}

	public static void menuFichero(File arch) {
		int opcionArch = 0;
		do {
			opcionArch = 0;
			System.out.println(
					"Elige lo que quieres hacer con el fichero: 1-Añadir alumno. 2-Mostrar alumnos. 3-Salir al menu de inicio.");
			opcionArch = prompt.nextInt();
			prompt.nextLine();
			switch (opcionArch) {
			case 1:
				anadirAlumno(arch);
				break;

			case 2:
				mostrarAlumnos(arch);
				break;
			case 3:
				System.out.println("salida de fichero");
				break;
			default:
				System.out.println("Fuera de rango.");
				break;

			}

		} while (opcionArch != 3);
	}

	public static File crearArchivo(String ruta) {
			File arch=null;
		
			try {
				if(!listaArchivosUsados.exists()) {
					listaArchivosUsados.createNewFile();
				}
				
				if(archivos.size()<0) {
					archivos.add(ruta);
				}
				
				FileInputStream leerArch=new FileInputStream(listaArchivosUsados);
				BufferedReader leerArchivosUsados=new BufferedReader(new InputStreamReader(leerArch));
				
				String nombresArchivos;
				
				while((nombresArchivos=leerArchivosUsados.readLine())!=null) {
					if(!archivos.contains(nombresArchivos)) {
						
						archivos.add(ruta);
					}
				}
				leerArchivosUsados.close();
				leerArch.close();
				arch = new File(ruta);

				if (!arch.exists()) {
					FileOutputStream escribirArch=new FileOutputStream(listaArchivosUsados,true);
					
					PrintWriter escribir=new PrintWriter (escribirArch);
					escribir.write(ruta.trim()+"\n");
					
					escribir.close();
					escribirArch.close();
					
					arch.createNewFile();
					
					
				} else {
					System.out.println("Ya existe un archivo con ese nombre");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return arch;

	}

	public static File seleccionarArchivo(int opcion) {
		File arch=null;
		
		if (opcion<= archivos.size() && opcion >= 0) {
			
			arch=new File(archivos.get(opcion - 1));
			
		} else {
			System.out.println("fuera de rango");
		}
		
		return arch;

	}

	public static boolean anadirAlumno(File arch) {
		boolean error=false;
		try (FileOutputStream escribirArch = new FileOutputStream(arch, true)) {
			
			ObjectOutputStream alumno = (arch.length()>0)?new MiObjectOutput(escribirArch):new ObjectOutputStream(escribirArch);

			alumno.writeObject(new Alumno());
			
			escribirArch.flush();;
			alumno.close();
			error=true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return error;
	}

	public static boolean mostrarAlumnos(File arch) {
		boolean error=false;
		try (FileInputStream leer = new FileInputStream(arch)) {
			ObjectInputStream leerObj = new ObjectInputStream(leer);

			System.out.println("Alumnos dentro del archivo leido:");
			while (leer.available() > 0) {
				Alumno alumno = (Alumno) leerObj.readObject();
				System.out.println(alumno.toString());
			}

			leer.close();
			leerObj.close();
			error=true;
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
		return error;
	}

}

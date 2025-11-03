package tarea9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.w3c.dom.Document;

public class Main {

	private Scanner prompt = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main().run();
	}

	private void run() {
		menu();
	}
	
	
	public void menu() {
		int opcion=0;
		
		do {
		System.out.println("elige una opcion: 1-Generar xml de un archvio srt. 2-Generar xml de archivos .srt en carpeta");
		opcion=prompt.nextInt();
		prompt.nextLine();
		
		
		switch (opcion) {
		case 1: 
			System.out.println("Ruta del fichero de subtitulos (.srt):");
			String ruta = "ejemplo.srt";// prompt.next();
			
			//con el array r y b sacamos el nombre del .srt para ponerselo al xml en caso de que tenga una ruta mas extensa.
			String r[]=ruta.split(".srt");
			String b[]=r[0].split("/");
			String nombre=b[b.length-1];
			
			TransformadorSRTaXML srt_a_Xml = new TransformadorSRTaXML(ruta,nombre,"subtitulos","1.0");
			srt_a_Xml.crearXml();
			
			break;
		case 2:
			File dir=new File("D:\\empleo\\documentos Juan");
			
			if(dir.isDirectory()) {
				String files[]=dir.list();
				for(String file: files) {
					File f=new File(file);
					if(f.isFile()) {
						
						if(file.endsWith(".srt")) {
							
							System.out.println(file+"\n");
						}
					}
				}
			}
			break;
		default:
			System.out.println("fin del programa");
		}
		
		
		}while(opcion!=3);
	}

}

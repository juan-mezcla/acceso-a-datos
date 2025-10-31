package tarea9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Main {
	
	private Scanner prompt=new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main().run();
	}
	
	public void run() {
		System.out.println("Ruta del fichero de subtitulos (.srt):");
		String ruta="ejemplo.srt";//prompt.next();
		
		File archSrt=new File(ruta);
		List<String> subtitulos=new ArrayList<String>();
		
		List<Atributo> atributos=null;
		
		try(BufferedReader leerArch=new BufferedReader(new FileReader(archSrt));) {
			String contenidoSrt="";
			
			
			String linea;
			while((linea=leerArch.readLine())!=null) {
				
				
					subtitulos.add(linea);
				
				contenidoSrt+=" "+linea;
			}
			leerArch.close();
			System.out.println(contenidoSrt);
			//String subtitulos[]=contenidoSrt.split("\\d{1}$");
			
			
			ArchivoXml xml=new ArchivoXml("Subtitulos","subtitulos","1.0");
			Document doc=xml.getDoc();
			
			
			boolean siguienteSubtitulo=true;
			
			String texto="";
			
			for(String subtitulo:subtitulos) {
				
				if(subtitulo.matches("\\d+") && !siguienteSubtitulo) {//añadimos los datos de atributo y linea dentro de la etiqueta.
					System.out.println("Añadidos los atributos a la etiqueta.");
					System.out.println("Texto: "+texto);
					xml.anadirAtributo(doc.getDocumentElement(), "subtitulo", texto, atributos);
					siguienteSubtitulo=true;
				}
				
				  
				if(subtitulo.matches("\\d+")) {//comprobamos que sea el numero de la columna.
					System.out.println("Creacion de atributo columna:"+subtitulo+" \n");
					atributos=new ArrayList<Atributo>();
					atributos.add(new Atributo("numero", subtitulo));
					
					siguienteSubtitulo=false;
					
				}else if(subtitulo.contains("-->")) {//comprobamos si es el tiempo de inicio y fin
					System.out.println("Creacion de atributos de tiempo. \n");
					String tiempos[]=subtitulo.split("-->");
					
					atributos.add(new Atributo("inicio", tiempos[0].trim()));
					atributos.add(new Atributo("fin", tiempos[1].trim()));
				
				}else if(!subtitulo.trim().equals(" ")) {//El texto que tendra la etiqueta.
					System.out.println("Texto de la etiqueta con contenido:"+subtitulo+" \n");
					texto+=" "+subtitulo;
				}
				
				
				
			}
			System.out.println("Fin bucle for.");
			xml.crearXml();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

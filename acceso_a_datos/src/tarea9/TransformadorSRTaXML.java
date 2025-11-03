package tarea9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;

public class TransformadorSRTaXML extends ArchivoXml {

	private String srt,texto = "";;
	private List<Atributo> atributos = null;
	/**
	 * @param srt
	 */
	public TransformadorSRTaXML(String srt, String nombre, String etiquetaRaiz, String version) {

		super(nombre, etiquetaRaiz, version);
		this.srt = srt;

		this.transformador();
	}

	private void transformador() {
		File archSrt = new File(this.getSrt());
		List<Atributo> atributos = null;

		try (BufferedReader leerArch = new BufferedReader(new FileReader(archSrt));) {
			String linea;
			
			Document doc = this.getDoc();

			boolean siguiente = true;

			while ((linea = leerArch.readLine()) != null) {

				if (linea.equals("") && !siguiente) {// añadimos los datos de atributo y linea dentro
					// de la etiqueta.
					//System.out.println("Añadidos los atributos a la etiqueta.");
					//System.out.println("Texto: " + this.getTexto());

					this.anadirAtributo(doc.getDocumentElement(), "subtitulo", this.getTexto(), this.getAtributos());
					
					this.setTexto("");
					siguiente = true;
				}

				siguiente=siguienteSubtitulo(linea,siguiente);
			}
			leerArch.close();

			System.out.println("Fin bucle.");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("archivo no encontrado");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private boolean siguienteSubtitulo(String linea, boolean siguienteSubtitulo) {
		if (linea.matches("\\d+")) {// comprobamos que sea el numero de la columna.
			//System.out.println("Creacion de atributo columna:" + linea + " \n");

			this.setAtributos(new ArrayList<Atributo>());

			this.getAtributos().add(new Atributo("numero", linea));

			siguienteSubtitulo = false;

		} else if (linea.contains("-->")) {// comprobamos si es el tiempo de inicio y fin
			//System.out.println("Creacion de atributos de tiempo. \n");
			String tiempos[] = linea.split("-->");

			this.getAtributos().add(new Atributo("inicio", tiempos[0].trim()));
			this.getAtributos().add(new Atributo("fin", tiempos[1].trim()));
			
		} else if (!linea.equals("")) {// El texto que tendra la etiqueta.
			//System.out.println("Texto de la etiqueta con contenido:" + linea + " \n");
			this.setTexto(this.getTexto()+" "+linea);
		}

		return siguienteSubtitulo;
	}

	/**
	 * @return the srt
	 */
	private String getSrt() {
		return srt;
	}

	/**
	 * @return the atributos
	 */
	private List<Atributo> getAtributos() {
		return atributos;
	}

	/**
	 * @param atributos the atributos to set
	 */
	private void setAtributos(List<Atributo> atributos) {
		this.atributos = atributos;
	}

	/**
	 * @return the texto
	 */
	private String getTexto() {
		return texto;
	}

	/**
	 * @param texto the texto to set
	 */
	private void setTexto(String texto) {
		this.texto = texto;
	}
	
	

}

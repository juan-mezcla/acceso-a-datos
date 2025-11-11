package tarea9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IntervalosSinSubtítulos {
	private String ruta, textoMasLargo = "", textoSubtitulo = "";;
	private File archivoSrt, archivoDeSalida;
	private static final int LONGITUDMAX = 50;
	private List<String> subtituloMasLargo = new ArrayList<String>();
	private List<String> subtitulo = new ArrayList<String>();

	/**
	 * @param archivo
	 */
	public IntervalosSinSubtítulos(File archivoSrt, File outPut) {

		if (!archivoSrt.isAbsolute()) {
			archivoSrt = new File(System.getProperty("user.dir"), ruta);
		}
		String nombreArchSalida = outPut.getName();
		if (!outPut.isAbsolute()) {
			outPut = new File(System.getProperty("user.dir"), nombreArchSalida);
		}

		this.archivoSrt = archivoSrt;
		this.archivoDeSalida = outPut;

	}

	public void buscarIntervalosSrt() {
		FileReader leerArchivo;
		FileWriter escribirArchivo;
		try {

			leerArchivo = new FileReader(this.getArchivoSrt());
			escribirArchivo = new FileWriter(this.getArchivoDeSalida());

			try (BufferedWriter escribir = new BufferedWriter(escribirArchivo)) {

				try (BufferedReader leer = new BufferedReader(leerArchivo)) {

					String linea;
					boolean siguiente = true;

					while ((linea = leer.readLine()) != null) {
						if (linea.equals("") && !siguiente) {

							siguiente = true;
						}

						if (linea.contains("-->")) {

							escribir.write(linea+"\n");
							siguiente = false;
						}
					}
					escribir.close();
					leer.close();
					System.out.println("fin de lectura");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}

	/**
	 * @return the archivoDeSalida
	 */
	private File getArchivoDeSalida() {
		return archivoDeSalida;
	}

	/**
	 * @param archivoDeSalida the archivoDeSalida to set
	 */
	private void setArchivoDeSalida(File archivoDeSalida) {
		this.archivoDeSalida = archivoDeSalida;
	}

	/**
	 * @return the ruta
	 */
	private String getRuta() {
		return ruta;
	}

	/**
	 * @param ruta the ruta to set
	 */
	private void setRuta(String ruta) {
		this.ruta = ruta;
	}

	/**
	 * @return the archivoSrt
	 */
	private File getArchivoSrt() {
		return archivoSrt;
	}

	/**
	 * @param archivoSrt the archivoSrt to set
	 */
	private void setArchivoSrt(File archivoSrt) {
		this.archivoSrt = archivoSrt;
	}

}

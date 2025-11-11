package tarea9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LineaMasLarga {
	private String ruta,textoMasLargo = "", textoSubtitulo = "";
	private File archivoSrt;
	private static final int LONGITUDMAX = 50;
	private List<String> subtituloMasLargo = new ArrayList<String>();
	private List<String> subtitulo = new ArrayList<String>();
	/**
	 * @param archivo
	 */
	public LineaMasLarga(String ruta) {

		File f = new File(ruta);
		if (!f.isAbsolute()) {
			f = new File(System.getProperty("user.dir"), ruta);
		}
		this.archivoSrt = f;
	}

	public void buscarSrtConLineaMasLarga() {
		FileReader leerArchivo;
		
		try {
			leerArchivo = new FileReader(this.getArchivoSrt());
			try (BufferedReader leer = new BufferedReader(leerArchivo)) {

				String linea;
				boolean siguiente = true;

				while ((linea = leer.readLine()) != null) {
					if (linea.equals("") && !siguiente) {
						// comprobamos que el subtitulo que tenemos es mas largo o no que el que hubiese
						// anterior.
						if (this.getSubtituloMasLargo().size() <= 0) {
							if (this.getTextoSubtitulo().length() >= LONGITUDMAX) {

								this.getSubtitulo().add(this.getTextoSubtitulo().trim());
								this.setSubtituloMasLargo(new ArrayList<>(this.getSubtitulo()));
								this.setTextoMasLargo(this.getTextoSubtitulo());

							}
						} else if (this.getTextoMasLargo().length() < this.getTextoSubtitulo().length()) {

							if (this.getTextoSubtitulo().length() >= LONGITUDMAX) {

								this.getSubtitulo().add(this.getTextoSubtitulo().trim());
								this.setSubtituloMasLargo(new ArrayList<>(this.getSubtitulo()));
								this.setTextoMasLargo(this.getTextoSubtitulo());

							}

						}
						this.setTextoSubtitulo("");
						subtitulo.clear();
						siguiente = true;
					}

					siguiente = siguienteSubtitulo(linea, siguiente);
				}
				leer.close();
				System.out.println("Subtitulo mas largo dentro del archivo:");
				for (String contenido : subtituloMasLargo) {
					System.out.println(contenido + "\n");
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private boolean siguienteSubtitulo(String linea,boolean siguienteSubtitulo) {
		if (linea.matches("\\d+")) {
			this.getSubtitulo().add(linea);
			siguienteSubtitulo = false;

		} else if (linea.contains("-->")) {
			this.getSubtitulo().add(linea);

		} else if (!linea.equals("")) {
			this.setTextoSubtitulo(this.getTextoSubtitulo()+" "+linea);
		}

		return siguienteSubtitulo;
	}
	
	

	/**
	 * @return the textoMasLargo
	 */
	private String getTextoMasLargo() {
		return textoMasLargo;
	}

	/**
	 * @param textoMasLargo the textoMasLargo to set
	 */
	private void setTextoMasLargo(String textoMasLargo) {
		this.textoMasLargo = textoMasLargo;
	}

	/**
	 * @return the textoSubtitulo
	 */
	private String getTextoSubtitulo() {
		return textoSubtitulo;
	}

	/**
	 * @param textoSubtitulo the textoSubtitulo to set
	 */
	private void setTextoSubtitulo(String textoSubtitulo) {
		this.textoSubtitulo = textoSubtitulo;
	}

	/**
	 * @return the subtituloMasLargo
	 */
	private List<String> getSubtituloMasLargo() {
		return subtituloMasLargo;
	}

	/**
	 * @param subtituloMasLargo the subtituloMasLargo to set
	 */
	private void setSubtituloMasLargo(List<String> subtituloMasLargo) {
		this.subtituloMasLargo = subtituloMasLargo;
	}

	/**
	 * @return the subtitulo
	 */
	private List<String> getSubtitulo() {
		return subtitulo;
	}

	/**
	 * @return the ruta
	 */
	private String getRuta() {
		return ruta;
	}

	/**
	 * @return the archivoSrt
	 */
	private File getArchivoSrt() {
		return archivoSrt;
	}

}

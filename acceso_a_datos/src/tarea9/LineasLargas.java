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

public class LineasLargas {

	private File carpeta;
	private File ficheros[];
	private File lineasMasLargasTxt;
	private String textoSubtitulo;
	private int totalOcurrencias=0;
	private static final int LONGITUDMAX = 50;

	/**
	 * @param directorio
	 * @throws FileNotFoundException
	 */

	public LineasLargas(String directorio) throws FileNotFoundException {

		this.carpeta = new File(directorio);
		if (!this.getCarpeta().isDirectory()) {

			throw new java.io.FileNotFoundException("Esto no es un directorio.");

		} else {

			this.ficheros = this.getCarpeta().listFiles((d, arch) -> arch.toLowerCase().endsWith(".srt"));
			this.lineasMasLargasTxt = new File(this.getCarpeta(), "LineasMasLargas.txt");

			try {
				if (!this.getLineasMasLargasTxt().exists()) {

					this.getLineasMasLargasTxt().createNewFile();
				} else {
					try (BufferedWriter vaciarTxt = new BufferedWriter(new FileWriter(this.getLineasMasLargasTxt()));) {

						vaciarTxt.write("");

					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void recorrerCarpeta() {
		FileWriter txt;
		try {
			txt = new FileWriter(this.getLineasMasLargasTxt(), true);

			try (BufferedWriter escribir = new BufferedWriter(txt)) {

				for (File srt : this.getFicheros()) {
					FileReader srtLeer;

					srtLeer = new FileReader(srt);

					escribir.write("\n--------------Contenido largo dentro de " + srt.getName() + "--------------\n");
					
					this.setTotalOcurrencias(this.getTotalOcurrencias()+leerFichero(srtLeer, escribir));
					
				}
				System.out.println("numero de ocurrencias encontradas: "+this.getTotalOcurrencias());
				
				escribir.flush();
				escribir.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private int leerFichero(FileReader srtLeer,BufferedWriter escribir) {
		int ocurrencias = 0;
		try (BufferedReader leer = new BufferedReader(srtLeer)) {

			List<String> subtituloLargo = new ArrayList<>();
			String linea;
			boolean siguiente = true;

			
			while ((linea = leer.readLine()) != null) {
				
				if (linea.equals("") && !siguiente) {
					
					if (this.getTextoSubtitulo().length() > this.LONGITUDMAX) {
						
						subtituloLargo.add(this.getTextoSubtitulo());
						
						for (String cont : subtituloLargo) {
							
							escribir.write(cont + "\n");
							
						}
						ocurrencias++;
					}

					this.setTextoSubtitulo("");
					subtituloLargo.clear();
					siguiente = true;
				}

				siguiente = siguienteSubtitulo(linea, subtituloLargo, siguiente);

			}

			leer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ocurrencias;
	}

	private boolean siguienteSubtitulo(String linea, List subtitulo, boolean siguienteSubtitulo) {
		if (linea.matches("\\d+")) {

			siguienteSubtitulo = false;
			subtitulo.add(linea);

		} else if (linea.contains("-->")) {

			subtitulo.add(linea);

		} else if (!linea.equals("")) {

			this.setTextoSubtitulo(this.getTextoSubtitulo() + " " + linea);
		}

		return siguienteSubtitulo;
	}
	
	

	/**
	 * @return the totalOcurrencias
	 */
	private int getTotalOcurrencias() {
		return totalOcurrencias;
	}

	/**
	 * @param totalOcurrencias the totalOcurrencias to set
	 */
	private void setTotalOcurrencias(int totalOcurrencias) {
		this.totalOcurrencias = totalOcurrencias;
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
	 * @return the carpeta
	 */
	private File getCarpeta() {
		return carpeta;
	}

	/**
	 * @param carpeta the carpeta to set
	 */
	private void setCarpeta(File carpeta) {
		this.carpeta = carpeta;
	}

	/**
	 * @return the lineasMasLargasTxt
	 */
	private File getLineasMasLargasTxt() {
		return lineasMasLargasTxt;
	}

	/**
	 * @param lineasMasLargasTxt the lineasMasLargasTxt to set
	 */
	private void setLineasMasLargasTxt(File lineasMasLargasTxt) {
		this.lineasMasLargasTxt = lineasMasLargasTxt;
	}

	/**
	 * @return the ficheros
	 */
	private File[] getFicheros() {
		return ficheros;
	}

	/**
	 * @param ficheros the ficheros to set
	 */
	private void setFicheros(File[] ficheros) {
		this.ficheros = ficheros;
	}

}

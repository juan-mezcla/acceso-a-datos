package tarea9;

import java.io.File;
import java.util.Scanner;

public class Main {

    private Scanner prompt = new Scanner(System.in);

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        menu();
    }

    public void menu() {
        int opcion = 0;

        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Generar XML de un archivo .srt 2. Generar XML de todos los .srt en una carpeta 3. Guardar subtitulos mas largos. 4. Salir");
            System.out.println("Elige una opción: ");

            opcion = prompt.nextInt();
            prompt.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                	srtA_XML();
                    break;
                case 2:
                	carpetasConSubtitulosA_XML();
                    break;
                case 3:
                	srts_con_subtitulos_largos();
                    break;
                case 4:
                    System.out.println("Fin del programa.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 4);
    }

    private void srtA_XML() {
        System.out.println("Ruta del fichero de subtítulos (.srt): ");
        String ruta = prompt.nextLine().trim();

        File archivoSrt = new File(ruta);

        if (!archivoSrt.exists() || !archivoSrt.getName().endsWith(".srt")) {
            System.out.println("El archivo no existe o no tiene extensión .srt");
        }else {
        	
        	//Sacar el nombre base del archivo (sin extensión)
        	String nombreBase = archivoSrt.getName().replaceFirst("\\.srt$", "");
        	
        	//Crear el transformador
        	TransformadorSRTaXML srt_a_Xml = new TransformadorSRTaXML(archivoSrt.getAbsolutePath(),
        			new File(archivoSrt.getParent(), nombreBase).getAbsolutePath(),"subtitulos","1.0");
        	
        	srt_a_Xml.crearXml();
        }

    }

    private void carpetasConSubtitulosA_XML() {
        System.out.println("Ruta de la carpeta donde están los .srt: ");
        String rutaCarpeta = prompt.nextLine().trim();

        File dir = new File(rutaCarpeta);

        if (!dir.isDirectory()) {
            System.out.println("La ruta indicada no es una carpeta válida.");
            return;
        }

        File[] archivos = dir.listFiles((d, name) -> name.toLowerCase().endsWith(".srt"));//funcion lamba para seleccionar solo los .srt

        if (archivos == null || archivos.length == 0) {
            System.out.println("No se encontraron archivos .srt en la carpeta.");
            return;
        }

        for (File srtFile : archivos) {
            String nombreBase = srtFile.getName().replaceFirst("\\.srt$", "");

            System.out.println("Procesando: " + srtFile.getName());

            TransformadorSRTaXML srt_a_Xml = new TransformadorSRTaXML(
                    srtFile.getAbsolutePath(),
                    new File(srtFile.getParent(), nombreBase).getAbsolutePath(),
                    "subtitulos",
                    "1.0"
            );

            srt_a_Xml.crearXml();
        }

        System.out.println("Conversión completada para todos los archivos .srt.");
    }
    
    private void srts_con_subtitulos_largos() {
    	try {
    		System.out.println("Ruta de la carpeta donde están los .srt: ");
            String rutaCarpeta = prompt.nextLine().trim();
            
            LineasLargas comprobador=new LineasLargas(rutaCarpeta);
            comprobador.recorrerCarpeta();        
            
		} catch (java.io.FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }
}

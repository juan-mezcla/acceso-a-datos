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

    private String texto = "";
    private List<Atributo> atributos = null;
    private File archivoSrt;

    /**
     * Constructor que acepta tanto rutas absolutas como relativas.
     *
     * @param srt ruta o nombre del archivo .srt
     * @param nombre nombre base para el xml
     * @param etiquetaRaiz etiqueta raíz del xml
     * @param version versión del xml
     */
    public TransformadorSRTaXML(String srt, String nombre, String etiquetaRaiz, String version) {
        super(nombre, etiquetaRaiz, version);

    
        File f = new File(srt);
        if (!f.isAbsolute()) {
            f = new File(System.getProperty("user.dir"), srt);
        }
        this.archivoSrt = f;

        this.transformador();
    }

    private void transformador() {
        try (BufferedReader leerArch = new BufferedReader(new FileReader(this.archivoSrt))) {
            String linea;
            Document doc = this.getDoc();
            boolean siguiente = true;

            while ((linea = leerArch.readLine()) != null) {

                if (linea.equals("") && !siguiente) {
                    // Añadimos el texto y atributos a la etiqueta <subtitulo>
                    this.anadirAtributo(doc.getDocumentElement(), "subtitulo", this.getTexto(), this.getAtributos());
                    this.setTexto("");
                    siguiente = true;
                }

                siguiente = siguienteSubtitulo(linea, siguiente);
            }

            System.out.println("Transformación completada para: " + archivoSrt.getName());

        } catch (FileNotFoundException e) {
            System.err.println("Archivo no encontrado: " + archivoSrt.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean siguienteSubtitulo(String linea, boolean siguienteSubtitulo) {
        if (linea.matches("\\d+")) {
            this.setAtributos(new ArrayList<Atributo>());
            this.getAtributos().add(new Atributo("numero", linea));
            siguienteSubtitulo = false;

        } else if (linea.contains("-->")) {
            String tiempos[] = linea.split("-->");
            this.getAtributos().add(new Atributo("inicio", tiempos[0].trim()));
            this.getAtributos().add(new Atributo("fin", tiempos[1].trim()));

        } else if (!linea.equals("")) {
            this.setTexto(this.getTexto() + " " + linea);
        }

        return siguienteSubtitulo;
    }

    /**
     * Sobrescribimos el método crearXml() para guardar el XML en la misma carpeta
     * que el .srt
     */
    @Override
    public void crearXml() {
        try {
            // Ruta del XML en el mismo directorio del SRT
            String rutaXml = new File(archivoSrt.getParent(), this.getNombreXml() + ".xml").getAbsolutePath();
            this.setResult(new javax.xml.transform.stream.StreamResult(new File(rutaXml)));
            this.setRecurso(new javax.xml.transform.dom.DOMSource(this.getDoc()));

            javax.xml.transform.Transformer transformer = javax.xml.transform.TransformerFactory.newInstance().newTransformer();
            transformer.transform(this.getRecurso(), this.getResult());

            System.out.println("XML creado en: " + rutaXml);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<Atributo> getAtributos() { return atributos; }

    private void setAtributos(List<Atributo> atributos) { this.atributos = atributos; }

    private String getTexto() { return texto; }

    private void setTexto(String texto) { this.texto = texto; }
}

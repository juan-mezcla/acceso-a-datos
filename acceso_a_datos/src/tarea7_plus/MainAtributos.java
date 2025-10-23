package tarea7_plus;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.Source;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class MainAtributos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DocumentBuilderFactory instancia=DocumentBuilderFactory.newInstance();
		Alumno alumnos[]=new Alumno[5];
		List<Atributo> atributos=new ArrayList<>();
		
		for(int i=0; i<5; i++) {
			alumnos[i]=new Alumno();
			Alumno alumno=alumnos[i];		
		}
		try{
			ArchivoXml xml=new ArchivoXml("alumnosAtributos","alumnos","1.0");
			Document doc=xml.getDoc();
			
			for(Alumno alumno: alumnos) {
				atributos.add(new Atributo("nia",Integer.toString(alumno.getNia())));
				atributos.add(new Atributo("nombre",alumno.getNombre()));
				atributos.add(new Atributo("apellidos",alumno.getApellidos()));
				atributos.add(new Atributo("genero",String.valueOf(alumno.getGenero())));
				atributos.add(new Atributo("fechaNacimiento",alumno.getFechaString()));
				atributos.add(new Atributo("ciclo",alumno.getCiclo()));
				atributos.add(new Atributo("curso",alumno.getCurso()));
				atributos.add(new Atributo("grupo",alumno.getGrupo()));
				
				
				xml.anadirEtiqueta(doc.getDocumentElement(),"alumno",alumno.getNombre(), atributos);
				
				
			}
			
			xml.crearXml();
		}finally {
			
		}
	}
	
	private static void crearElemento(String nomEtiqueta,String dato, Document doc, Element padre){
		Element etiqueta=doc.createElement(nomEtiqueta);
		etiqueta.setTextContent(dato);
		padre.appendChild(etiqueta);
	}

}

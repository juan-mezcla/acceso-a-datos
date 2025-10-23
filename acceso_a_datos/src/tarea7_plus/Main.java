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


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DocumentBuilderFactory instancia=DocumentBuilderFactory.newInstance();
		Alumno alumnos[]=new Alumno[5];
		
		for(int i=0; i<5; i++) {
			alumnos[i]=new Alumno();
			Alumno alumno=alumnos[i];
			/*
			 
			atributos.add(new Atributo("nia",Integer.toString(alumno.getNia())));
			atributos.add(new Atributo("nombre",alumno.getNombre()));
			atributos.add(new Atributo("apellidos",alumno.getApellidos()));
			atributos.add(new Atributo("genero",String.valueOf(alumno.getGenero())));
			atributos.add(new Atributo("fechaNacimiento",alumno.getFechaString()));
			atributos.add(new Atributo("ciclo",alumno.getCiclo()));
			atributos.add(new Atributo("curso",alumno.getCurso()));
			atributos.add(new Atributo("grupo",alumno.getGrupo()));
			 * */
			
			
		}
		try{
			ArchivoXml xml=new ArchivoXml("alumnosEtiqueta","alumnos","1.0");
			Document doc=xml.getDoc();
			
			for(Alumno alumno: alumnos) {
				Element etiquetaAlumno=doc.createElement("alumno");
				doc.getDocumentElement().appendChild(etiquetaAlumno);
				
				xml.anadirEtiqueta(etiquetaAlumno,"nia",Integer.toString(alumno.getNia()), null);
				xml.anadirEtiqueta(etiquetaAlumno,"nombre",alumno.getNombre(), null);
				xml.anadirEtiqueta(etiquetaAlumno,"apellidos",alumno.getApellidos(), null);
				xml.anadirEtiqueta(etiquetaAlumno,"genero",String.valueOf(alumno.getGenero())  , null);
				xml.anadirEtiqueta(etiquetaAlumno,"fechaNacimiento",alumno.getFechaString(), null);
				xml.anadirEtiqueta(etiquetaAlumno,"ciclo",alumno.getCiclo(), null);
				xml.anadirEtiqueta(etiquetaAlumno,"curso",alumno.getCurso(), null);
				xml.anadirEtiqueta(etiquetaAlumno,"grupo",alumno.getGrupo(), null);
				
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

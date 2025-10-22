package tarea7_plus;

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
		}
		try{
			ArchivoXml xml=new ArchivoXml("alumnos","alumnos","1.0");
			
		}finally {
			
		}
	}
	
	private static void crearElemento(String nomEtiqueta,String dato, Document doc, Element padre){
		Element etiqueta=doc.createElement(nomEtiqueta);
		etiqueta.setTextContent(dato);
		padre.appendChild(etiqueta);
	}

}

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
			DocumentBuilder builder=instancia.newDocumentBuilder();
			DOMImplementation domXml=builder.getDOMImplementation();
			
			Document doc=domXml.createDocument(null,"alumnos", null);
			doc.setXmlVersion("1.0");
			
			for(int i=0; i<alumnos.length-1; i++) {
				Alumno alumno=alumnos[i];
				
				Element etiquetaAlumno=doc.createElement("alumno");
				doc.getDocumentElement().appendChild(etiquetaAlumno);
				
				crearElemento("nia",Integer.toString(alumno.getNia()),doc,etiquetaAlumno);
				crearElemento("nombre",alumno.getNombre(),doc,etiquetaAlumno);
				crearElemento("apellidos",alumno.getApellidos(),doc,etiquetaAlumno);
				crearElemento("genero",String.valueOf(alumno.getGenero()) ,doc,etiquetaAlumno);
				crearElemento("fechaNacimiento",alumno.getFechaString(),doc,etiquetaAlumno);
				crearElemento("ciclo",alumno.getCiclo(),doc,etiquetaAlumno);
				crearElemento("curso",alumno.getCurso(),doc,etiquetaAlumno);
				crearElemento("grupo",alumno.getGrupo(),doc,etiquetaAlumno);
			}
			
			Source recurso=new DOMSource(doc);
			Result result=new StreamResult(new java.io.File("Alumnos.xml"));
			Transformer creacionXml=TransformerFactory.newInstance().newTransformer();
			creacionXml.transform(recurso, result);
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
		}
	}
	
	private static void crearElemento(String nomEtiqueta,String dato, Document doc, Element padre){
		Element etiqueta=doc.createElement(nomEtiqueta);
		etiqueta.setTextContent(dato);
		padre.appendChild(etiqueta);
	}

}

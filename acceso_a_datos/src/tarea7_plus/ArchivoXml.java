package tarea7_plus;

import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ArchivoXml {
	private String nombreXml,elementoRaiz;
	private DocumentBuilderFactory instancia=DocumentBuilderFactory.newInstance();
	private DocumentBuilder builder;
	private DOMImplementation domXml;

	private Document doc;

	/**
	 * @param nombreXml    nombre del documento que se creara.
	 * @param elementoRaiz la etiqueta principal dentro del XMl.
	 * *@param version la de nuestro XMl.
	 */
	public ArchivoXml(String nombreXml, String elementoRaiz, String version) {

		this.nombreXml = nombreXml;
		this.elementoRaiz = elementoRaiz;
		try {
			
			this.setBuilder(this.getInstancia().newDocumentBuilder());
			
			this.setDomXml(this.getBuilder().getDOMImplementation());
			
			this.setDoc(this.getDomXml().createDocument(null, this.elementoRaiz, null));
			
			this.getDoc().setXmlVersion(version);
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}
	
	public void anadirEtiqueta(String nomEtiqueta,String texto,List<String> atributos) {
		Element etiqueta=this.getDoc().createElement(nomEtiqueta);
		
		etiqueta.setTextContent(texto);
		
		if(atributos!=null) {
			for(String atributo: atributos) {
				etiqueta.setAttribute(atributo, texto);
			}
		}
		this.getDoc().appendChild(etiqueta);
		
	}

	private String getNombreXml() {
		return nombreXml;
	}

	private void setNombreXml(String nombreXml) {
		this.nombreXml = nombreXml;
	}

	private String getElementoRaiz() {
		return elementoRaiz;
	}

	private void setElementoRaiz(String elementoRaiz) {
		this.elementoRaiz = elementoRaiz;
	}

	private DocumentBuilderFactory getInstancia() {
		return instancia;
	}

	private DocumentBuilder getBuilder() {
		return builder;
	}

	private void setBuilder(DocumentBuilder builder) {
		this.builder = builder;
	}

	private DOMImplementation getDomXml() {
		return domXml;
	}

	private void setDomXml(DOMImplementation domXml) {
		this.domXml = domXml;
	}

	private Document getDoc() {
		return doc;
	}

	private void setDoc(Document doc) {
		this.doc = doc;
	}

}

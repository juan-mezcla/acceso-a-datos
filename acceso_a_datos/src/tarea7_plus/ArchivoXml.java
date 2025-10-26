package tarea7_plus;

import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ArchivoXml {
	private String nombreXml, elementoRaiz;
	private DocumentBuilderFactory instancia = DocumentBuilderFactory.newInstance();
	private DocumentBuilder builder;
	private DOMImplementation domXml;

	private Document doc;
	private Source recurso;
	private Result result;
	private Transformer creacionXml;

	/**
	 * @param nombreXml    nombre del documento que se creara.
	 * @param elementoRaiz la etiqueta principal dentro del XMl. 
	 * @param version la de nuestro XMl.
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

	public void anadirEtiqueta(Element padre,String nomEtiqueta, String texto, List<Atributo> atributos) {
		Element etiqueta = this.getDoc().createElement(nomEtiqueta);

		if (atributos != null) {// Ejemplo: <etiqueta atributo="valor" ...></etiqueta>
			for (Atributo atributo : atributos) {
				etiqueta.setAttribute(atributo.getNombre(), atributo.getValor());
			}
		}else {
			etiqueta.setTextContent(texto);// Ejemplo: <etiqueta>texto</etiqueta>
		}
		padre.appendChild(etiqueta);

	}

	public Transformer getCreacionXml() {
		return creacionXml;
	}

	public void setCreacionXml(Transformer creacionXml) {
		this.creacionXml = creacionXml;
	}

	public void crearXml() {
		try {
			this.setRecurso(new DOMSource(this.getDoc()));
			this.setResult(new StreamResult(new java.io.File(this.getNombreXml() + ".xml")));

			this.setCreacionXml(TransformerFactory.newInstance().newTransformer());
			this.getCreacionXml().transform(this.getRecurso(), this.getResult());
			
		} catch (TransformerConfigurationException | TransformerFactoryConfigurationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Source getRecurso() {
		return recurso;
	}

	public void setRecurso(Source recurso) {
		this.recurso = recurso;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public void setInstancia(DocumentBuilderFactory instancia) {
		this.instancia = instancia;
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

	public Document getDoc() {
		return doc;
	}
 
	private void setDoc(Document doc) {
		this.doc = doc;
	}

}

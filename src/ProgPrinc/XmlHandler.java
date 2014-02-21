package ProgPrinc;

import java.util.jar.Attributes;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import types.donnees.Reader;

public class XmlHandler extends DefaultHandler {
	/**
	 * la méthode traitant de l'évènement début d'élément
	 * 
	 * @param tag
	 *            le nom de l'élément
	 * @param attrs
	 *            la liste des attributs de cet élément
	 * @throws SAXException
	 */
	public void startElement(String namespaceURI, String localName,
			String qName, Attributes atts) throws SAXException {
		if (localName == "type")
			traiteType(atts);
		if (localName == "variable")
			traiteVariable(atts);
		if (localName == "primitive")
			traitePrimitive(atts);
		if (localName == "load")
			traiteLoad(atts);
		if (localName == "loadlibrary")
			traiteLoadLibrary(atts);
	}

	/**
	 * Traite un chargement de fichier
	 * 
	 * @param attrs
	 *            les attributs
	 * @throws SAXException
	 */
	protected void traiteLoad(Attributes attrs) throws SAXException {
		try {
			String name = attrs.getValue("name");
			Reader.importe(name);
		} catch (Exception e) {
			throw new SAXException("traiteLoad", e);
		}
	}

	private void traiteLoadLibrary(Attributes atts) {
		// TODO Auto-generated method stub

	}

	private void traitePrimitive(Attributes atts) {
		// TODO Auto-generated method stub

	}

	private void traiteVariable(Attributes atts) {
		// TODO Auto-generated method stub

	}

	private void traiteType(Attributes atts) {
		// TODO Auto-generated method stub

	}

	// partie ErrorHandler
	// treat validation errors as fatal
	/** traitement de erreur */
	public void error(SAXParseException e) throws SAXParseException {
		throw e;
	}

	// dump warnings too
	/** traitement de warning */
	public void warning(SAXParseException err) throws SAXParseException {
		Console.println("** Warning" + ", line " + err.getLineNumber()
				+ ", uri " + err.getSystemId());
		Console.println(" " + err.getMessage());
	}

	/**
	 * Acquisition des éléments de configuration de la session lisp
	 * 
	 * @param file
	 *            le fichier de configuration
	 */
	public static void read(String file) {
		// lecture du fichier de description du contexte
		try {
			XmlHandler handler = new XmlHandler();
			XMLReader parser = XMLReaderFactory.createXMLReader();
			parser.setContentHandler(handler);
			parser.setErrorHandler(handler);
			parser.parse(new InputSource(Reader.class.getResourceAsStream(file)));
		} catch (SAXParseException err) {
			System.err.println("** Error" + ", line " + err.getLineNumber()
					+ ", uri " + err.getSystemId());
			System.err.println(" " + err.getMessage());
		} catch (SAXException e) {
			Console.printStack((e.getException() != null) ? e.getException()
					: e);
		} catch (Throwable t) {
			Console.printStack(t);
		}
	}
}

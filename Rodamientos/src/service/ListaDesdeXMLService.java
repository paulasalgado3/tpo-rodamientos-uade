package service;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import modelo.ListaPrecios;

public interface ListaDesdeXMLService {
	public Set<ListaPrecios> readXML(File f) throws SAXException, IOException, ParserConfigurationException;

	public void loadXML(File file);
}

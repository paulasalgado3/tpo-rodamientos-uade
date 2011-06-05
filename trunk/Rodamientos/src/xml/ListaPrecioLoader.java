package xml;

import java.io.IOException;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import modelo.ListaPrecios;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ListaPrecioLoader {

	private ListaPrecioLoader(){}
	private static ListaPrecioLoader l=null;
	public static ListaPrecioLoader getInstance(){
		if(l==null)
			l=new ListaPrecioLoader();
		return l;
	}
	
	public static void main(String[] args) {
		// Main de prueba para ver si levanta bien el xml
		String archivo = "xml/listaDePrecios.xml";
		try {
			Set<ListaPrecios> set = ListaPrecioLoader.getInstance().readXML(archivo);
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
	}
	
	public Set<ListaPrecios> readXML(String xml) throws SAXException, IOException, ParserConfigurationException{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(xml);
		Element n = doc.getDocumentElement();
		//System.out.println(n.getNodeName());
		NodeList lst = n.getChildNodes();
		for(int i = 0; i<lst.getLength();i++){
			Node nodo = lst.item(i);
			if(nodo.getNodeType()==Node.ELEMENT_NODE){
				//armar todo el set
			}
		}
		return null;
	}
	
}

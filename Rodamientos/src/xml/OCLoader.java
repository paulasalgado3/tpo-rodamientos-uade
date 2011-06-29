package xml;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import modelo.Item;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import dao.RodamientoDAO;
import dao.impl.RodamientoDAOImpl;

public class OCLoader {

	static String xml = "xml/OC.xml";
	
	public static void main(String[] arg0s){
		try {
			readOC(xml);
		} catch (Exception e) {
			System.out.println("LPM!!");
		} 
	}
	
	private static void readOC(String ocXML) throws SAXException, IOException, ParserConfigurationException{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(xml);
		Element e = doc.getDocumentElement();
		NodeList ordCompras = e.getChildNodes();
		for(int i=0; i<ordCompras.getLength();i++){
			Node n = ordCompras.item(i);
			if(n.getNodeType()==Node.ELEMENT_NODE){
				NodeList items = n.getChildNodes();
								
					for(int j = 0 ; j< items.getLength();j++){
						Node item = items.item(j);
						Item nuevo = new Item();
						if(item.getNodeType()==Node.ELEMENT_NODE){
							System.out.println(item.getChildNodes().item(0).getNodeValue());
							System.out.println("...");
						}
						
					}
				
			}
		}
	
	}
	
}

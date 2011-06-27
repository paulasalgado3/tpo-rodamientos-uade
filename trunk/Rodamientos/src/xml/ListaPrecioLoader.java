package xml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import modelo.Item;
import modelo.ListaPrecios;
import modelo.Proveedor;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import dao.impl.ProveedorDAOImpl;
import dao.impl.RodamientoDAOImpl;

public class ListaPrecioLoader {
	private Element n;
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
			List<ListaPrecios> set = ListaPrecioLoader.getInstance().readXML(archivo);
			System.out.println(set.get(0).getProveedor().getRazonSocial());
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
	}
	
	@SuppressWarnings("deprecation")//levanta las listas del xml!!!!!
	public List<ListaPrecios> readXML(String xml) throws SAXException, IOException, ParserConfigurationException{
		List<ListaPrecios> listados = new ArrayList<ListaPrecios>();
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(xml);
		n = doc.getDocumentElement();
		NodeList lst = n.getElementsByTagName("Lista");
		
		Proveedor prov = new ProveedorDAOImpl().findByCuit(n.getAttribute("proveedor"));//lee el proveedor
		for(int i = 0; i<lst.getLength();i++){
			ListaPrecios lp = new ListaPrecios();
			lp.setProveedor(prov);
			lp.setTipo(lst.item(i).getAttributes().item(0).getNodeValue());
			lp.setVigencia(Integer.parseInt(lst.item(i).getChildNodes().item(3).getChildNodes().item(0).getNodeValue()));
			lp.setFecha(new Date(lst.item(i).getChildNodes().item(1).getChildNodes().item(0).getNodeValue()));
			lp.setNumeroLista(Integer.parseInt(lst.item(i).getChildNodes().item(5).getChildNodes().item(0).getNodeValue()));
			lp.setDescuento(Double.parseDouble(lst.item(i).getChildNodes().item(7).getChildNodes().item(0).getNodeValue()));
			List<Item> itemList = new ArrayList<Item>();
			for(int nose = 9; nose<28;){
				Item it = new Item();
				//it.setIdItem(lst.item(i).getChildNodes().item(nose).getAttributes().item(0).getNodeValue());
				NodeList datos = lst.item(i).getChildNodes().item(nose).getChildNodes();
				//it.setRodamiento(new RodamientoDAOImpl().findByName(datos.item(1).getChildNodes().item(0).getNodeValue()));
				it.setCantidad(Integer.parseInt(datos.item(5).getChildNodes().item(0).getNodeValue()));
				it.setPrecio(Float.parseFloat(datos.item(7).getChildNodes().item(0).getNodeValue()));
				itemList.add(it);
				nose+=2;
			}
			lp.setItems(itemList);
			listados.add(lp);
		}
		return listados;
	}

	private String getAtributo(Element e, String tag,int i) {
		String result = e.getElementsByTagName(tag).item(i).getChildNodes().item(0).getNodeValue();
		return result;
	}
	
	
}

package xml;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import modelo.Item;
import modelo.ListaPrecios;
import modelo.Proveedor;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import service.ListaDesdeXMLService;
import dao.ListaPreciosDAO;
import dao.impl.ListaPreciosDAOImpl;
import dao.impl.ProveedorDAOImpl;
import dao.impl.RodamientoDAOImpl;

public class ListaPrecioLoader implements ListaDesdeXMLService{
	private Element n;
	private ListaPrecioLoader(){}
	private static ListaPrecioLoader l=null;
	public static ListaPrecioLoader getInstance(){
		if(l==null)
			l=new ListaPrecioLoader();
		return l;
	}
	
	/*public static void main(String[] args) {
		ListaPreciosDAO lpDao = new ListaPreciosDAOImpl();
		// Main de prueba para ver si levanta bien el xml
		String archivo = "xml/listaDePrecios.xml";
		try {
			Set<ListaPrecios> set = ListaPrecioLoader.getInstance().readXML(archivo);
			for(ListaPrecios lp : set){
				System.out.println(lp.getTipo());
				System.out.println(lp.getDescuento());
				System.out.println(lp.getFecha());
				System.out.println(lp.getProveedor().getRazonSocial());
				System.out.println("Vacio??"+lp.getItems().size());
				for(Item i:lp.getItems()){
					if(i.getRodamiento()!=null)
					System.out.println(i.getRodamiento().getMarca());
				}
				lpDao.save(lp);
			}
	
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
	}*/
	
	@SuppressWarnings("deprecation")//levanta las listas del xml!!!!!
	public Set<ListaPrecios> readXML(File xml) throws SAXException, IOException, ParserConfigurationException{
		Set<ListaPrecios> listados = new HashSet<ListaPrecios>();
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(xml);
		n = doc.getDocumentElement();
		NodeList lst = n.getElementsByTagName("Lista");
		
		Proveedor prov = new ProveedorDAOImpl().findByCuit(n.getAttribute("proveedor"));//lee el proveedor
		for(int i = 0; i<lst.getLength();i++){
			NodeList hijos = lst.item(i).getChildNodes();
			ListaPrecios lp = new ListaPrecios();
			Set<Item> set = new HashSet<Item>();
			lp.setProveedor(prov);
			lp.setTipo((lst.item(i).getAttributes().item(0).getNodeValue()));
			lp.setItems(set);
			for(int j=0;j<hijos.getLength();j++){
				Node hijo = hijos.item(j);
			
				if(hijo.getNodeType()==Node.ELEMENT_NODE){
					
				//	System.out.println(hijo.getNodeName());
					if(hijo.getNodeName().equals("Fecha")){
						lp.setFecha(new Date(hijo.getChildNodes().item(0).getNodeValue()));
					}
					if(hijo.getNodeName().equals("Vigencia")){
						lp.setVigencia(Integer.parseInt(hijo.getChildNodes().item(0).getNodeValue()));
					}
					if(hijo.getNodeName().equals("Descuento")){
						lp.setDescuento(Double.parseDouble(hijo.getChildNodes().item(0).getNodeValue()));
					}
					if(hijo.getNodeName().equals("Numero")){
						lp.setNumeroLista(Integer.parseInt(hijo.getChildNodes().item(0).getNodeValue()));
					}
					if(hijo.getNodeName().equals("Item")){
						NodeList nietos = hijo.getChildNodes();
						Item it = new Item();
						for(int k =0 ;k <nietos.getLength();k++){
							Node nieto = nietos.item(k);
							if(nieto.getNodeType()==Node.ELEMENT_NODE){
								if(nieto.getNodeName().equals("Rodamiento")){
									it.setRodamiento(new RodamientoDAOImpl().findByCodigo(nieto.getChildNodes().item(0).getNodeValue()));
								}
								if(nieto.getNodeName().equals("Cantidad")){
									it.setCantidad(Integer.parseInt(nieto.getChildNodes().item(0).getNodeValue()));
								}
								if(nieto.getNodeName().equals("Precio")){
									it.setPrecio(Float.parseFloat(nieto.getChildNodes().item(0).getNodeValue()));
								}
							//	System.out.println("ITEM: "+nieto.getChildNodes().item(0).getNodeValue());
							}
						}
						it.setListaPrecios(lp);
						set.add(it);
					}
					
				}
			}
			listados.add(lp);
			//System.out.println("......");
		}
		return listados;
	}

	@Override
	public void loadXML(File file) {
		try {
			ListaPreciosDAO lpDAO = new ListaPreciosDAOImpl();
			Set<ListaPrecios> set = ListaPrecioLoader.getInstance().readXML(file);
			for(ListaPrecios lp : set){
				
				lpDAO.save(lp);
			}
	
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
		
	}


	
}

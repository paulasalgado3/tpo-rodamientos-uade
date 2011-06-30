package test;

import modelo.Item;
import modelo.ListaPrecios;
import modelo.Rodamiento;
import dao.ListaPreciosDAO;
import dao.impl.ListaPreciosDAOImpl;
import dao.impl.ProveedorDAOImpl;
import dao.impl.RodamientoDAOImpl;

public class PruebaListaPreciosDAO {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListaPreciosDAO lpDAO = new ListaPreciosDAOImpl();
		ListaPrecios lp = new ListaPrecios();
		lp.setNumeroLista(new Integer(123458));
		lp.setDescuento(new Double (0.30));
		lp.setTipo(new String ("oferta"));
		lp.setVigencia(new Integer(1));
		
		
		RodamientoDAOImpl rDAO = new RodamientoDAOImpl();
		Rodamiento rodamiento1 = new Rodamiento();
		rodamiento1.setCaracteristicas("caract 1");
		rodamiento1.setCodigo("D1");
		rodamiento1.setMarca("SFK");
		rodamiento1.setPaisOrigen("Argentina");
			
	
		
		Rodamiento rodamiento2 = new Rodamiento();
		rodamiento2.setCaracteristicas("caract 2");
		rodamiento2.setCodigo("h2");
		rodamiento2.setMarca("FAG");
		rodamiento2.setPaisOrigen("Brasil");
			
		Item item1 = new Item();
		Item item2 = new Item();
		
		item1.setCantidad(2);
		item1.setPrecio(new Float(1));
		item1.setListaPrecios(lp);
		item1.setRodamiento(rodamiento1);
		
		item2.setCantidad(3);
		item2.setPrecio(new Float(1));
		item2.setListaPrecios(lp);
		item2.setRodamiento(rodamiento2);
		
		lp.getItems().add(item1);
		lp.getItems().add(item2);

		//Le asigno a la lista de precios el proveedor del TEST PROVEEDOR
		ProveedorDAOImpl pDAO = new ProveedorDAOImpl();
		lp.setProveedor(pDAO.findByCuit("123456789"));
		

		lpDAO.save(lp);
		
		System.out.println("Salvada la lista número " + lp.getNumeroLista());
		
		
		
		//Busco por numero de lista
		/*
		ListaPrecios lp2 = lpDAO.findByNumber(new Integer(123456));
		System.out.println("ID de la lista obtenida: " + lp2.getId());
		*/
		
		//Elimino la lista
		//lpDAO.delete(1); //not funking, por el tema de la sesion de mierda... para esto sirve spring tmb!
		
		
	}

}

package test;

import dao.RodamientoDAO;
import dao.impl.RodamientoDAOImpl;
import modelo.Rodamiento;

public class PruebaRodamientosDAO {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RodamientoDAO rodamientoDAO = new RodamientoDAOImpl();
		for(int k=3;k<11;k++){
		Rodamiento rodamiento = new Rodamiento();
		rodamiento.setCaracteristicas("las caracteristicas");
		rodamiento.setCodigo(""+k);
		rodamiento.setMarca("Rodamiento "+k);
		//rodamiento.setNroSerie(new Integer(31));
		rodamiento.setPaisOrigen("Argentina");
		
		rodamientoDAO.save(rodamiento);
		System.out.println("Guardado rodamiento codigo " + rodamiento.getCodigo());
		}
		
		//Bùsqueda por codigo
		//Rodamiento r = rodamientoDAO.findByCodigo(new String("123"));
		//
	}

}

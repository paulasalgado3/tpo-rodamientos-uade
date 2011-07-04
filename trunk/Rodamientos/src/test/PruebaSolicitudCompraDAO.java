package test;

import java.util.List;

import service.impl.SolicitudCompraServiceImpl;

import modelo.SolicitudCompra;

public class PruebaSolicitudCompraDAO {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<SolicitudCompra> solcomp = new SolicitudCompraServiceImpl().obtenerNoConfirmadas();
		System.out.println("Resultados: " + solcomp.size());

	}

}

package test;

import java.rmi.RemoteException;
import java.util.List;

import service.impl.SolicitudCompraServiceImpl;

import modelo.SolicitudCompra;

public class PruebaSolicitudCompraDAO {

	/**
	 * @param args
	 * @throws RemoteException 
	 */
	public static void main(String[] args) throws RemoteException {
		List<SolicitudCompra> solcomp = new SolicitudCompraServiceImpl().obtenerNoConfirmadas();
		System.out.println("Resultados: " + solcomp.size());

	}

}

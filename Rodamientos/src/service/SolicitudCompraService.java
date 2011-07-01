package service;

import java.util.List;

import modelo.SolicitudCompra;

public interface SolicitudCompraService {

	void generarSolicitudCompra();
	List<SolicitudCompra> findAll();
	void confirmarSolicitudCompra(Integer id);
}

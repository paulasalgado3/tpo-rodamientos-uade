package service;

import java.util.List;

import modelo.Cliente;
import modelo.Item;
import modelo.SolicitudCompra;

public interface SolicitudCompraService {

	void generarSolicitudCompra(List<Item> items, Cliente cli);
	List<SolicitudCompra> findAll();
	void confirmarSolicitudCompra(Integer id);
	void confirmarSolicitudCompra1(Integer idSolicitudCompra);
}

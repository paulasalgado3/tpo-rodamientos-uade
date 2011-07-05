package service;

import java.util.List;
import java.util.Set;

import modelo.Cliente;
import modelo.Item;
import modelo.SolicitudCompra;

public interface SolicitudCompraService {

	void generarSolicitudCompra(Set<Item> items, Cliente cli);
	public Set<SolicitudCompra> generarSolicitudCompraSet(Set<Item> items, Cliente cli);
	List<SolicitudCompra> findAll();
	void confirmarSolicitudCompra(Integer id);
	List<SolicitudCompra> obtenerNoConfirmadas();
}

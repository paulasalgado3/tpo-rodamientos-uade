package service;

import java.util.Set;

import modelo.Item;

public interface CotizacionService {
	
	void generarCotizacion(Integer dniCliente,Set<Item> items);
}

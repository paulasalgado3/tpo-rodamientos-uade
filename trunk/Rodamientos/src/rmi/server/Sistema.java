package rmi.server;

import generico.lista.ListaGenerica;

/*
 * Puse la clase esta para que vayamos probando todo en consola hasta que tengamos 
 * la interfaz grafica.
 */

/*
 * Mande la clase en este paquete, pero me parece que tendria que ir en otro.
 */

public class Sistema {

	static Sistema instancia = null;

	public Sistema getInstancia(){
		if (instancia == null){
			return new Sistema();
		}
		return instancia;
	}
	
}

package modelo;

import java.io.Serializable;

public class ListaOferta extends ListaPrecios implements Serializable{

	/*
	 * Los proveedores publican listas de ofertas donde indican descuentos sobre los ítems.
	 * */
	private float descuento;
	private Rodamiento rodamiento;
	
	public float getDescuento() {
		return descuento;
	}
	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}
	public Rodamiento getRodamiento() {
		return rodamiento;
	}
	public void setRodamiento(Rodamiento rodamiento) {
		this.rodamiento = rodamiento;
	}
	
	
}

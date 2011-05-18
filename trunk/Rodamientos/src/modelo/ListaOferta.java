package modelo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ListaOferta extends ListaPrecios implements Serializable{

	/*
	 * Los proveedores publican listas de ofertas donde indican descuentos sobre los ítems.
	 * */
	private float descuento;
	private Item item;
	
	public float getDescuento() {
		return descuento;
	}
	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}	
}

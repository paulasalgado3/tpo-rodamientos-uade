package modelo;

import java.util.Date;

@SuppressWarnings("unchecked")
public abstract class ListaPrecios implements Comparable {

	private int numero;
	private Date fecha;
	private Proveedor proveedor;
	private String tipo;
	
	@SuppressWarnings("deprecation")
	public int compareTo(Object otraLista) {
		if (!(otraLista instanceof ListaPrecios)) {
			throw new ClassCastException("Objeto Invalido para comparar");
		}
		ListaPrecios otra = (ListaPrecios)otraLista;
		
		/*
		 * Lista de Nº 103 del 1 Mar 2011 de SKF. (La lista anterior es sustituida
		 * por la nueva).
		 * */
		if(this.getFecha().getDate() == otra.getFecha().getDate()
				&& this.getNumero() == otra.getNumero()
				&& this.getProveedor().equals(otra.getProveedor())
				&& this.getTipo().equalsIgnoreCase(otra.getTipo())){
			
			return 0;//son iguales
		}
		return -1;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}

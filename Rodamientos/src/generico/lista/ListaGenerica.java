package generico.lista;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * Una lista generica para lo que vayamos precisando,
 * la podemos usar para cualquier cosa (Proveedores, clientes, prods, lo que fuese necesario)
 */
public class ListaGenerica<E> {
	
	private List<E> lista = new ArrayList<E>();

	public List<E> getLista() { 
		return lista; 
	}
	
	public void setLista(List<E> lista) { 
		this.lista = lista; 
	}
	
	public void agregar(E e) { 
		lista.add(e); 
	}

	public boolean eliminar(E e) { 
		return lista.remove(e); 
	}
	
	public E eliminar(int index) { 
		return lista.remove(index); 
		}
	
	public boolean buscar(E e) {
		return lista.contains(e); 
		}
	
	public E obtener(int index) { 
		return lista.get(index); 
	}
	
	public Iterator<E> iterador() { 
		return lista.iterator(); 
		}
	
	public int cantidad() { 
		return lista.size();	
		}
	
	public boolean estaVacia() { 
		return lista.isEmpty(); 
		}
}

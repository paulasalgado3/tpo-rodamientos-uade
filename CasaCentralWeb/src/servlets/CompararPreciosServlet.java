package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Item;

import service.ListaPreciosService;
import service.impl.ListaPreciosServiceImpl;

/**
 * Servlet implementation class CompararPreciosServlet
 */
public class CompararPreciosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompararPreciosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.process(request, response);
	}
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ListaPreciosService listaPreciosService = new ListaPreciosServiceImpl();
		
		Integer nroSerie = new Integer(request.getParameter("nroSerie"));
		String [] marcasString = request.getParameter("marcas").split(",");
		List<String> marcas = new ArrayList<String>();
		for(String m : marcasString){
			marcas.add(m.trim());
		}
		String paisOrigen = request.getParameter("paisOrigen");
		String caracteristicas = request.getParameter("caracteristicas");
		
		//Item item = listaPreciosService.obtenerItemPorMejorPrecio(nroSerie, marcas, paisOrigen, caracteristicas);
		//request.setAttribute("item", item);
		String url = "/pages/comparativa-precios/resultado-comparar-precios.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(url);
		requestDispatcher.forward(request, response);
	}

}

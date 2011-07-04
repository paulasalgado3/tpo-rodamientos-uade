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
 * Servlet implementation class CompararServlet
 */
public class CompararServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CompararServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ListaPreciosService listaPreciosService = new ListaPreciosServiceImpl();

		String codigo = request.getParameter("codigo");
		String[] marcasString = request.getParameter("marcas").split(",");
		List<String> marcas = new ArrayList<String>();
		for (String m : marcasString) {
			marcas.add(m.trim());
		}
		String paisOrigen = request.getParameter("paisOrigen");
		String caracteristicas = request.getParameter("caracteristicas");

		/*
		 * List<Item> obtenerItemPorMejorPrecio (String codigo, List<String>
		 * marcas, String paisOrigen, String caracteristicas)
		 */

		List<Item> items = listaPreciosService.obtenerItemPorMejorPrecio(
				codigo, marcas, paisOrigen, caracteristicas);
		request.setAttribute("items", items);
		String url = "/pages/comparativa-precios/resultado-comparar-precios.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(url);
		requestDispatcher.forward(request, response);
	}

}

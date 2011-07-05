package servlets;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import modelo.Cliente;
import modelo.Item;
import modelo.SolicitudCompra;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ClienteService;
import service.ItemService;
import service.SolicitudCompraService;
import service.impl.ClienteServiceImpl;
import service.impl.ItemServiceImpl;
import service.impl.SolicitudCompraServiceImpl;

/**
 * Servlet implementation class GenerarSolicitudCompraServlet
 */
public class GenerarSolicitudCompraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenerarSolicitudCompraServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] stringItems = request.getParameterValues("items");
		SolicitudCompraService solicitudCompraService = new SolicitudCompraServiceImpl();
		ItemService itemService = new ItemServiceImpl();
		ClienteService clienteService = new ClienteServiceImpl();
		Set<Item> items = new HashSet<Item>();
		for(int i = 0; i < stringItems.length; i++){
			Item it = itemService.findById(Integer.parseInt(stringItems[i]));
			items.add(it);
		}
		String dni = request.getParameter("dni");
		Cliente cli = clienteService.findByDni(Integer.parseInt(dni));
		Set<SolicitudCompra> solicitudes =solicitudCompraService.generarSolicitudCompraSet(items, cli);
		request.setAttribute("solicitudes", solicitudes);
		String url = "./pages/generar-solicitud-compra/resultado-generar-solicitud-compra.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	
	}

}

package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.SolicitudCompraService;
import service.impl.SolicitudCompraServiceImpl;

/**
 * Servlet implementation class ConfirmarSolicitudesCompraServlet
 */
public class ConfirmarSolicitudesCompraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmarSolicitudesCompraServlet() {
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
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] solicitudesCompra = request.getParameterValues("solicitudesCompra");
		SolicitudCompraService solicitudCompraService = new SolicitudCompraServiceImpl();
		for(int i = 0; i < solicitudesCompra.length; i++){
			Integer id = new Integer(solicitudesCompra[i]);
			solicitudCompraService.confirmarSolicitudCompra(id);
		}
		String url = "/pages/solicitud-compra";
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
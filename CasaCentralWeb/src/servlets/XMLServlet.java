package servlets;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.ListaPrecios;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.FileUploadException;

import service.ListaDesdeXMLService;

import xml.ListaPrecioLoader;

/**
 * Servlet implementation class XMLServlet
 */
public class XMLServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XMLServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest r, HttpServletResponse re) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(r,re);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			process(request, response);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (org.apache.commons.fileupload.FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void process(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, FileUploadException, org.apache.commons.fileupload.FileUploadException {

		// Check that we have a file upload request
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if(isMultipart){
			System.out.println("si, es multipart locooo");
			// Create a factory for disk-based file items
			DiskFileItemFactory factory = new DiskFileItemFactory();
			
			// Create a new file upload handler
			ServletFileUpload upload = new ServletFileUpload(factory);
			

			// Parse the request
			List /* FileItem */ items = upload.parseRequest(request);
			String buscar;
			String destino= "C:\\uploaded\\";
			Iterator it = items.iterator();
			while(it.hasNext()){
				try {
				DiskFileItem item = (DiskFileItem)it.next();
				if(item.getName()!=null){
					buscar = item.getName();
					System.out.println("Leido: "+buscar);
					File file = new File(buscar);
					
					file = new File(destino+file.getName());
					//con esto lo guardo al disco.. pero yo no lo quiero guardar en el disco, por eso, lo comento.
					item.write(file);
					ListaDesdeXMLService lpl = ListaPrecioLoader.getInstance();
					System.out.println("lpl"+lpl);
					lpl.loadXML(file);
					
					request.setAttribute("file", file);
					request.setAttribute("arch", file.getTotalSpace());
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/pages/levantarXML/mostrarXML.jsp");
		requestDispatcher.forward(request, response);
		
	}

}

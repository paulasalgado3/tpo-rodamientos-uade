package servlets;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;

import xml.ListaPrecioLoader;

/**
 * Servlet implementation class LevantarXMLServlet
 */
public class LevantarXMLServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LevantarXMLServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
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
				FileItem item = (FileItem)it.next();
				if(item.getName()!=null){
				buscar = item.getName();
				System.out.println("Leido: "+buscar);
				File file = new File(buscar);
				System.out.println(destino+file.getName());
				file = new File(destino + file.getName());
				//con esto lo guardo al disco.. pero yo no lo quiero guardar en el disco, por eso, lo comento.
				//item.write(file);
				ListaPrecioLoader.getInstance().readXML(file);
				request.setAttribute("file", file);
				request.setAttribute("arch", file.toString());
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/pages/mostrarXML.jsp");
		requestDispatcher.forward(request, response);
		
	}

}

package co.edu.ufps.crud.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class ProductoServlet
 */
@WebServlet("/")
public class ProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductoDAO productoDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() {
    	productoDAO = new ProductoDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getServletPath();
		System.out.println(action);
		try {
			switch (action) {
				case "/new":
			        NewProducto(request, response);
			        break;
			    case "/insert":
			        insertProducto(request, response);
			        break;
			    case "/delete":
			        deleteProducto(request, response);
			        break;
			    case "/edit":
			        EditProducto(request, response);
			        break;
			    case "/update":
			        updateProducto(request, response);
			        break;
			    case "/list":
			        list(request, response);
			        break;
			    default:
			    	index(request, response);
			    	break;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void index(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			List < Producto > listProd = productoDAO.selectAll();
			request.setAttribute("listProd", listProd);
			RequestDispatcher dispatcher = request.getRequestDispatcher("html/index.jsp");
		    dispatcher.forward(request, response);
	}
	
	private void list(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		        List < Producto > listProd = productoDAO.selectAll();
		        request.setAttribute("listProd", listProd);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("html/list_productos.jsp");
		        dispatcher.forward(request, response);
	}
	
	private void NewProducto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			Producto producto = new Producto();
			RequestDispatcher dispatcher = request.getRequestDispatcher("html/nuevo_producto.jsp");
			request.setAttribute("prod", producto);
		    dispatcher.forward(request, response);
	}
	
	private void insertProducto(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
				int id = Integer.parseInt(request.getParameter("id"));
				String referencia = request.getParameter("referencia");
				String nombre = request.getParameter("nombre");
				String detalle = request.getParameter("detalle");
				int valor = Integer.parseInt(request.getParameter("valor"));
		
				Categoria categoria = null;
				Marca marca = null;
		        
				Producto prod = new Producto(id, referencia, nombre, detalle, valor, categoria, marca);
		        productoDAO.insert(prod);
		        response.sendRedirect("list");
	}
	
	private void updateProducto(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
				int id = Integer.parseInt(request.getParameter("id"));
				String referencia = request.getParameter("referencia");
				String nombre = request.getParameter("nombre");
				String detalle = request.getParameter("detalle");
				int valor = Integer.parseInt(request.getParameter("valor"));
		
				Categoria categoria = null;
				Marca marca = null;
		        
				Producto prod = new Producto(id, referencia, nombre, detalle, valor, categoria, marca);
		        productoDAO.insert(prod);
		        response.sendRedirect("list");
	}
	
	private void EditProducto(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, ServletException, IOException {
		        int id = Integer.parseInt(request.getParameter("id"));
		        Producto producto = productoDAO.select(id);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("nuevo_producto.jsp");
		        request.setAttribute("prod", producto);
		        dispatcher.forward(request, response);

	}
	
	private void deleteProducto(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		        int id = Integer.parseInt(request.getParameter("id"));
		        productoDAO.delete(id);
		        response.sendRedirect("list");

	}
}

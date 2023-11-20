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

import co.edu.ufps.crud.dao.BillDao;
import co.edu.ufps.crud.dao.UsuarioDAO;
import co.edu.ufps.crud.model.Bill;
import co.edu.ufps.crud.model.Usuario;



/**
 * Servlet implementation class ProductoServlet
 */
@WebServlet("/")
public class ProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioDAO userDao;
	private BillDao billDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() {
    	this.userDao = new UsuarioDAO();
    	this.billDao = new BillDao();
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
				case "/login":
			        login(request, response);
			        break;
			    case "/insert":
			        //insertBill(request, response);
			        break;
			    case "/delete":
			        deleteBill(request, response);
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
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		    dispatcher.forward(request, response);
	}
	
	private void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		
		String username = request.getParameter("user");
		String pass = request.getParameter("pass");
		
		Usuario user = userDao.selectName(username);
		
		if(user!=null && user.getPass()==pass) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/list");
		    dispatcher.forward(request, response);
		}else {
			String error="Datos Incorrectos";
		request.setAttribute("datoError", error);
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
	    dispatcher.forward(request, response);
		}
	}
	
	private void list(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		        List <Bill> listBill = billDao.selectAll();
		        request.setAttribute("listBill", listBill);
		        
		        RequestDispatcher dispatcher = request.getRequestDispatcher("html/movimientos.jsp");
		        dispatcher.forward(request, response);
	}
	
	
	private void deleteBill(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		        int id = Integer.parseInt(request.getParameter("id"));
		        billDao.delete(id);
		        response.sendRedirect("list");

	}
}

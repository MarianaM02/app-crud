package org.adaitw.app_crud.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.adaitw.app_crud.dao.ArticuloDAO;
import org.adaitw.app_crud.dao.VentaDAO;
import org.adaitw.app_crud.model.Venta;

/**
 * Servlet implementation class AdminVentas
 */
@WebServlet("/adminVentas")
public class AdminVentas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	VentaDAO ventaDAO;
	ArticuloDAO articuloDAO;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
		try {
			ventaDAO = new VentaDAO(jdbcURL, jdbcUsername, jdbcPassword);
			articuloDAO = new ArticuloDAO(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminVentas() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("pasó por el doGet");
		String action = request.getParameter("action");
		try {
			switch (action) {
			case "index":
				index(request, response);
				break;
			case "nuevo":
				nuevo(request, response);
				break;
			case "register":
				System.out.println("entro");
				registrar(request, response);
				break;
			case "mostrar":
				mostrar(request, response);
				break;
			case "showedit":
				showEditar(request, response);
				break;
			case "editar":
				editar(request, response);
				break;
			case "eliminar":
				eliminar(request, response);
				break;
			default:
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	////////////////////////////////////////////////
	private void index(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		System.out.println("index");
		dispatcher.forward(request, response);
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		Venta venta = new Venta(0, articuloDAO.obtenerPorId(Integer.parseInt(request.getParameter("id_articulo"))),request.getParameter("cliente"), 
				Double.parseDouble(request.getParameter("cantidad")));
		ventaDAO.insertar(venta);

		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		System.out.println("registrar");
		dispatcher.forward(request, response);
	}

	private void nuevo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/ventas/ventaRegister.jsp");
		System.out.println("nuevo");
		dispatcher.forward(request, response);
	}

	private void mostrar(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/ventas/ventaMostrar.jsp");
		List<Venta> listaVentas = ventaDAO.listarVentas();
		request.setAttribute("lista", listaVentas);
		System.out.println("mostrar");
		dispatcher.forward(request, response);
	}

	private void showEditar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		Venta venta = ventaDAO.obtenerPorId(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("venta", venta);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/ventas/ventaEditar.jsp");
		System.out.println("showEditar");
		dispatcher.forward(request, response);
	}

	private void editar(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		Venta venta = new Venta(Integer.parseInt(request.getParameter("id")), articuloDAO.obtenerPorId(Integer.parseInt(request.getParameter("id_articulo"))), request.getParameter("cliente"),
				 Double.parseDouble(request.getParameter("cantidad")));
		ventaDAO.actualizar(venta);
		System.out.println("editar");
		mostrar(request, response);
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		Venta venta = ventaDAO.obtenerPorId(Integer.parseInt(request.getParameter("id")));
		ventaDAO.eliminar(venta);
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		System.out.println("eliminar");
		dispatcher.forward(request, response);

	}

}

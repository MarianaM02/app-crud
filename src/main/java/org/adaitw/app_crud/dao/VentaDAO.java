package org.adaitw.app_crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.adaitw.app_crud.model.Venta;
import org.adaitw.app_crud.model.Conexion;

public class VentaDAO {
	private Conexion con;
	private Connection connection;
	private ArticuloDAO articuloDAO;

	public VentaDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
		System.out.println("VentaDAO");
		con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
		articuloDAO = new ArticuloDAO(jdbcURL, jdbcUsername, jdbcPassword);
	}

	// insertar venta
	public boolean insertar(Venta venta) throws SQLException {
		String sql = "INSERT INTO ventas (id, id_articulo, cliente, cantidad) VALUES (?,?,?,?)";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, null);
		statement.setInt(2, venta.getArticulo().getId());
		statement.setString(3, venta.getCliente());
		statement.setDouble(4, venta.getCantidad());

		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowInserted;
	}

	// listar todas las ventas
	public List<Venta> listarVentas() throws SQLException {

		List<Venta> listaVentas = new ArrayList<Venta>();
		String sql = "SELECT * FROM ventas";
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);

		while (resulSet.next()) {
			int id = resulSet.getInt("id");
			int id_articulo = resulSet.getInt("id_articulo");
			String cliente = resulSet.getString("cliente");
			Double cantidad = resulSet.getDouble("cantidad");
			Venta venta = new Venta(id, articuloDAO.obtenerPorId(id_articulo), cliente, cantidad);
			listaVentas.add(venta);
		}
		con.desconectar();
		return listaVentas;
	}

	// obtener por id
	public Venta obtenerPorId(int id) throws SQLException {
		Venta venta = null;

		String sql = "SELECT * FROM ventas WHERE id= ? ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);

		ResultSet res = statement.executeQuery();
		if (res.next()) {
			venta = new Venta(res.getInt("id"), articuloDAO.obtenerPorId(res.getInt("id_articulo")), res.getString("cliente"),
					res.getDouble("cantidad"));
		}
		res.close();
		con.desconectar();

		return venta;
	}

	// actualizar
	public boolean actualizar(Venta venta) throws SQLException {
		boolean rowActualizar = false;
		String sql = "UPDATE ventas SET id_articulo=?, cliente=?, cantidad=? WHERE id=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, venta.getArticulo().getId());
		statement.setString(2, venta.getCliente());
		statement.setDouble(3, venta.getCantidad());
		statement.setInt(4, venta.getId());

		rowActualizar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowActualizar;
	}

	// eliminar
	public boolean eliminar(Venta venta) throws SQLException {
		boolean rowEliminar = false;
		String sql = "DELETE FROM ventas WHERE id=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, venta.getId());

		rowEliminar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();

		return rowEliminar;
	}
}

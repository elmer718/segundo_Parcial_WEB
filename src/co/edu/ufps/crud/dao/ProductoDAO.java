package co.edu.ufps.crud.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.ufps.crud.conexion.ConexionMySQL;
import co.edu.ufps.crud.model.Categoria;
import co.edu.ufps.crud.model.Marca;
import co.edu.ufps.crud.model.Producto;

public class ProductoDAO {
	private ConexionMySQL conexion;
	
	private static final String INSERT_PRODUCTO_SQL = "INSERT INTO producto (id, referencia, nombre, detalle, valor, categoria_id, marca_id) VALUES (?, ?, ?, ?, ?, ?,?);";
	private static final String DELETE_PRODUCTO_SQL = "DELETE FROM producto WHERE id = ?;";
	private static final String UPDATE_PRODUCTO_SQL = "UPDATE producto SET referencia = ?, nombre = ?, detalle = ?, valor = ?, categoria_id = ?, marca_id = ? WHERE id = ?;";
	private static final String SELECT_PRODUCTO_BY_ID = "SELECT * FROM producto WHERE id = ?;";
	private static final String SELECT_ALL_PRODUCTO = "SELECT * FROM producto;";
	
	public ProductoDAO() {
		this.conexion = ConexionMySQL.getConexion();
	}
	
	public void insert(Producto producto) throws SQLException {
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(INSERT_PRODUCTO_SQL);
			preparedStatement.setInt(1, producto.getId());
			preparedStatement.setString(2, producto.getReferencia());
			preparedStatement.setString(3, producto.getNombre());
			preparedStatement.setString(4, producto.getDetalle());
			preparedStatement.setInt(5, producto.getValor());
			
			//implementar los metodos de busqueda de la categoria y marca
			preparedStatement.setInt(6, producto.getCategoria().getId());
			preparedStatement.setInt(7, producto.getMarca().getId());
			conexion.execute();
		} catch (SQLException e) {
			
		}
	}
	
	public void delete (int id)  throws SQLException {
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(DELETE_PRODUCTO_SQL);
			preparedStatement.setInt(1, id);

			conexion.execute();
		} catch (SQLException e) {
			
		}
	}
	
	public void update(Producto producto)  throws SQLException {
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(UPDATE_PRODUCTO_SQL);
			preparedStatement.setString(1, producto.getReferencia());
			preparedStatement.setString(2, producto.getNombre());
			preparedStatement.setString(3, producto.getDetalle());
			preparedStatement.setInt(4, producto.getValor());
			
			//implementar los metodos de busqueda de la categoria y marca
			preparedStatement.setInt(5, producto.getCategoria().getId());
			preparedStatement.setInt(6, producto.getMarca().getId());
			preparedStatement.setInt(7, producto.getId());
			conexion.execute();
		} catch (SQLException e) {
			
		}
	}
	
	public List<Producto> selectAll() {
		List <Producto> producto = new ArrayList<>();
		
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(SELECT_ALL_PRODUCTO);
			
			ResultSet rs = conexion.query();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String referencia = rs.getString("referencia");
				String nombre = rs.getString("nombre");
				String detalle = rs.getString("detalle");
				int valor = rs.getInt("valor");
				
				//implementar metodo de busqueda y asignar 
				Categoria categoria = null;
				Marca marca = null;
				
				producto.add(new Producto(id, referencia, nombre, detalle, valor, categoria, marca));
			}
			
		} catch (SQLException e) {
			
		}
		
		return producto;
		
	}
	
	public Producto select(int id) {
		Producto producto = null;
		
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(SELECT_PRODUCTO_BY_ID);
			preparedStatement.setInt(1, id);
			
			ResultSet rs = conexion.query();
			
			while(rs.next()) {
				String referencia = rs.getString("referencia");
				String nombre = rs.getString("nombre");
				String detalle = rs.getString("detalle");
				int valor = rs.getInt("valor");
				
				CategoriaDAO cat = new CategoriaDAO();
				Categoria categoria = cat.select(rs.getInt("categoria_id"));
				MarcaDAO mar = new MarcaDAO();
				Marca marca = mar.select(rs.getInt("marca_id"));
				
				producto = new Producto(id, referencia, nombre, detalle, valor, categoria, marca);
			}
			
		} catch (SQLException e) {
			
		}
		
		return producto;
		
	}
	
}

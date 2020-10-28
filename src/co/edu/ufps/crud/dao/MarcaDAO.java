package co.edu.ufps.crud.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.ufps.crud.conexion.ConexionMySQL;
import co.edu.ufps.crud.model.Marca;

public class MarcaDAO {
	private ConexionMySQL conexion;
	
	private static final String INSERT_MARCA_SQL = "INSERT INTO marca (id, nombre) VALUES (?, ?);";
	private static final String DELETE_MARCA_SQL = "DELETE FROM marca WHERE id = ?;";
	private static final String UPDATE_MARCA_SQL = "UPDATE marca SET nombre = ? WHERE id = ?;";
	private static final String SELECT_MARCA_BY_ID = "SELECT * FROM marca WHERE id = ?;";
	private static final String SELECT_ALL_MARCA = "SELECT * FROM marca;";
	
	public MarcaDAO() {
		this.conexion = ConexionMySQL.getConexion();
	}
	
	public void insert(Marca marca) throws SQLException {
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(INSERT_MARCA_SQL);
			preparedStatement.setInt(1, marca.getId());
			preparedStatement.setString(2, marca.getNombre());
			
			conexion.execute();
		} catch (SQLException e) {
			
		}
	}
	
	public void delete (int id)  throws SQLException {
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(DELETE_MARCA_SQL);
			preparedStatement.setInt(1, id);

			conexion.execute();
		} catch (SQLException e) {
			
		}
	}
	
	public void update(Marca marca)  throws SQLException {
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(UPDATE_MARCA_SQL);
			preparedStatement.setString(1, marca.getNombre());
			preparedStatement.setInt(2, marca.getId());
			
			conexion.execute();
		} catch (SQLException e) {
			
		}
	}
	
	public List<Marca> selectAll() {
		List <Marca> marca = new ArrayList<>();
		
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(SELECT_ALL_MARCA);
			
			ResultSet rs = conexion.query();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				
				marca.add(new Marca(id, nombre));
			}
			
		} catch (SQLException e) {
			
		}
		
		return marca;
		
	}
	
	public Marca select(int id) {
		Marca marca = null;
		
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(SELECT_MARCA_BY_ID);
			preparedStatement.setInt(1, id);
			
			ResultSet rs = conexion.query();
			
			while(rs.next()) {
				String nombre = rs.getString("nombre");
				
				marca = new Marca(id, nombre);
			}
			
		} catch (SQLException e) {
			
		}
		
		return marca;
		
	}
}

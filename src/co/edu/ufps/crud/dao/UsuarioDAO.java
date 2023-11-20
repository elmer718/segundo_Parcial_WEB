package co.edu.ufps.crud.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.ufps.crud.conexion.ConexionMySQL;
import co.edu.ufps.crud.model.Usuario;

public class UsuarioDAO {
	private ConexionMySQL conexion;
	
	private static final String INSERT_USER_SQL = "INSERT INTO users (username, pass, email) VALUES (?, ?, ?);";
	private static final String SELECT_USER_BY_ID = "SELECT * FROM users WHERE id = ?;";
	private static final String SELECT_USER_BY_NAME = "SELECT * FROM users WHERE username = ?;";
	
	public UsuarioDAO() {
		this.conexion = ConexionMySQL.getConexion();
	}
	
	public void insert(Usuario user) throws SQLException {
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(INSERT_USER_SQL);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPass());
			preparedStatement.setString(3, user.getEmail());
			
			conexion.execute();
		} catch (SQLException e) {
			
		}
	}
	
	
	public Usuario select(int id) throws SQLException {
		Usuario usuario = new Usuario();

		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(SELECT_USER_BY_ID);
			preparedStatement.setInt(1, id);
			
			ResultSet rs = conexion.query();

			while (rs.next()) {
			String username = rs.getString("username");
			String pass = rs.getString("pass");
			String email = rs.getString("email");
			

			usuario = new Usuario(id, username, email, pass);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return usuario;
	}
	
	public Usuario selectName(String username) throws SQLException {
		Usuario usuario = new Usuario();

		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(SELECT_USER_BY_NAME);
			preparedStatement.setString(1, username);
			
			ResultSet rs = conexion.query();

			while (rs.next()) {
			int id = rs.getInt("id");
			String pass = rs.getString("pass");
			String email = rs.getString("email");
			

			usuario = new Usuario(id, username, email, pass);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return usuario;
	}
}

package co.edu.ufps.crud.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.ufps.crud.conexion.ConexionMySQL;
import co.edu.ufps.crud.model.Bill;

public class BillDao {
	private ConexionMySQL conexion;
	
	private static final String INSERT_BILL_SQL = "INSERT INTO bill (date_bill, user_id, value, type, observation) VALUES (?, ?, ?, ?, ?);";
	private static final String DELETE_BILL_SQL = "DELETE FROM bill WHERE id = ?;";
	private static final String SELECT_BILL_BY_ID = "SELECT * FROM bill WHERE id = ?;";
	private static final String SELECT_ALL_BILL = "SELECT * FROM bill;";
	
	public BillDao() {
		this.conexion = ConexionMySQL.getConexion();
	}
	
	public void insert(Bill bill) throws SQLException {
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(INSERT_BILL_SQL);
			preparedStatement.setDate(1, bill.getDate_bill());
			preparedStatement.setInt(2, bill.getUser_id());
			preparedStatement.setInt(3, bill.getValue());
			preparedStatement.setInt(4, bill.getType());
			preparedStatement.setString(5, bill.getObservation());
			
			conexion.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete (int id)  throws SQLException {
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(DELETE_BILL_SQL);
			preparedStatement.setInt(1, id);

			conexion.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public List<Bill> selectAll() {
		List <Bill> listbill = new ArrayList<>();
		
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(SELECT_ALL_BILL);
			
			ResultSet rs = conexion.query();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				Date date_bill = rs.getDate("date_bill");
				int user_id = rs.getInt("user_id");
				int value = rs.getInt("value");
				int type = rs.getInt("type");
				String observation = rs.getString("observation");
				
				
				listbill.add(new Bill(id, date_bill, type, value, observation, user_id));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listbill;
		
	}
	
	public Bill select(int id) {
		Bill bill = null;
		
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conexion.setPreparedStatement(SELECT_BILL_BY_ID);
			preparedStatement.setInt(1, id);
			
			ResultSet rs = conexion.query();
			
			while(rs.next()) {
				Date date_bill = rs.getDate("date_bill");
				int user_id = rs.getInt("user_id");
				int value = rs.getInt("value");
				int type = rs.getInt("type");
				String observation = rs.getString("observation");

				bill = new Bill(id, date_bill, type, value, observation, user_id);
			}
			
		} catch (SQLException e) {
			
		}
		
		return bill;
		
	}
	
}

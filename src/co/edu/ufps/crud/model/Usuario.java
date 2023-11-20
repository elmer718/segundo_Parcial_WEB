package co.edu.ufps.crud.model;

import lombok.Data;

@Data
public class Usuario {
	private int id;
	private String username;
	private String pass;
	private String email;
	
	
	public Usuario(int id, String username, String pass, String email) {
		super();
		this.id = id;
		this.username = username;
		this.pass = pass;
		this.email = email;
	}


	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

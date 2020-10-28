package co.edu.ufps.crud.model;

import lombok.Data;

@Data
public class Marca {
	private int id;
	private String nombre;
	
	public Marca(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
}

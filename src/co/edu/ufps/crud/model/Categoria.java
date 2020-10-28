package co.edu.ufps.crud.model;

import lombok.Data;

@Data
public class Categoria {
	private int id;
	private String descripcion;
	
	public Categoria(int id, String descripcion) {
		this.id = id;
		this.descripcion = descripcion;
	}
}

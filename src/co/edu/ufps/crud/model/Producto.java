package co.edu.ufps.crud.model;

import lombok.Data;

@Data
public class Producto {
	private int id;
	private String referencia;
	private String nombre;
	private String detalle;
	private int valor;
	
	private Categoria categoria;
	private Marca marca;
	
	public Producto(int id, String referencia, String nombre, String detalle, 
			int valor, Categoria categoria, Marca marca) {
		this.id = id;
		this.referencia = referencia;
		this.nombre = nombre;
		this.detalle = detalle;
		this.valor = valor;
		
		this.categoria = categoria;
		this.marca = marca;
	}

	public Producto() {
		// TODO Auto-generated constructor stub
	}
}

package com.motos.modelo.dto;

public class V_Motos {

	private int id ;
	private String nombre;
	private String matricula;
	private int precio;
	private String descripcion;
	private String cilindrada;
	private int fk_marca;
	private String marca;
	private int fk_categoria;
	private String categoria;
	
	public V_Motos(int id, String nombre, String matricula, String descripcion, int precio, String cilindrada,
			int fk_marca, String marca, int fk_categoria, String categoria) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.matricula = matricula;
		this.precio = precio;
		this.descripcion = descripcion;
		this.cilindrada = cilindrada;
		this.fk_marca = fk_marca;
		this.marca = marca;
		this.fk_categoria = fk_categoria;
		this.categoria = categoria;
	}
	
	public V_Motos() {
		
		this.id = 0;
		this.nombre = "";
		this.matricula = "";
		this.precio = 0;
		this.descripcion = "";
		this.cilindrada = "";
		this.fk_marca = 0;
		this.marca = "";
		this.fk_categoria = 0;
		this.categoria = "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(String cilindrada) {
		this.cilindrada = cilindrada;
	}

	public int getfk_marca() {
		return fk_marca;
	}

	public void setfk_marca(int fk_marca) {
		this.fk_marca = fk_marca;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getfk_categoria() {
		return fk_categoria;
	}

	public void setfk_categoria(int fk_categoria) {
		this.fk_categoria = fk_categoria;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return id + ";" + nombre + ";" + matricula + ";" + precio
				+ ";" + descripcion + ";" + cilindrada + ";" + fk_marca + ";"
				+ marca + ";" + fk_categoria + ";" + categoria;
	}


	
	
	
}

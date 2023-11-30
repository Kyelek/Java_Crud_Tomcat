package com.motos.modelo.dto;

public class Motos {

		private int id ;
		private String nombre;
		private String matricula;
		private int precio;
		private String descripcion;
		private String cilindrada;
		private int fk_marca;
		private int fk_categoria;
		
		public Motos(int id,String nombre, String matricula, String descripcion, int precio,  String cilindrada, int fk_marca,
				int fk_categoria) {
			super();
			this.id = id;
			this.nombre = nombre;
			this.matricula = matricula;
			this.descripcion = descripcion;
			this.precio = precio;
			this.cilindrada = cilindrada;
			this.fk_marca = fk_marca;
			this.fk_categoria = fk_categoria;
		}
		
		public Motos() {
			
			this.id = 0;
			this.nombre = "";
			this.matricula = "";
			this.descripcion = "";
			this.precio = 0;
			this.cilindrada = "";
			this.fk_marca = 0;
			this.fk_categoria = 0;
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

		public void setfk_marca(int fK_marca) {
			fk_marca = fK_marca;
		}

		public int getfk_categoria() {
			return fk_categoria;
		}

		public void setfk_categoria(int fK_categoria) {
			fk_categoria = fK_categoria;
		}

		@Override
		public String toString() {
			return id + ";" + nombre + ";" + matricula + ";" + descripcion
					+ ";" + precio + ";" + cilindrada + ";" + fk_marca
					+ ";" + fk_categoria ;
		}


		
		
		
}

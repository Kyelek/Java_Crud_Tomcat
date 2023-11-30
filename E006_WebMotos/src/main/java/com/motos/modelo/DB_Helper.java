package com.motos.modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.motos.modelo.dto.Categoria;
import com.motos.modelo.dto.Marca;
import com.motos.modelo.dto.Motos;
import com.motos.modelo.dto.V_Motos;

public class DB_Helper implements DAO_Constantes{

	public Connection Conectar() {

		Connection con = null;

		try {

			Class.forName(DRIVE);
			con = DriverManager.getConnection(RUTA, USUARIO, PASS);

		} catch (ClassNotFoundException e) {

			System.out.println("DRIVER NO ENCONTRADO");

			e.printStackTrace();

		} catch (SQLException e) {
			System.out.println("NO SE PUDO CONECTAR A LA BD");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return con;
	}

	public void desconectar(Connection con) {

		try {
			con.close();

		} catch (SQLException e) {

			System.out.println("NO SE PUDO DESCONECTAR");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<V_Motos> obtenerTodosMotos(Connection con) {

		List<V_Motos> lista_Motos = new ArrayList<V_Motos>();

		try {

			CallableStatement cStmt = con.prepareCall(SP_OBTENER_VISTA_TODAS_MOTOS);
			cStmt.execute();
			ResultSet rs = cStmt.getResultSet();

			while (rs.next()) {

				V_Motos mot = new V_Motos();

				mot.setId			(rs.getInt(MOTOS_ID)); // por que esto es un string ?
				mot.setNombre		(rs.getString(MOTOS_NOMBRE));
				mot.setMatricula	(rs.getString(MOTOS_MATRICULA));
				mot.setPrecio		(rs.getInt(MOTOS_PRECIO));
				mot.setDescripcion	(rs.getString(MOTOS_DESCRIPCION));
				mot.setCilindrada	(rs.getString(MOTOS_CILINDRADADA));
				
				mot.setfk_marca		(rs.getInt(MOTOS_FK_MARCA));
				mot.setfk_categoria	(rs.getInt(MOTOS_FK_CATEGORIA));

				mot.setMarca		(rs.getString(MARCA_MARCA));
				mot.setCategoria	(rs.getString(CATEGORIA_CATEGORIA));

				lista_Motos.add(mot);

			}

		} catch (SQLException e) {

			System.out.println("NO SE PUDO OBTENER LA LISTA DE MOTOS");
			lista_Motos = new ArrayList<V_Motos>();
			e.printStackTrace();
		}

		return lista_Motos;
	}
	
	public List<Motos> obtenerMotos(Connection con) {

		List<Motos> listaTablaMotos = new ArrayList<Motos>();

		try {

			CallableStatement cStmt = con.prepareCall(SP_OBTENER_TABLA_MOTOS);
			cStmt.execute();
			ResultSet rs = cStmt.getResultSet();

			while (rs.next()) {

				Motos mot = new Motos();

				mot.setId			(rs.getInt(MOTOS_ID)); // por que esto es un string ?
				mot.setNombre		(rs.getString(MOTOS_NOMBRE));
				mot.setMatricula	(rs.getString(MOTOS_MATRICULA));
				mot.setPrecio		(rs.getInt(MOTOS_PRECIO));
				mot.setDescripcion	(rs.getString(MOTOS_DESCRIPCION));
				mot.setCilindrada	(rs.getString(MOTOS_CILINDRADADA));
				
				mot.setfk_marca		(rs.getInt(MOTOS_FK_MARCA));
				mot.setfk_categoria	(rs.getInt(MOTOS_FK_CATEGORIA));

				listaTablaMotos.add(mot);

			}

		} catch (SQLException e) {

			System.out.println("NO SE PUDO OBTENER LA LISTA DE MOTOS");
			listaTablaMotos = new ArrayList<Motos>();
			e.printStackTrace();
		}

		return listaTablaMotos;
	}
	
	public List<Marca> obtenerTodosMarca(Connection con){
		
		List<Marca> listaMarca = new ArrayList<Marca>();
		
		try {
			
			CallableStatement cStmt = con.prepareCall(SP_OBTENER_MARCA);
			
			cStmt.execute();
			ResultSet rs = cStmt.getResultSet();
			
			while(rs.next()) {
				
				Marca mar = new Marca();
				
				mar.setId	(rs.getInt(MARCA_ID));
				mar.setMarca(rs.getString(MARCA_MARCA));
				
				listaMarca.add(mar);
				//System.out.println(mar);
			}
			
		}catch(SQLException e) {
			
			System.out.println("NO SE PUDO OBTENER LA LISTA DE estilos");
			listaMarca = new ArrayList<Marca>();
			e.printStackTrace();
		}
		
		return listaMarca;
	}
	
	public List<Categoria> obtenerTodosCategoria(Connection con){
		
		List<Categoria> listaCategoria = new ArrayList<Categoria>();
		
		try {
			
			CallableStatement cStmt = con.prepareCall(SP_OBTENER_CATEGORIA);
			
			cStmt.execute();
			ResultSet rs = cStmt.getResultSet();
			
			while(rs.next()) {
				
				Categoria cat = new Categoria();
				
				cat.setId		(rs.getInt(MARCA_ID));
				cat.setCategoria(rs.getString(CATEGORIA_CATEGORIA));
				
				listaCategoria.add(cat);
				//System.out.println(cat);
			}
			
		}catch(SQLException e) {
			
			System.out.println("NO SE PUDO OBTENER LA LISTA DE estilos");
			listaCategoria = new ArrayList<Categoria>();
			e.printStackTrace();
		}
		
		return listaCategoria;
		
	}
	
	public void insertarMotos(Connection con, Motos moto) {

		try {

			CallableStatement cStmt = con.prepareCall(SP_INSERTAR_MOTOS);
				
			cStmt.setString(1, moto.getNombre());
			cStmt.setString(2, moto.getMatricula());
			cStmt.setString(3, moto.getDescripcion());
			cStmt.setInt   (4, moto.getPrecio());
			cStmt.setString(5, moto.getCilindrada());
			
			cStmt.setInt   (6, moto.getfk_marca());
			cStmt.setInt   (7, moto.getfk_categoria());

			cStmt.execute();

			System.out.println("Insertado correctamente");

		} catch (SQLException e) {

			e.printStackTrace();
			System.out.println("No ha salido correcto No insertado");
		}

	}
	
	public void insertarCategoria(Connection con, Categoria categoria) {

		try {

			CallableStatement cStmt = con.prepareCall(SP_INSERTAR_CATEGORIAS);
				
			cStmt.setString(1, categoria.getCategoria());

			cStmt.execute();

			System.out.println("Insertado correctamente");

		} catch (SQLException e) {

			e.printStackTrace();
			System.out.println("No ha salido correcto No insertado");
		}

	}

	public void insertarMarca(Connection con, Marca marca) {
		
		try {

			CallableStatement cStmt = con.prepareCall(SP_INSERTAR_MARCA);
				
			cStmt.setString(1, marca.getMarca());

			cStmt.execute();

			System.out.println("Insertado correctamente");

		} catch (SQLException e) {

			e.printStackTrace();
			System.out.println("No ha salido correcto No insertado");
		}
	}
	
	public void borrarMotoPorId(Connection con, int id) {
		
		try {
			
			CallableStatement cStmt = con.prepareCall(SP_BORRAR_MOTO);
			
			cStmt.setInt(1, id);
			cStmt.execute();
			
			System.out.println("Borrado correctamente");
			
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("No se ha borrado");
		}
	}
	
	public V_Motos obtenerMotoPorId(Connection con, int id) {
		
		V_Motos moto = new V_Motos();
		
		try {
			
			CallableStatement cStmt = con.prepareCall(SP_OBTENER_MOTO_ID);
			cStmt.setInt(1, id);
			cStmt.execute();
			
			ResultSet rs = cStmt.getResultSet();
			
			while(rs.next()) {
				
				moto.setId			(rs.getInt(V_MOTOS_ID));
				moto.setNombre		(rs.getString(V_MOTOS_NOMBRE));
				moto.setMatricula	(rs.getString(V_MOTOS_MATRICULA));
				moto.setPrecio		(rs.getInt(V_MOTOS_PRECIO));
				moto.setDescripcion	(rs.getString(V_MOTOS_DESCRIPCION));
				moto.setCilindrada	(rs.getString(V_MOTOS_CILINDRADADA));
				moto.setfk_marca	(rs.getInt(V_MOTOS_FK_MARCA));
				moto.setMarca		(rs.getString(V_MOTOS_MARCA));
				moto.setfk_categoria(rs.getInt(V_MOTOS_FK_CATEGORIA));
				moto.setCategoria	(rs.getString(V_MOTOS_CATEGORIA));
				
				System.out.println(moto);
			}
					
		}catch(SQLException e) {
			
			moto = new V_Motos();
			e.printStackTrace();
			System.out.println("No manda bien el id para recoger el formulario");
		
		}
		
		return moto;
	}
	
	public void modificarMotos(Connection con, Motos moto) {
		
		try {
			
			CallableStatement cStmt = con.prepareCall(SP_MODIFICAR_MOTO); //--> ESTA SIN HACER
			
			cStmt.setInt   (1, moto.getId());
			cStmt.setString(2, moto.getNombre());
			cStmt.setString(3, moto.getMatricula());
			cStmt.setString(4, moto.getDescripcion());
			cStmt.setInt   (5, moto.getPrecio());
			cStmt.setString(6, moto.getCilindrada());
			
			cStmt.setInt   (7, moto.getfk_marca());
			cStmt.setInt   (8, moto.getfk_categoria());
			
			cStmt.execute();
			
			System.out.println(cStmt);
			System.out.println("Se ha modificado correctamente");
			
		}catch(SQLException e) {
			
			e.printStackTrace();
			System.out.println("No se ha modificado");
		}
	}
	
	public void borrarTodo(Connection con) {
		
		try {
			
			CallableStatement cStmt = con.prepareCall(SP_BORRAR_TODO);
			
			cStmt.execute();
			
			System.out.println("Se ha borrado Correctamente");
			
		}catch(SQLException e) {
			
			e.printStackTrace();
			System.out.println("No se han borrado correctamente");
		}
	}
	
	public void restaurarMotos(Connection con, Motos moto) {
		
		try {
			
			CallableStatement cStmt = con.prepareCall(SP_RESTAURAR_MOTO); 
			
			cStmt.setInt   (1, moto.getId());
			cStmt.setString(2, moto.getNombre());
			cStmt.setString(3, moto.getMatricula());
			cStmt.setString(4, moto.getDescripcion());
			cStmt.setInt   (5, moto.getPrecio());
			cStmt.setString(6, moto.getCilindrada());
			
			cStmt.setInt   (7, moto.getfk_marca());
			cStmt.setInt   (8, moto.getfk_categoria());
			
			cStmt.execute();
			
			System.out.println(cStmt);
			System.out.println("Se ha modificado correctamente");
			
		}catch(SQLException e) {
			
			e.printStackTrace();
			System.out.println("No se ha modificado");
		}
		
	}
	
	public void restaurarMarca(Connection con, Marca marca) {
		
		try {
			
			CallableStatement cStmt = con.prepareCall(SP_RESTAURAR_MARCA); 
			
			cStmt.setInt   (1, marca.getId());
			cStmt.setString(2, marca.getMarca());
			
			cStmt.execute();
			
			System.out.println(cStmt);
			System.out.println("Se ha modificado correctamente");
			
		}catch(SQLException e) {
			
			e.printStackTrace();
			System.out.println("No se ha modificado");
		}
	}
	
	public void restaurarCategoria(Connection con, Categoria categoria) {
		
		try {
			
			CallableStatement cStmt = con.prepareCall(SP_RESTAURAR_CATEGORIA);
			
			cStmt.setInt   (1, categoria.getId());
			cStmt.setString(2, categoria.getCategoria());
			
			cStmt.execute();
			
			System.out.println(cStmt);
			System.out.println("Se ha modificado correctamente");
			
		}catch(SQLException e) {
			
			e.printStackTrace();
			System.out.println("No se ha modificado");
		}
		
	}
	
	public List<V_Motos> busquedaMotos(Connection con, String texto) {

		List<V_Motos> listaBusqueda = new ArrayList<V_Motos>();

		try {

			CallableStatement cStmt = con.prepareCall(SP_BUSQUEDA_MOTO);
			
			cStmt.setString(1,texto);
			cStmt.execute();
			
			ResultSet rs = cStmt.getResultSet();

			while (rs.next()) {

				V_Motos moto = new V_Motos();

				moto.setId			(rs.getInt(V_MOTOS_ID));
				moto.setNombre		(rs.getString(V_MOTOS_NOMBRE));
				moto.setMatricula	(rs.getString(V_MOTOS_MATRICULA));
				moto.setPrecio		(rs.getInt(V_MOTOS_PRECIO));
				moto.setDescripcion	(rs.getString(V_MOTOS_DESCRIPCION));
				moto.setCilindrada	(rs.getString(V_MOTOS_CILINDRADADA));
				moto.setfk_marca	(rs.getInt(V_MOTOS_FK_MARCA));
				moto.setMarca		(rs.getString(V_MOTOS_MARCA));
				moto.setfk_categoria(rs.getInt(V_MOTOS_FK_CATEGORIA));
				moto.setCategoria	(rs.getString(V_MOTOS_CATEGORIA));

				listaBusqueda.add(moto);

			}

		} catch (SQLException e) {

			System.out.println("NO SE PUDO OBTENER LA LISTA DE MOTOS");
			listaBusqueda = new ArrayList<V_Motos>();
			e.printStackTrace();
		}

		return listaBusqueda;
	}
	
}

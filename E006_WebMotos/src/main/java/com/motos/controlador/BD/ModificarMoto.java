package com.motos.controlador.BD;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.motos.modelo.DAO_Constantes;
import com.motos.modelo.dto.Categoria;
import com.motos.modelo.dto.Marca;
import com.motos.modelo.dto.Motos;
import com.motos.modelo.dto.V_Motos;
import com.motos.modelo.DB_Helper;

@WebServlet("/ModificarMoto")
public class ModificarMoto extends HttpServlet implements DAO_Constantes{
	private static final long serialVersionUID = 1L;
       
    public ModificarMoto() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int id = 0;
		if(request.getParameter("id")!=null) {
			id=Integer.parseInt(request.getParameter("id"));
		}
		
		String nombre = "";
		if(request.getParameter("nombre")!=null) {
			nombre=request.getParameter("nombre");
		}
		
		String matricula = "";
		if(request.getParameter("matricula")!=null) {
			matricula=request.getParameter("matricula");
		}
		
		String descripcion = "";
		if(request.getParameter("descripcion")!=null) {
			descripcion=request.getParameter("descripcion");
		}
		
		int precio = 0;
		if(request.getParameter("precio")!=null) {
			precio=Integer.parseInt(request.getParameter("precio"));
		}
		
		String cilindrada = "";
		if(request.getParameter("cilindrada")!=null) {
			cilindrada=request.getParameter("cilindrada");
		}
		
		int marca = 0;
		if(request.getParameter("marca")!=null) {
			marca=Integer.parseInt(request.getParameter("marca"));
		}
		
		int categoria = 0;
		if(request.getParameter("categoria")!=null) {
			categoria=Integer.parseInt(request.getParameter("categoria"));
		}
		
		Motos moto = new Motos(id,nombre,matricula,descripcion,precio,cilindrada,marca,categoria);
		
		DB_Helper db = new DB_Helper();
		Connection con = db.Conectar();
		
		
		db.modificarMotos(con,moto); //--> TIENES QUE HACERLO
		
		List<Marca> listaMarca = db.obtenerTodosMarca(con);
		List<Categoria> listaCategoria = db.obtenerTodosCategoria(con);
		List<V_Motos> lista_V_Motos = db.obtenerTodosMotos(con);
		
		db.desconectar(con);
		
		request.setAttribute(ATR_LISTA_MARCAS, listaMarca);
		request.setAttribute(ATR_LISTA_CATEGORIAS, listaCategoria); 
		request.setAttribute(ATR_LISTA_V_MOTOS, lista_V_Motos); 
		
		request.getRequestDispatcher(INDEX_JSP).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

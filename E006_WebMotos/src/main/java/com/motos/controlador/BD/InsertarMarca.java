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
import com.motos.modelo.DB_Helper;
import com.motos.modelo.dto.Categoria;
import com.motos.modelo.dto.Marca;
import com.motos.modelo.dto.V_Motos;

@WebServlet("/InsertarMarca")
public class InsertarMarca extends HttpServlet implements DAO_Constantes{
	private static final long serialVersionUID = 1L;
       

    public InsertarMarca() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//recoger atributos
		
		String marca = "";
		if(request.getParameter("marca")!= null) {
			marca = request.getParameter("marca");
		}
		Marca marcaM = new Marca(0,marca);
		
		DB_Helper db = new DB_Helper();
		Connection con = db.Conectar();
		
		db.insertarMarca(con,marcaM);
		
		List<V_Motos> lista_Motos = db.obtenerTodosMotos(con);
		List<Marca> listaMarca = db.obtenerTodosMarca(con);
		List<Categoria> listaCategoria = db.obtenerTodosCategoria(con);
		
		db.desconectar(con);
		
		request.setAttribute(ATR_LISTA_V_MOTOS, lista_Motos);
		request.setAttribute(ATR_LISTA_MARCAS, listaMarca);
		request.setAttribute(ATR_LISTA_CATEGORIAS, listaCategoria);  
		
		request.getRequestDispatcher(ADD_MARCAS).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

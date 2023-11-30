package com.motos.controlador.BD;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.motos.modelo.DAO_Constantes;
import com.motos.modelo.DB_Helper;
import com.motos.modelo.dto.Categoria;


@WebServlet("/InsertarCategoria")
public class InsertarCategoria extends HttpServlet implements DAO_Constantes{
	private static final long serialVersionUID = 1L;

    public InsertarCategoria() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String categoria = "";
		if(request.getParameter("categoria")!= null) {
			categoria = request.getParameter("categoria");
		}
	
		Categoria categoriaM = new Categoria(0,categoria);
		
		DB_Helper db = new DB_Helper();
		Connection con = db.Conectar();
		
		db.insertarCategoria(con,categoriaM);
		
		db.desconectar(con);
		
		request.getRequestDispatcher(ADD_CATEGORIAS).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

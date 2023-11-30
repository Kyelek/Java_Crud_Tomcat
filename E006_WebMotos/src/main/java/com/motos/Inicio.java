package com.motos;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.motos.modelo.DB_Helper;
import com.motos.modelo.dto.Motos;
import com.motos.modelo.dto.V_Motos;
import com.motos.modelo.DAO_Constantes;


@WebServlet("/Inicio")
public class Inicio extends HttpServlet implements DAO_Constantes{
	private static final long serialVersionUID = 1L;
       
    public Inicio() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		DB_Helper db = new DB_Helper();
		Connection con = db.Conectar();	
		
		List<V_Motos> lista_Motos = db.obtenerTodosMotos(con);
		
		db.desconectar(con);
		
		request.setAttribute(ATR_LISTA_MOTOS, lista_Motos);
		
		request.getRequestDispatcher(INDEX_JSP).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

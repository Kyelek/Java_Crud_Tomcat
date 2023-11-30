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
import com.motos.modelo.dto.V_Motos;

@WebServlet("/BorrarMoto")
public class BorrarMoto extends HttpServlet implements DAO_Constantes{
	private static final long serialVersionUID = 1L;
       
    public BorrarMoto() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int id= 0 ;
		if(request.getParameter("id")!=null) {
			id=Integer.parseInt(request.getParameter("id"));
		}
		
		DB_Helper db = new DB_Helper();
		Connection con = db.Conectar();
		
		db.borrarMotoPorId(con, id);
		
		List<V_Motos> lista_Motos = db.obtenerTodosMotos(con);
		
		db.desconectar(con);
		
		request.setAttribute(ATR_LISTA_MOTOS, lista_Motos);
		
		request.getRequestDispatcher(INDEX_JSP).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

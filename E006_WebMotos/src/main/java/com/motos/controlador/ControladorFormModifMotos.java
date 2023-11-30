package com.motos.controlador;

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

/**
 * Servlet implementation class ControladorFormModifMotos
 */
@WebServlet("/ControladorFormModifMotos")
public class ControladorFormModifMotos extends HttpServlet implements DAO_Constantes{
	private static final long serialVersionUID = 1L;
       
    public ControladorFormModifMotos() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id=0;
		
		if(request.getParameter("id")!=null) {
			id=Integer.parseInt(request.getParameter("id"));
		}
		
		DB_Helper db = new DB_Helper();
		Connection con = db.Conectar();
		
		List<Marca> listaMarca = db.obtenerTodosMarca(con);
		List<Categoria> listaCategoria = db.obtenerTodosCategoria(con);
		V_Motos moto = db.obtenerMotoPorId(con, id);
		
		System.out.println(id+ "" + moto +"," + listaMarca+ "," + listaCategoria);
		
		db.desconectar(con);
		
		request.setAttribute(ATR_MOTOS, moto);
		request.setAttribute(ATR_LISTA_MARCAS, listaMarca);
		request.setAttribute(ATR_LISTA_CATEGORIAS, listaCategoria); 
		
		request.getRequestDispatcher(MODIF_FORM_MOTOS).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

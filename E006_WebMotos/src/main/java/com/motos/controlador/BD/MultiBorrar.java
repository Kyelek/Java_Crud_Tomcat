package com.motos.controlador.BD;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
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
 * Servlet implementation class MultiBorrar
 */
@WebServlet("/MultiBorrar")
public class MultiBorrar extends HttpServlet implements DAO_Constantes{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MultiBorrar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<String> listaIDs = new ArrayList<String>();

				
		if (request.getParameterValues("id")!=null) {
			listaIDs=Arrays.asList(request.getParameterValues("id"));
			
			}
		DB_Helper db = new DB_Helper();
		Connection con = db.Conectar();
		
		List<Marca> listaMarca = db.obtenerTodosMarca(con);
		List<Categoria> listaCategoria = db.obtenerTodosCategoria(con);
		List<V_Motos> lista_V_Motos = db.obtenerTodosMotos(con);
		
		for(String elemento: listaIDs) {
			
			int numero = Integer.parseInt(elemento);
			db.borrarMotoPorId(con, numero);
			
		}
		
		db.desconectar(con);
		
		request.setAttribute(ATR_LISTA_MARCAS, listaMarca);
		request.setAttribute(ATR_LISTA_CATEGORIAS, listaCategoria); 
		request.setAttribute(ATR_LISTA_V_MOTOS, lista_V_Motos);
		
		request.getRequestDispatcher(INDEX_JSP).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

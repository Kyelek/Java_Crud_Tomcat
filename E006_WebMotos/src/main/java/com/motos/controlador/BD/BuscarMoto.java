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

@WebServlet("/BuscarMoto")
public class BuscarMoto extends HttpServlet implements DAO_Constantes{
	private static final long serialVersionUID = 1L;

    public BuscarMoto() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String texto = "";
		if(request.getParameter("texto")!= null) {
			texto=request.getParameter("texto");
		}		
		
		DB_Helper db = new DB_Helper();
		Connection con = db.Conectar();
		
		List<Marca> listaMarca = db.obtenerTodosMarca(con);
		List<Categoria> listaCategoria = db.obtenerTodosCategoria(con);
		List<V_Motos> listaBusqueda = db.busquedaMotos(con, texto);
		
		request.setAttribute(ATR_LISTA_MARCAS, listaMarca);
		request.setAttribute(ATR_LISTA_CATEGORIAS, listaCategoria);
		request.setAttribute(ATR_LISTA_V_MOTOS, listaBusqueda);

		db.desconectar(con);
		
		request.getRequestDispatcher(INDEX_JSP).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

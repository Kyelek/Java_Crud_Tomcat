package com.motos.controlador.BD;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
import com.motos.modelo.dto.Motos;
import com.motos.modelo.dto.V_Motos;

@WebServlet("/CrearCopiaSeguridad")
public class CrearCopiaSeguridad extends HttpServlet implements DAO_Constantes{
	private static final long serialVersionUID = 1L;

    public CrearCopiaSeguridad() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		DB_Helper db = new DB_Helper();
		Connection con = db.Conectar();
		
		List<V_Motos> lista_Motos = db.obtenerTodosMotos(con);
		List<Marca> listaMarca = db.obtenerTodosMarca(con);
		List<Categoria> listaCategoria = db.obtenerTodosCategoria(con);
		List<Motos> listaTablaMotos = db.obtenerMotos(con);
		
		PrintWriter pw;
		
		try {
			
			FileWriter archivo = new FileWriter(DIRECCION_CS_MARCA);
			pw = new PrintWriter(archivo);
			
			for(Marca elemento : listaMarca) {
				pw.println(elemento);
			}
			archivo.close();
			
		}catch(IOException e) {
			
			e.printStackTrace();
		}
		
		try {
			
			FileWriter archivo2 = new FileWriter(DIRECCION_CS_CATEGORIA);
			pw = new PrintWriter(archivo2);
			
			for(Categoria elemento2 : listaCategoria) {
				pw.println(elemento2);
			}
			archivo2.close();
			
		}catch(IOException e) {
			
			e.printStackTrace();
		}
		
		try {
			
			FileWriter archivo3 = new FileWriter(DIRECCION_CS_MOTOS);
			pw = new PrintWriter(archivo3);
			
			for(Motos elemento3 : listaTablaMotos) {
				pw.println(elemento3);
			}
			archivo3.close();
			
		}catch(IOException e) {
			
			e.printStackTrace();
		}
		
		
		
		db.desconectar(con);
		
		request.setAttribute(ATR_LISTA_MOTOS, lista_Motos);
		request.setAttribute(ATR_LISTA_MARCAS, listaMarca);
		request.setAttribute(ATR_LISTA_CATEGORIAS, listaCategoria);
		request.setAttribute(ATR_MOTOS, listaTablaMotos);
		
		request.getRequestDispatcher(INDEX_JSP).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

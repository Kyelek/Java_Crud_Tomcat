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

import com.google.gson.Gson;
import com.motos.modelo.DAO_Constantes;
import com.motos.modelo.DB_Helper;
import com.motos.modelo.dto.Categoria;
import com.motos.modelo.dto.Marca;
import com.motos.modelo.dto.V_Motos;

@WebServlet("/CrearCopiaJSON")
public class CrearCopiaJSON extends HttpServlet implements DAO_Constantes{
	private static final long serialVersionUID = 1L;
       
    public CrearCopiaJSON() {
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
		
		FileWriter archivo = new FileWriter(DIRECCION_CS_MARCA_JSON);
		PrintWriter pw = new PrintWriter(archivo);
		
		String jsonMarcas = new Gson().toJson(listaMarca);
		pw.println(jsonMarcas);
		
		archivo.close();
		
		FileWriter archivo2 = new FileWriter(DIRECCION_CS_CATEGORIA_JSON);
		PrintWriter pw2 = new PrintWriter(archivo2);
		
		String jsonCategoria = new Gson().toJson(listaCategoria);
		pw2.println(jsonCategoria);
		
		archivo2.close();
		
		FileWriter archivo3 = new FileWriter(DIRECCION_CS_MOTOS_JSON);
		PrintWriter pw3 = new PrintWriter(archivo3);
		
		String jsonMotos = new Gson().toJson(lista_Motos);
		pw3.println(jsonMotos);
		
		archivo3.close();
		
		
		request.getRequestDispatcher(INDEX_JSP).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

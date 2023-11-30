package com.motos.controlador.BD;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.motos.modelo.DAO_Constantes;
import com.motos.modelo.dto.Categoria;
import com.motos.modelo.dto.Marca;
import com.motos.modelo.dto.Motos;

@WebServlet("/RestaurarCopiaJSON")
public class RestaurarCopiaJSON extends HttpServlet implements DAO_Constantes{
	private static final long serialVersionUID = 1L;
       
    public RestaurarCopiaJSON() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		List<Marca> listaMarcas = new ArrayList<Marca>();
		
		FileReader fr = new FileReader(DIRECCION_CS_MOTOS_JSON);
		BufferedReader br = new BufferedReader(fr);
		
		String linea = "";
		
		while((linea = br.readLine()) != null) {
			
			Marca[] ArrayMarcas = new Gson().fromJson(linea,Marca[].class);
			listaMarcas = Arrays.asList(ArrayMarcas);
		}
		
		List<Categoria> listaCategoria = new ArrayList<Categoria>();
		
		FileReader fr2 = new FileReader(DIRECCION_CS_CATEGORIA_JSON);
		BufferedReader br2 = new BufferedReader(fr2);
		
		String linea2 = "";
		
		while((linea2 = br2.readLine()) != null) {
			
			Categoria[] ArrayCategoria = new Gson().fromJson(linea2,Categoria[].class);
			listaCategoria = Arrays.asList(ArrayCategoria);
		}
		
		
		List<Motos> listaMotos = new ArrayList<Motos>();
		
		FileReader fr3 = new FileReader(DIRECCION_CS_CATEGORIA_JSON);
		BufferedReader br3 = new BufferedReader(fr3);
		
		String linea3=  "";
		
		while((linea3 = br3.readLine()) != null) {
			
			Motos[] ArrayMotos = new Gson().fromJson(linea3,Motos[].class);
			listaMotos = Arrays.asList(ArrayMotos);
		}
		
		
		request.getRequestDispatcher(INDEX_JSP).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

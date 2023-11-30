package com.motos.controlador.BD;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
import com.motos.modelo.dto.Marca;
import com.motos.modelo.dto.Motos;

@WebServlet("/RestaurarCopiaSeguridad")
public class RestaurarCopiaSeguridad extends HttpServlet implements DAO_Constantes{
	private static final long serialVersionUID = 1L;
       
    public RestaurarCopiaSeguridad() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		DB_Helper db = new DB_Helper();
		Connection con = db.Conectar();
		
		db.borrarTodo(con);
		
		File archivo3 = new File(DIRECCION_CS_CATEGORIA);
		FileReader fr3 = new FileReader(archivo3);
		BufferedReader br3 = new BufferedReader(fr3);
		
		String linea3 = "";
		
		while ((linea3 = br3.readLine()) != null) {
			
			String partes3[] = linea3.split(";");
			Categoria categoria = new Categoria(Integer.parseInt(partes3[0]), partes3[1]);
			
			db.restaurarCategoria(con, categoria);
			
			System.out.println(linea3);
		}
		
		File archivo2 = new File(DIRECCION_CS_MARCA);
		FileReader fr2 = new FileReader(archivo2);
		BufferedReader br2 = new BufferedReader(fr2);
		
		String linea2 = "";
		
		while ((linea2 = br2.readLine()) != null) {
			
			String partes2[] = linea2.split(";");
			Marca marca = new Marca(Integer.parseInt(partes2[0]), partes2[1]);
			
			db.restaurarMarca(con, marca);
			
			System.out.println(linea2);
		}
		
		
		File archivo = new File(DIRECCION_CS_MOTOS);
		FileReader fr = new FileReader(archivo);
		BufferedReader br = new BufferedReader(fr);
		
		String linea = "";
		
		while ((linea = br.readLine()) != null) {
			
			String partes[] = linea.split(";");
			Motos moto = new Motos(
					Integer.parseInt(partes[0]),
					partes[1],
					partes[2],
					partes[3],
					Integer.parseInt(partes[4]),
					partes[5],
					Integer.parseInt(partes[6]),
					Integer.parseInt(partes[7]));
			
			db.restaurarMotos(con, moto);
			
			System.out.println(linea);
		}
		
		
		db.desconectar(con);
		
		request.getRequestDispatcher(INDEX_JSP).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

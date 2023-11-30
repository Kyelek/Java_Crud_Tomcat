<%@page import="com.motos.modelo.dto.Categoria"%>
<%@page import="com.motos.modelo.dto.Marca"%>
<%@page import="com.motos.modelo.DAO_Constantes"%>
<%@page import="com.motos.modelo.dto.V_Motos"%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%

	List<V_Motos> lista_Motos = new ArrayList<V_Motos>();

	if(request.getAttribute(DAO_Constantes.ATR_LISTA_V_MOTOS)!=null){
		lista_Motos = (List<V_Motos>)request.getAttribute(DAO_Constantes.ATR_LISTA_V_MOTOS);
	}
	
	List<Marca> listaMarca = new ArrayList<Marca>();

	if(request.getAttribute(DAO_Constantes.ATR_LISTA_MARCAS)!=null){
		listaMarca = (List<Marca>)request.getAttribute(DAO_Constantes.ATR_LISTA_MARCAS);
	}
	
	List<Categoria> listaCategoria = new ArrayList<Categoria>();

	if(request.getAttribute(DAO_Constantes.ATR_LISTA_CATEGORIAS)!=null){
		listaCategoria = (List<Categoria>)request.getAttribute(DAO_Constantes.ATR_LISTA_CATEGORIAS);
	}

%>

<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Moto Pasión</title>
		<link rel="stylesheet" href="Styles/style.css">
	</head>
	<body>
		
	<%@ include file ="Includes/header_nav.jsp" %>
			
		<main>
		
			<div>
				<h2> Añade un nuevo modelo</h2>
			</div>
			<form method = "GET" action ="InsertarCategoria">
			
				<div id="cont_principal_motos">
					<div class="cont_moto_individual">
						<section class="cont_moto_izq">
							<img id ="imagenes_motos"  src = "Imagenes/ImagenesMotos/kawasaki_ninja_125.png">
						</section>
						<section class="cont_moto_der">
							
							<label id="label_cont_motos" name="nombre">Categoria</label><br>							
							<input type="text" name="categoria"><br>
							
						</section>
						<input type="submit" class="botonInsertar" value ="Insertar nuevo modelo" >
					</div>
				</div>
			</form>
		</main>
		
		<footer>
		
		</footer>
		
	</body>
</html>
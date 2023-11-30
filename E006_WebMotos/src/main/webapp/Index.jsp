<%@page import="com.motos.modelo.DAO_Constantes"%>
<%@page import="com.motos.modelo.dto.V_Motos"%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%

	List<V_Motos> lista_motos = new ArrayList<V_Motos>();
	
	if(request.getAttribute(DAO_Constantes.ATR_LISTA_MOTOS)!=null){
		lista_motos = (List<V_Motos>)request.getAttribute(DAO_Constantes.ATR_LISTA_MOTOS);
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
				<h2> Nuestras motos</h2>
				<form method="GET" action="MultiBorrar">
					<input type="submit" value="borrar muchos">
				</form>
			</div>
			<%
				for(V_Motos elemento: lista_motos){
			%>
			<div id="cont_principal_motos">
				<div class="cont_moto_individual">
					<section class="cont_moto_izq">
						<img id ="imagenes_motos" src="Imagenes/ImagenesMotos/kawasaki_ninja_125.png"><br></br>
						<a class="enlaceBYM" href = "BorrarMoto?id=<%=elemento.getId() %>" >Borrar</a><a class="enlaceBYM" href="ControladorFormModifMotos?id=<%=elemento.getId() %>">Modificar</a>
					</section>
					<section class="cont_moto_der">
						
						<input type="checkbox" value="<%=elemento.getId()%>" name="id"><br>

						<label id="label_cont_motos" name="nombre">Nombre</label>
						<p><%=elemento.getNombre() %></p>
						<label id="label_cont_motos" name="marca">Marca</label>
						<p><%=elemento.getMarca() %></p>
						<label id="label_cont_motos" name="precio">Precio</label>
						<p><%=elemento.getPrecio() %>$</p>
						<label id="label_cont_motos" name="descripcion">Descripción</label>
						<p><%=elemento.getDescripcion() %></p>
						<label id="label_cont_motos" name="cilindrada">Cilindrada</label>
						<p><%=elemento.getCilindrada() %></p>
						<label id="label_cont_motos" name="matricula">Matricula</label>
						<p><%=elemento.getMatricula() %></p>
						<label id="label_cont_motos" name="categoria">Categoria</label>
						<p><%=elemento.getCategoria() %></p>
						
					</section>
				</div>
			</div>
		
			<%
				}
			%>
			
		</main>
		
		<footer>
		
		</footer>
		
	</body>
</html>
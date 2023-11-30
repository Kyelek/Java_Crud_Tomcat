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

	V_Motos moto = new V_Motos();

	if(request.getAttribute(DAO_Constantes.ATR_MOTOS)!=null){
		moto = (V_Motos)request.getAttribute(DAO_Constantes.ATR_MOTOS);
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
				<h2> Añade una moto al catálogo</h2>
			</div>
			<form method = "GET" action = "ModificarMoto">
			
				<div id="cont_principal_motos">
					<div class="cont_moto_individual">
						<section class="cont_moto_izq">
							<img id ="imagenes_motos" src = "Imagenes/ImagenesMotos/kawasaki_ninja_125.png">
						</section>
						<section class="cont_moto_der">
							
							<label id="label_cont_motos" name="id">ID</label><br>
							<input type="number" name="id" value="<%=moto.getId()%>"><br>
							<label id="label_cont_motos" name="nombre">Nombre</label><br>							
							<input type="text" name="nombre" value="<%=moto.getNombre()%>"><br>
							<label id="label_cont_motos" name="matricula">Matricula</label><br>
							<input type="text" name="matricula" value="<%=moto.getMatricula()%>"><br>
							<label id="label_cont_motos" name="descripcion">Descripción</label><br>
							<input type="text" name ="descripcion" value="<%=moto.getDescripcion()%>"><br>
							<label id="label_cont_motos" name="precio">Precio</label><br>
							<input type="number" name="precio" value="<%=moto.getPrecio()%>"><br>
							<label id="label_cont_motos" name="cilindrada">Cilindrada</label><br>
							<input type="text" name="cilindrada" value="<%=moto.getCilindrada()%>"><br>
							<label id="label_cont_motos" name="marca">Marca</label><br>
								<select name ="marca">
								<%
									for(Marca elemento:listaMarca){
										if(elemento.getId() == (moto.getfk_marca())){
								%>
											<option value="<%=elemento.getId()%>" selected><%=elemento.getMarca() %></option>
								<%
										}else{
								%>
											<option value="<%=elemento.getId()%>"><%=elemento.getMarca() %></option>
								<%
										}
									} 
								%>
								</select><br>	
							<label id="label_cont_motos" name="categoria">Categoria</label><br>
								<select name ="categoria">
								<%
									for(Categoria elemento2:listaCategoria){
										if(elemento2.getId() == (moto.getfk_categoria())){
								%>
											<option value="<%=elemento2.getId()%>" selected><%=elemento2.getCategoria() %></option>
								<%
										}else{
								%>
											<option value="<%=elemento2.getId()%>"><%=elemento2.getCategoria() %></option>
								<%
										}
									}
								%>
								</select><br>
						</section>
						<input type="submit" class="botonInsertar" value ="Modificar Moto" >
					</div>
				</div>
			</form>
			<form method ="GET" action = "">
				<input type="file">
				<input type="submit">
			</form>
		</main>
		
		<footer>
		
		</footer>
		
	</body>
</html>
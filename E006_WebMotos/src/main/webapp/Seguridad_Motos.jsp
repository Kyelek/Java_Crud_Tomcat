<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Moto Pasión</title>
		<link rel="stylesheet" href="Styles/style.css">
	</head>
	<body>
		
	<%@ include file ="Includes/header_nav.jsp" %>
			
		<main>
		
		<h2>Seguridad</h2>

		</main>
		
			<form method = "get" action="CrearCopiaSeguridad">			
				<input type="submit" class="botonInsertar"  value="Crear copia de seguridad">
			</form>
			
			<form method = "get" action="RestaurarCopiaSeguridad">
				<input type="submit" class="botonInsertar"  value="Restaurar copia de seguridad">
			</form>
			
			<form method = "get" action="CrearCopiaJSON">
				<input type="submit" class="botonInsertar"  value="Crear copia de JSON">
			</form>
			
			<form method = "get" action="RestaurarCopiaJSON">
				<input type="submit" class="botonInsertar"  value="Restaurar copia de JSON">
			</form>
		
		<footer>
		
		</footer>
		
	</body>
</html>
package com.motos.modelo;

public interface DAO_Constantes {

	
	// constantes de la BD

	String NOMBRE_BD = "db_motos";
	String RUTA = "jdbc:mysql://localhost:3306/" + NOMBRE_BD;
	String DRIVE = "com.mysql.cj.jdbc.Driver";
	String USUARIO = "root";
	String PASS = "1234";
	
	// constantes JSP
	
	String INDEX_JSP = "Index.jsp";
	String ADD_MOTOS = "Add_motos.jsp";
	String ADD_CATEGORIAS = "Add_Categorias.jsp";
	String ADD_MARCAS = "Add_Marca.jsp";	
	String MODIF_FORM_MOTOS = "Modif_Motos.jsp";
	String SEGURIDAD_MOTOS_JSP ="Seguridad_Motos.jsp";
	// constandes BD
	
	String TABLA_MOTOS = "tb_motos";
	String MOTOS_ID = "id";
	String MOTOS_NOMBRE = "nombre";
	String MOTOS_MATRICULA = "matricula";
	String MOTOS_PRECIO = "precio";
	String MOTOS_DESCRIPCION = "descripcion";
	String MOTOS_CILINDRADADA = "cilindrada";
	String MOTOS_FK_MARCA = "fk_marca";
	String MOTOS_FK_CATEGORIA = "fk_categoria";
	
	String TABLA_CATEGORIA = "tb_categoria";
	String CATEGORIA_ID = "id";
	String CATEGORIA_CATEGORIA = "categoria";
	
	String TABLA_MARCA = "tb_marca";
	String MARCA_ID = "id";
	String MARCA_MARCA = "marca";
	
	String V_MOTOS ="v_motos";
	String V_MOTOS_ID = "id";
	String V_MOTOS_NOMBRE = "nombre";
	String V_MOTOS_MATRICULA = "matricula";
	String V_MOTOS_PRECIO = "precio";
	String V_MOTOS_DESCRIPCION = "descripcion";
	String V_MOTOS_CILINDRADADA = "cilindrada";
	String V_MOTOS_FK_MARCA = "fk_marca";
	String V_MOTOS_MARCA = "marca";
	String V_MOTOS_FK_CATEGORIA = "fk_categoria";
	String V_MOTOS_CATEGORIA = "categoria";
	
	// Procedimientos
	
	String V_VISTA_TODAS_MOTOS = "call v_motos()";
	String SP_OBTENER_TABLA_MOTOS = "call sp_obtener_motos()";
	String SP_OBTENER_VISTA_TODAS_MOTOS = "call sp_obtener_vista_todas_motos();";
	String SP_OBTENER_MARCA = "call sp_obtener_marca()";
	String SP_OBTENER_CATEGORIA = "call sp_obtener_categoria()";
	String SP_OBTENER_MOTO_ID ="call sp_obtener_moto_por_id(?)";
	String SP_INSERTAR_MOTOS = "call sp_insertar_motos(?,?,?,?,?,?,?)";
	String SP_INSERTAR_CATEGORIAS = "call sp_insertar_categoria(?)";
	String SP_INSERTAR_MARCA = "call sp_insertar_marca(?)";
	String SP_BORRAR_MOTO = "call sp_borrar_moto(?)";
	String SP_MODIFICAR_MOTO = "call sp_modificar_moto(?,?,?,?,?,?,?,?)";
	String SP_RESTAURAR_MOTO = "call sp_restaurar_motos(?,?,?,?,?,?,?,?)";
	String SP_RESTAURAR_MARCA = "call sp_restaurar_marca(?,?)";
	String SP_RESTAURAR_CATEGORIA = "call sp_restaurar_categoria(?,?)";
	String SP_BUSQUEDA_MOTO = "call sp_buscar_moto(?)";
	String SP_BORRAR_TODO = "call sp_borrar_todo()";
	
	// Atributos Lista
	
	String ATR_LISTA_MOTOS = "atr_lista_motos";
	String ATR_LISTA_V_MOTOS = "atr_lista_v_motos";
	String ATR_MOTOS = "atr_motos";
	String ATR_LISTA_MARCAS = "atr_lista_marcas";
	String ATR_LISTA_CATEGORIAS = "atr_lista_categorias";
	
	// Archivos
	
	String DIRECCION_CS_MARCA = "D:\\Desktop\\Clases\\manejo_archivos\\marcas.csv";
	String DIRECCION_CS_CATEGORIA = "D:\\Desktop\\Clases\\manejo_archivos\\categoria.csv";
	String DIRECCION_CS_MOTOS = "D:\\Desktop\\Clases\\manejo_archivos\\motos.csv";
	
	String DIRECCION_CS_MOTOS_JSON = "D:\\Desktop\\Clases\\manejo_archivos\\motosJSON.json";
	String DIRECCION_CS_CATEGORIA_JSON = "D:\\Desktop\\Clases\\manejo_archivos\\categoriaJSON.json";
	String DIRECCION_CS_MARCA_JSON = "D:\\Desktop\\Clases\\manejo_archivos\\marcasJSON.json";
}

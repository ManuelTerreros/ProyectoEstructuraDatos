<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario</title>
<link rel="Stylesheet" type="text/css" href="CSS/index.css">
<script src="JS/funcion.js"></script>
</head>

<body>

<div id="loader">
  <img src="Img/PantallaCarga.png" alt="Cargando...">
</div>

<div class="contenedor">
  <img class="img-esquina" src="Img/UNOLogo.png" alt="Logo" >
</div>

	<form id="formulario" action="LogicaServlet" method="post" onsubmit=" return validarUsuarios();">
		<div class="form-content">
			<h1 class="titulo">UNO TEACHER</h1>
			<div class="table-container">
				<table>
					<tr>
						<td class="subtitulos">JUGADOR 1</td>
						<td><input type="text" name="usuario1" value="" size="40"
							class="field" id="labeljug1"></td>
					</tr>
					<tr>
						<td class="subtitulos">JUGADOR 2</td>
						<td><input type="text" name="usuario2" value="" size="40"
							class="field" id="labeljug2"></td>
					</tr>
					<tr>
						<td class="subtitulos">APRENDIZ</td>
						<td><input type="text" name="apren" value="" size="40"
							class="field" id="labeljug3"></td>
					</tr>
				</table>
			</div>
			<br> <input type="submit" value="JUGAR" class="button" >
		</div>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UNO</title>
<link rel="Stylesheet" type="text/css" href="CSS/Estilo.css">
</head>
<header>
	<label class="logo"> <img src="Img/UNOLogo.png">
	</label>
	<ul class="label">
		<li class="label11"><h4>${jug1}</h4></li>
		<li class="label21"><h4>${jug2}</h4></li>
		<li class="label31"><h4>${apren}</h4></li>
	</ul>
	<button class="botonsalir">
		<a href="index.jsp">Salir</a>
	</button>
</header>
<body>
	<div class="panelprincipal">
		<img src="Img/Fondo.png" class="fondo">
	</div>
	<div class="opciones">
		<button class="retroceder">
			<img src="Img/Izquierda.png">
		</button>
		<button class="consultar">
			<img src="Img/Lupa.png">
		</button>
		<button class="continuar">
			<img src="Img/derecha.png">
		</button>
	</div>
	<div>
		<div class="jugador">
			<h4>Player</h4>
		</div>
		<button class="mazo">
			<img src="Img/respaldoCarta.png">
		</button>
	</div>
	<div>
		<button class="aleatorio">Descartar Cartas</button>
	</div>
	<div class="numcartas">
		<ul>
			<li>Jugador 1:</li>
			<li>Jugador 2:</li>
			<li>Jugador 3:</li>
		</ul>
	</div>
	<div class="recuadro">
		<div class="cartas">
			<button class="carta1">1</button>
			<button class="carta2">2</button>
			<button class="carta3">3</button>
			<button class="carta4">4</button>
			<button class="carta5">5</button>
		</div>
	</div>
</body>
</html>
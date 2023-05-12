
function validarUsuarios(){
	var jug1 = document.getElementById("labeljug1").textContent;
	var jug2 = document.getElementById("labeljug2").textContent;
	var jug3 = document.getElementById("labeljug3").textContent;
	
	if(jug1==""||jug2==""||jug3==""){
		alert("Deben haber tres jugadores disponibles");
		return false;
	}
	return true;

}
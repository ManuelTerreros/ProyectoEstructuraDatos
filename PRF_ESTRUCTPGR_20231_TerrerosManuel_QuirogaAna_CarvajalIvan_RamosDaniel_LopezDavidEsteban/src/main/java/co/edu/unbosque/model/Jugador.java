package co.edu.unbosque.model;

public class Jugador {
	private String juga1,juga2,juga3;
	
	public Jugador(String jug1, String jug2, String jug3) {
		
		almacenarJugadores(jug1, jug2, jug3);
	}

	
	public void almacenarJugadores(String jug1, String jug2, String jug3) {
		 this.juga1 = jug1; 
		 this.juga2 = jug2;
		 this.juga3 = jug3;
		 System.out.println(juga1+" "+juga2+" "+juga3);

	}
}

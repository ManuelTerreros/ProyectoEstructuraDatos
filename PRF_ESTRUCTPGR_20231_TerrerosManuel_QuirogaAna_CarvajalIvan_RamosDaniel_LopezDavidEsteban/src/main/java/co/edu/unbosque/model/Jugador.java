package co.edu.unbosque.model;

import java.util.Random;

public class Jugador {
	private String juga1,juga2,aprendiz;
	private Random rd = new Random();
	
	
	public Jugador(String jug1, String jug2, String apren) {
		
		
	}

	
	public void almacenarJugadores(String jug1, String jug2, String apren) {
		 this.juga1 = jug1; 
		 this.juga2 = jug2;
		 this.aprendiz = apren;
		 System.out.println(juga1+" "+juga2+" "+aprendiz);

	}
	
	public void ordenarJugadores() {
		int[]orden = new int [3];
		orden[0] = 1;
		orden[1] = 2;
		orden[2] = 3;

			for(int i=2; i >= 0; i--) {
				int j = rd.nextInt(i+1) ;
		        int temp = orden[i];
		        orden[i] = orden[j];
		        orden[j] = temp;
			}
			    System.out.println("Jugador: " + orden[0]);
			    System.out.println("Jugador: " + orden[1]);
			    System.out.println("Jugador: " + orden[2]);
		//AQUÍ TENGO UN PROBLEMA, NO ME DEJA HACER EL CAMBIO DE LAS VARIABLES DE NOMBRE
		// A ENTERO Y MANDARLAS AL SERVLET, APRARECE LA EXCEPCION DE NUMEROS
		// ATT: MANUEL EL 13/05	    

		
		
		
		
	}
}

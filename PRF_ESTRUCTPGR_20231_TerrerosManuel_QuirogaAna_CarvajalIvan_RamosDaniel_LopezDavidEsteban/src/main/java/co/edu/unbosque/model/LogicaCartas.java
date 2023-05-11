package co.edu.unbosque.model;

import java.util.ArrayList;

public class LogicaCartas {
	
	private ArrayList<Carta> montoCarta;
	private String[] color;
	
	public LogicaCartas() {
		 montoCarta=new ArrayList<>();
		color= new String[4];
		generarCartaNumero();
	}

	public void generarCartaNumero() {
		color[0]="Amarillo";
		color[1]="Rojo";
		color[2]="Azul";
		color[3]="Verde";
		for(int i=0; i<4;i++) {
			for(int j=0;j<10;j++) {
				if(j==0) {
					Carta c1= new Carta(j,color[i]);
					montoCarta.add(c1);
				}else {
					Carta c2= new Carta(j,color[i]);
					Carta c3= new Carta(j,color[i]);
					montoCarta.add(c2);
					montoCarta.add(c3);

				}
			}
		}
	}

}

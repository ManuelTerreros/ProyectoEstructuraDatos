package co.edu.unbosque.model;

public class LogicaCartas {
	
	private Pila montoCarta;
	private String[] color;
	
	public LogicaCartas() {
		montoCarta=new Pila();
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
					Carta c1= new Carta(i,color[j]);
					montoCarta.agregarElemento(c1);
				}else {
					Carta c2= new Carta(i,color[j]);
					Carta c3= new Carta(i,color[j]);
					montoCarta.agregarElemento(c2);
					montoCarta.agregarElemento(c3);
				}
			}
		}
	}

}

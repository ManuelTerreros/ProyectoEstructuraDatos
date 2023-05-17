package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.Stack;

public class LogicaCartas {
	
	private ArrayList<Carta> montoCarta;
	 Stack <Carta> pilaFinal;
	private String[] color;
	private int cont=0;
	private int concol=0;
	private Pila pila;
	
	public LogicaCartas() {
		 montoCarta=new ArrayList<>();
		 pilaFinal= new Stack <Carta> ();
		color= new String[4];
		color[0]="Amarillo";
		color[1]="Rojo";
		color[2]="Azul";
		color[3]="Verde";
		System.out.println(cont);
		generarCartaNumero();
		generarCartasComodinColor();
		generarCartasComodin();
		
		System.out.println(montoCarta.size());
		System.out.println(aleatorio(montoCarta.size()));
		generarPila(aleatorio(montoCarta.size()));
		System.out.println(concol);
		
	}

	public void generarCartaNumero() {

		for(int i=0; i<4;i++) {
			for(int j=0;j<10;j++) {
				if(j==0) {
					Carta c1= new Carta(j,color[i]);
					montoCarta.add(c1);
					cont++;
					concol++;
				}else {
					Carta c2= new Carta(j,color[i]);
					Carta c3= new Carta(j,color[i]);
					montoCarta.add(c2);
					montoCarta.add(c3);
					cont++;
					cont++;
					concol++;
					concol++;
				}
			}
		}
	}
	
	public void generarCartasComodinColor() {
		
		for(int i=0; i<4;i++) {
			for(int j=10; j<13; j++) {
					Carta c2= new Carta(j,color[i]);
					Carta c3= new Carta(j,color[i]);
					montoCarta.add(c2);
					montoCarta.add(c3);
					cont++;
					cont++;
					concol++;
					concol++;

				
			}
		}
		
	}
	
	public void generarCartasComodin() {
		String negro="negro";
		for(int j=0; j<4; j++) {
		for(int i=13; i<15; i++) {
			Carta c1= new Carta(i, negro);
			montoCarta.add(c1);
			cont++;
		}
		}
	}
	
	public void generarPila(Stack<String> pos) {
		int[] ale = new int[montoCarta.size()];
	//	int num = 0;
		for(int i=0; i<montoCarta.size(); i++) {
			
			int posi = Integer. parseInt(pos.pop());
			
			pilaFinal.push(montoCarta.get(posi));
		//	System.out.println(pilaFinal.get(i).getNumero()+" "+pilaFinal.get(i).getColor());
			//System.out.println(num);
		//	num=num+1;
		}
		
	}
	
	public Stack <String> aleatorio(int posi) {
		int pos;
	    Stack <String> pCartas = new Stack <String> ();
	    for (int i = 0; i < posi ; i++) {
	      pos = (int) Math.floor(Math.random() * posi );
	      while (pCartas.contains(pos)) {
	        pos = (int) Math.floor(Math.random() * posi );
	      }
	      pCartas.push(pos+"");
	    }
	    return pCartas;
	}
	
}

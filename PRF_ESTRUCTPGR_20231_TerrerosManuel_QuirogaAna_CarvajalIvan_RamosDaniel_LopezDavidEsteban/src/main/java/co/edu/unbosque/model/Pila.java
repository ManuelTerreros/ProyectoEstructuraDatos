package co.edu.unbosque.model;

import java.util.Stack;

public class Pila extends Thread{
	
	private Stack<Carta> montoCartas;
	
	public Pila() {
		montoCartas = new Stack<Carta>();
	}
	
	public void run() {
		
	}
	
	public void agregarElemento(Carta elemento) {
		montoCartas.push(elemento);
	}

}

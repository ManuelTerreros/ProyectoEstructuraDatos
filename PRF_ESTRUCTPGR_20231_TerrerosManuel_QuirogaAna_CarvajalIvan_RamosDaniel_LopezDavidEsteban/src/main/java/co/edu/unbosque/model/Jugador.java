package co.edu.unbosque.model;

import java.util.Stack;

public class Jugador {
	
	private String nombre;
	private Stack<Carta> pilaCartas;
	
	public Jugador(String nombre, Stack<Carta> pilaCartas) {
		this.nombre = nombre;
		this.pilaCartas = pilaCartas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Stack<Carta> getPilaCartas() {
		return pilaCartas;
	}

	public void setPilaCartas(Stack<Carta> pilaCartas) {
		this.pilaCartas = pilaCartas;
	}

	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", pilaCartas=" + pilaCartas + "]";
	}

	
	
	

}

package co.edu.unbosque.model;

import java.util.Stack;

public class ListaCircularJugador {

	OrdenJugador inicio;
	OrdenJugador fin;
	String jugador;
	String jugadorAnt;
	
	public ListaCircularJugador() {
		inicio=fin=null; 
		jugador="";
		jugadorAnt="";
	}
	
	public boolean vacia() {
		return inicio==null;
	}
	
	public void agregarInicio(String nombre, Stack<String> pilaCartas) {
		OrdenJugador nuevo = new OrdenJugador();
		Jugador j1 = new Jugador(nombre, pilaCartas);
		nuevo.setJugador(j1);
		if(vacia()) {
			inicio=nuevo;
			inicio.setSiguiente(inicio);
			//inicio.siguiente=inicio;
			inicio.setAnterior(fin);
			//inicio.anterior=fin;
			fin=nuevo;
		}else {
			fin.setSiguiente(nuevo);
			//fin.siguiente=nuevo;
			nuevo.setSiguiente(inicio);
			//nuevo.siguiente=inicio;
			fin=nuevo;
			inicio.setAnterior(fin);
			//inicio.anterior=fin;
		}
	}
	
	public void buscar(String v) {
		OrdenJugador actual = new OrdenJugador();
		actual=fin;
		boolean encontrado = false;
		do {
			if(actual.getJugador().getNombre()==v) {
				encontrado = true;
				jugador = actual.getJugador().getNombre();
			}
			actual = actual.getSiguiente();
		}while(actual!=fin);	
		if(encontrado==true) {
			System.out.println("esta");
			System.out.println(jugador);
		}else {
			System.out.println("no esta");
		}
	}
	
	public void juagdorSiguiente(String v) {
		OrdenJugador actual = new OrdenJugador();
		actual=inicio;
		boolean encontrado = false;
		do {
			if(actual.getJugador().getNombre().equals(v)) {
				encontrado = true;
				jugador = actual.getJugador().getNombre();
				jugadorAnt = actual.getSiguiente().getJugador().getNombre();
			}
			actual = actual.getSiguiente();
		}while(actual!=inicio);	
		if(encontrado==true) {
			System.out.println("El jugador que le sigue a "+v+" es");
			System.out.println(jugadorAnt);
		}else {
			System.out.println("no esta");
		}
	}
	
	public void juagdorAnterior(String v) {
		OrdenJugador actual = new OrdenJugador();
		OrdenJugador anterior = new OrdenJugador();
		actual=inicio;
		anterior = fin;
		boolean encontrado = false;
		do {
			if(actual.getJugador().getNombre().equals(v)) {
				encontrado = true;
				jugador = actual.getJugador().getNombre();
				jugadorAnt = anterior.getJugador().getNombre();
			}
			anterior = anterior.getSiguiente();
			actual = actual.getSiguiente();
			
		}while(actual!=inicio);	
		if(encontrado==true) {
			System.out.println("El jugador anterior a "+v+" es");
			System.out.println(jugadorAnt);
		}else {
			System.out.println("no esta");
		}
	}
	
	
	public void mostrar() {
		OrdenJugador actual = new OrdenJugador();
		actual=inicio;
		if(!vacia()) {
			do {
				System.out.println(actual.getJugador().toString());
				actual = actual.getSiguiente();
			}while(actual!=inicio);
		}
	}
	

}

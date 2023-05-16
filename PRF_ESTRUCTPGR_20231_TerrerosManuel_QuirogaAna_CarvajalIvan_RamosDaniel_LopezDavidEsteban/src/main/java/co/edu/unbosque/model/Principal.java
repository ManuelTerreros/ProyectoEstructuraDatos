package co.edu.unbosque.model;

import java.util.Stack;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListaCircularJugador lista = new ListaCircularJugador();
		Stack<String> pila1 = new  Stack<String>();
		pila1.push("Carta 2");
		pila1.push("Carta 4");
		Stack<String> pila2 = new  Stack<String>();
		pila2.push("Carta 6");
		pila2.push("Carta 7");
		Stack<String> pila3 = new  Stack<String>();
		pila3.push("Carta 8");
		pila3.push("Carta 1");
		
		lista.agregarInicio("Juan", pila1);
		lista.agregarInicio("Jose", pila2);
		lista.agregarInicio("Sebastian", pila3);
		lista.mostrar();
		System.out.println("----------------------------------");
		lista.juagdorSiguiente("Jose");
		lista.juagdorAnterior("Jose");
	}

}

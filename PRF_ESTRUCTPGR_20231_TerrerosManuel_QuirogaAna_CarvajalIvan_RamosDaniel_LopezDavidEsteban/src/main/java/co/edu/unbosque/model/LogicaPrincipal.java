package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class LogicaPrincipal {

	private PosicionJugador posJugador;
	private ArrayList<Carta> creacion;
	private Stack<Carta> pilaJugador1, pilaJugador2, pilaJugador3, montoRobar, montoDescartar;
	private String[] color;
	private String jug1, jug2, jug3;
	private Jugador jugador1, jugador2, jugador3;

	public LogicaPrincipal() {
		posJugador = new PosicionJugador();
		creacion = new ArrayList<>();
		color = new String[4];
		montoRobar = new Stack<Carta>();
		montoDescartar = new Stack<Carta>();
		pilaJugador1 = new Stack<Carta>();
		pilaJugador2 = new Stack<Carta>();
		pilaJugador3 = new Stack<Carta>();
		jugador1 = jugador2 = jugador3 = null;
		jug1 = jug2 = jug3 = "";
		generarCartaNumero();

	}

	public void generarCartaNumero() {
		color[0] = "Amarillo";
		color[1] = "Rojo";
		color[2] = "Azul";
		color[3] = "Verde";
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 10; j++) {
				if (j == 0) {
					Carta c1 = new Carta(j, color[i]);
					creacion.add(c1);
				} else {
					Carta c2 = new Carta(j, color[i]);
					Carta c3 = new Carta(j, color[i]);
					creacion.add(c2);
					creacion.add(c3);

				}
			}

			// las cartas con 10 equivalen a toma dos.
			// las cartas con 11 equivalen a reversa.
			// las cartas con 12 equivalen a pierde turno.

			for (int k = 10; k < 13; k++) {
				Carta c2 = new Carta(k, color[i]);
				Carta c3 = new Carta(k, color[i]);
				creacion.add(c2);
				creacion.add(c3);
			}
			// las cartas con 13 equivalen a cambio de color.
			// las cartas con 14 equivalen a toma cuatro.

			for (int l = 13; l < 15; l++) {
				Carta c1 = new Carta(l, "Negro");
				creacion.add(c1);
			}
		}

		int pos;
		int nCartas = creacion.size();

		for (int i = 0; i < nCartas; i++) {
			pos = (int) Math.floor(Math.random() * nCartas);
			while (montoRobar.contains(creacion.get(pos))) {
				pos = (int) Math.floor(Math.random() * nCartas);
			}
			montoRobar.push(creacion.get(pos));
		}
	}

	public void distribuirCartasYJugadores() {

		for (int i = 0; i < 7; i++) {
			pilaJugador1.push(montoRobar.pop());
			pilaJugador2.push(montoRobar.pop());
			pilaJugador3.push(montoRobar.pop());
		}

		jugador1 = new Jugador(jug1, pilaJugador1);
		jugador2 = new Jugador(jug2, pilaJugador2);
		jugador3 = new Jugador(jug3, pilaJugador3);

		posJugador.agregarInicio(jugador1);
		posJugador.agregarInicio(jugador2);
		posJugador.agregarInicio(jugador3);

	}

	public void robarCartas(int numero, String nombre) {

		for (int i = 0; i < numero; i++) {
			posJugador.buscar(nombre).getPilaCartas().push(montoRobar.pop());
		}

	}

	public String cambioColor() {

		Random r = new Random();
		String colorAleatorio = color[r.nextInt(4)];

		return colorAleatorio;
	}
	

	//Este metodo sirve para poder modificar la pila de cartas de el jugador que este seleccionando cartas
	public Carta elegirCarta(String nombre, Carta carta) {
		Jugador jugadorActual = posJugador.buscar(nombre);
		Stack<Carta> pilaActual = jugadorActual.getPilaCartas();
		Stack<Carta> pilaAux = new Stack<Carta>();
		ArrayList<Carta> arrayAux = new ArrayList<Carta>();
		int tam = pilaActual.size();
		int pos = 0;
		boolean encontrado = false;
		int numero = carta.getNumero();
		String color = carta.getColor();

		for (int i = 0; i < tam; i++) {
			arrayAux.add(pilaActual.pop());
		}

		while (!encontrado) {
			for (int i = 0; i < arrayAux.size(); i++) {
				if (arrayAux.get(i).getNumero() == numero && arrayAux.get(i).getColor().equals(color)) {
					encontrado = true;
					pos = i;
				}
			}
		}
		arrayAux.remove(pos);

		int tam2 = arrayAux.size() - 1;
		for (int i = tam2; i >= 0; i--) {
			pilaAux.push(arrayAux.get(i));
		}
		
		posJugador.buscar(nombre).setPilaCartas(pilaAux);
		
		return carta;
	}
	
	//este metodo agrega cartas a la pila de el centro que es la de descartar, les dejo a eleccion que quieren que retorne la pila o el array para que sepan cual fue
	//la ultima carta que se agrego y conforme a eso escojer la imagen
	public Stack<Carta> agregarPilaDescartar(Carta carta) {
		ArrayList<Carta> arrayUltimaCarta = new ArrayList<Carta>();
		montoDescartar.push(carta);
		arrayUltimaCarta.add(carta);
		return montoDescartar;
	}


	// METODOS PARA EL SENTIDO HORARIO DE LOS
	// JUGADORES----------------------------------------------------------------------------

	public Jugador consultarHorarioAnterior(String nombre) {
		Jugador ant = posJugador.jugadorAnterior(nombre);
		return ant;
	}

	public Jugador consultarHorarioSiguiente(String nombre) {
		Jugador sig = posJugador.jugadorSiguiente(nombre);
		return sig;
	}

	public Jugador consultarHorarioSaltaTurno(String nombre) {
		Jugador omi = posJugador.saltarTurno(nombre);
		return omi;
	}

	// METODOS PARA EL SENTIDO ANTI-HORARIO DE LOS
	// JUGADORES------------------------------------------------------------------------

	public Jugador consultarContrarioAnterior(String nombre) {
		Jugador ant = posJugador.jugadorSiguiente(nombre);
		return ant;
	}

	public Jugador consultarContrarioSiguiente(String nombre) {
		Jugador sig = posJugador.jugadorAnterior(nombre);
		return sig;
	}

	public Jugador consultarContrarioSaltaTurno(String nombre) {
		Jugador omi = posJugador.saltarTurnoContrario(nombre);
		return omi;
	}

	public Stack<Carta> getPilaJugador1() {
		return pilaJugador1;
	}

	public void setPilaJugador1(Stack<Carta> pilaJugador1) {
		this.pilaJugador1 = pilaJugador1;
	}

	public Stack<Carta> getPilaJugador2() {
		return pilaJugador2;
	}

	public void setPilaJugador2(Stack<Carta> pilaJugador2) {
		this.pilaJugador2 = pilaJugador2;
	}

	public Stack<Carta> getPilaJugador3() {
		return pilaJugador3;
	}

	public void setPilaJugador3(Stack<Carta> pilaJugador3) {
		this.pilaJugador3 = pilaJugador3;
	}

	public String getJug1() {
		return jug1;
	}

	public void setJug1(String jug1) {
		this.jug1 = jug1;
	}

	public String getJug2() {
		return jug2;
	}

	public void setJug2(String jug2) {
		this.jug2 = jug2;
	}

	public String getJug3() {
		return jug3;
	}

	public void setJug3(String jug3) {
		this.jug3 = jug3;
	}

	public Stack<Carta> getMontoRobar() {
		return montoRobar;
	}

	public void setMontoRobar(Stack<Carta> montoRobar) {
		this.montoRobar = montoRobar;
	}

	public Jugador getJugador1() {
		return jugador1;
	}

	public void setJugador1(Jugador jugador1) {
		this.jugador1 = jugador1;
	}

	public Jugador getJugador2() {
		return jugador2;
	}

	public void setJugador2(Jugador jugador2) {
		this.jugador2 = jugador2;
	}

	public Jugador getJugador3() {
		return jugador3;
	}

	public void setJugador3(Jugador jugador3) {
		this.jugador3 = jugador3;
	}

}

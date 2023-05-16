package co.edu.unbosque.model;

public class OrdenJugador {

	private Jugador jugador;
	private OrdenJugador siguiente;
	private OrdenJugador anterior;

	

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public OrdenJugador getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(OrdenJugador siguiente) {
		this.siguiente = siguiente;
	}

	public OrdenJugador getAnterior() {
		return anterior;
	}

	public void setAnterior(OrdenJugador anterior) {
		this.anterior = anterior;
	}
	
	
}

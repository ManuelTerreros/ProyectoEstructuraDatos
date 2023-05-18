package co.edu.unbosque.model;



public class PosicionJugador {

	OrdenJugador inicio;
	OrdenJugador fin;
	Jugador jugador;
	Jugador jugadorAnt, jugadorSig;
	
	public PosicionJugador() {
		inicio=fin=null; 
		jugador=null;
		jugadorAnt=null;
	}
	
	public boolean vacia() {
		return inicio==null;
	}
	
	public void agregarInicio(Jugador jug) {
		OrdenJugador nuevo = new OrdenJugador();

		nuevo.setJugador(jug);
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
				jugador = actual.getJugador();
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
	
	public Jugador jugadorSiguiente(String v) {
		OrdenJugador actual = new OrdenJugador();
		actual=inicio;
		boolean encontrado = false;
		do {
			if(actual.getJugador().getNombre().equals(v)) {
				encontrado = true;
				jugador = actual.getJugador();
				jugadorSig = actual.getSiguiente().getJugador();
			}
			actual = actual.getSiguiente();
		}while(actual!=inicio);	
		
		if(encontrado==true) {
			return jugadorSig;
		}
		return null;
	}
	
	public Jugador jugadorAnterior(String v) {
		OrdenJugador actual = new OrdenJugador();
		OrdenJugador anterior = new OrdenJugador();
		actual=inicio;
		anterior = fin;
		boolean encontrado = false;
		do {
			if(actual.getJugador().getNombre().equals(v)) {
				encontrado = true;
				jugador = actual.getJugador();
				jugadorAnt = anterior.getJugador();
			}
			anterior = anterior.getSiguiente();
			actual = actual.getSiguiente();
			
		}while(actual!=inicio);	
		
		if(encontrado==true) {
			return jugadorAnt;
		}
		
		return null;
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
	
	public Jugador saltarTurno(String v) {
		
		Jugador jug = jugadorSiguiente(v);
		String n = jug.getNombre();
		Jugador jugadorOmitido = jugadorSiguiente(n);
		
		return jugadorOmitido;
	}
	
	public Jugador saltarTurnoContrario(String v) {
		Jugador jug = jugadorAnterior(v);
		String n = jug.getNombre();
		Jugador jugadorOmitido = jugadorAnterior(n);
		
		return jugadorOmitido;
	}
	

}

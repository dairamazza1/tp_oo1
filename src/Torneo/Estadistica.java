package Torneo;

public class Estadistica {
	private int cantidadGoles;
	private int asistencias;
	private int minJugadores;
	private Jugador jugador;
	private Partido partido;
	
	public Estadistica(int cantidadGoles, int asistencias, int minJugadores, Jugador jugador, Partido partido) {
		this.cantidadGoles = cantidadGoles;
		this.asistencias = asistencias;
		this.minJugadores = minJugadores;
		this.jugador = jugador;
		this.partido = partido;
	}

	public int getCantidadGoles() {
		return cantidadGoles;
	}

	public int getAsistencias() {
		return asistencias;
	}

	public int getMinJugadores() {
		return minJugadores;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public Partido getPartido() {
		return partido;
	}

	public void setCantidadGoles(int cantidadGoles) {
		this.cantidadGoles = cantidadGoles;
	}

	public void setAsistencias(int asistencias) {
		this.asistencias = asistencias;
	}

	public void setMinJugadores(int minJugadores) {
		this.minJugadores = minJugadores;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	@Override
	public String toString() {
		return "Estadistica [cantidadGoles=" + cantidadGoles + ", asistencias=" + asistencias + ", minJugadores="
				+ minJugadores + "]";
	}
	
	 public boolean equals(Jugador jugador, Partido partido) {
		return this.jugador.equals(jugador) && this.partido.equals(partido) ;
	}
	
	
	
	
}

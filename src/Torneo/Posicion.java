package Torneo;

public class Posicion {

	private Equipo equipo;
	private int puntaje;
	
	public Posicion(Equipo equipo, int puntaje) {
		this.equipo=equipo;
		this.puntaje=puntaje;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	@Override
	public String toString() {
		return "Posicion [equipo=" + equipo.getNombre() + ", puntaje=" + puntaje + "]";
	}
	
	public boolean equals(Posicion posicion) {
		return this.equipo == posicion.getEquipo();
	}
}

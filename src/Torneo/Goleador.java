package Torneo;

public class Goleador {
	
	private Jugador jugador;
	private int cantGoles;
	
	public Goleador(Jugador jugador, int cantGoles) {
	
		this.jugador = jugador;
		this.cantGoles = cantGoles;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public int getCantGoles() {
		return cantGoles;
	}

	public void setCantGoles(int cantGoles) {
		this.cantGoles = cantGoles;
	}

	@Override
	public String toString() {
		return "Goleador [jugador=" + jugador + ", cantGoles=" + cantGoles + "]";
	}
	
	public boolean equals(Goleador goleador) {
		
		return (goleador.getJugador().equals(this.jugador));
		
	}
	
	

}

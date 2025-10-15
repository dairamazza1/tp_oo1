package Torneo;

public class Asistidor {
	
	private Jugador jugador;
	private int cantAsistencias;
	
	
	public Asistidor(Jugador jugador, int cantAsistencias) {
		this.jugador = jugador;
		this.cantAsistencias = cantAsistencias;
	}


	public Jugador getJugador() {
		return jugador;
	}


	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}


	public int getCantAsistencias() {
		return cantAsistencias;
	}


	public void setCantAsistencias(int cantAsistencias) {
		this.cantAsistencias = cantAsistencias;
	}


	@Override
	public String toString() {
		return "Asistidor [jugador=" + jugador + ", cantAsistencias=" + cantAsistencias + "]";
	}
	
	public boolean equasl(Asistidor asistidor) {
		
		return (asistidor.getJugador().equals(this.jugador));
	}
	
	

}

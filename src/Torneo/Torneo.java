package Torneo;

public class Torneo {
	private int id;
	private String nombre;
	private String temporada;
	private int asistencias;
	private Jugador jugador;
	private Partido partido;
	
	public Torneo(String nombre, String temporada, int asistencias, Jugador jugador, Partido partido) {
		this.nombre = nombre;
		this.temporada = temporada;
		this.asistencias = asistencias;
		this.jugador = jugador;
		this.partido = partido;
	
	}
	
	public String getNombre() {
		return nombre;
	}
	public String getTemporada() {
		return temporada;
	}
	public int getAsistencias() {
		return asistencias;
	}
	public Jugador getJugador() {
		return jugador;
	}
	public Partido getPartido() {
		return partido;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}
	public void setAsistencias(int asistencias) {
		this.asistencias = asistencias;
	}
	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}
	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	@Override
	public String toString() {
		return "Toneo [nombre=" + nombre + ", temporada=" + temporada + ", asistencias=" + asistencias + "]";
	}
	
	public boolean equals(Torneo torneo) {
		return this.id == torneo.getId();
	}
	
	
	
}

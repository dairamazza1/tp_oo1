package Torneo;

import java.util.List;
import java.util.ArrayList;

public class Equipo {
	private String codUnico;
	private String nombre;
	private Entrenador entrenador;
	private List<String> listaJugadores = new ArrayList<>();
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getCodUnico() {
		return codUnico;
	}
	public String getNombre() {
		return nombre;
	}
	
	public List<String> getListaJugadores() {
		return listaJugadores;
	}
	public void setCodUnico(String codUnico) {
		this.codUnico = codUnico;
	}
	
	//public void setListaJugadores(List<String> listaJugadores) {
	//	this.listaJugadores = listaJugadores;
	//}



	public Entrenador getEntrenador() {
		return entrenador;
	}

	public void setEntrenador(Entrenador entrenador) {
		this.entrenador = entrenador;
	}

//	public void asignarEntrenador(Entrenador nombreEntrenador) {
//		this.entrenador = nombreEntrenador.getNombre();
//	}
//	
//	public void agregarJugador(Jugador jugador) {
//		listaJugadores.add(jugador.getNombre());
//	}
	
	@Override
	public String toString() {
		return "Equipo [codUnico=" + codUnico + ", nombre=" + nombre + ", entrenador=" + entrenador
				+ ", listaJugadores=" + listaJugadores + "]";
	}

	public boolean equals(Equipo equipo) {
			return this.codUnico == equipo.getCodUnico();		
	}
}

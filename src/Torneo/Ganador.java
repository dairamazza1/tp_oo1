package Torneo;

import java.time.LocalDate;

public class Ganador {
	private LocalDate fecha;
	private Equipo equipoGanador;
	private int cantidadDeGoles;
	
	public Ganador(LocalDate fecha, Equipo equipoGanador, int cantidadDeGoles) {
		this.fecha = fecha;
		this.equipoGanador = equipoGanador;
		this.cantidadDeGoles = cantidadDeGoles;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public Equipo getEquipoGanador() {
		return equipoGanador;
	}
	public void setEquipoGanador(Equipo equipoGanador) {
		this.equipoGanador = equipoGanador;
	}
	public int getCantidadDeGoles() {
		return cantidadDeGoles;
	}
	public void setCantidadDeGoles(int cantidadDeGoles) {
		this.cantidadDeGoles = cantidadDeGoles;
	}
	@Override
	public String toString() {
		return "\nGanador [fecha=" + fecha + ", equipoGanador=" + equipoGanador + ", cantidadDeGoles=" + cantidadDeGoles
				+ "]";
	}
	
	public boolean equals(Ganador ganador) {
		return this.equipoGanador == ganador.getEquipoGanador();
	}
}

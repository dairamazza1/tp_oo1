package Torneo;

import java.time.*;

public class Partido {
	
	private LocalDate fecha;
	private Equipo local;
	private Equipo visitante;
	private Estadio estadio;
	
	//Constructor
	
	public Partido(LocalDate fecha, Equipo local,Equipo visitante,Estadio estadio) {
		
		this.fecha=fecha;
		this.local=local;
		this.visitante=visitante;
		this.estadio=estadio;
		
		
	}
		 
	
	//getters y Setters

	public LocalDate getFecha() {
	return fecha;
	}
	public Equipo getLocal() {
	return local;
	}
	public Equipo getVisitante() {
	return visitante;
	}

	public Estadio getEstadio() {
	return estadio;
	}

	
	@Override
	public String toString() {
		
		return "PARTIDO: Fecha: "+ fecha + 
				"\nLocal: "+ local + "|  Visitante: "+ visitante +
				"\nEstadio: "+ estadio;
		
	}
	
	public boolean equals(Partido partido) {
		return partido.equals(this);
	}
	
}



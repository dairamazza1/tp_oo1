package Torneo;

import java.time.*;

public class Partido {
	
	private LocalDate fecha;
	private Equipo local;
	private Equipo visitante;
	private int golesLocal;
	private int golesVisitante;
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
	public int getGolesLocal() {
		return golesLocal;
	}


	public int getGolesVisitante() {
		return golesVisitante;
	}


	public void setGolesLocal(int golesLocal) {
		this.golesLocal = golesLocal;
	}


	public void setGolesVisitante(int golesVisitante) {
		this.golesVisitante = golesVisitante;
	}


	


	@Override
	public String toString() {
		return "\nPartido [fecha=" + fecha + ", local=" + local + ", visitante=" + visitante + ", golesLocal="
				+ golesLocal + ", golesVisitante=" + golesVisitante + ", estadio=" + estadio + "]";
	}


	public boolean equals(Partido partido) {
		
		return (partido.getFecha().isEqual(this.fecha) && partido.getEstadio().equals(this.estadio));
		
	}
	
	public Equipo getGanador() {
		Equipo ganador = null;
		
		if(golesLocal > golesVisitante) {
			ganador = local;
		}else {
			ganador = visitante;
		}
		return ganador;
	}
	
	public int getGolesDelGanador() {
		int goles = 0;
		
		if(golesLocal > golesVisitante) {
			goles = golesLocal;
		}else {
			goles = golesVisitante;
		}
		return goles;
	}
	
}



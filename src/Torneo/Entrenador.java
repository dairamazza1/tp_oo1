package Torneo;

import java.time.*;

public class Entrenador {
	private int dni;
	private String nombre;
	private String apellido;
	private String estrategiafavorita;
	private LocalDate Fecha;
	
	public Entrenador(int dni, String nombre, String apellido, String estrategiafavorita, LocalDate fecha) {
		
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.estrategiafavorita = estrategiafavorita;
		Fecha = fecha;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEstrategiafavorita() {
		return estrategiafavorita;
	}

	public void setEstrategiafavorita(String estrategiafavorita) {
		this.estrategiafavorita = estrategiafavorita;
	}

	public LocalDate getFecha() {
		return Fecha;
	}

	public void setFecha(LocalDate fecha) {
		Fecha = fecha;
	}

	public String toString() {
		return "Entrenador [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", estrategiafavorita="
				+ estrategiafavorita + ", Fecha=" + Fecha + "]";
	}
	
	public boolean equals(Entrenador entrenador) {
		return ((this.dni == entrenador.getDni()));
	}
	
}

package Torneo;

import java.time.*;

public class Entrenador {
	private int dni;
	private String nombre;
	private String apellido;
	private String estrategiafavorita;
	private LocalDate fechadeDeNacimiento;
	
	public Entrenador(int dni, String nombre, String apellido, String estrategiafavorita, LocalDate fechadeDeNacimiento) {
		
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.estrategiafavorita = estrategiafavorita;
		this.fechadeDeNacimiento = fechadeDeNacimiento;
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

	public LocalDate getfechadeDeNacimiento() {
		return fechadeDeNacimiento;
	}

	public void setfechadeDeNacimiento(LocalDate fechadeDeNacimiento) {
		this.fechadeDeNacimiento = fechadeDeNacimiento;
	}

	public String toString() {
		return "\nEntrenador: " + nombre + "\n apellido: " + apellido + "\n Dni: " + dni + "\n estrategia favorita: "+ estrategiafavorita +" \nfecha de nacimiento: "+ fechadeDeNacimiento + "";

	}
	
	public boolean equals(Entrenador entrenador) {
		return ((this.dni == entrenador.getDni()));
	}
	
}

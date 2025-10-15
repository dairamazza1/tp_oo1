package Torneo;

import java.time.LocalDate;

public class Persona {
	protected int dni;
	protected String apellido;
	protected String nombre;
	protected LocalDate fechaDeNacimiento;
	
	public Persona(int dni, String apellido, String nombre, LocalDate fechaDeNacimiento) {
		this.dni = dni;
		this.apellido = apellido;
		this.nombre = nombre;
		this.fechaDeNacimiento = fechaDeNacimiento;
	}
	
	public int getDni() {
		return dni;
	}
	public String getApellido() {
		return apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}
	@Override
	public String toString() {
		return "\nPersona [dni=" + dni + ", apellido=" + apellido + ", nombre=" + nombre + ", fechaDeNacimiento="
				+ fechaDeNacimiento + "]";
	}
	
	public boolean equals(Persona p) {
		return p.dni == this.dni;
	}
	
}

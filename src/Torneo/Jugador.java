package Torneo;
import java.time.*;

public class Jugador {
	private int dni;
	private float estatura;
	private String posicion;
	private int numeroCamiseta;
	private String apellido;
	private String nombre;
	private LocalDate fechaDeNacimiento;
	 
	public Jugador(int dni, Float estatura, String posicion, int numeroCamiseta, String apellido, String nombre, LocalDate fechaDeNacimiento) {
		this.dni=dni;
		this.estatura=estatura;
		this.posicion=posicion;
		this.numeroCamiseta=numeroCamiseta;
		this.apellido=apellido;
		this.nombre=nombre;
		this.fechaDeNacimiento=fechaDeNacimiento;
	}
	
	
	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public float getEstatura() {
		return estatura;
	}

	public void setEstatura(float estatura) {
		this.estatura = estatura;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public int getNumeroCamiseta() {
		return numeroCamiseta;
	}

	public void setNumeroCamiseta(int numeroCamiseta) {
		this.numeroCamiseta = numeroCamiseta;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}
	
	public boolean equals(Jugador jugador) {
		return((this.dni==jugador.getDni()));
	}
	
	@Override
	public String toString(){
		return("Nombre: "+nombre+" apellido: "+apellido+
				"dni: "+dni+" estatura: "+estatura+
				" posicion: "+posicion+" numero de camiseta "+numeroCamiseta+
				" fecha de nacimiento: "+ fechaDeNacimiento);
	}

	
}

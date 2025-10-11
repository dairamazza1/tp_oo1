package Torneo;
import java.time.*;

public class Jugador extends Persona {
	private float estatura;
	private int posicion;
	private int numeroCamiseta;
	
	
	public Jugador(int dni, float estatura,  int posicion, int numeroCamiseta,String nombre, String apellido, LocalDate fechaDeNacimiento) {
		
		super(dni, apellido, nombre, fechaDeNacimiento);
		
		this.estatura = estatura;
		this.posicion = posicion;
		this.numeroCamiseta = numeroCamiseta;
	}

	public float getEstatura() {
		return estatura;
	}

	public void setEstatura(float estatura) {
		this.estatura = estatura;
	}

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	public int getNumeroCamiseta() {
		return numeroCamiseta;
	}

	public void setNumeroCamiseta(int numeroCamiseta) {
		this.numeroCamiseta = numeroCamiseta;
	}

	
//	public boolean equals(Jugador jugador) {
//		return((this.getDni() == jugador.getDni()));
//	}

	@Override
	public String toString() {
		return "Jugador [estatura=" + estatura + ", posicion=" + posicion + ", numeroCamiseta=" + numeroCamiseta
				+ ", toString()=" + super.toString() + "]";
	}


	
	
	

	
}

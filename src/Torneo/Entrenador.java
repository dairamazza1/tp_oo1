package Torneo;

import java.time.*;

public class Entrenador extends Persona{
	
	private String estrategiafavorita;
	
	public Entrenador(int dni, String nombre, String apellido, String estrategiafavorita, LocalDate fechadeDeNacimiento) {
		super(dni, apellido, nombre, fechadeDeNacimiento);
	
		this.estrategiafavorita = estrategiafavorita;
	}

	
	public String getEstrategiafavorita() {
		return estrategiafavorita;
	}

	public void setEstrategiafavorita(String estrategiafavorita) {
		this.estrategiafavorita = estrategiafavorita;
	}

		

	@Override
	public String toString() {
		return "Entrenador [estrategiafavorita=" + estrategiafavorita + ", toString()=" + super.toString() + "]";
	}

//  Sorbrecarga => q compare el equals del padre
//	public boolean equals(Entrenador entrenador) {
//		return ((this.getDni() == entrenador.getDni()));
//	}
	
}

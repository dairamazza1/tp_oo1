package Torneo;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

public class Equipo {
	private int codUnico;
	private String nombre;
	private Entrenador entrenador;
	private List<Jugador> listaJugadores; //***** se crea una lista de jugadores
	private LocalDate fechaDeFundacion; 
	
	
	
	public Equipo(String nombre, Entrenador entrenador, LocalDate fechaDeFundacion) {  // [DM] Faltaba crear el constructor
		this.nombre = nombre;
		this.entrenador = entrenador;
		//this.listaJugadores = listaJugadores;
		this.listaJugadores = new ArrayList<Jugador>();  //***** se unicializa un array de lista de elementos de tipo jugador
		this.fechaDeFundacion=fechaDeFundacion;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int  getCodUnico() {
		return codUnico;
	}
	public String getNombre() {
		return nombre;
	}
	
	public List<Jugador> getListaJugadores() { //[DM] Antes => List<String> , lo ajusté x List<Jugador>  
		return listaJugadores;
	}
	
	public void setCodUnico(int codUnico) {
		this.codUnico = codUnico;
	}
	
	//public void setListaJugadores(List<Jugador> listaJugadores) {  //no se usa el método set en las listas (x ahora)
	//	this.listaJugadores = listaJugadores;
	//}

	public Entrenador getEntrenador() {
		return entrenador;
	}

	public void setEntrenador(Entrenador entrenador) {
		this.entrenador = entrenador;
	}


	@Override
	public String toString() {
		return "Equipo: \ncodUnico=" + codUnico + ", \nnombre=" + nombre + ", \n" + entrenador
				+ ", \nlistaJugadores=" + listaJugadores + "]";
	}

	public boolean equals(Equipo equipo) {
			return this.codUnico == equipo.getCodUnico();		
	}
	
	
	//	public void asignarEntrenador(Entrenador nombreEntrenador) {
	//	this.entrenador = nombreEntrenador.getNombre();
	//}
	//
	//public void agregarJugador(Jugador jugador) {
	//	listaJugadores.add(jugador.getNombre());
	//}
	
	//métodos CU
	public void asignarEntrenador(Entrenador entrenador){
		setEntrenador(entrenador);
	}
	
	public boolean agregarJugador(Jugador j) {
		
		boolean found = (traerJugador(j.getDni()) != null);
		
		if(!found) {
			
			return listaJugadores.add(j);
		}
		//agregar excepción
		return false;	
	}
	
	public Jugador traerJugador(int dni) {
		int i = 0;
		boolean found = false;
		Jugador j = null;
		while(i < listaJugadores.size()  && !found) {
			if(listaJugadores.get(i).getDni() == dni) {
				found = true;
				j = listaJugadores.get(i);
			}
			i++;
		}
		
		return j;
	}
	
	public void modificarJugador(int dni, String nombre, String apellido){
		if(traerJugador(dni) != null) {
			Jugador j = traerJugador(dni);
			j.setNombre(nombre);
			j.setApellido(apellido);
		}
	}
	public boolean eliminarJugador(int dni) {
		Jugador j = traerJugador(dni);
		
		if(j == null) {
			return false;
		}
		
		return listaJugadores.remove(j);
	}

	public LocalDate getFechaDeFundacion() {
		return fechaDeFundacion;
	}

	public void setFechaDeFundacion(LocalDate fechaDeFundacion) {
		this.fechaDeFundacion = fechaDeFundacion;
	}
	
	
	
}

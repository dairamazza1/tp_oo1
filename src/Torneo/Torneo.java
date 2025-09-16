package Torneo;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Torneo {
	private int id;
	private String nombre;
	private String temporada;
	private List<Equipo> listaEquipos;
	private LocalDate fechInicio;
	private LocalDate fechaFinal;
	
	
	
	public Torneo(int id, String nombre, String temporada, LocalDate fechInicio, LocalDate fechaFinal) {
		this.id = id;
		this.nombre = nombre;
		this.temporada = temporada;
		this.fechInicio = fechInicio;
		this.fechaFinal = fechaFinal;
		
		this.listaEquipos = new ArrayList<Equipo>();
	}



	public int getId() {
		return id;
	}



	public String getNombre() {
		return nombre;
	}



	public String getTemporada() {
		return temporada;
	}



	public List<Equipo> getEquipo() {
		return listaEquipos;
	}



	public LocalDate getFechInicio() {
		return fechInicio;
	}



	public LocalDate getFechaFinal() {
		return fechaFinal;
	}



	public void setId(int id) {
		this.id = id;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}





	public void setFechInicio(LocalDate fechInicio) {
		this.fechInicio = fechInicio;
	}



	public void setFechaFinal(LocalDate fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	

	@Override
	public String toString() {
		return "Torneo: "+nombre +" \nid=" + id + 
				", \ntemporada=" + temporada + ", \nfechInicio=" + fechInicio + ", \nfechaFinal=" + fechaFinal + ", \n" + listaEquipos ;
	}



	public boolean equals(Torneo torneo) {
		return this.id == torneo.getId();
	}
	
	
	//Métodos CU
	public Equipo traerEquipo(int codUnico) {
		int i = 0;
		boolean found = false;
		Equipo e = null;
		
		while(i < listaEquipos.size() && !found) {
			if(listaEquipos.get(i).getCodUnico() == codUnico) {
				found = true;
				e = listaEquipos.get(i);
			}
			i ++;
		}
		
		return e;
	}
	
	public boolean agregarEquipo(Equipo e) {
		//pre cond: validar que el nombre no exista en la lista	
		//post cond: agregar el equipo con un cod único
		
		int i = 0;
		boolean found = false;
		
		while(i < listaEquipos.size() && !found) {
			if(!found && listaEquipos.get(i).getNombre().equalsIgnoreCase(e.getNombre())) {
				found = true;
			}
			i++;
		}
		
		if(!found) {
			int codUnico = 0;
			if(listaEquipos.size() > 0) {
				//agrego codUnico+1 en el útimo elemento de la lista
				codUnico = listaEquipos.get(listaEquipos.size() - 1).getCodUnico() + 1;				
			}
			e.setCodUnico(codUnico);
			
			return listaEquipos.add(e);
		}
		//agregar excepcion
		return false;
	}
	
	public void modificarEquipo(int codUnico, String nombre) {
		Equipo equipoFound = traerEquipo(codUnico);
		
		if(equipoFound != null) {
			equipoFound.setNombre(nombre);
		}
	}
	
	public boolean eliminarEquipo(int codUnico) {
		Equipo equipoFound = traerEquipo(codUnico);
		
		if(equipoFound != null) {
			listaEquipos.remove(equipoFound);
		}
		//agegar excepción
		return false;
	} 
	
	
	public List<Jugador> obternerJugadorEntreFechasDeNac( LocalDate fechaDesde, LocalDate fechaHasta){
		List<Jugador> listaJugadores = new ArrayList<>();
		for(Equipo equipo : this.listaEquipos) {
			for(Jugador jugador : equipo.getListaJugadores()) {
				LocalDate fechaNacimiento = jugador.getFechaDeNacimiento();
				if ((fechaNacimiento.isEqual(fechaDesde) || fechaNacimiento.isAfter(fechaDesde)) &&
					    (fechaNacimiento.isEqual(fechaHasta) || fechaNacimiento.isBefore(fechaHasta))) {
					    listaJugadores.add(jugador);
					}
			}
		}
		return listaJugadores;
	}
	
	public List<Equipo> obtenerEquiposPorFechaDeFundacion(LocalDate fechaEspecifica){
		List<Equipo> listaEquipo = new ArrayList<>();
		for (Equipo equipo : this.listaEquipos) {
			LocalDate fechaFundacion = equipo.getFechaDeFundacion();
			if(fechaFundacion.isBefore(fechaEspecifica)) {
				listaEquipo.add(equipo);
			}
		}
		return listaEquipo;
	}
	
	public float alturaPromediaDeEquipo(Equipo equipo) {
		float promedio=0;
		int contador=0;
			for(Jugador jugador : equipo.getListaJugadores()) {
				promedio+=jugador.getEstatura();
				contador++;
			}
		return promedio/contador;
	}
	
	public Equipo equipoMayorPromedioDeAltura(List<Equipo> equipos) {
		Equipo mayorEquipo = null;
		float mayorPromedio=0;
		for(Equipo equipo : equipos) {
			float promedio=alturaPromediaDeEquipo(equipo);
			if(promedio>mayorPromedio){
				mayorPromedio=promedio;
				mayorEquipo=equipo;
			}
			
		}
		return mayorEquipo;
	}
	
}

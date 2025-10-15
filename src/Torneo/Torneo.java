package Torneo;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class Torneo {
	private int id;
	private String nombre;
	private String temporada;
	private List<Partido> lstPartidos; //partidos que se jugaron en el torneo
	private List<Estadistica> lstEstadisticas;
	private LocalDate fechInicio;
	private LocalDate fechaFinal;
	
	
	
	public Torneo(int id, String nombre, String temporada, LocalDate fechInicio, LocalDate fechaFinal) {
		this.id = id;
		this.nombre = nombre;
		this.temporada = temporada;
		this.fechInicio = fechInicio;
		this.fechaFinal = fechaFinal;
		
		this.lstPartidos = new ArrayList<Partido>();
		this.lstEstadisticas = new ArrayList<Estadistica>();
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


	
	public List<Partido> getlstPartido() {
		return lstPartidos;
	}
	
	public List<Estadistica> getlstEstadisticas() {
		return lstEstadisticas;
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
		return "\nTorneo [id=" + id + ", nombre=" + nombre + ", temporada=" + temporada + ", lstPartidos="
				+ lstPartidos + ", fechInicio=" + fechInicio + ", fechaFinal=" + fechaFinal + "]";
	}



	public boolean equals(Torneo torneo) {
		return this.id == torneo.getId();
	}
	
	
	//Métodos CU

	public boolean agregarPartido(LocalDate fecha, Equipo local,Equipo visitante,Estadio estadio) throws Exception {
		int i = 0;
		boolean found = false;
		
		while(i<lstPartidos.size() && !found) {
			if(lstPartidos.get(i).getFecha().isEqual(fecha) && lstPartidos.get(i).getEstadio().equals(estadio)) {
				found = true;
			}
			i++;
		}
		if(!found) {
			return lstPartidos.add(new Partido(fecha, local, visitante, estadio));
		}else {
			throw new Exception("El partido ya existe");
		}
	}
	
	
	public boolean agregarEstadistica(int cantidadGoles, int asistencias, int minJugadores, Jugador jugador, Partido partido) throws Exception {
		int i = 0;
		boolean found = false;
		
		while(i<lstEstadisticas.size() && !found) {
			
			 if(lstEstadisticas.get(i).getPartido().equals(partido) 
					 && lstEstadisticas.get(i).getJugador().equals(jugador)) {
				 
				 found = true;
				 
			 }
			 i++;
		}
			 
			 
			 if(!found) {
				 
				 return lstEstadisticas.add(new Estadistica(cantidadGoles, asistencias, minJugadores, jugador, partido));
				 
			 }else {throw new Exception("ya existe la estadistica del jugador para este partido");  }
			
			
			
	}
	
	public Partido traerPartido(LocalDate fecha, Estadio estadio) {
		int i = 0;
		boolean found = false;
		Partido p = null;
		
		while(i < lstPartidos.size() && !found) {
			if(lstPartidos.get(i).getEstadio().equals(estadio) && lstPartidos.get(i).getFecha().isEqual(fecha)) {
				found = true;
				p = lstPartidos.get(i);
			}
			i ++;
		}
		
		return p;
	}
	
	
	public boolean eliminarPartido(LocalDate fecha, Estadio estadio)  throws Exception {
		Partido pFound = traerPartido(fecha, estadio);
		
		if(pFound != null) {
			return lstPartidos.remove(pFound);
		}else {
			throw new Exception("No se pudo eliminar el partido");
		}
	}
	
	
	//9 Identificación de equipo con mayor altura promedio: Crear un método que devuelva
	//el objeto Equipo con la mayor altura promedio en el torneo
	
	//pd:  no me queda otra q recorrer los partidos para obtener los equipos xq torneo no tiene equipos ¯\_(ツ)_/¯
		public Equipo equipoConMasEstatura() {
						
			List<Equipo> lstEquiposDeltorneo = new ArrayList<Equipo>();
			
			for (Partido partido : lstPartidos) {
				if(lstEquiposDeltorneo.contains(partido.getLocal()) == false) { //agregar si no existe en la lst
					lstEquiposDeltorneo.add(partido.getLocal());		
				}
				if(lstEquiposDeltorneo.contains(partido.getVisitante()) == false) { //agregar si no existe en la lst
					lstEquiposDeltorneo.add(partido.getVisitante());	
				}
			}
			
			 Equipo equipoConMasAltura = null;
			    float maxPromedio = (float) 0.0;

			    for (Equipo equipo : lstEquiposDeltorneo) {
			        float promedio = equipo.estaturaPromedioEquipo();
			        if (equipoConMasAltura == null || promedio > maxPromedio) {
			            maxPromedio = promedio;
			            equipoConMasAltura = equipo;
			        }
			    }
			
			return equipoConMasAltura;
		}
		
		/*
		 10. Cálculo de puntos de equipo: Implementar un método que calcule y 
		 	 retorne el total de 
			 puntos acumulados por un equipo, considerando 3 puntos por victoria
			 y 1 por empate.   
		 */
			
		public int totalDePuntosDeUnEquipo(Equipo equipo) {
			int cantidadDePuntos=0;
			for(Partido p : lstPartidos) {
				if(equipo.equals(p.getLocal())) {
					if(p.getGolesLocal()>p.getGolesVisitante()) {
						cantidadDePuntos+=3;
					}else if(p.getGolesLocal()==p.getGolesVisitante()) {
						cantidadDePuntos+=1;
					}
				}else if(equipo.equals(p.getVisitante())) {
					if(p.getGolesVisitante()>p.getGolesLocal()) {
						cantidadDePuntos+=3;
					}else if(p.getGolesLocal()==p.getGolesVisitante()) {
						cantidadDePuntos+=1;
					}
				}
			}
			return cantidadDePuntos;
		}
		
		/*
		12. Cálculo de goles por jugador: Escribir un método que, dado un objeto Jugador,
		devuelva el total de goles que ha logrado en el torneo
		
		*/
		public int calcularTotalGoles(Jugador jugador) {
			
			 if (jugador == null) {
				        return 0;
				    }
				
				int golesTotales = 0;
				
				for(Estadistica e : this.getlstEstadisticas()) {
					
					if(e.getJugador().equals(jugador)) {
						
						golesTotales += e.getCantidadGoles() ;
						
					}	
					
				}
				
				
				return golesTotales;
			}
		
		/*
		 13. Cálculo de asistencias por jugador: Escribir un método que, dado un objeto Jugador,
             devuelva el total de asistencias que ha logrado en el torneo.

		 */
		public int calcularTotalAsistencias(Jugador jugador) {
			
		 if (jugador == null) {
			        return 0;
			    }
			
			int asistenciasTotales = 0;
			
			for(Estadistica e : this.getlstEstadisticas()) {
				
				if(e.getJugador().equals(jugador)) {
					
					asistenciasTotales += e.getAsistencias() ;
					
				}	
				
			}
			
			
			return asistenciasTotales;
		}
		
		
		/*
		  14. Generación de tabla de goleadores: Crear un método que retorne una lista de
            (Goleador, no se persiste es solo para generar reporte) con el jugador y los goles,
            ordenada de mayor a menor (utilizando ordenamiento de listas nativo o desarrollando el
             algoritmo de algún método de ordenamiento).

		 */
		
        public List<Goleador> crearTablaGoleadores(){
			
			List<Goleador> tablaGoleadores = new ArrayList<Goleador>();
			List<Jugador> listaJugadores = new ArrayList<Jugador>();
			
			
			//for para guardar a todos los jugadores en una lista
			for(Partido p : this.lstPartidos ) {
				
				for(Jugador j : p.getLocal().getListaJugadores()) {
					
					if(!listaJugadores.contains(j)) {
						
						listaJugadores.add(j);
					}
				}
				
				for(Jugador j : p.getVisitante().getListaJugadores()) {
					
					if(!listaJugadores.contains(j)) {
						
						listaJugadores.add(j);
					}
					
				}
			}
			
			
			//agregando a los Goleadores a la lista
			for(Jugador j : listaJugadores) {
				
				tablaGoleadores.add(new Goleador(j, calcularTotalGoles(j)));
				
			}
			
			
			//ordenamiento
			
			tablaGoleadores.sort(Comparator.comparingInt(Goleador::getCantGoles).reversed());
			
			
			return tablaGoleadores;
			
		}
		
        
        /*
          15. Generación de tabla de asistidores: Implementar un método que retorne una lista de
          (Asistencia, no se persiste es solo para generar reporte) con el jugador y sus
           asistencias, ordenada de mayor a menor (utilizando ordenamiento de listas nativo o
            desarrollando el algoritmo de algún método de ordenamiento).
         */
	
		public List<Asistidor> crearTablaAsistidores(){
			
			List<Asistidor> tablaAsistidores = new ArrayList<Asistidor>();
			List<Jugador> listaJugadores = new ArrayList<Jugador>();
			
			
			//for para guardar a todos los jugadores en una lista
			for(Partido p : this.lstPartidos ) {
				
				for(Jugador j : p.getLocal().getListaJugadores()) {
					
					if(!listaJugadores.contains(j)) {
						
						listaJugadores.add(j);
					}
				}
				
				for(Jugador j : p.getVisitante().getListaJugadores()) {
					
					if(!listaJugadores.contains(j)) {
						
						listaJugadores.add(j);
					}
					
				}
			}
			
			
			//agregando a los asistidores a la lista
			for(Jugador j : listaJugadores) {
				
				tablaAsistidores.add(new Asistidor(j, calcularTotalAsistencias(j)));
				
			}
			
			
			//ordenamiento
			
			tablaAsistidores.sort(Comparator.comparingInt(Asistidor::getCantAsistencias).reversed());
			
			
			return tablaAsistidores;
			
		}
}

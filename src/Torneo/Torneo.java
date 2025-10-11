package Torneo;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Torneo {
	private int id;
	private String nombre;
	private String temporada;
	private List<Partido> lstPartidos; //partidos que se jugaron en el torneo
	private LocalDate fechInicio;
	private LocalDate fechaFinal;
	
	
	
	public Torneo(int id, String nombre, String temporada, LocalDate fechInicio, LocalDate fechaFinal) {
		this.id = id;
		this.nombre = nombre;
		this.temporada = temporada;
		this.fechInicio = fechInicio;
		this.fechaFinal = fechaFinal;
		
		this.lstPartidos = new ArrayList<Partido>();
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


	
}

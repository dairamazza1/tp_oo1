package Torneo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Sistema {
	private  List<Torneo> lstTorneos;
	private List<Equipo> lstEquipos;
	private List<Jugador> lstJugadores;
	private List<Entrenador> lstEntrenadores;
	public Sistema() {
		this.lstTorneos = new ArrayList<Torneo>();
		this.lstEquipos = new ArrayList<Equipo>();
		this.lstJugadores = new ArrayList<Jugador>();
		this.lstEntrenadores = new ArrayList<Entrenador>();
	}
	public List<Torneo> getLstTorneos() {
		return lstTorneos;
	}
	public List<Equipo> getLstEquipos() {
		return lstEquipos;
	}
	public List<Jugador> getLstJugadores() {
		return lstJugadores;
	}
	public List<Entrenador> getLstEntrenadores() {
		return lstEntrenadores;
	}
	@Override
	public String toString() {
		return "\nSistema [lstTorneos=" + lstTorneos + ", lstEquipos=" + lstEquipos + ", lstJugadores=" + lstJugadores
				+ ", lstEntrenadores=" + lstEntrenadores + "]";
	}
	
	
	public Equipo traerEquipo(String nombre) {
		int i = 0;
		boolean found = false;
		Equipo e = null;
		
		while(i < lstEquipos.size() && !found) {
			if(lstEquipos.get(i).getNombre().equalsIgnoreCase(nombre)) {
				found = true;
				e = lstEquipos.get(i);
			}
			i ++;
		}
		
		return e;
	}
	
	public boolean agregarEquipo(String nombre) throws Exception{
		//pre cond: validar que el nombre no exista en la lista	
		//post cond: agregar el equipo con un cod único
		
		int i = 0;
		boolean found = false;
		
		while(i < lstEquipos.size() && !found) {
			if(!found && lstEquipos.get(i).getNombre().equalsIgnoreCase(nombre)) {
				found = true;
			}
			i++;
		}
		
		if(!found) {
			int codUnico = 1;
			if(lstEquipos.size() > 0) {
				//agrego codUnico+1 en el útimo elemento de la lista
				codUnico = lstEquipos.get(lstEquipos.size() - 1).getCodUnico() + 1;				
			}			
			return lstEquipos.add(new Equipo(codUnico, nombre));
		}else {
				throw new Exception("el equipo ya existe");		
		}
	}
	
	
	public void modificarEquipo(int codUnico, String nombre) {
		Equipo equipoFound = traerEquipo(nombre);
		
		if(equipoFound != null) {
			equipoFound.setNombre(nombre);
		}
	}
	
	public boolean eliminarEquipo(String nombre) throws Exception {
		Equipo equipoFound = traerEquipo(nombre);
		
		if(equipoFound != null) {
			return lstEquipos.remove(equipoFound);
		}else {
			throw new Exception("No se pudo eliminar el equipo");
		}
	}
	
	
	
	public boolean agregarJugador(int dni, float estatura, int posicion, int numeroCamiseta, String nombre, String apellido, LocalDate fechaDeNacimiento) throws Exception {
		
		boolean found = (traerJugador(dni) != null);
		
		if(!found) {
			
			return lstJugadores.add(new Jugador(dni, estatura, posicion, numeroCamiseta, nombre, apellido, fechaDeNacimiento));
		}else {
			throw new Exception("El jugador ya existe");
		}
	}
	
	public Jugador traerJugador(int dni) {
		int i = 0;
		boolean found = false;
		Jugador j = null;
		while(i < lstJugadores.size()  && !found) {
			if(lstJugadores.get(i).getDni() == dni) {
				found = true;
				j = lstJugadores.get(i);
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
		
		return lstJugadores.remove(j);
	}
	
	
	
public boolean agregarEntrenador(int dni, String nombre, String apellido, String estrategiafavorita, LocalDate fechadeDeNacimiento) throws Exception {
		
		boolean found = (traerEntrenador(dni) != null);
		
		if(!found) {		
			return lstEntrenadores.add(new Entrenador(dni, nombre, apellido, estrategiafavorita, fechadeDeNacimiento));
		}else {
			throw new Exception("El entrenador ya existe");
		}
	}
	
	public Entrenador traerEntrenador(int dni) {
		int i = 0;
		boolean found = false;
		Entrenador j = null;
		while(i < lstEntrenadores.size()  && !found) {
			if(lstEntrenadores.get(i).getDni() == dni) {
				found = true;
				j = lstEntrenadores.get(i);
			}
			i++;
		}
		
		return j;
	}
	
	public void modificarEntrenador(int dni, String nombre, String apellido){
		if(traerEntrenador(dni) != null) {
			Entrenador j = traerEntrenador(dni);
			j.setNombre(nombre);
			j.setApellido(apellido);
		}
	}
	
	public boolean eliminarEntrenador(int dni) {
		Entrenador j = traerEntrenador(dni);
		
		if(j == null) {
			return false;
		}
		
		return lstEntrenadores.remove(j);
	}
	
	
	
public boolean agregarTorneo(String nombre, String temporada, LocalDate fechInicio, LocalDate fechaFinal) throws Exception {
		
		boolean found = (traerTorneo(nombre, temporada) != null);
		
		if(!found) {
			int codUnico = 1;
			if(lstTorneos.size() > 0) {
				//agrego codUnico+1 en el útimo elemento de la lista
				codUnico = lstTorneos.get(lstTorneos.size() - 1).getId() + 1;				
			}			
			return lstTorneos.add(new Torneo(codUnico, nombre, temporada, fechInicio, fechaFinal));
		}else {
				throw new Exception("el torneo ya existe");		
		}
		
		
	}
	
	public Torneo traerTorneo(String nombre, String temporada) {
		int i = 0;
		boolean found = false;
		Torneo j = null;
		while(i < lstTorneos.size()  && !found) {
			if(lstTorneos.get(i).getNombre().equalsIgnoreCase(nombre) && lstTorneos.get(i).getTemporada().equalsIgnoreCase(temporada) ) {
				found = true;
				j = lstTorneos.get(i);
			}
			i++;
		}
		
		return j;
	}
	
	
	public boolean eliminarTorneo(String nombre, String temporada) {
		Torneo j = traerTorneo(nombre, temporada);
		
		if(j == null) {
			return false;
		}
		
		return lstTorneos.remove(j);
	}
	
	
	// 4. Traer para un torneo y un número de fecha, la lista de los equipos ganadores
		//utilizando una clase (Ganador, no se persiste es solo para generar reporte) con
		//fecha, el equipo ganador, cantidad de goles
		
		public List<Ganador> traerListaEquiposGanadores(Torneo torneo, LocalDate fecha){
			List<Ganador> listaEquiposGanadores= new ArrayList<Ganador>();
			
			List<Partido> lstPartido = torneo.getlstPartido();
			for (Partido partido : lstPartido) {
				if(partido.getFecha().isEqual(fecha) && partido.getGanador() != null) {
					Equipo ganador = partido.getGanador();
		            int goles = partido.getGolesDelGanador();
					listaEquiposGanadores.add(new Ganador(fecha, ganador, goles));
				}
			}
			return listaEquiposGanadores;
		}
		
		
		//5. Búsqueda de entrenadores: Crear un método que, dada una táctica preferida,
		//devuelva una lista de todos los entrenadores que la utilicen.
		
		public List<Entrenador> traerEntrenadorConTactica(String estrategia){
			List<Entrenador> entrenadoresFiltrados = new ArrayList<Entrenador>();
			
			for (Entrenador entrenador : lstEntrenadores) {
				if(entrenador.getEstrategiafavorita().indexOf(estrategia) >= 0) {
					//agregar en la lista
					entrenadoresFiltrados.add(entrenador);
				}
			}			
			return entrenadoresFiltrados;
		}
		
		//6. Búsqueda de jugadores por fecha de nacimiento: Implementar una método que
		//retorne una lista de jugadores nacidos entre dos fechas dadas.
		public List<Jugador> traerJugadorPorFechaNacimiento(LocalDate fecha1, LocalDate fecha2){
			List<Jugador> listaJugadoresFiltrados = new ArrayList<Jugador>();
			for (Jugador jugador : lstJugadores) {
				if( !jugador.getFechaDeNacimiento().isBefore(fecha1)  && !jugador.getFechaDeNacimiento().isAfter(fecha2)  ) {
					listaJugadoresFiltrados.add(jugador);
				}
			}
			
			return listaJugadoresFiltrados;
		}
		
		//7. Búsqueda de equipos por fecha de fundación: Desarrollar un método que devuelva
		//una lista de equipos fundados antes de una fecha específica.
		
		//agrego fecha de fundación en la clase equipo?
		
		
		/*11. Generación de tabla de posiciones: Desarrollar un método que retorne una lista de 
			  (Posicion,  no se persiste es solo para generar reporte) que contenga equipo y puntaje, 
			  ordenada de mayor a menor puntaje (utilizando ordenamiento de listas nativo o 
		 	  desarrollando el algoritmo de algún método de ordenamiento).
		 */
	
		public List<Posicion> crearTablaDePosicion(Torneo torneo){
			List<Posicion> tablaDePosiciones = new ArrayList<Posicion>();
			for(Equipo e : lstEquipos) {
				int puntos = torneo.totalDePuntosDeUnEquipo(e);
				tablaDePosiciones.add(new Posicion(e,puntos));
			}
			tablaDePosiciones.sort((p1,p2)->Integer.compare(p2.getPuntaje(), p1.getPuntaje()));
			return tablaDePosiciones;
		}
}

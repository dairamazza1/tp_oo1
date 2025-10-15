package Pruebas;

import java.time.LocalDate;
import java.util.List;

import Torneo.Asistidor;
import Torneo.Equipo;
import Torneo.Estadio;
import Torneo.Goleador;
import Torneo.Jugador;
import Torneo.Sistema;
import Torneo.Torneo;

public class TestTorneo {

	public static void main(String[] args) {
		
		//agrego sistema
		Sistema sistema = new Sistema();
		
		//agrego estadios
		Estadio elgalatasay = new Estadio("Galatasaray", 1200, "wandaaaaaaMeMueroooo");
		Estadio boca = new Estadio("Boca", 999, "La boca");
		Estadio river = new Estadio("River", 111, "Nuñez");
		
		System.out.println("\n\t******** Agregar torneo ********");
		try {
			sistema.agregarTorneo("Torneo en la playita", "verano", LocalDate.of(2025,1,1), LocalDate.of(2025,1,30));
		
			System.out.println(sistema.getLstTorneos());
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		System.out.println("\n\t******** Agregar jugadores ********");
		try {
			sistema.agregarJugador(123, (float)1.90, 10, 1, "Daira", "Mazza", LocalDate.of(1997, 01, 01));
			sistema.agregarJugador(345, (float)1.41, 10, 1, "Pepe", "Ochoa", LocalDate.of(1994, 01, 01));
			sistema.agregarJugador(678, (float)1.52, 10, 1, "Martin", "Cirio", LocalDate.of(2000, 01, 01));
			sistema.agregarJugador(901, (float)1.90, 10, 1, "Diego", "Ibañez", LocalDate.of(1995, 01, 01));
			sistema.agregarJugador(234, (float)1.50, 10, 1, "Juan", "Perez", LocalDate.of(1993, 01, 01));
			sistema.agregarJugador(567, (float)1.64, 10, 1, "Homero", "Simpsons", LocalDate.of(1990, 01, 01));
			
			System.out.println(sistema.getLstJugadores());
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		System.out.println("\n\t******** Agregar entrenadores ********");
		try {
			sistema.agregarEntrenador(1111, "Emilia", "Perez", "Patea pelota",  LocalDate.of(1993, 01, 01));
			sistema.agregarEntrenador(2222, "Tizziano", "Perez", "Agarra pelota",  LocalDate.of(1990, 01, 01));
			
			System.out.println(sistema.getLstEntrenadores());
		} catch (Exception e) {
			System.out.println(e);
		}
		
		System.out.println("\n\t******** Agregar equipos y asignarles entrenador y jugadores ********");
		Equipo equipoRojo = null;
		Equipo equipoVerde = null;
		try {
			sistema.agregarEquipo("Rojo");
			sistema.agregarEquipo("Verde");
			
			equipoRojo = sistema.traerEquipo("Rojo");
			equipoVerde = sistema.traerEquipo("Verde");
			
			equipoRojo.asignarEntrenador(sistema.traerEntrenador(1111));
			equipoVerde.asignarEntrenador(sistema.traerEntrenador(2222));
			
			equipoRojo.agregarJugador(sistema.traerJugador(123));
			equipoRojo.agregarJugador(sistema.traerJugador(345));
			equipoRojo.agregarJugador(sistema.traerJugador(678));
			
			equipoVerde.agregarJugador(sistema.traerJugador(901));
			equipoVerde.agregarJugador(sistema.traerJugador(234));
			equipoVerde.agregarJugador(sistema.traerJugador(567));
			
			System.out.println(sistema.getLstEquipos());
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		System.out.println("\n\t******** Agregar partidos en torneo ********");
		Torneo torneoPlayita = null;
		try {
			torneoPlayita = sistema.traerTorneo("Torneo en la playita", "verano");
			
			torneoPlayita.agregarPartido(LocalDate.of(2025,1,1), equipoRojo, equipoVerde, elgalatasay);
			torneoPlayita.agregarPartido(LocalDate.of(2025,1,10), equipoVerde, equipoRojo, boca);
			torneoPlayita.agregarPartido(LocalDate.of(2025,1,20), equipoVerde, equipoRojo, river);
			
			System.out.println(sistema.getLstTorneos());
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		System.out.println("\n\t******** 4. Agregar ganadores de partidos en un torneo y traer lista equipos ganadores ********");
		torneoPlayita.traerPartido(LocalDate.of(2025,1,1), elgalatasay).setGolesLocal(2);
		torneoPlayita.traerPartido(LocalDate.of(2025,1,1), elgalatasay).setGolesVisitante(0);
		
		torneoPlayita.traerPartido(LocalDate.of(2025,1,10), boca).setGolesLocal(2);
		torneoPlayita.traerPartido(LocalDate.of(2025,1,10), boca).setGolesVisitante(4);
		
		torneoPlayita.traerPartido(LocalDate.of(2025,1,20), river).setGolesLocal(3);
		torneoPlayita.traerPartido(LocalDate.of(2025,1,20), river).setGolesVisitante(1);
		
		System.out.println(sistema.traerListaEquiposGanadores(torneoPlayita, LocalDate.of(2025,1,1)));
		System.out.println(sistema.traerListaEquiposGanadores(torneoPlayita, LocalDate.of(2025,1,10)));
		System.out.println(sistema.traerListaEquiposGanadores(torneoPlayita, LocalDate.of(2025,1,20)));
		
		System.out.println("\n\t******** 5. Búsqueda de entrenadores por táctica ********");
		System.out.println(sistema.traerEntrenadorConTactica("Patea pelota"));
		System.out.println(sistema.traerEntrenadorConTactica("Agarra pelota"));
		
		
		System.out.println("\n\t******** 6. Búsqueda de jugadores por fecha de nacimiento ********");
		System.out.println(sistema.traerJugadorPorFechaNacimiento(LocalDate.of(1990, 01, 01), LocalDate.of(1998, 01, 01)));
		
		
		System.out.println("\n\t******** [Validar] 7. Búsqueda de equipos por fecha de fundación ********");
		
		System.out.println("\n\t******** 8. Cálculo de altura promedio de equipo ********");	
		System.out.println("Estatura promedio equipo rojo: " +equipoRojo.estaturaPromedioEquipo());
		System.out.println("Estatura promedio equipo verde: " +equipoVerde.estaturaPromedioEquipo());
		
		System.out.println("\n\t******** 9. Identificación de equipo con mayor altura promedio ********");
		System.out.println(torneoPlayita.equipoConMasEstatura());
		
		
		
		
		
		System.out.println("\n\t******** 10. Agregar estadísticas a los partidos ********");
		try {
		    // Agregar estadísticas para el primer partido (Rojo 2 - Verde 0)
		    torneoPlayita.agregarEstadistica(0, 2, 90, sistema.traerJugador(123), torneoPlayita.traerPartido(LocalDate.of(2025,1,1), elgalatasay)); // Daira
		    torneoPlayita.agregarEstadistica(1, 1, 90, sistema.traerJugador(345), torneoPlayita.traerPartido(LocalDate.of(2025,1,1), elgalatasay)); // Pepe
		    torneoPlayita.agregarEstadistica(0, 0, 90, sistema.traerJugador(678), torneoPlayita.traerPartido(LocalDate.of(2025,1,1), elgalatasay)); // Martin
		    
		    // Agregar estadísticas para el segundo partido (Verde 4 - Rojo 2)
		    torneoPlayita.agregarEstadistica(2, 3, 90, sistema.traerJugador(901), torneoPlayita.traerPartido(LocalDate.of(2025,1,10), boca)); // Diego
		    torneoPlayita.agregarEstadistica(1, 1, 90, sistema.traerJugador(234), torneoPlayita.traerPartido(LocalDate.of(2025,1,10), boca)); // Juan
		    torneoPlayita.agregarEstadistica(0, 0, 90, sistema.traerJugador(567), torneoPlayita.traerPartido(LocalDate.of(2025,1,10), boca)); // Homero
		    
		    // Agregar estadísticas para el tercer partido (Verde 1 - Rojo 3)
		    torneoPlayita.agregarEstadistica(1, 2, 90, sistema.traerJugador(901), torneoPlayita.traerPartido(LocalDate.of(2025,1,20), river)); // Diego
		    torneoPlayita.agregarEstadistica(0, 1, 90, sistema.traerJugador(234), torneoPlayita.traerPartido(LocalDate.of(2025,1,20), river)); // Juan
		    torneoPlayita.agregarEstadistica(0, 0, 90, sistema.traerJugador(567), torneoPlayita.traerPartido(LocalDate.of(2025,1,20), river)); // Homero
		    
		    System.out.println("Estadísticas agregadas correctamente");
		} catch (Exception e) {
		    System.out.println("Error al agregar estadísticas: " + e.getMessage());
		}
		
		
		
		 System.out.println("\n\t******** 12. Probar calcularTotalGoles ********");
		try {
		    Jugador daira = sistema.traerJugador(123);
		    Jugador diego = sistema.traerJugador(901);
		    Jugador pepe = sistema.traerJugador(345);
		    
		    System.out.println("Total goles de Daira: " + torneoPlayita.calcularTotalGoles(daira));
		    System.out.println("Total goles de Diego: " + torneoPlayita.calcularTotalGoles(diego)); 
		    System.out.println("Total goles de Pepe: " + torneoPlayita.calcularTotalGoles(pepe)); 
		} catch (Exception e) {
		    System.out.println("Error en calcularTotalGoles: " + e.getMessage());
		}
	 
	
		

		System.out.println("\n\t******** 13. Probar calcularTotalAsistencias ********");
		try {
		    Jugador daira = sistema.traerJugador(123);
		    Jugador diego = sistema.traerJugador(901);
		    Jugador pepe = sistema.traerJugador(345);
		    
		    System.out.println("Total asistencias de Daira: " + torneoPlayita.calcularTotalAsistencias(daira));
		    System.out.println("Total asistencias de Diego: " + torneoPlayita.calcularTotalAsistencias(diego)); 
		    System.out.println("Total asistencias de Pepe: " + torneoPlayita.calcularTotalAsistencias(pepe)); 
		} catch (Exception e) {
		    System.out.println("Error en calcularTotalAsistencias: " + e.getMessage());
		}
		
		
		
		 System.out.println("\n\t******** 14. Probar crearTablaGoleadores ********");
		try {
		    System.out.println("=== TABLA DE GOLEADORES ===");
		    List<Goleador> tabla = torneoPlayita.crearTablaGoleadores();
		    
		    for (Goleador g : tabla) {
		        System.out.println(g.getJugador().getNombre() + " " + g.getJugador().getApellido() + 
		                           ": " + g.getCantGoles() + " goles");
		    }
		} catch (Exception e) {
		    System.out.println("Error en crearTablaGoleadores: " + e.getMessage());
		}
		
		 
		

		System.out.println("\n\t******** 15. Probar crearTablaAsistidores ********");
		try {
		    System.out.println("=== TABLA DE ASISTIDORES ===");
		    List<Asistidor> tabla = torneoPlayita.crearTablaAsistidores();
		    
		    for (Asistidor a : tabla) {
		        System.out.println(a.getJugador().getNombre() + " " + a.getJugador().getApellido() + 
		                           ": " + a.getCantAsistencias() + " asistencias");
		    }
		} catch (Exception e) {
		    System.out.println("Error en crearTablaAsistidores: " + e.getMessage());
		}
		
		
	}

}

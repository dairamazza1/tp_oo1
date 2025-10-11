package Pruebas;

import java.time.LocalDate;

import Torneo.Equipo;
import Torneo.Estadio;
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
		
	}

}

package Pruebas;

import java.time.LocalDate;
import java.util.List;

import Torneo.Entrenador;
import Torneo.Equipo;
import Torneo.Jugador;
import Torneo.Torneo;

public class TestTorneo {

	public static void main(String[] args) {
		
//		LocalDate fechaInicio = LocalDate.of(2025, 01, 01);
//		LocalDate fechaFin = LocalDate.of(2025, 02, 01);
		
		
		//consultar si crear una clase en test de "entrenador" para agregarlo en método agregarEquipo (como ahora)
		// o si debo pasar todos los parametros y el método agregarEquipo deba validar y agregar
		
		Entrenador entrenador1 = new Entrenador(12345678, "Emilia", "Perez", "Patea pelota",  LocalDate.of(1993, 01, 01));
		Entrenador entrenador2 = new Entrenador(87654321, "Tizziano", "Perez", "Agarra pelota",  LocalDate.of(1990, 01, 01));
		
		Jugador jugador1 = new Jugador(123, 170, 10, 1, "Daira", "Mazza", LocalDate.of(1993, 01, 01));
		Jugador jugador2 = new Jugador(124, 140, 10, 1, "Pepe", "Ochoa", LocalDate.of(1993, 01, 01));
		Jugador jugador3 = new Jugador(125, 170, 10, 1, "Martin", "Cirio", LocalDate.of(1993, 01, 01));
		Jugador jugador4 = new Jugador(126, 170, 10, 1, "Diego", "Ibañez", LocalDate.of(1993, 01, 01));

		Equipo rojo = new Equipo("Rojo", entrenador1,LocalDate.of(1901, 5, 25));
		Equipo azul = new Equipo("Azul", entrenador2,LocalDate.of(1905, 4, 3));
		
		rojo.agregarJugador(jugador1);
		rojo.agregarJugador(jugador2);
		
		azul.agregarJugador(jugador3);
		azul.agregarJugador(jugador4);
		
		Torneo torneo1 = new Torneo(001, "Torneo en la playita", "Verano", LocalDate.of(2025, 01, 01), LocalDate.of(2025, 02, 01));
				
		torneo1.agregarEquipo(rojo);
		torneo1.agregarEquipo(azul);
		
		System.out.println(torneo1);
		
		
		LocalDate fechaDesde = LocalDate.of(1990,1,1);
		LocalDate fechaHasta = LocalDate.of(1994,12,31);
		List<Jugador> filtro = torneo1.obternerJugadorEntreFechasDeNac(fechaDesde, fechaHasta);
		System.out.println("Jugadores nacidos entre " + fechaDesde + " y " + fechaHasta + ":");
		for(Jugador j : filtro) {
			System.out.println(j.getNombre());
		}
		
		
		System.out.println("\nLa altura promedio del equipo es: "+torneo1.alturaPromediaDeEquipo(rojo));
		System.out.println("El equipo con mayor promedio es: "+torneo1.equipoMayorPromedioDeAltura(torneo1.getEquipo()).getNombre());
		LocalDate fechaEspecifica = LocalDate.of(1903,1,1);
		List<Equipo> filtrados = torneo1.obtenerEquiposPorFechaDeFundacion(fechaEspecifica);
		System.out.println("Equipos fundados antes de " + fechaEspecifica +":");
		for(Equipo e : filtrados) {
			System.out.println(e.getNombre());
		}
	}

}

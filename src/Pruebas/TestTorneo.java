package Pruebas;

import java.time.LocalDate;

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
		Jugador jugador2 = new Jugador(123, 170, 10, 1, "Pepe", "Ochoa", LocalDate.of(1993, 01, 01));
		Jugador jugador3 = new Jugador(123, 170, 10, 1, "Martin", "Cirio", LocalDate.of(1993, 01, 01));
		Jugador jugador4 = new Jugador(123, 170, 10, 1, "Diego", "Ibañez", LocalDate.of(1993, 01, 01));

		Equipo rojo = new Equipo("Rojo", entrenador1);
		Equipo azul = new Equipo("Azul", entrenador2);
		
		rojo.agregarJugador(jugador1);
		rojo.agregarJugador(jugador2);
		
		azul.agregarJugador(jugador3);
		azul.agregarJugador(jugador4);
		
		Torneo torneo1 = new Torneo(001, "Torneo en la playita", "Verano", LocalDate.of(2025, 01, 01), LocalDate.of(2025, 02, 01));
				
		torneo1.agregarEquipo(rojo);
		torneo1.agregarEquipo(azul);
		
		System.out.println(torneo1);
	}

}

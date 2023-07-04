import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Persona persona = new Persona();
        Jugador jugador = new Jugador();
        Temporada temporada = new Temporada();
        Equipo equipo = new Equipo("");
        EquipoInscrito equipoInscrito = new EquipoInscrito(equipo, null);
        Competencia competencia = null;
        ModoJuego modalidad = null;
        Partido partido = new Partido();
        Inscripcion inscripcion = new Inscripcion();

        persona.agregarPersona();

        System.out.print("¿Desea inscribirse a la competencia? (si/no): ");
        String respuesta = scanner.nextLine();

        if (respuesta.equalsIgnoreCase("si")) {
            System.out.print("Ingrese el nombre de la competencia: ");
            String nombreCompetencia = scanner.nextLine();
            competencia = new Competencia(nombreCompetencia, temporada);

            equipo.agregarEquipo();
            System.out.print("Ingrese el nombre de la temporada: ");
            String nombreTemporada = scanner.nextLine();
            temporada.setNombre(nombreTemporada);

            equipoInscrito.escogerDeporte(equipoInscrito);

            boolean ingresarJugador = true;
            while (ingresarJugador) {
                jugador.agregarJugador();

                System.out.print("Desea ingresar otro jugador (si/no): ");
                respuesta = scanner.nextLine();
                if (!respuesta.equalsIgnoreCase("si")) {
                    ingresarJugador = false;
                }
            }

            modalidad = temporada.asignarModalidad(null);
            partido.crearPartido();
        }

        if (modalidad != null) {
            System.out.println("Modalidad seleccionada: " + modalidad);
            System.out.println("Nombre del jugador: " + persona.getNombre());
            System.out.println("Número de camiseta: " + jugador.getNumeroCamiseta());
            System.out.println("Nombre del equipo: " + equipo.getNombre());
            System.out.println("Nombre de la competencia: " + competencia.getNombre());
            System.out.println("Nombre de la temporada: " + temporada.getNombre());
            System.out.println("Deporte: " + equipoInscrito.getDeporte());
            System.out.println("Estado del Partido: " + partido.getEstado());
            System.out.println("Estado de inscripción: " + inscripcion.getEstadoInscripcion());

            inscripcion.setEstadoInscripcion(EstadoInscripcion.getRandomEstadoInscripcion());
            boolean jugadorInscrito = inscripcion.inscribirJugador(jugador);
        }

        scanner.close();
    }
}

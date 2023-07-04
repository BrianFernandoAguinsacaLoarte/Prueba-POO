import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Persona persona = new Persona();
        Jugador jugador = new Jugador();
        Temporada temporada = new Temporada();
        System.out.print("Ingrese el nombre de la persona: ");
        String nombre = scanner.nextLine();
        persona.setNombre(nombre);
        System.out.print("Ingrese el apellido de la persona: ");
        String apellido = scanner.nextLine();
        persona.setApellido(apellido);
        System.out.print("Ingrese la edad de la persona: ");
        int edad = scanner.nextInt();
        persona.setEdad(edad);
        scanner.nextLine(); // Consumir el salto de línea

        System.out.print("¿Desea inscribirse a la competencia? (si/no): ");
        String respuesta = scanner.nextLine();
        if (respuesta.equalsIgnoreCase("si")) {
            // Inscríbir al jugador
            boolean exito = temporada.inscribirJugador(jugador);
            Competencia competencia = new Competencia();
            Equipo equipo = new Equipo();
            EquipoInscrito equipoInscrito = new EquipoInscrito(equipo, null);
            System.out.print("Ingrese el nombre de la competencia: ");
            String nombreCompetencia = scanner.nextLine();
            competencia.setNombre(nombreCompetencia);
            System.out.print("Ingrese el nombre del equipo: ");
            String nombreEquipo = scanner.nextLine();
            equipo.setNombre(nombreEquipo);

            competencia.inscribirEquipo(equipo);
            competencia.setTipoModoJuego(ModoJuego.FASE_GRUPOS);
            competencia.setTemporada(temporada); // Asignar la temporada actual
            competencia.setInscripcion(new Inscripcion());
            competencia.setReglamento(new Reglamento());
            System.out.print("Ingrese el nombre de la temporada: ");
            String nombreTemporada = scanner.nextLine();
            temporada.setNombre(nombreTemporada);
            System.out.print("En qué deporte desea inscribirse? (Futbol, Baloncesto, Ecuavoly u otro): ");
            String deporteInscripcion = scanner.nextLine();
            if (deporteInscripcion.equalsIgnoreCase("otro")) {
                equipoInscrito.escogerDeporte();
                System.out.println("Deporte seleccionado: " + equipoInscrito.getDeporte().getNombres().iterator().next());
            } else {
                try {
                    Deporte deporte = Deporte.valueOf(deporteInscripcion.toUpperCase());
                    equipoInscrito.setDeporte(deporte);
                    System.out.println("Deporte seleccionado: " + deporte);
                } catch (IllegalArgumentException e) {
                    System.out.println("Deporte no válido. Se creará uno nuevo.");

                    // Verificar si ya existe el nombre del deporte
                    boolean existeNombreDeporte = Deporte.getNombres().contains(deporteInscripcion);
                    Deporte deporteNuevo;

                    if (existeNombreDeporte) {
                        System.out.println("El nombre del deporte ya existe.");
                        deporteNuevo = null; // Deporte no válido
                    } else {
                        Set<String> nombresDeporteNuevo = new HashSet<>();
                        nombresDeporteNuevo.add(deporteInscripcion);
                        Deporte.agregarNombre(deporteInscripcion);
                        deporteNuevo = Deporte.crearDeporteConNombres(nombresDeporteNuevo);
                        System.out.println("Deporte creado: " + deporteInscripcion);
                    }

                    equipoInscrito.setDeporte(deporteNuevo);
                }
            }
            if (scanner.hasNextInt()) {
                int numeroCamiseta = scanner.nextInt();
                jugador.setNumeroCamiseta(numeroCamiseta);
                scanner.nextLine(); // Consumir el salto de línea
                JugadorInscrito jugadorInscrito = new JugadorInscrito();
                jugadorInscrito.setInscripcion(new Inscripcion());
                System.out.print("Ingrese la posición del jugador: ");
                String posicion = scanner.nextLine();
                jugador.setPosicion(posicion);
            } else {
                System.out.println("Número de camiseta inválido. Se requiere un número entero.");
            }
            // Crear una instancia de Competencia

            ModoJuego modalidad = temporada.asignarModalidad(null);

            if (modalidad != null) {
                System.out.println("Modalidad seleccionada: " + modalidad);

                // Acceder a los datos de las clases
                System.out.println("Nombre del jugador: " + persona.getNombre());
                System.out.println("Número de camiseta: " + jugador.getNumeroCamiseta());
                System.out.println("Nombre del equipo: " + equipo.getNombre());
                System.out.println("Nombre de la competencia: " + competencia.getNombre());
                System.out.println("Nombre de la temporada: " + temporada.getNombre());
                System.out.println("Deporte: " + equipoInscrito.getDeporte());

                // Acceder al estado de inscripción de una inscripción específica
                Random random = new Random();
                Inscripcion inscripcion = new Inscripcion();
                EstadoInscripcion estado = EstadoInscripcion.values()[random.nextInt(EstadoInscripcion.values().length)];
                inscripcion.setEstadoInscripcion(estado);
                System.out.println("Estado de inscripción: " + inscripcion.getEstadoInscripcion());

                System.out.println("El jugador ha sido inscrito en la competencia.");
            } else if (respuesta.equalsIgnoreCase("no")) {
                System.out.println("El jugador no desea inscribirse en la competencia.");
            } else {
                System.out.println("Respuesta inválida. Por favor, ingrese 'si' o 'no'.");
            }
            scanner.close();

        }
    }
}


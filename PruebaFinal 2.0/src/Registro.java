import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.awt.Toolkit;

public class Registro {
    private List<Equipo> equiposInscritos = new ArrayList<>();
    private List<Grupo> grupos = new ArrayList<>();
    private List<Usuario> usuarios;
    private Grupo grupo;
    private Reglamento reglamento;
    private List<Jugador> jugadoresRegistrados = new ArrayList<>();
    private Grupo grupoJugadores;
    private Temporada temporada;
    private List<Jugador> jugadoresRegistradosEnTemporada = new ArrayList<>();

    public Registro() {
        usuarios = new ArrayList<>();
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public boolean iniciarSesion(String nombreUsuario, String contrasena) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario) && usuario.getContrasena().equals(contrasena)) {
                return true;
            }
        }
        return false;
    }

    public void realizarRegistro(Scanner scanner) {
        boolean seguirRegistrando = true;
        while (seguirRegistrando) {
            System.out.println("¡Advertencia! Escoger el rol de jugador es para equipos individuales.");
            System.out.println("¡Si usted escoge el rol de Director_Tecnico es para generar un equipo.");
            System.out.println("¡Si usted escoge el rol de Arbitro es para ver las reglas de los deportes sean grupales o individuales!");
            System.out.println("Escoja su rol (Jugador, Director_Tecnico, Arbitro):");
            String rol = scanner.nextLine();

            switch (EleccionDeRol.valueOf(rol.toUpperCase())) {
                case JUGADOR:
                    System.out.println("Desea visualizar la temporada ? (Si/No):");
                    String respuestaTemporada = scanner.nextLine();
                    if (respuestaTemporada.equalsIgnoreCase("Si")) {
                        if (temporada != null) {
                            temporada.verTemporada();
                            System.out.println("Desea ver la temporada? (Si/No)");
                            String respuestaVerTemporada = scanner.nextLine();
                            if (respuestaVerTemporada.equalsIgnoreCase("Si")) {
                                System.out.println("Jugadores en la temporada:");
                                for (Jugador jugador : jugadoresRegistrados) {
                                    jugador.mostrarInformacion();
                                }
                            }
                        } else {
                            System.out.println("No hay temporada actualmente.");
                        }
                    }
                    List<Jugador> jugadoresRegistrados = registrarJugadores(scanner);

                    break;
                case DIRECTOR_TECNICO:
                    System.out.println("Desea visualizar la temporada? (Si/No):");
                    String respuestaTemporada1 = scanner.nextLine();
                    if (respuestaTemporada1.equalsIgnoreCase("Si")) {
                        if (temporada != null) {
                            temporada.verTemporada();
                            temporada.mostrarEquiposEnTemporada(); // Mostrar la información de los equipos en la temporada
                        } else {
                            System.out.println("No hay temporada actualmente.");
                        }
                    }
                    realizarRegistroEquipos(scanner);
                    break;
                case ARBITRO:
                    System.out.println("Usted ha elegido el rol de Árbitro.");
                    System.out.println("Seleccione una opción:");
                    System.out.println("1. Ver todas las reglas");
                    System.out.println("2. Ver regla específica");
                    System.out.println("3. Agregar nueva regla");
                    System.out.println("4. Modificar regla existente");

                    int opcion = scanner.nextInt();
                    scanner.nextLine(); // Consumir la nueva línea pendiente después del nextInt()

                    Reglamento reglamento = new Reglamento("Reglamento de Deportes Grupales", new Fecha(2023, 8, 1));

                    switch (opcion) {
                        case 1:
                            reglamento.mostrarReglamento();
                            break;
                        case 2:
                            System.out.println("Ingrese el índice de la regla que desea ver:");
                            int indiceRegla = scanner.nextInt() - 1;
                            scanner.nextLine(); // Consumir la nueva línea pendiente después del nextInt()
                            String reglaEspecifica = reglamento.mostrarReglaEspecifica(indiceRegla);
                            System.out.println("Regla " + (indiceRegla + 1) + ": " + reglaEspecifica);
                            break;
                        case 3:
                            System.out.println("Ingrese la descripción de la nueva regla:");
                            String nuevaDescripcion = scanner.nextLine();
                            reglamento.agregarRegla(nuevaDescripcion);
                            System.out.println("Regla " + reglamento.getNumeroReglas() + ": " + nuevaDescripcion + " agregada correctamente.");
                            break;
                        case 4:
                            System.out.println("Ingrese el índice de la regla que desea modificar:");
                            int indiceModificar = scanner.nextInt() - 1;
                            scanner.nextLine(); // Consumir la nueva línea pendiente después del nextInt()

                            System.out.println("Regla " + (indiceModificar + 1) + ": " + reglamento.mostrarReglaEspecifica(indiceModificar));

                            System.out.println("Ingrese la nueva descripción de la regla:");
                            String nuevaDescripcionModificada = scanner.nextLine();

                            reglamento.modificarRegla(indiceModificar, nuevaDescripcionModificada);

                            System.out.println("Regla " + (indiceModificar + 1) + ": " + reglamento.mostrarReglaEspecifica(indiceModificar) + " modificada correctamente.");
                            break;
                        default:
                            System.out.println("Opción inválida.");
                            break;
                    }
            }
            System.out.println("¿Desea ingresar otro rol? (Si/No):");
            String respuesta = scanner.nextLine();
            if (!respuesta.equalsIgnoreCase("Si")) {
                seguirRegistrando = false;
                System.out.println("Registro finalizado.");
            }
        }
    }

    private List<Jugador> registrarJugadores(Scanner scanner) {
        List<Jugador> jugadoresNuevos = new ArrayList<>();
        boolean seguirRegistrandoJugadores = true;
        int contadorGruposJugador = 1; // Inicializar el contador

        Grupo grupoJugadores = new Grupo("Grupo A"); // Cambiar nombre del grupo

        while (seguirRegistrandoJugadores) {
            Jugador jugador = new Jugador();
            jugador.registrarInfoJugador(scanner, new EscogerDeporteIndividual());
            System.out.println("Registro en proceso. Espere un momento...");
            Toolkit.getDefaultToolkit().beep();
            Inscripcion inscripcion = new Inscripcion();
            inscripcion.validarInscripcionDelJugador(
                    jugador.getNombre(), jugador.getApellido(), jugador.getEdad(),
                    jugador.getNumeroDeCamiseta(), jugador.getPosicion());

            EstadoInscripcion estado = inscripcion.getEstado();
            if (estado == EstadoInscripcion.Registrado) {
                jugadoresNuevos.add(jugador);
                System.out.println("¡Jugador inscrito correctamente!");
                System.out.println("¿Desea registrar otro jugador? (Si/No):");
                String respuestaJugador = scanner.nextLine();
                if (!respuestaJugador.equalsIgnoreCase("Si")) {
                    seguirRegistrandoJugadores = false;
                }
            } else {
                System.out.println("Jugador no inscrito. Revise los datos ingresados, por favor.");
            }

            // Registrar los jugadores en el grupo
            if (!grupoJugadores.puedeAgregarJugador()) {
                contadorGruposJugador++;
                grupoJugadores = new Grupo("Grupo " + (char) ('A' + contadorGruposJugador - 1)); // Cambiar nombre y letra del grupo
            }
            grupoJugadores.agregarJugador(jugador);
        }
        jugadoresRegistradosEnTemporada.addAll(jugadoresNuevos);
        temporada = new Temporada("Temporada 2023", new Fecha(2023, 8, 10), new Fecha(2023, 12, 31)); // Crear una nueva instancia de Temporada
        temporada.agregarJugadores(jugadoresNuevos);

        System.out.println("Temporada: " + temporada.getNombre()); // Mostrar nombre de la temporada
        System.out.println("Modo de Juego de la Temporada: " + temporada.getModoDeJuego()); // Mostrar modo de juego aleatorio
        System.out.println("Fecha de inicio: " + temporada.getFechaInicio()); // Mostrar fecha de inicio
        System.out.println("Fecha de finalización: " + temporada.getFechaFin()); // Mostrar fecha de finalización
        System.out.println("Desea visualizar la temporada nuevamente? (Si/No):");
        String respuestaVerTemporada = scanner.nextLine();
        if (respuestaVerTemporada.equalsIgnoreCase("Si")) {
            if (!jugadoresNuevos.isEmpty()) {
                System.out.println("Jugadores en la temporada:");
                for (Jugador jugador : jugadoresNuevos) {
                    jugador.mostrarInformacion();
                }
            } else {
                System.out.println("No hay jugadores inscritos en la temporada.");
            }
        }

        System.out.println("Desea visualizar los grupos? (Si/No):");
        String respuestaGrupos = scanner.nextLine();
        if (respuestaGrupos.equalsIgnoreCase("Si")) {
            grupoJugadores.mostrarJugadoresEnGrupo();
        }
        System.out.println("En unos momentos se definirán los grupos. Espere un momento...");
        grupoJugadores.mostrarJugadoresEnGrupo();
        System.out.println("Los Enfrentamientos se definirán muy pronto.....");
        Partido.generarEnfrentamientosIndividuales(grupoJugadores.getJugadoresEnGrupo());
        return jugadoresNuevos;
    }


    private void realizarRegistroEquipos(Scanner scanner) {
        boolean seguirInscribiendoEquipos = true;
        List<Grupo> grupos = new ArrayList<>();
        Grupo grupoActual = null; // Inicializa grupoActual como null

        while (seguirInscribiendoEquipos) {
            grupoActual = new Grupo();
            Equipo equipo = new Equipo();
            grupo = grupoActual;
            equipo.escogerDeporte(scanner, new EscogerDeporte());
            equipo.registrarInfoEquipo(scanner);
            System.out.println("Registro en proceso. Espere un momento...");
            Toolkit.getDefaultToolkit().beep();
            Inscripcion inscripcionEquipo = new Inscripcion();
            inscripcionEquipo.validarInscripcionDelEquipo(equipo);

            EstadoInscripcion estadoEquipo = equipo.getEstadoInscripcion();
            if (estadoEquipo == EstadoInscripcion.Registrado) {
                System.out.println("¡Equipo inscrito correctamente!");
                equiposInscritos.add(equipo);
                grupoActual.agregarEquipo(equipo.getNombre());
            } else {
                System.out.println("Equipo no inscrito. Revise los datos ingresados, por favor.");
            }

            System.out.println("¿Desea ingresar otro equipo? (Si/No):");
            String respuesta = scanner.nextLine();
            if (!respuesta.equalsIgnoreCase("Si")) {
                seguirInscribiendoEquipos = false;
                System.out.println("Registro de equipos finalizado.");

                // Agregar el último grupo si no está lleno
                if (!grupoActual.getEquiposEnGrupo().isEmpty()) {
                    grupos.add(grupoActual);
                }

                System.out.println("Equipos ingresados:");
                for (Equipo equipoInscrito : equiposInscritos) {
                    System.out.println("- " + equipoInscrito.getNombre());
                }
                temporada = new Temporada("Temporada 2023", new Fecha(2023, 8, 10), new Fecha(2023, 12, 31)); // Crear una nueva instancia de Temporada
                System.out.println("Temporada: " + temporada.getNombre()); // Mostrar nombre de la temporada
                System.out.println("Fecha de inicio: " + temporada.getFechaInicio()); // Mostrar fecha de inicio
                System.out.println("Fecha de finalización: " + temporada.getFechaFin()); // Mostrar fecha de finalización
                System.out.println("¿Desea ver la temporada actualizada? (Si/No):");
                String respuestaTemporada = scanner.nextLine();
                if (respuestaTemporada.equalsIgnoreCase("Si")) {
                    if (temporada != null) {
                        temporada.verTemporada();
                    }


                        // Mostrar información de los equipos ingresados
                        System.out.println("Equipos ingresados:");
                        for (Equipo equipoInscrito : equiposInscritos) {
                            equipoInscrito.mostrarInformacionEquipo();
                        }


                        // Preguntar si desea ver los grupos
                        System.out.println("¿Desea ver los grupos? (Si/No):");
                        String respuestaGrupos = scanner.nextLine();
                        if (respuestaGrupos.equalsIgnoreCase("Si")) {
                            // Generar y mostrar los grupos
                            System.out.println("En unos momentos se definirán los grupos. Espere un momento...");
                            List<String> nombresEquipos = new ArrayList<>();
                            for (Equipo equipoInscrito : equiposInscritos) {
                                nombresEquipos.add(equipoInscrito.getNombre());
                            }
                            String[] arrayNombresEquipos = nombresEquipos.toArray(new String[nombresEquipos.size()]);
                            List<Grupo> gruposDefinidos = Grupo.definirGrupos(arrayNombresEquipos);
                            int contadorGrupos = 1;

                            for (Grupo grupo : gruposDefinidos) {
                                List<String> equiposEnGrupo = grupo.getEquiposEnGrupo();
                                if (!equiposEnGrupo.isEmpty()) {
                                    System.out.println("Grupo " + contadorGrupos + ":");
                                    contadorGrupos++;
                                    for (String nombreEquipo : equiposEnGrupo) {
                                        System.out.println("- " + nombreEquipo);
                                    }
                                }

                                List<Partido> partidos = grupo.generarPartidos();
                                System.out.println("Los Partidos se definirán muy pronto.....");
                                for (Partido partido : partidos) {
                                    System.out.println("El partido iniciará a las " + partido.getTiempo() +
                                            " el día " + partido.getFecha());
                                    System.out.println("- " + partido.getEquipoLocal() + " vs " + partido.getEquipoVisitante() +
                                            " (" + partido.getNombrePartido() + ") estado: " + partido.getEstado());

                                    if (partido.getEstado() == EstadoPartido.Iniciado) {
                                        System.out.println(Sorteo.realizarSorteo(partido));
                                    } else if (partido.getEstado() == EstadoPartido.Entretiempo) {
                                        System.out.println("El partido se encuentra en entretiempo.");
                                        Marcador marcador = Marcador.generarMarcadorAleatorio();
                                        System.out.println("Marcador: " + marcador); // Mostrar el marcador generado
                                    } else if (partido.getEstado() == EstadoPartido.Finalizado) {
                                        Marcador marcadorFinal = Marcador.generarMarcadorAleatorio();
                                        System.out.println("Marcador final: " + marcadorFinal); // Mostrar el marcador final generado
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }
    }

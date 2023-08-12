import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.awt.Toolkit;

public class Registro {
    private List<Equipo> equiposInscritos = new ArrayList<>();
    private List<Grupo> grupos = new ArrayList<>();
    private List<Usuario> usuarios;
    private Grupo grupo;

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
            System.out.println("Escoja su rol (Jugador, Director_Tecnico, Arbitro):");
            String rol = scanner.nextLine();

            switch (EleccionDeRol.valueOf(rol.toUpperCase())) {
                case JUGADOR:
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
                        System.out.println("¡Jugador inscrito correctamente!");
                    } else {
                        System.out.println("Jugador no inscrito. Revise los datos ingresados, por favor.");
                    }
                    break;
                case DIRECTOR_TECNICO:
                    realizarRegistroEquipos(scanner);
                    break;
                case ARBITRO:
                    System.out.println("Usted ha elegido el rol de Árbitro.");
                    break;
                default:
                    System.out.println("Rol no válido.");
                    break;
            }

            System.out.println("¿Desea ingresar otro rol? (Si/No):");
            String respuesta = scanner.nextLine();
            if (!respuesta.equalsIgnoreCase("Si")) {
                seguirRegistrando = false;
                System.out.println("Registro finalizado.");
            }
        }
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

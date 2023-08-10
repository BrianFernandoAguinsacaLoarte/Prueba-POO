import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.awt.Toolkit;

public class Registro {
    private List<Usuario> usuarios;
    private List<Equipo> equiposInscritos;
    private List<Grupo> grupos;
    private List<Partido> partidos;
    private int capacidadMaximaDelGrupo;

    public Registro() {
        usuarios = new ArrayList<>();
        equiposInscritos = new ArrayList<>();
        grupos = new ArrayList<>();
        partidos = new ArrayList<>();
        capacidadMaximaDelGrupo = 4;

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
                    if (estado == EstadoInscripcion.Registrado){
                        System.out.println("¡Jugador inscrito correctamente!");
                    } else {
                        System.out.println("Jugador no inscrito. Revise los datos ingresados, por favor.");
                    }
                    break;
                case DIRECTOR_TECNICO:
                    crearEquipos(scanner);

                    if (equiposInscritos.size() >= 2) {
                        Grupo nuevoGrupo = new Grupo("Grupo único", capacidadMaximaDelGrupo, equiposInscritos);
                        nuevoGrupo.generarPartidosYCrearGrupos(grupos);

                        System.out.println("En unos momentos se definirán los partidos.");
                        System.out.println("Equipo Local: " + nuevoGrupo.getEquipoLocal().getNombre());
                        System.out.println("Equipo Visitante: " + nuevoGrupo.getEquipoVisitante().getNombre());

                        if (!nuevoGrupo.getListaPartidos().isEmpty()) {
                            Partido primerPartido = nuevoGrupo.getListaPartidos().get(0);
                            System.out.println("Nombre de partido: " + primerPartido.generarNombreAleatorio());
                            System.out.println("Estado partido: " + primerPartido.getEstadoPartido());
                        }
                    } else {
                        System.out.println("Se necesitan al menos 2 equipos para definir los equipos locales y visitantes.");
                        System.out.println("En unos momentos se definirán los partidos.");
                    }
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
                seguirRegistrando = false; // Terminar el registro si la respuesta no es "Si"
                System.out.println("Registro finalizado.");
            }
        }
    }


    private void crearEquipos(Scanner scanner) {
        ArrayList<Equipo> equiposInscritosTemporal = new ArrayList<>();

        boolean deseaIngresarOtroEquipo = true;
        while (deseaIngresarOtroEquipo) {
            Equipo equipo = new Equipo();
            equipo.escogerDeporte(scanner, new EscogerDeporte());
            equipo.registrarInfoEquipo(scanner);

            Inscripcion inscripcionEquipo = new Inscripcion();
            inscripcionEquipo.validarInscripcionDelEquipo(equipo);
            EstadoInscripcion estadoEquipo = equipo.getEstadoInscripcion();

            if (estadoEquipo == EstadoInscripcion.Registrado) {
                System.out.println("¡Equipo inscrito correctamente!");
                equiposInscritosTemporal.add(equipo);
            } else {
                System.out.println("Equipo no inscrito. Revise los datos ingresados, por favor. Recuerde que un equipo es conformado por más de dos jugadores.");
            }

            System.out.println("¿Desea ingresar otro equipo? (Si/No):");
            String respuesta = scanner.nextLine();
            deseaIngresarOtroEquipo = respuesta.equalsIgnoreCase("Si");
        }

        // Una vez que termina el bucle, continuar con la generación de grupos y partidos

    }




}

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Registro {
    private List<Usuario> usuarios;

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
        while (true) {
            System.out.println("Escoja su rol (Jugador, Director_Tecnico, Arbitro):");
            String rol = scanner.nextLine();

            switch (EleccionDeRol.valueOf(rol.toUpperCase())) {
                case JUGADOR:
                    Jugador jugador = new Jugador();
                    jugador.registrarInfoJugador(scanner, new EscogerDeporte());
                    break;
                case DIRECTOR_TECNICO:
                    Equipo equipo = new Equipo();

                    equipo.escogerModoJuegoYDeporte(scanner, new EscogerDeporte());

                    System.out.println("Ingrese el nombre del equipo: ");
                    String nombreEquipo = scanner.nextLine();
                    equipo.setNombre(nombreEquipo);

                    System.out.print("Ingrese la cantidad de jugadores que conforman el equipo: ");
                    int cantidadJugadores = Integer.parseInt(scanner.nextLine());

                    equipo.registrarInfoJugadoresEquipo(scanner, cantidadJugadores);

                    break;
                case ARBITRO:
                    System.out.println("Usted ha elegido el rol de Árbitro.");
                    // Lógica para el registro de Árbitro, si es necesario
                    break;
                default:
                    System.out.println("Rol no válido.");
            }

            System.out.println("¿Desea ingresar otro rol? (Sí/No):");
            String respuesta = scanner.nextLine();
            if (!respuesta.equalsIgnoreCase("Sí")) {
                System.out.println("Registro finalizado.");
                break;
            }
        }
    }
}

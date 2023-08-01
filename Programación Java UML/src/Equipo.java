import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Equipo {
    private String nombre;
    private List<Jugador> jugadores;
    private ModoJuego modoJuego;
    private String deporte;

    public Equipo() {
        jugadores = new ArrayList<>();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    public void setModoJuego(ModoJuego modoJuego) {
        this.modoJuego = modoJuego;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public void escogerModoJuegoYDeporte(Scanner scanner, EscogerDeporte escogerDeporte) {
        System.out.print("Escoja el modo de juego:\n" +
                "- LIGAS\n" +
                "- FASE_GRUPOS\n" +
                "- ELIMINATORIAS\n" +
                "- ELIMINACION_SIMPLE\n" +
                "- RONDAS_DE_CLASIFICACION\n" +
                "- PUNTUACION_ACUMULATIVA\n" +
                "- UNO_CONTRA_UNO\n");
        String modoJuegoStr = scanner.next(); // Usamos next() para leer la palabra (modo de juego)
        scanner.nextLine(); // Consumir el salto de línea pendiente
        modoJuego = ModoJuego.valueOf(modoJuegoStr.toUpperCase());

        escogerDeporte.mostrarDeportesDisponibles();
        System.out.println("Ingrese el número del deporte que desea escoger:");
        int opcionDeporte = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea pendiente

        if (opcionDeporte >= 1 && opcionDeporte <= escogerDeporte.getDeportes().size()) {
            deporte = escogerDeporte.getDeportes().get(opcionDeporte - 1);
        } else if (opcionDeporte == escogerDeporte.getDeportes().size() + 1) {
            System.out.print("Ingrese el deporte: ");
            deporte = scanner.nextLine();
            escogerDeporte.agregarDeportePersonalizado(deporte); // Agregar deporte personalizado a la lista
        } else {
            System.out.println("Opción no válida. Deporte no seleccionado.");
        }
    }

    public void registrarInfoJugadoresEquipo(Scanner scanner, int cantidadJugadores) {
        for (int i = 0; i < cantidadJugadores; i++) {
            System.out.println("Ingrese los datos del Jugador " + (i + 1) + ":");

            System.out.print("Nombre: ");
            String nombreJugador = scanner.nextLine();

            System.out.print("Apellido: ");
            String apellido = scanner.nextLine();

            System.out.print("Edad: ");
            int edad = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea pendiente

            System.out.print("Número de camiseta: ");
            int numeroDeCamiseta = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea pendiente

            System.out.print("Posición: ");
            String posicion = scanner.nextLine();

            // Aquí puedes utilizar los datos recopilados para crear un objeto Jugador
            // o simplemente almacenarlos en una lista, dependiendo de tus necesidades.
        }
    }
}

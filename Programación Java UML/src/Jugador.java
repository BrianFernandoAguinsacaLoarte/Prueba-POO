import java.util.Scanner;

public class Jugador {
    private String nombre;
    private String apellido;
    private int edad;
    private int numeroDeCamiseta;
    private String posicion;
    private ModoJuego modoJuego;
    private String deporte;

    public Jugador() {
        // Constructor vacío
    }

    public void setModoJuego(ModoJuego modoJuego) {
        this.modoJuego = modoJuego;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public void registrarInfoJugador(Scanner scanner, EscogerDeporte escogerDeporte) {
        System.out.println("Ingrese los datos del Jugador:");
        System.out.print("Nombre: ");
        nombre = scanner.nextLine();

        System.out.print("Apellido: ");
        apellido = scanner.nextLine();

        System.out.print("Edad: ");
        edad = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea pendiente

        System.out.print("Número de camiseta: ");
        numeroDeCamiseta = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea pendiente

        System.out.print("Posición: ");
        posicion = scanner.nextLine();

        System.out.println("Escoja el deporte:");
        escogerDeporte.mostrarDeportesDisponibles();
        int opcionDeporte = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea pendiente

        if (opcionDeporte >= 1 && opcionDeporte <= escogerDeporte.getDeportes().size()) {
            deporte = escogerDeporte.getDeportes().get(opcionDeporte - 1);
        } else if (opcionDeporte == escogerDeporte.getDeportes().size() + 1) {
            System.out.print("Ingrese el deporte: ");
            deporte = scanner.nextLine();
        } else {
            System.out.println("Opción no válida. Deporte no seleccionado.");
        }

        System.out.print("Escoja el modo de juego:\n" +
                "- LIGAS\n" +
                "- FASE_GRUPOS\n" +
                "- ELIMINATORIAS\n" +
                "- ELIMINACION_SIMPLE\n" +
                "- RONDAS_DE_CLASIFICACION\n" +
                "- PUNTUACION_ACUMULATIVA\n" +
                "- UNO_CONTRA_UNO\n");
        String modoJuegoStr = scanner.nextLine();
        modoJuego = ModoJuego.valueOf(modoJuegoStr.toUpperCase());
    }
}

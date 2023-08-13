import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Equipo {
    private String nombre;
    private List<Jugador> jugadores;
    private String deporte;
    private Categoria categoria;
    private EstadoInscripcion estadoInscripcion;

    public Equipo() {
        jugadores = new ArrayList<>();
    }



    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public EstadoInscripcion getEstadoInscripcion() {
        return estadoInscripcion;
    }

    public void setEstadoInscripcion(EstadoInscripcion estadoInscripcion) {
        this.estadoInscripcion = estadoInscripcion;
    }

    public void escogerDeporte(Scanner scanner, EscogerDeporte escogerDeporte) {
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

        System.out.print("Ingrese la categoría del equipo (masculino o femenino): ");
        String categoriaStr = scanner.nextLine();
        categoria = Categoria.valueOf(categoriaStr.toLowerCase());
    }

    public void registrarInfoEquipo(Scanner scanner) {
        System.out.println("Recuerde que al momento de ingresar los datos del jugadores estos tengan una edad menos de 40 años y que el número de camiseta sea único y no repetido.");
        System.out.println("GRACIAS POR SU COMPRENSION");
        System.out.print("Ingrese el nombre del equipo: ");
        nombre = scanner.nextLine();

        System.out.print("Ingrese la cantidad de jugadores que conforman el equipo: ");
        int cantidadJugadores = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea pendiente

        for (int i = 0; i < cantidadJugadores; i++) {
            System.out.println("Ingrese los datos del Jugador " + (i + 1) + ":");

            Jugador jugador = new Jugador();

            System.out.print("Nombre: ");
            jugador.setNombre(scanner.nextLine());

            System.out.print("Apellido: ");
            jugador.setApellido(scanner.nextLine());

            System.out.print("Edad: ");
            jugador.setEdad(scanner.nextInt());
            scanner.nextLine(); // Consumir el salto de línea pendiente

            System.out.print("Número de camiseta: ");
            jugador.setNumeroDeCamiseta(scanner.nextInt());
            scanner.nextLine(); // Consumir el salto de línea pendiente

            System.out.print("Posición: ");
            jugador.setPosicion(scanner.nextLine());

            agregarJugador(jugador);
        }
    }
    public Equipo clone() {
        Equipo nuevoEquipo = new Equipo();
        nuevoEquipo.setNombre(this.nombre);
        nuevoEquipo.setCategoria(this.categoria);
        // Copiar los jugadores del equipo actual al nuevo equipo
        nuevoEquipo.getJugadores().addAll(this.jugadores);
        return nuevoEquipo;
    }
    @Override
    public String toString() {
        return nombre;
    }
    public void mostrarInformacionEquipo() {
        System.out.println("Nombre del equipo: " + nombre);
        System.out.println("Deporte: " + deporte);
        System.out.println("Categoría: " + categoria);
        System.out.println("Jugadores: ");
        for (Jugador jugador : jugadores) {
            System.out.println("- Nombre: " + jugador.getNombre() +
                    ", Edad: " + jugador.getEdad() +
                    ", Número de camiseta: " + jugador.getNumeroDeCamiseta() +
                    ", Posición: " + jugador.getPosicion());
        }
    }


}

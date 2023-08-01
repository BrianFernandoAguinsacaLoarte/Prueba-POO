import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del Jugador: ");
        String nombreJugador = scanner.nextLine();

        System.out.print("Ingrese el apellido del Jugador: ");
        String apellidoJugador = scanner.nextLine();

        System.out.print("Ingrese la edad del Jugador: ");
        int edadJugador = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese el género del Jugador: ");
        String generoJugador = scanner.nextLine();

        System.out.print("Ingrese el número de Camiseta del Jugador: ");
        int numeroCamisetaJugador = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese en la posición del Jugador: ");
        String posicionJugador = scanner.nextLine();

        System.out.print("En qué deporte quiere participar: ");
        String deporteEquipo = scanner.nextLine();

        System.out.print("Cuántos equipos se van a inscribir a la temporada? ");
        int numEquipos = scanner.nextInt();
        scanner.nextLine();

        List<Equipo> equipos = new ArrayList<>();
        for (int i = 0; i < numEquipos; i++) {
            System.out.print("Nombre del Equipo " + (i + 1) + ": ");
            String nombreEquipo = scanner.nextLine();

            // Crear un nuevo jugador para cada equipo
            Jugador jugador = new Jugador(nombreJugador, apellidoJugador, edadJugador, generoJugador, numeroCamisetaJugador, posicionJugador);

            Equipo equipo = new Equipo(nombreEquipo, deporteEquipo);
            equipo.agregarJugador(jugador);

            equipos.add(equipo);

        }

        Competencia competencia = new Competencia();
        competencia.agregarEquipos(equipos);

        System.out.print("¿Desea realizar el sorteo de los Equipos? (y/n): ");
        char opcion = scanner.next().charAt(0);

        if (opcion == 'y' || opcion == 'Y') {
            competencia.realizarSorteo();
            competencia.asignarFechasYHorarios();

            System.out.println("Sorteo realizado con éxito:");
            System.out.println(competencia);
        } else {
            System.out.println("El sorteo fue cancelado. Programa terminado.");
        }
    }
}

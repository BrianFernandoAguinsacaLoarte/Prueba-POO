import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;
public class Temporada {
    private String nombre;
    private Fecha fechaInicio;
    private Fecha fechaFin;
    private List<Jugador> jugadoresEnTemporada = new ArrayList<>();
    private List<Equipo> equiposEnTemporada = new ArrayList<>();
    private List<Equipo> equiposInscritos = new ArrayList<>();
    private ModoJuego modoDeJuego;

    public void agregarJugadores(List<Jugador> jugadores) {
        jugadoresEnTemporada.addAll(jugadores);
    }

    public void agregarEquipos(List<Equipo> equipos) {
        equiposEnTemporada.addAll(equipos);
    }

    public Temporada(String nombre, Fecha fechaInicio, Fecha fechaFin) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.modoDeJuego = ModoJuego.generarModoDeJuegoAleatorio();
    }

    public String getNombre() {
        return nombre;
    }

    public Fecha getFechaInicio() {
        return fechaInicio;
    }

    public Fecha getFechaFin() {
        return fechaFin;
    }

    public String getModoDeJuego() {
        return modoDeJuego.toString();
    }

    public void verTemporada() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Desea visualizar la temporada nuevamente? (Si/No):");
        String respuesta = scanner.nextLine();

        if (respuesta.equalsIgnoreCase("Si")) {
            System.out.println("Modo de Juego de la Temporada: " + modoDeJuego); // Imprimir modo de juego


            if (!jugadoresEnTemporada.isEmpty()) {
                System.out.println("Jugadores en la temporada:");
                for (Jugador jugador : jugadoresEnTemporada) {
                    jugador.mostrarInformacion();
                }
            }
        }
    }


        public void verTemporadaEquipos() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Desea ver la temporada de equipos? (Si/No)");
        String respuesta = scanner.nextLine();

        if (!equiposEnTemporada.isEmpty()) {
            System.out.println("Equipos en la temporada:");
            for (Equipo equipo : equiposEnTemporada) {
                System.out.println("- " + equipo.getNombre());
            }
        }
    }
    public void mostrarEquiposEnTemporada() {
        if (!equiposInscritos.isEmpty()) {
            System.out.println("Equipos en la temporada:");
            for (Equipo equipo : equiposInscritos) {
                equipo.mostrarInformacionEquipo();
            }

        }
    }

}

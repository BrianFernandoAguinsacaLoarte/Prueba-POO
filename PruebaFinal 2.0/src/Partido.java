import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Partido {
    private String equipoLocal;
    private String equipoVisitante;
    private String nombrePartido;
    EstadoPartido estado;
    Fecha fecha;
    Tiempo tiempo;
    private Marcador marcador;
    private MarcadorIndividual marcadorIndividualJugador1;
    private MarcadorIndividual marcadorIndividualJugador2;

    public Partido(Jugador jugador1, Jugador jugador2, String nombreEnfrentamiento) {
        this.equipoLocal = jugador1.getNombre();
        this.equipoVisitante = jugador2.getNombre();
        this.nombrePartido = nombreEnfrentamiento;
        this.estado = EstadoPartido.generarEstadoPartido();
        this.marcador = new Marcador(0, 0);
        this.marcadorIndividualJugador1 = new MarcadorIndividual(0, 0);
        this.marcadorIndividualJugador2 = new MarcadorIndividual(0, 0);
    }


    public Fecha getFecha() {
        return fecha;
    }

    public Tiempo getTiempo() {
        return tiempo;
    }

    public EstadoPartido getEstado() {
        return estado;
    }


    public Partido(String equipoLocal, String equipoVisitante, String nombrePartido) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.nombrePartido = nombrePartido;
        this.estado = EstadoPartido.generarEstadoPartido();
        this.marcador = new Marcador(0, 0);
        this.marcadorIndividualEquipoVisitante = new MarcadorIndividual(0, 0);
    }


    public Marcador getMarcador() {
        return marcador;
    }


    public String getEquipoLocal() {
        return equipoLocal;
    }

    public String getEquipoVisitante() {
        return equipoVisitante;
    }

    public String getNombrePartido() {
        return nombrePartido;
    }
    private MarcadorIndividual marcadorIndividualEquipoLocal;
    private MarcadorIndividual marcadorIndividualEquipoVisitante;


    public MarcadorIndividual getMarcadorIndividualJugador1() {
        return marcadorIndividualJugador1;
    }

    public MarcadorIndividual getMarcadorIndividualJugador2() {
        return marcadorIndividualJugador2;
    }

    public void setEstado(EstadoPartido estado) {
        this.estado = estado;
    }

    public void setMarcadorIndividualJugador1(MarcadorIndividual marcador) {
        this.marcadorIndividualJugador1 = marcador;
    }

    public void setMarcadorIndividualJugador2(MarcadorIndividual marcador) {
        this.marcadorIndividualJugador2 = marcador;
    }
    public static List<String> generarPartidosAleatorios(List<String> equipos) {
        List<String> partidos = new ArrayList<>();

        for (int i = 0; i < equipos.size(); i++) {
            for (int j = i + 1; j < equipos.size(); j++) {
                String partido = equipos.get(i) + " Vs " + equipos.get(j);
                partidos.add(partido);
            }
        }

        return partidos;
    }
    public static String generarNombreAleatorio() {
        String[] nombresPartidos = {"Partido Amistoso", "Partido Normal", "Encuentro Épico", "Choque de Titanes", "Duelo Legendario", "Partido del Siglo", "Enfrentamiento Estelar"};
        return nombresPartidos[new Random().nextInt(nombresPartidos.length)];
    }
    public static void generarEnfrentamientosIndividuales(List<Jugador> jugadores) {
        for (int i = 0; i < jugadores.size(); i++) {
            for (int j = i + 1; j < jugadores.size(); j++) {
                Jugador jugador1 = jugadores.get(i);
                Jugador jugador2 = jugadores.get(j);
                String nombreEnfrentamiento = generarNombreAleatorioEnfrentamiento();
                Fecha fechaAleatoria = Fecha.generarFechaAleatoria(2023, 2023, 8, 31);
                Tiempo tiempoAleatorio = Tiempo.generarTiempoAleatorio();
                EstadoPartido estadoPartido = EstadoPartido.generarEstadoPartido();

                MarcadorIndividual marcador = MarcadorIndividual.generarPuntosAleatorios();

                System.out.println("El enfrentamiento iniciará a las " + tiempoAleatorio + " el día " +
                        fechaAleatoria + "\n" + jugador1.getNombre() + " vs " + jugador2.getNombre() +
                        " (" + nombreEnfrentamiento + ")" + " - Estado: " + estadoPartido);
                System.out.println(jugador1.getNombre() + " " + marcador.getPuntosJugador1() +
                        " puntos - " + jugador2.getNombre() + " " + marcador.getPuntosJugador2() + " puntos\n");
            }
        }
    }



    private static final String[] nombresEnfrentamientos = {
            "Enfrentamiento Amistoso", "Enfrentamiento Normal", "Encuentro Épico",
            "Choque de Titanes", "Duelo Legendario", "Partido del Siglo", "Pesos pesados"
    };

    public static String generarNombreAleatorioEnfrentamiento() {
        Random random = new Random();
        int indiceAleatorio = random.nextInt(nombresEnfrentamientos.length);
        return nombresEnfrentamientos[indiceAleatorio];
    }
}







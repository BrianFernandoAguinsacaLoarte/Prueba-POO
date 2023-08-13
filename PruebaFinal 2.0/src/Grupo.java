import java.util.ArrayList;
import java.util.List;

public class Grupo {
    private List<String> equiposEnGrupo = new ArrayList<>();
    private List<Jugador> jugadoresEnGrupo = new ArrayList<>();
    private String nombre;
    private List<Partido> partidos;
    private static final int LIMITE_EQUIPOS = 4;
    private static final int LIMITE_JUGADORES = 4;


    public Grupo() {
            this.nombre = "Grupo ";
    }
    public Grupo(String nombre) {
        this.nombre = nombre;
    }


    public void agregarEquipo(String nombreEquipo) {
        equiposEnGrupo.add(nombreEquipo);
    }

    public List<String> getEquiposEnGrupo() {
        return equiposEnGrupo;
    }
    public void agregarJugador(Jugador jugador) {
        jugadoresEnGrupo.add(jugador);
    }
    public List<Jugador> getJugadoresEnGrupo() {
        return jugadoresEnGrupo;
    }
    public static List<Grupo> definirGrupos(String[] equipos) {
        List<Grupo> gruposDefinidos = new ArrayList<>();
        Grupo grupoActual = new Grupo();

        for (String equipo : equipos) {
            if (!grupoActual.puedeAgregarEquipo()) {
                gruposDefinidos.add(grupoActual);
                grupoActual = new Grupo();
            }
            grupoActual.agregarEquipo(equipo);
        }

        // Agregar el último grupo si no está lleno
        if (!grupoActual.getEquiposEnGrupo().isEmpty()) {
            gruposDefinidos.add(grupoActual);
        }

        return gruposDefinidos;
    }
    public boolean puedeAgregarEquipo() {
        return equiposEnGrupo.size() < LIMITE_EQUIPOS;

    }
    public List<Partido> generarPartidos() {
        List<String> equipos = getEquiposEnGrupo();
        List<String> nombresPartidos = Partido.generarPartidosAleatorios(equipos);
        List<Partido> partidos = new ArrayList<>();

        for (String nombrePartido : nombresPartidos) {
            String[] equiposPartido = nombrePartido.split(" Vs ");
            String equipoLocal = equiposPartido[0];
            String equipoVisitante = equiposPartido[1];
            String nombrePartidoAleatorio = Partido.generarNombreAleatorio();
            Fecha fechaAleatoria = Fecha.generarFechaAleatoria(2023, 2023, 8, 31); // Ajusta los valores según tus necesidades
            Tiempo tiempoAleatorio = Tiempo.generarTiempoAleatorio();

            Partido partido = new Partido(equipoLocal, equipoVisitante, nombrePartidoAleatorio);
            partido.fecha = fechaAleatoria;
            partido.tiempo = tiempoAleatorio;
            partido.estado = EstadoPartido.generarEstadoPartido();

            partidos.add(partido);
        }

        return partidos;
    }
    public void mostrarJugadoresEnGrupo() {
        System.out.println("Jugadores en el " + nombre + ":");
        for (Jugador jugador : jugadoresEnGrupo) {
            System.out.println("- " + jugador.getNombre());
        }
    }

    public void registrarJugadoresEnGrupo(List<Jugador> jugadores) {
        if (jugadoresEnGrupo.size() + jugadores.size() > LIMITE_JUGADORES) {
            System.out.println("No se pueden registrar más jugadores en este grupo.");
            return;
        }

        for (Jugador jugador : jugadores) {
            jugadoresEnGrupo.add(jugador);
        }

        System.out.println("¡Jugadores registrados en el grupo correctamente!");
    }
    public boolean puedeAgregarJugador() {
        return jugadoresEnGrupo.size() < LIMITE_JUGADORES;
    }
}

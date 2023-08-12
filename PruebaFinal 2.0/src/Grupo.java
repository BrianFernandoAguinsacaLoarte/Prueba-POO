import java.util.ArrayList;
import java.util.List;

public class Grupo {
    private List<String> equiposEnGrupo = new ArrayList<>();
    private String nombre;
    private List<Partido> partidos;
    private static final int LIMITE_EQUIPOS = 4;


    public Grupo() {
            this.nombre = "Grupo ";
    }
    public void agregarEquipo(String nombreEquipo) {
        equiposEnGrupo.add(nombreEquipo);
    }

    public List<String> getEquiposEnGrupo() {
        return equiposEnGrupo;
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
            Partido partido = new Partido(equipoLocal, equipoVisitante, Partido.generarNombreAleatorio());
            partidos.add(partido);
        }

        return partidos;
    }


}


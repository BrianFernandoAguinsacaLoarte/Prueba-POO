import java.util.ArrayList;
import java.util.List;

public class Grupo {
    private List<Equipo> equipos;
    private List<Partido> partidos;

    public Grupo() {
        equipos = new ArrayList<>();
        partidos = new ArrayList<>();
    }

    public void agregarEquipo(Equipo equipo) {
        equipos.add(equipo);
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void agregarPartido(Partido partido) {
        partidos.add(partido);
    }

    public List<Partido> getPartidos() {
        return partidos;
    }
}

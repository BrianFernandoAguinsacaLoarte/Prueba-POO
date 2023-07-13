import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Competencia {
    private String nombre;
    private ModoJuego tipoModoJuego;
    private Temporada temporada;
    private Inscripcion inscripcion;
    private Reglamento reglamento;
    private List<Equipo> equiposInscritos;
    private List<Partido> partidos;

    public Competencia(String nombreCompetencia, Temporada temporada) {
        this.nombre = nombreCompetencia;
        this.temporada = temporada;
        equiposInscritos = new ArrayList<>();
        partidos = new ArrayList<>();
    }

    public Competencia() {
        equiposInscritos = new ArrayList<>();
        partidos = new ArrayList<>();
    }

    public List<Equipo> getEquiposInscritos() {
        return equiposInscritos;
    }

    public void setEquiposInscritos(List<Equipo> equiposInscritos) {
        this.equiposInscritos = equiposInscritos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ModoJuego getTipoModoJuego() {
        return tipoModoJuego;
    }

    public void setTipoModoJuego(ModoJuego tipoModoJuego) {
        this.tipoModoJuego = tipoModoJuego;
    }

    public Temporada getTemporada() {
        return temporada;
    }

    public void setTemporada(Temporada temporada) {
        this.temporada = temporada;
    }

    public Inscripcion getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(Inscripcion inscripcion) {
        this.inscripcion = inscripcion;
    }

    public Reglamento getReglamento() {
        return reglamento;
    }

    public void setReglamento(Reglamento reglamento) {
        this.reglamento = reglamento;
    }

    public void inscribirEquipo(Equipo equipo) {
        equiposInscritos.add(equipo);
    }

    public void generarPartidos() {
        // Verificar si la competencia tiene equipos suficientes para generar partidos
        if (equiposInscritos.size() < 2) {
            System.out.println("No hay suficientes equipos inscritos para generar partidos.");
            return;
        }

        // Obtener una lista aleatoria de los equipos inscritos
        List<Equipo> equiposAleatorios = new ArrayList<>(equiposInscritos);
        Collections.shuffle(equiposAleatorios);

        // Limpiar la lista de partidos antes de generar nuevos
        partidos.clear();

        // Generar los partidos
        for (int i = 0; i < equiposAleatorios.size() - 1; i += 2) {
            Equipo equipo1 = equiposAleatorios.get(i);
            Equipo equipo2 = equiposAleatorios.get(i + 1);

            Partido partido = new Partido(equipo1.getEquipoInscrito(), equipo2.getEquipoInscrito());
            partidos.add(partido);
        }

        System.out.println("Se generaron " + partidos.size() + " partidos.");
    }

}

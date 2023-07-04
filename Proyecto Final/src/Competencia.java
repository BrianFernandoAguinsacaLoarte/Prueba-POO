import java.util.ArrayList;
import java.util.List;
public class Competencia {
    private String nombre;
    private ModoJuego tipoModoJuego;
    private Temporada temporada;
    private Inscripcion inscripcion;
    private Reglamento reglamento;
    private List<Equipo> equiposInscritos;

    public Competencia() {
        equiposInscritos = new ArrayList<>();
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

}


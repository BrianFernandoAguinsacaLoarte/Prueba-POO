
import java.util.Random;
public class Partido {
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private EstadoPartido estadoPartido;

    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(Equipo equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(Equipo equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public EstadoPartido getEstadoPartido() {
        return estadoPartido;
    }

    public void setEstadoPartido(EstadoPartido estado) {
        this.estadoPartido = estado;
    }

    public Partido(Equipo equipoLocal, Equipo equipoVisitante) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.estadoPartido = EstadoPartido.Iniciado; // Por defecto, el partido se crea con estado "Aplazado"
    }
    public Partido() {

    }

    // Método para generar un nombre aleatorio para el partido
    public String generarNombreAleatorio() {
        String[] nombres = {"Partido Amistoso", "Partido Normal", "Encuentro Épico", "Choque de Titanes", "Duelo Legendario", "Partido del Siglo", "Enfrentamiento Estelar"};
        Random random = new Random();
        return nombres[random.nextInt(nombres.length)];
    }
}

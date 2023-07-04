import java.util.Date;
import java.util.*;

public class Inscripcion {
    private String tipoInscripcion;
    private Fecha fechaInscripcion;
    private EstadoInscripcion estadoInscripcion;
    private JugadorInscrito jugadorInscrito;
    private Competencia competencia;
    private List<Equipo> equipoInscritoList;
    private List<JugadorInscrito> jugadorInscritoList;

    public String getTipoInscripcion() {
        return tipoInscripcion;
    }

    public void setTipoInscripcion(String tipoInscripcion) {
        this.tipoInscripcion = tipoInscripcion;
    }

    public Fecha getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Fecha fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public EstadoInscripcion getEstadoInscripcion() {
        return estadoInscripcion;
    }

    public void setEstadoInscripcion(EstadoInscripcion estadoInscripcion) {
        this.estadoInscripcion = estadoInscripcion;
    }

    public JugadorInscrito getJugadorInscrito() {
        return jugadorInscrito;
    }

    public void setJugadorInscrito(JugadorInscrito jugadorInscrito) {
        this.jugadorInscrito = jugadorInscrito;
    }
    public Competencia getCompetencia() {
        return competencia;
    }
   public boolean inscribirJugador(Jugador jugador) {
        for(JugadorInscrito jugadorInscrito : jugadorInscritoList){
            if(jugadorInscrito.getJugador().equals(jugador)){
                return true;
            }
        }
        return false;
    }

    public boolean validarInscripcionDeporte() {
        for(JugadorInscrito jugadorInscrito : jugadorInscritoList){
            if(jugadorInscrito.getJugador().equals(jugadorInscrito)){
                return true;
            }
        }
        return true;
    }

    public boolean validarJugador(Jugador jugador) {
        for(JugadorInscrito jugadorInscrito : jugadorInscritoList){
            if(jugadorInscrito.getJugador().equals(jugador)){
                return true;
            }
        }
        return false;
    }
}

import java.util.ArrayList;
import java.util.List;

public class Inscripcion {
    private Fecha fechaAprobacion;
    private Fecha fechaInscripcion;
    private Fecha fechaRechazado;
    private EstadoInscripcion estado;
    private List<Equipo> equiposInscritos;
    private List<Jugador> jugadoresInscritos;

    public Inscripcion() {
        equiposInscritos = new ArrayList<>();
        jugadoresInscritos = new ArrayList<>();
    }

    public EstadoInscripcion getEstado() {
        return estado;
    }

    public void validarInscripcionDelJugador(String nombreJugador, String apellidoJugador, int edadJugador,
                                             int numeroDeCamiseta, String posicion) {
        estado = EstadoInscripcion.En_proceso;

        if (nombreJugador != null && !nombreJugador.isEmpty()
                && apellidoJugador != null && !apellidoJugador.isEmpty()
                && edadJugador >= 18 && edadJugador <= 40
                && numeroDeCamiseta > 0
                && posicion != null && !posicion.isEmpty()) {
            estado = EstadoInscripcion.Registrado;
        } else {
            estado = EstadoInscripcion.Anulado;
        }
    }

    public void validarInscripcionDelEquipo(Equipo equipo) {
        EstadoInscripcion estado = EstadoInscripcion.En_proceso;

        if (equipo.getJugadores().size() < 2) {
            estado = EstadoInscripcion.Anulado;
        } else {
            boolean jugadoresValidos = true;
            for (Jugador jugador : equipo.getJugadores()) {
                if (!jugador.esValido()) {
                    jugadoresValidos = false;
                    break;
                }
            }
            if (jugadoresValidos) {
                estado = EstadoInscripcion.Registrado;
            } else {
                estado = EstadoInscripcion.Anulado;
            }
        }

        equipo.setEstadoInscripcion(estado);
    }

    // Otros métodos y constructores de la clase Inscripcion
}

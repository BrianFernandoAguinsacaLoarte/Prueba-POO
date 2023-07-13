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
        String respuesta = "";

        if (jugadorInscritoList == null) {
            jugadorInscritoList = new ArrayList<>();
            System.out.println("El jugador ha sido inscrito en la competencia.");
        } else if (respuesta.equalsIgnoreCase("no")) {
            System.out.println("El jugador no desea inscribirse en la competencia.");
        } else {
            System.out.println("Respuesta inválida. Por favor, ingrese 'si' o 'no'.");
            return false;
        }

        for (JugadorInscrito jugadorInscrito : jugadorInscritoList) {
            if (jugadorInscrito.getJugador().equals(jugador)) {
                return true;
            }
        }

        System.out.println("El jugador no cumple los requisitos para inscribirse.");
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
        if (jugadorInscritoList != null) {
            for (JugadorInscrito jugadorInscrito : jugadorInscritoList) {
                if (jugadorInscrito.getJugador().equals(jugador)) {
                    return true;
                }
            }
        }
        return false;
    }
    public void agregarEquipo(Equipo equipo) {
        equipoInscritoList.add(equipo);
    }

}

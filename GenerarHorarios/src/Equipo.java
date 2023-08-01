import java.util.ArrayList;
import java.util.List;

class Equipo {
    private String nombre;
    private String deporte;
    private List<Jugador> jugadores;

    public Equipo(String nombre, String deporte) {
        this.nombre = nombre;
        this.deporte = deporte;
        this.jugadores = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getDeporte() {
        return deporte;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    @Override
    public String toString() {
        StringBuilder jugadoresString = new StringBuilder();
        for (Jugador jugador : jugadores) {
            jugadoresString.append(jugador.toString()).append("\n");
        }

        return "Nombre del Equipo: " + nombre +
                "\nDeporte: " + deporte +
                "\nJugadores:\n" + jugadoresString;
    }
}


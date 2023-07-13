public class JugadorInscrito {
    private Inscripcion inscripcion;
    private String deporte;
    private Jugador jugador;

    public JugadorInscrito(Jugador jugador) {
        this.jugador = jugador;
        this.inscripcion = new Inscripcion();
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public Inscripcion getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(Inscripcion inscripcion) {
        this.inscripcion = inscripcion;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public boolean validarDatoJugador(Jugador jugador) {
        if (jugador == null) {
            return false;
        }

        if (jugador.getNombre() == null || jugador.getNombre().isEmpty()) {
            return false;
        }

        if (jugador.getEdad() <= 18) {
            return false;
        }

        return true; // Todos los datos del jugador son válidos
    }

    public String toString() {
        return "Jugador: " + jugador.getNombre() + " " + jugador.getApellido() + "\nDeporte: " + deporte;
    }
}

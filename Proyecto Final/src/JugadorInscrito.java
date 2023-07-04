public class JugadorInscrito {
    private Inscripcion inscripcion;
    private String deporte;
    private Jugador jugador;

    public JugadorInscrito() {
        this.inscripcion = new Inscripcion();
        this.jugador = jugador;
    }
    //Settes and Getters


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
        // Lógica de validación del jugador
        // ...
        return true;
    }
    public String toString(){
        return "Jugador: "+jugador.getNombre()+" "+jugador.getApellido()+"\nDeporte: "+deporte;
    }
}

public class Estadistica {
    private int goles;
    private int puntos;
    private int asistencias;

    public Estadistica(int goles, int puntos, int asistencias) {
        this.goles = goles;
        this.puntos = puntos;
        this.asistencias = asistencias;
    }

    // Métodos getters y setters...

    public int getGoles() {
        return goles;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(int asistencias) {
        this.asistencias = asistencias;
    }

    public void agregarNuevaEstadistica(int nuevosGoles, int nuevosPuntos, int nuevasAsistencias) {
        goles += nuevosGoles;
        puntos += nuevosPuntos;
        asistencias += nuevasAsistencias;
    }
}

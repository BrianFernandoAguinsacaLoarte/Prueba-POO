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

    public void agregarNuevaEstadistica(int nuevosGoles, int nuevosPuntos, int nuevasAsistencias) {
        goles += nuevosGoles;
        puntos += nuevosPuntos;
        asistencias += nuevasAsistencias;
    }
}

import java.util.HashSet;
import java.util.Set;

public enum Deporte {
    FUTBOL, BALONCESTO, ECUAVOLY;

    public static Deporte OTRO;
    private static Set<String> nombres;
    private Set<Fecha> fechas;
    private Set<Estadistica> estadisticas;

    static {
        nombres = new HashSet<>();
    }

    Deporte() {
        fechas = new HashSet<>();
        estadisticas = new HashSet<>();
    }

    public static void agregarNombre(String nombre) {
        nombres.add(nombre);
    }

    public static Deporte crearDeporteConNombres(Set<String> nombres) {
        Deporte deporteNuevo = Deporte.OTRO;
        deporteNuevo.setNombres(nombres);
        return deporteNuevo;
    }

    public void agregarFecha(Fecha fecha) {
        fechas.add(fecha);
    }

    public void agregarEstadistica(Estadistica estadistica) {
        estadisticas.add(estadistica);
    }

    public static Set<String> getNombres() {
        return nombres;
    }

    public Set<Fecha> getFechas() {
        return fechas;
    }

    public Set<Estadistica> getEstadisticas() {
        return estadisticas;
    }

    public void setNombres(Set<String> nombresDeporteNuevo) {
        nombres = nombresDeporteNuevo;
    }
}

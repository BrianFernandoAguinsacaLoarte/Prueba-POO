import java.util.Collection;
import java.util.Set;

public enum Deporte {
    FUTBOL,
    BALONCESTO,
    ECUAVOLY;
    private Fecha fecha;
    private Estadistica estadistica;

    public static void agregarNombre(String deporteInscripcion) {
    }

    public static Collection<Object> getNombres() {
        return null;
    }

    public static Deporte crearDeporteConNombres(Set<String> nombresDeporteNuevo) {
        return null;
    }

    public void agregarFecha(int dia, int mes, int año) {
        this.fecha = new Fecha(dia, mes, año);
    }

    public void agregarEstadistica(int goles, int puntos, int asistencias) {
        this.estadistica = new Estadistica(goles, puntos, asistencias);
    }

    public Fecha getFecha() {
        return fecha;
    }

    public Estadistica getEstadistica() {
        return estadistica;
    }
    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }
    public void setEstadistica(Estadistica estadistica) {
        this.estadistica = estadistica;
    }
    public String agregarDeporte(){
        return "Deporte agregado";
    }

}

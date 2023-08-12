
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Partido {
    private String equipoLocal;
    private String equipoVisitante;
    private String nombrePartido;
    EstadoPartido estado;
    Fecha fecha;
    Tiempo tiempo;
    private Marcador marcador;


    public Fecha getFecha() {
        return fecha;
    }

    public Tiempo getTiempo() {
        return tiempo;
    }

    public EstadoPartido getEstado() {
        return estado;
    }

    public Partido(String equipoLocal, String equipoVisitante, String nombrePartido) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.nombrePartido = nombrePartido;
        this.estado = EstadoPartido.generarEstadoPartido();
        this.marcador = new Marcador(0, 0);
    }
    public void setMarcador(Marcador marcador) {
        this.marcador = marcador;
    }

    public Marcador getMarcador() {
        return marcador;
    }

    public String getEquipoLocal() {
        return equipoLocal;
    }

    public String getEquipoVisitante() {
        return equipoVisitante;
    }

    public String getNombrePartido() {
        return nombrePartido;
    }

    public static List<String> generarPartidosAleatorios(List<String> equipos) {
        List<String> partidos = new ArrayList<>();

        for (int i = 0; i < equipos.size(); i++) {
            for (int j = i + 1; j < equipos.size(); j++) {
                String partido = equipos.get(i) + " Vs " + equipos.get(j);
                partidos.add(partido);
            }
        }

        return partidos;
    }
    public static String generarNombreAleatorio() {
        String[] nombresPartidos = {"Partido Amistoso", "Partido Normal", "Encuentro Épico", "Choque de Titanes", "Duelo Legendario", "Partido del Siglo", "Enfrentamiento Estelar"};
        return nombresPartidos[new Random().nextInt(nombresPartidos.length)];
    }
}






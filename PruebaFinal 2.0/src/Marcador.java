import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Marcador {
    private int golesEquipoLocal;
    private int golesEquipoVisitante;
    private EstadoPartido estado;
    private Marcador marcador;

    public Marcador(int golesEquipoLocal, int golesEquipoVisitante) {
        this.golesEquipoLocal = golesEquipoLocal;
        this.golesEquipoVisitante = golesEquipoVisitante;
    }
    public void iniciarPartido() {
        this.estado = EstadoPartido.Iniciado;
    }
    public int getGolesEquipoLocal() {
        return golesEquipoLocal;
    }

    public int getGolesEquipoVisitante() {
        return golesEquipoVisitante;
    }

    public static Marcador generarMarcadorAleatorio() {
        Random random = new Random();
        int golesEquipoLocal = random.nextInt(6);    // Goles entre 0 y 5
        int golesEquipoVisitante = random.nextInt(6); // Goles entre 0 y 5
        return new Marcador(golesEquipoLocal, golesEquipoVisitante);
    }

    @Override
    public String toString() {
        return golesEquipoLocal + " - " + golesEquipoVisitante;
    }
}


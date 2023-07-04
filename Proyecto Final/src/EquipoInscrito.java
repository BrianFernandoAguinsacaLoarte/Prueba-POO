import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
public class EquipoInscrito {
    private Equipo equipo;
    private List<EquipoInscrito> equipoInscritoList;
    private Temporada temporada;
    private Deporte deporte;
    private Inscripcion inscripcion;

    public EquipoInscrito(Equipo equipo, EquipoInscrito equipoInscrito) {
        this.equipo = equipo;
        this.equipoInscritoList = new ArrayList<>();
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public List<EquipoInscrito> getEquipoInscritoList() {
        return equipoInscritoList;
    }

    public void setEquipoInscritoList(List<EquipoInscrito> equipoInscritoList) {
        this.equipoInscritoList = equipoInscritoList;
    }

    public Deporte getDeporte() {
        return deporte;
    }

    public void setDeporte(Deporte deporte) {
        this.deporte = deporte;
    }

    public void escogerDeporte() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("En qué deporte desea inscribirse?: ");
        String nombreDeporte = scanner.nextLine();

        Deporte deporte = null;

        try {
            deporte = Deporte.valueOf(nombreDeporte.toUpperCase());
        } catch (IllegalArgumentException e) {
            // El nombre del deporte no coincide con ninguno de los valores de la enumeración
            System.out.println("Deporte no válido. Se creará uno nuevo.");
        }

        if (deporte == null) {
            // Crear un nuevo deporte y agregar el nombre
            Deporte.OTRO.agregarNombre(nombreDeporte);
            deporte = Deporte.OTRO;
        }

        this.deporte = deporte;

        scanner.close();
    }

    public boolean inscribirJugadorEquipo(Jugador jugador) {
     equipoInscritoList.add(new EquipoInscrito(equipo, this));
        return true;
    }
    public boolean validarJugador(Jugador jugador) {
        return inscripcion.validarJugador(jugador);
    }
}


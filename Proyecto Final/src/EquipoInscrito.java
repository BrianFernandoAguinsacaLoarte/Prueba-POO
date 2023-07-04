import java.util.*;
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

    public void escogerDeporte(EquipoInscrito equipoInscrito) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("En qué deporte desea inscribirse? (Futbol, Baloncesto, Ecuavoly u otro): ");
        String deporteInscripcion = scanner.nextLine();

        if (deporteInscripcion.equalsIgnoreCase("otro")) {
            equipoInscrito.escogerDeporte(equipoInscrito);
            System.out.println("Deporte seleccionado: " + equipoInscrito.getDeporte().getNombres().iterator().next());
        } else {
            try {
                Deporte deporte = Deporte.valueOf(deporteInscripcion.toUpperCase());
                equipoInscrito.setDeporte(deporte);
                System.out.println("Deporte seleccionado: " + deporte);
            } catch (IllegalArgumentException e) {
                System.out.println("Deporte no válido. Se creará uno nuevo.");
                boolean existeNombreDeporte = Deporte.getNombres().contains(deporteInscripcion);
                Deporte deporteNuevo;

                if (existeNombreDeporte) {
                    System.out.println("El nombre del deporte ya existe.");
                    deporteNuevo = null;
                } else {
                    Set<String> nombresDeporteNuevo = new HashSet<>();
                    nombresDeporteNuevo.add(deporteInscripcion);
                    Deporte.agregarNombre(deporteInscripcion);
                    deporteNuevo = Deporte.crearDeporteConNombres(nombresDeporteNuevo);
                    System.out.println("Deporte creado: " + deporteInscripcion);
                }
            }
        }
    }

    public boolean inscribirJugadorEquipo(Jugador Jugador) {
        if (!inscripcion.validarJugador(Jugador)) {
            return false;
        }
        equipoInscritoList.add(new EquipoInscrito(equipo, this));
        return true;
    }

    public boolean validarJugador(Jugador jugador) {
        return inscripcion.validarJugador(jugador);
    }
}
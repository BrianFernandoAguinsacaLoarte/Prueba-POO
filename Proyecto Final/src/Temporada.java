import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
public class Temporada {
    private String nombre;
    private String duracion;
    private Estado estado;
    private Modalidad modalidad;
    private Competencia competencia;
    private List<JugadorInscrito> jugadorInscritoList;

    public Temporada() {
        jugadorInscritoList = new ArrayList<>();
    }

    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Modalidad getModalidad() {
        return modalidad;
    }

    public void setModalidad(Modalidad modalidad) {
        this.modalidad = modalidad;
    }

    public Competencia getCompetencia() {
        return competencia;
    }

    public void setCompetencia(Competencia competencia) {

        this.competencia = competencia;
    }

    public void ingresarDatosTemporada() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre de la temporada: ");
        nombre = scanner.nextLine();
        System.out.print("Ingrese la duración de la temporada: ");
        duracion = scanner.nextLine();
        System.out.print("Ingrese el estado de la temporada: ");
        String estadoStr = scanner.nextLine();
        estado = Estado.valueOf(estadoStr.toUpperCase());
    }
    public ModoJuego asignarModalidad(ModoJuego modoJuego) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione la modalidad de juego:");
        int index = 1;
        for (ModoJuego mj : ModoJuego.values()) {
            System.out.println(index + ". " + mj);
            index++;
        }

        int seleccion = scanner.nextInt();
        ModoJuego[] modalidades = ModoJuego.values();
        modoJuego = modalidades[seleccion - 1];

        return modoJuego;
    }

    public boolean validarJugador(Jugador jugador) {
        for ( JugadorInscrito jugadorInscrito : jugadorInscritoList) {
            if (jugadorInscrito.getJugador().equals(jugador)) {
                System.out.println("El jugador ya está inscrito");
                return true;
            }
        }

        return false;
    }
    public boolean inscribirJugador(Jugador jugador) {
        for(JugadorInscrito jugadorInscrito : jugadorInscritoList){
            if(jugadorInscrito.getJugador().equals(jugador)){
                return true;
            }
        }
        return false;
    }
}

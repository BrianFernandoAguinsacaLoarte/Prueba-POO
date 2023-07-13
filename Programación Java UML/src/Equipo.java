import java.util.Scanner;
public class Equipo {
    private String nombre;
    private EquipoInscrito equipoInscrito;

    public Equipo(String nombreEquipo) {
        nombre = nombreEquipo;
    }
    public String getNombre() {
        this.nombre = nombre;
        return nombre;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    public void agregarEquipo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del equipo: ");
        nombre = scanner.nextLine();
    }
    public EquipoInscrito getEquipoInscrito() {
        return equipoInscrito;
    }

    public void setEquipoInscrito(EquipoInscrito equipoInscrito) {
        this.equipoInscrito = equipoInscrito;
    }

    public Jugador[] getJugadores() {
        return null;
    }
}

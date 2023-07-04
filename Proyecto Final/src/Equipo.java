import java.util.Scanner;
public class Equipo {
    private String nombre;
    private EquipoInscrito equipoInscrito;

    public void ingresarDatosEquipo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del equipo: ");
        nombre = scanner.nextLine();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public EquipoInscrito getEquipoInscrito() {
        return equipoInscrito;
    }

    public void setEquipoInscrito(EquipoInscrito equipoInscrito) {
        this.equipoInscrito = equipoInscrito;
    }
}

import java.util.Scanner;
public class Modalidad {
    private String nombre;
    private String descripcion;
    private ModoJuego modoJuego;
    private Asignacion asignacion;

    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ModoJuego getModoJuego() {
        return modoJuego;
    }

    public void setModoJuego(ModoJuego modoJuego) {
        this.modoJuego = modoJuego;
    }

    public Asignacion getAsignacion() {
        return asignacion;
    }

    public void setAsignacion(Asignacion asignacion) {
        this.asignacion = asignacion;
    }

    public ModoJuego asignarModalidad(Scanner scanner) {
        System.out.println("Seleccione la modalidad de juego:");
        System.out.println("1. LIGAS");
        System.out.println("2. FASE_GRUPOS");
        System.out.println("3. ELIMINATORIAS");
        System.out.println("4. AMISTOSO");

        String opcion = scanner.nextLine();
        int modalidad = Integer.parseInt(opcion);

        switch (modalidad) {
            case 1:
                return ModoJuego.LIGAS;
            case 2:
                return ModoJuego.FASE_GRUPOS;
            case 3:
                return ModoJuego.ELIMINATORIAS;
            case 4:
                return ModoJuego.AMISTOSO;
            default:
                return null;
        }
    }

}

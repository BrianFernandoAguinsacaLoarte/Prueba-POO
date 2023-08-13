import java.util.Scanner;

public class Jugador {
    private String nombre;
    private String apellido;
    private int edad;
    private int numeroDeCamiseta;
    private String posicion;

    private String deporte;

    public String getDeporte() {
        return deporte;
    }

    public Jugador() {
        // Constructor vacío
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getNumeroDeCamiseta() {
        return numeroDeCamiseta;
    }

    public void setNumeroDeCamiseta(int numeroDeCamiseta) {
        this.numeroDeCamiseta = numeroDeCamiseta;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public void registrarInfoJugador(Scanner scanner,  EscogerDeporteIndividual escogerDeporteIndividual) {
        System.out.println("Ingrese los datos del Jugador:");

        System.out.print("Nombre: ");
        nombre = scanner.nextLine();

        System.out.print("Apellido: ");
        apellido = scanner.nextLine();

        System.out.print("Edad: ");
        edad = Integer.parseInt(scanner.nextLine());
        System.out.println("Al momento de ingresar otro deporte considere que este sea un deporte individual");
        System.out.println("Escoja el deporte:");
        escogerDeporteIndividual.mostrarDeportesDisponibles();
        int opcionDeporte = Integer.parseInt(scanner.nextLine());

        if (opcionDeporte >= 1 && opcionDeporte <= escogerDeporteIndividual.getDeportes().size()) {
            deporte = escogerDeporteIndividual.getDeportes().get(opcionDeporte - 1);
        } else if (opcionDeporte == escogerDeporteIndividual.getDeportes().size() + 1) {
            System.out.print("Ingrese el deporte: ");
            deporte = scanner.nextLine();
        } else {
            System.out.println("Opción no válida. Deporte no seleccionado.");
        }

        System.out.print("Número de camiseta : ");
        numeroDeCamiseta = Integer.parseInt(scanner.nextLine());

        System.out.print("Posición: ");
        posicion = scanner.nextLine();

    }

    public void inscribirJugador() {
    }
    public void mostrarInformacion() {
        System.out.println("- Nombre: " + nombre + ", Edad: " + edad + ", Deporte: " + deporte + ", Posición: " + posicion);
    }
    public boolean esValido() {
        return true;
    }
    @Override
    public String toString() {
        return "Nombre: " + nombre +
                "\nApellido: " + apellido +
                "\nEdad: " + edad +
                "\nDeporte: " + deporte +
                "\nNúmero de camiseta: " + numeroDeCamiseta +
                "\nPosición: " + posicion;
    }
}

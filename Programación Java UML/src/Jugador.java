import java.util.Scanner;
public class Jugador extends Persona {

    private int numeroCamiseta;
    private String posicion;
    private JugadorInscrito jugadorInscrito;

    public int getNumeroCamiseta() {
        return numeroCamiseta;
    }

    public void setNumeroCamiseta(int numeroCamiseta) {
        this.numeroCamiseta = numeroCamiseta;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public JugadorInscrito getJugadorInscrito() {
        return jugadorInscrito;
    }

    public void setJugadorInscrito(JugadorInscrito jugadorInscrito) {
        // Validar si el jugador está inscrito antes de establecerlo
        if (jugadorInscrito.validarDatoJugador(this)) {
            this.jugadorInscrito = jugadorInscrito;
        } else {
            System.out.println("El jugador no está inscrito correctamente.");
        }
    }
    public void agregarJugador() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el número de camiseta: ");
        numeroCamiseta = scanner.nextInt();
        scanner.nextLine(); // Consumir el carácter de nueva línea

        System.out.print("Ingrese la posición del jugador: ");
        posicion = scanner.nextLine();
    }
}

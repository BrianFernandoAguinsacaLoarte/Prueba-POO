public class Jugador {
    private String nombre;
    private String apellido;
    private int edad;
    private int numeroCamiseta;
    private String posicion;
    private JugadorInscrito jugadorInscrito;

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
}

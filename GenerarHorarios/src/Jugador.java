class Jugador {
    private String nombre;
    private String apellido;
    private int edad;
    private String genero;
    private int numeroCamiseta;
    private String posicion;

    public Jugador(String nombre, String apellido, int edad, String genero, int numeroCamiseta, String posicion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.numeroCamiseta = numeroCamiseta;
        this.posicion = posicion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public String getGenero() {
        return genero;
    }

    public int getNumeroCamiseta() {
        return numeroCamiseta;
    }

    public String getPosicion() {
        return posicion;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " " + apellido +
                ", Edad: " + edad +
                ", Género: " + genero +
                ", Número de Camiseta: " + numeroCamiseta +
                ", Posición: " + posicion;
    }
}

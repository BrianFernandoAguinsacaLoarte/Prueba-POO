public enum EstadoInscripcion {
    PENDIENTE,
    APROBADA,
    RECHAZADA;

    public static EstadoInscripcion getRandomEstadoInscripcion() {
        return values()[(int) (Math.random() * values().length)];
    }
}

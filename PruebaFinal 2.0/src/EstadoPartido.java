import java.util.Random;

public enum EstadoPartido {
    Finalizado,
    Aplazado,
    Suspendido,
    Iniciado,
    Entretiempo,
    ;

    public static EstadoPartido generarEstadoPartido() {
        EstadoPartido[] estados = EstadoPartido.values();
        Random random = new Random();
        int indiceAleatorio = random.nextInt(estados.length);
        return estados[indiceAleatorio];
    }
}

import java.util.Random;

public enum ModoJuego {
    LIGAS,
    FASE_GRUPOS,
    ELIMINATORIAS,
    ELIMINCACION_SIMPLE,
    RONDAS_DE_CLASIFICACION,
    PUNTUACION_ACUMULATIVA,
    UNO_CONTRA_UNO,
    ;
    public static ModoJuego generarModoDeJuegoAleatorio() {
        ModoJuego[] modos = ModoJuego.values();
        Random random = new Random();
        int indiceAleatorio = random.nextInt(modos.length);
        return modos[indiceAleatorio];
    }

}

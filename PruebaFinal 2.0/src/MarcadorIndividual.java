import java.util.Random;

public class MarcadorIndividual {
    private int puntosJugador1;
    private int puntosJugador2;

    public MarcadorIndividual(int puntosJugador1, int puntosJugador2) {
        this.puntosJugador1 = puntosJugador1;
        this.puntosJugador2 = puntosJugador2;
    }

    public int getPuntosJugador1() {
        return puntosJugador1;
    }

    public int getPuntosJugador2() {
        return puntosJugador2;
    }

    public static MarcadorIndividual generarPuntosAleatorios() {
        Random random = new Random();
        int puntosJugador1 = random.nextInt(101); // Puntos entre 0 y 100
        int puntosJugador2 = random.nextInt(101); // Puntos entre 0 y 100
        return new MarcadorIndividual(puntosJugador1, puntosJugador2);
    }
}

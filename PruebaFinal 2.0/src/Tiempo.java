import java.util.Random;

public class Tiempo {

    private int hora;
    private int minuto;
    private int segundo;

    public Tiempo(int hora, int minuto, int segundo) {
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
    }

    public static Tiempo generarTiempoAleatorio() {
        Random random = new Random();
        int hora = random.nextInt(24);    // Hora entre 0 y 23
        int minuto = random.nextInt(60);  // Minuto entre 0 y 59
        int segundo = random.nextInt(60); // Segundo entre 0 y 59
        return new Tiempo(hora, minuto, segundo);
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", hora, minuto, segundo);
    }
}

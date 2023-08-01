import java.util.Random;

public class Horario {
    private int hora;
    private int minuto;

    public Horario(int hora, int minuto) {
        this.hora = hora;
        this.minuto = minuto;
    }

    public Horario() {

    }


    public int getHora() {
        return hora;
    }

    public int getMinuto() {
        return minuto;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d", hora, minuto);
    }

    public static Horario generarHorarioAleatorio() {
        Random random = new Random();
        int horaAleatoria = random.nextInt(24);
        int minutoAleatorio = random.nextInt(60);
        return new Horario(horaAleatoria, minutoAleatorio);
    }
}

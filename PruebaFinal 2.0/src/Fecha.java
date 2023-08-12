import java.util.Random;

public class Fecha {
    private int anio;
    private int mes;
    private int dia;

    public Fecha(int anio, int mes, int dia) {
        this.anio = anio;
        this.mes = mes;
        this.dia = dia;
    }

    public static Fecha generarFechaAleatoria(int anioInicial, int anioFinal, int mesMaximo, int diaMaximo) {
        Random random = new Random();
        int anio = random.nextInt(anioFinal - anioInicial + 1) + anioInicial; // Año entre anioInicial y anioFinal
        int mes = random.nextInt(mesMaximo) + 1; // Mes entre 1 y mesMaximo
        int dia = random.nextInt(diaMaximo) + 1; // Día entre 1 y diaMaximo
        return new Fecha(anio, mes, dia);
    }

    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", dia, mes, anio);
    }
}


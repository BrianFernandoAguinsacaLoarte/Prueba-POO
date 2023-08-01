import java.util.Random;

public class Fecha {
    private int dia;
    private int mes;
    private int anio;

    public Fecha(int dia, int mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAnio() {
        return anio;
    }

    @Override
    public String toString() {
        return String.format("%04d-%02d-%02d", anio, mes, dia);
    }

    public static Fecha generarFechaAleatoria(int anioInicial, int mesInicial, int diaInicial, int anioFinal, int mesFinal, int diaFinal) {
        Random random = new Random();
        int anioAleatorio = anioInicial + random.nextInt(anioFinal - anioInicial + 1);
        int mesAleatorio = mesInicial + random.nextInt(mesFinal - mesInicial + 1);
        int diaAleatorio = diaInicial + random.nextInt(diaFinal - diaInicial + 1);
        return new Fecha(diaAleatorio, mesAleatorio, anioAleatorio);
    }
}

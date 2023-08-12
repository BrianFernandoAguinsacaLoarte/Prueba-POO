import java.util.Random;
import java.util.Scanner;

public class Sorteo {
    public static String realizarSorteo(Partido partido) {
        Random random = new Random();
        String equipoLocal = partido.getEquipoLocal();
        String equipoVisitante = partido.getEquipoVisitante();
        int indiceEquipoGanador = random.nextInt(2); // 0 para equipo local, 1 para equipo visitante

        String ganador = (indiceEquipoGanador == 0) ? equipoLocal : equipoVisitante;
        String perdedor = (ganador.equals(equipoLocal)) ? equipoVisitante : equipoLocal;

        System.out.println("Usted que equipo cree que va a ganar?  (" + equipoLocal + " o " + equipoVisitante + "):");
        Scanner scanner = new Scanner(System.in);
        String respuesta = scanner.nextLine();

        if (respuesta.equalsIgnoreCase(ganador)) {
            return "¡Felicidades! Usted acertó. Ganó " + ganador+ " " + generarMarcadorAleatorio();
        } else if (respuesta.equalsIgnoreCase(perdedor)) {
            return "Lo lamento pero ganó " + perdedor + " " + generarMarcadorAleatorio();
        } else {
            return "No acertó. Ganó " + ganador + " " + generarMarcadorAleatorio();
        }
    }

    private static String generarMarcadorAleatorio() {
        Random random = new Random();
        int golesEquipoGanador = random.nextInt(5) + 1; // Goles entre 1 y 5
        int golesEquipoPerdedor = random.nextInt(golesEquipoGanador); // Goles del perdedor menor a los del ganador
        return "con un marcador de " + golesEquipoGanador + " - " + golesEquipoPerdedor;
    }
}

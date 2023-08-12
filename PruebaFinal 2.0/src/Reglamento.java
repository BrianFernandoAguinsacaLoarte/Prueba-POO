import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Reglamento {
    private String nombre;
    private Fecha fecha;
    private List<String> reglas;

    private Regla regla;

    public Reglamento(String nombre, Fecha fecha) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.reglas = new ArrayList<>();
        cargarReglas();
    }

    private void cargarReglas() {
        reglas.add("Respetar las decisiones del árbitro.");
        reglas.add("Mantener un comportamiento deportivo y respetuoso en todo momento.");
        reglas.add("No usar lenguaje ofensivo ni gestos provocativos hacia oponentes, árbitros o público.");
        reglas.add("No realizar entradas o faltas peligrosas que pongan en riesgo la integridad de otros jugadores.");
        reglas.add("Evitar el juego brusco y desleal que pueda causar daño a los rivales.");
        reglas.add("Respetar las líneas de juego y no salir del campo durante el juego.");
        reglas.add("No utilizar objetos o accesorios que puedan causar daño o ventaja injusta.");
        reglas.add("No interferir en el juego del oponente o en la ejecución de tiros o saques.");
        reglas.add("Mantener el fair play y aceptar las decisiones arbitrales sin discutir.");
        reglas.add("Mantener un ambiente de juego seguro para todos los participantes.");
        reglas.add("Fuera de Juego: En deportes como el fútbol, un jugador se encuentra en posición de fuera de juego si está más cerca de la línea de gol rival que el balón y el penúltimo defensor al recibir el balón. Se sanciona con un tiro libre indirecto para el equipo contrario.");
        reglas.add("Tiro Penal: En deportes como el fútbol, se otorga un tiro penal por faltas cometidas dentro del área de penalti. El jugador atacante ejecuta un tiro libre directo desde el punto de penalti hacia la portería.");
        reglas.add("Bloqueo en Deportes de Red: En deportes como el voleibol, los bloqueadores no pueden tocar el balón antes o durante el ataque del oponente. Se permite bloquear si el balón no ha cruzado la red.");
        reglas.add("Líneas de Saque: En deportes como el baloncesto, los jugadores deben respetar las líneas de saque al realizar saques laterales o desde la línea de falta.");
        reglas.add("Zonas Restringidas: En deportes como el balonmano, existe una zona restringida alrededor de la portería donde solo el portero puede tocar el balón.");
        reglas.add("Faltas Personales: En deportes como el baloncesto, los jugadores acumulan faltas personales por cometer faltas contra un oponente durante el juego.");
        reglas.add("Penaltis de Equipo: En deportes como el hockey sobre hielo, un equipo que comete una falta puede enfrentar un penalti, donde el oponente intenta marcar desde una distancia determinada.");
        reglas.add("Fuera de Límites: En deportes como el rugby, un balón que cruza los límites del campo está fuera de juego y se realiza un saque desde el lugar donde salió.");
        reglas.add("Desempate en Tiempo Extra: En deportes como el fútbol americano, si el marcador está empatado al final del tiempo reglamentario, se juegan periodos de tiempo extra para determinar un ganador.");
        reglas.add("Regla de los Tres Toques: En deportes como el voleibol, un equipo no puede tocar el balón más de tres veces antes de enviarlo al campo contrario.");
    }

    public void mostrarReglamento() {
        System.out.println("Reglamento creado el " + fecha);
        for (String regla : reglas) {
            System.out.println("- " + regla);
        }
    }

    public int getNumeroReglas() {
        return reglas.size();
    }

    public String mostrarReglaEspecifica(int indice) {
        if (indice >= 0 && indice < reglas.size()) {
            return reglas.get(indice);
        } else {
            return "Índice de regla inválido.";
        }
    }

    public void agregarRegla(String descripcion) {
        reglas.add(descripcion);
    }

    public void modificarRegla(int indice, String nuevaDescripcion) {
        if (indice >= 0 && indice < reglas.size()) {
            reglas.set(indice, nuevaDescripcion);
        } else {
            System.out.println("Índice de regla inválido.");
        }
    }


}

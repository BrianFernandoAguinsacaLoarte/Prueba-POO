import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class Partido {
    private Fecha fecha;
    private Date hora;
    private EquipoInscrito equipoLocal;
    private EquipoInscrito equipoVisitante;
    private Estado estado;
    private Marcador marcador;


    public Partido() {
        this.equipoLocal = null;
        this.equipoVisitante = null;
        this.fecha = null;
        this.hora = null;
        this.estado = null;
        this.marcador = null;
    }

    public Partido(EquipoInscrito equipoInscrito, EquipoInscrito equipoInscrito1) {
    }
    public Partido(Estado estado) {
        this.estado = estado;
    }
    public Estado getEstado() {

        return estado;
    }
    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public EquipoInscrito getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(EquipoInscrito equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public EquipoInscrito getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(EquipoInscrito equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }



    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Marcador getMarcador() {
        return marcador;
    }

    public void setMarcador(Marcador marcador) {
        this.marcador = marcador;
    }

    public void crearPartido() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el estado del partido: ");
        System.out.println("1. Iniciado");
        System.out.println("2. Suspendido");
        System.out.println("3. Finalizado");
        System.out.println("4. Aplazada");
        System.out.println("5. Entretiempo");
        int estadoPartido = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea después de leer el entero

        Estado estado;
        switch (estadoPartido) {
            case 1:
                estado = Estado.INICIADO;
                break;
            case 2:
                estado = Estado.SUSPENDIDO;
                break;
            case 3:
                estado = Estado.FINALIZADO;
                break;
            case 4:
                estado = Estado.APLAZADA;
                break;
            case 5:
                estado = Estado.ENTRETIEMPO;
                break;
            default:
                System.out.println("Opción inválida, se establecerá como 'INICIADO' por defecto.");
                estado = Estado.INICIADO;
                break;
        }

        setEstado(estado);

        System.out.print("Ingrese la fecha del partido (dd/mm/aaaa): ");
        String fechaPartido = scanner.nextLine();
        String[] partesFecha = fechaPartido.split("/");
        int dia = Integer.parseInt(partesFecha[0]);
        int mes = Integer.parseInt(partesFecha[1]);
        int anio = Integer.parseInt(partesFecha[2]);
        Fecha fecha = new Fecha(dia, mes, anio);
        setFecha(fecha);

        System.out.print("Ingrese la hora del partido (HH:mm): ");
        String horaPartido = scanner.nextLine();
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");
        Date hora;
        try {
            hora = formatoHora.parse(horaPartido);
            setHora(hora);
        } catch (ParseException e) {
            System.out.println("Error al convertir la hora. Se establecerá como null.");
            setHora(null);
        }

        scanner.close();
    }

    public void jugar() {
        // Lógica para simular el juego del partido y asignar el marcador.
    }

    public void mostrarResultado() {
        if (marcador != null) {
            System.out.println("Resultado del partido:");
            System.out.println(equipoLocal.getEquipo().getNombre() + " " + marcador.getGolesLocal() + " - " +
                    marcador.getGolesVisitante() + " " + equipoVisitante.getEquipo().getNombre());
        } else {
            System.out.println("El partido aún no ha sido jugado.");
        }
    }


    public static class Marcador {
        private int golesLocal;
        private int golesVisitante;

        public Marcador(int golesLocal, int golesVisitante) {
            this.golesLocal = golesLocal;
            this.golesVisitante = golesVisitante;
        }

        public int getGolesLocal() {
            return golesLocal;
        }

        public int getGolesVisitante() {
            return golesVisitante;
        }
    }


}

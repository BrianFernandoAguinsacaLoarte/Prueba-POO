import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Grupo {
    private String nombre;
    private int capacidadMaxima;
    private List<Equipo> equipos;
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private List<Partido> listaPartidos = new ArrayList<>();

    public List<Partido> getListaPartidos() {
        return listaPartidos;
    }

    public void setListaPartidos(List<Partido> listaPartidos) {
        this.listaPartidos = listaPartidos;
    }

    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(Equipo equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(Equipo equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public Grupo(String nombre, int capacidadMaxima, List<Equipo> equiposInscritos) {
        this.nombre = nombre;
        this.capacidadMaxima = capacidadMaxima;
        this.equipos = equiposInscritos != null ? new ArrayList<>(equiposInscritos) : new ArrayList<>();

    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void generarPartidosYCrearGrupos(List<Grupo> grupos) {
        for (int i = 0; i < equipos.size(); i++) {
            Equipo equipo = equipos.get(i);
            if (agregarEquipo(equipo)) {
                equipos.remove(i);
                i--; // Decrementar el índice para evitar saltarse un equipo al eliminarlo de la lista
            }
        }


        if (equipos.size() >= 2) {
            System.out.println("¡EN HORA BUENA QUE COMIENCEN LOS PARTIDOS!");

            while (equipos.size() >= 2) {
                Partido partido = new Partido();
                String nombrePartidoAleatorio = partido.generarNombreAleatorio();
                System.out.println("Nombre del Partido: " + nombrePartidoAleatorio);

                EstadoPartido estadoPartido = EstadoPartido.generarEstadoPartido();
                System.out.println("Estado del Partido: " + estadoPartido);

                partido.setEquipoLocal(equipoLocal);
                partido.setEquipoVisitante(equipoVisitante);
                listaPartidos.add(partido);

                definirEquiposLocalesYVisitantes(); // Actualizar equipos locales y visitantes para el siguiente partido
            }
        } else {
            System.out.println("Se necesitan al menos 2 equipos para definir los equipos locales y visitantes.");
            System.out.println("En unos momentos se definirán los partidos.");
        }

        if (equipos.size() > 1) {
            grupos.add(this);
        } else {
            System.out.println("No se pudo formar un grupo con el equipo actual. Se necesita al menos otro equipo para formar un grupo.");
        }

    }

    public boolean agregarEquipo(Equipo equipo) {
        if (equipos.size() < capacidadMaxima) {
            equipos.add(equipo);
            return true;
        } else {
            System.out.println("No se pudo agregar el equipo " + equipo.getNombre() + " porque el grupo ya está lleno.");
            return false;
        }
    }

    public void definirEquiposLocalesYVisitantes() {
        if (equipos.size() >= 2) {
            Random random = new Random();
            int indiceLocal = random.nextInt(equipos.size());
            equipoLocal = equipos.get(indiceLocal);

            int indiceVisitante;
            do {
                indiceVisitante = random.nextInt(equipos.size());
            } while (indiceVisitante == indiceLocal);

            equipoVisitante = equipos.get(indiceVisitante);
        } else {
            System.out.println("Se necesitan al menos 2 equipos para definir los equipos locales y visitantes.");
        }
    }


    public void agregarPartido(Partido partido) {
    }
}

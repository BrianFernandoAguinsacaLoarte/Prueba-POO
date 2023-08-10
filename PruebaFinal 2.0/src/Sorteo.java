import java.util.ArrayList;
import java.util.List;

public class Sorteo {
    private List<Grupo> grupos;

    public Sorteo() {
        grupos = new ArrayList<>();
    }

    public void agregarGrupos(List<Grupo> grupos) {
        this.grupos.addAll(grupos);
    }

    public void realizarSorteo() {
        // Simplemente, definimos equipos locales y visitantes para cada grupo
        for (Grupo grupo : grupos) {
            grupo.definirEquiposLocalesYVisitantes();
        }
    }

    // Métodos para asignar fechas y horarios (no mostrados para mayor brevedad)
}

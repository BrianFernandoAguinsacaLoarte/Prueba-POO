import java.util.List;
import java.util.ArrayList;

public class Reglamento {
    private String nombre;
    private Competencia competencia;
    private List<Regla> reglas;
    public Reglamento() {
        reglas = new ArrayList<>();
    }
    public void agregarRegla(Regla regla) {
        reglas.add(regla);
    }
    public void eliminarRegla(Regla regla) {
        reglas.remove(regla);
    }
    public void mostrarReglas() {
        for (Regla regla : reglas) {
            System.out.println(regla);
        }
    }


}

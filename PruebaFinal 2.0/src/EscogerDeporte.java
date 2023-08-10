
import java.util.ArrayList;
import java.util.List;


public class EscogerDeporte {
    private List<String> deportes;

    public EscogerDeporte() {
        deportes = new ArrayList<>();
        deportes.add("Futbol");
        deportes.add("Basquet");
        deportes.add("Voley");
    }

    public void mostrarDeportesDisponibles() {
        System.out.println("Deportes Disponibles:");
        for (int i = 0; i < deportes.size(); i++) {
            System.out.println((i + 1) + ". " + deportes.get(i));
        }
        System.out.println((deportes.size() + 1) + ". Otro");
    }

    public List<String> getDeportes() {
        return deportes;
    }

    // Agregar este método para permitir agregar un deporte personalizado
    public void agregarDeportePersonalizado(String deporte) {
        deportes.add(deporte);
    }
}

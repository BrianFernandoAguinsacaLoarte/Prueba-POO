import java.util.Date;

public class Partido {
    private Fecha fecha;
    private Date hora;
    private String equipoLocal;
    private String equipoVisitante;
    private EquipoInscrito equipoInscrito;
    private Estado estado;
    private Marcador marcador;


    class Marcador{
        private int golesLocal;
        private int golesVisitante;
    }
    class Fecha{
        private int dia;
        private int mes;
        private int anio;
    }
    enum Estado{
        PENDIENTE,
        JUGADO,
        SUSPENDIDO
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

    public String getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(String equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public String getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(String equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public EquipoInscrito getEquipoInscrito() {
        return equipoInscrito;
    }

    public void setEquipoInscrito(EquipoInscrito equipoInscrito) {
        this.equipoInscrito = equipoInscrito;
    }

    public Estado getEstado() {
        return estado;
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
}



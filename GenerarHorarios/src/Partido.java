import java.util.Map;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Partido {
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private Fecha fecha;
    private Horario horario;

    public Partido(Equipo equipoLocal, Equipo equipoVisitante) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.fecha = (Fecha) generarFechasDisponibles(2023, 8, 1, 2023, 8, 10).get(0);
        this.horario = (Horario) generarHorariosDisponibles().get(0);
    }

    private List<Horario> generarHorariosDisponibles() {
        List<Horario> horarios = new ArrayList<>();
        for (int hora = 0; hora < 24; hora++) {
            for (int minuto = 0; minuto < 60; minuto++) {
                horarios.add(new Horario(hora, minuto));
            }
        }
        return horarios;
    }

    private List<Fecha> generarFechasDisponibles(int anioInicial, int mesInicial, int diaInicial, int anioFinal, int mesFinal, int diaFinal) {
        List<Fecha> fechas = new ArrayList<>();
        for (int anio = anioInicial; anio <= anioFinal; anio++) {
            for (int mes = (anio == anioInicial ? mesInicial : 1); mes <= (anio == anioFinal ? mesFinal : 12); mes++) {
                int diaInicio = (anio == anioInicial && mes == mesInicial) ? diaInicial : 1;
                int diaFin = (anio == anioFinal && mes == mesFinal) ? diaFinal : obtenerUltimoDiaDelMes(anio, mes);
                for (int dia = diaInicio; dia <= diaFin; dia++) {
                    fechas.add(new Fecha(dia, mes, anio));
                }
            }
        }
        return fechas;
    }
    private int obtenerUltimoDiaDelMes(int anio, int mes) {
        if (mes == 2) {
            // Año bisiesto
            if ((anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0)) {
                return 29;
            } else {
                return 28;
            }
        } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
            return 30;
        } else {
            return 31;
        }
    }



    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    public Horario getHorarioPartido() {
        return horario;
    }

    public void setHorarioPartido(Horario horarioPartido) {
        this.horario = horarioPartido;
    }
}


import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Competencia {
    private List<Grupo> grupos;
    private List<Fecha> fechasDisponibles;
    private List<Horario> horariosDisponibles;

    public Competencia() {
        grupos = new ArrayList<>();
        fechasDisponibles = generarFechasDisponibles(2023, 8, 1, 2023, 8, 10);
        horariosDisponibles = generarHorariosDisponibles();
    }


    public List<Grupo> getGrupos() {
        return grupos;
    }

    public void agregarGrupo(Grupo grupo) {
        grupos.add(grupo);
    }

    public void agregarEquipoAlSorteo(Equipo equipo) {
        Grupo grupo = sortearEquiposEnGrupo(equipo);
        agregarGrupo(grupo);
    }

    public void agregarEquipos(List<Equipo> equipos) {
        int numEquiposPorGrupo = 3; // Puedes ajustar este valor según la cantidad deseada por grupo

        for (int i = 0; i < equipos.size(); i += numEquiposPorGrupo) {
            Grupo grupo = new Grupo();
            for (int j = i; j < i + numEquiposPorGrupo && j < equipos.size(); j++) {
                grupo.agregarEquipo(equipos.get(j));
            }
            grupos.add(grupo);
        }

        if (equipos.size() % numEquiposPorGrupo == 1) {
            Equipo ganadorGrupoA = grupos.get(0).getEquipos().get(0);
            Grupo grupoRestante = grupos.get(grupos.size() - 1);
            grupoRestante.agregarEquipo(ganadorGrupoA);
        }

        realizarSorteo();
        asignarFechasYHorarios();
    }

    private Grupo sortearEquiposEnGrupo(Equipo equipo) {
        List<Equipo> equiposDisponibles = new ArrayList<>();
        for (Grupo grupo : grupos) {
            equiposDisponibles.addAll(grupo.getEquipos());
        }
        equiposDisponibles.remove(equipo);

        Grupo grupo = new Grupo();
        grupo.agregarEquipo(equipo);

        int numEquiposPorGrupo = 3;
        int equiposAgregados = 1;

        while (equiposAgregados < numEquiposPorGrupo && !equiposDisponibles.isEmpty()) {
            Equipo otroEquipo = equiposDisponibles.get(new Random().nextInt(equiposDisponibles.size()));
            grupo.agregarEquipo(otroEquipo);
            equiposDisponibles.remove(otroEquipo);
            equiposAgregados++;
        }

        return grupo;
    }

    public void realizarSorteo() {
        List<Equipo> equiposDisponibles = new ArrayList<>();
        equiposDisponibles.addAll(grupos.get(0).getEquipos());

        for (int i = 1; i < grupos.size(); i++) {
            Grupo grupoActual = grupos.get(i);

            while (!equiposDisponibles.isEmpty() && grupoActual.getEquipos().size() < 3) {
                Equipo equipoAleatorio = equiposDisponibles.remove(new Random().nextInt(equiposDisponibles.size()));
                grupoActual.agregarEquipo(equipoAleatorio);
            }
        }
    }

    public void asignarFechasYHorarios() {
        List<Partido> partidos = generarPartidos();

        List<Fecha> fechasDisponibles = generarFechasDisponibles(2023, 8, 1, 2023, 8, 10);
        List<Horario> horariosDisponibles = generarHorariosDisponibles();

        for (Partido partido : partidos) {
            // Verificar si aún hay fechas y horarios disponibles
            if (fechasDisponibles.isEmpty() || horariosDisponibles.isEmpty()) {
                System.out.println("No hay suficientes fechas y horarios disponibles para todos los partidos.");
                return;
            }

            // Generar una fecha y horario aleatorio y asignar al partido
            Fecha fecha = fechasDisponibles.remove(0);
            Horario horarioPartido = horariosDisponibles.remove(0);

            partido.setFecha(fecha);
            partido.setHorarioPartido(horarioPartido);
        }
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

    private List<Horario> generarHorariosDisponibles() {
        List<Horario> horarios = new ArrayList<>();

        for (int hora = 0; hora < 24; hora++) {
            for (int minuto = 0; minuto < 60; minuto++) {
                horarios.add(new Horario(hora, minuto));
            }
        }

        return horarios;
    }

    private List<Partido> generarPartidos() {
        List<Partido> partidos = new ArrayList<>();

        for (int i = 0; i < grupos.size(); i++) {
            Grupo grupo = grupos.get(i);
            List<Equipo> equipos = grupo.getEquipos();
            for (int j = 0; j < equipos.size(); j++) {
                for (int k = j + 1; k < equipos.size(); k++) {
                    Partido partido = new Partido(equipos.get(j), equipos.get(k));
                    partidos.add(partido);
                }
            }
        }

        return partidos;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        char grupoName = 'A';
        for (Grupo grupo : grupos) {
            result.append("Grupo ").append(grupoName).append(":\n");
            List<Equipo> equipos = grupo.getEquipos();
            for (Equipo equipo : equipos) {
                result.append(equipo.getNombre()).append("\n");
            }
            grupoName++;
            result.append("\n");
        }

        result.append("\nFechas y Horarios de Partidos:\n");
        List<Partido> partidos = generarPartidos();
        int partidoNum = 1;
        for (Partido partido : partidos) {
            result.append("Partido ").append(partidoNum).append(":\n");
            result.append("- Fecha: ").append(partido.getFecha()).append("\n");
            result.append("- Hora: ").append(partido.getHorarioPartido()).append("\n");
            result.append("- Equipos: ").append(partido.getEquipoLocal().getNombre())
                    .append(" vs ").append(partido.getEquipoVisitante().getNombre()).append("\n\n");
            partidoNum++;
        }

        return result.toString();
    }
}
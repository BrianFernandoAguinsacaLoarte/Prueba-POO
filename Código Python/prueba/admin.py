from django.contrib import admin

from prueba.models import Persona, Jugador, Inscripcion, JugadorInscrito, Competencia, Reglamento, Arbitro, Regla, \
    Temporada, EquipoInscrito, Equipo, Modalidad, Asignacion, Partido, Marcador

admin.site.register(Persona)
admin.site.register(Jugador)
admin.site.register(JugadorInscrito)
admin.site.register(Inscripcion)
admin.site.site_header = 'Administración de Interfaz'
admin.site.register(Competencia)
admin.site.register(Reglamento)
admin.site.register(Arbitro)
admin.site.register(Regla)
admin.site.register(Temporada)
admin.site.register(EquipoInscrito)
admin.site.register(Equipo)
admin.site.register(Modalidad)
admin.site.register(Asignacion)
admin.site.register(Partido)
admin.site.register(Marcador)

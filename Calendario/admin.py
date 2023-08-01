from django.contrib import admin

from Calendario.models import Jugador, Equipo, Sorteo, Grupo, Temporada, Horario, Partido

# Register your models here.
admin.site.register(Jugador)
admin.site.register(Equipo)
admin.site.register(Sorteo)
admin.site.register(Grupo)
admin.site.register(Temporada)
admin.site.register(Horario)
admin.site.register(Partido)
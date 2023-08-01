import enum

from django.core.exceptions import ValidationError
from django.db import models

class EleccionDeRol(enum.Enum):
    Jugador = 'Jugador'
    Director_Tecnico = 'Director Tecnico'
    Arbitro = 'Arbitro'

class EstadoInscripcion(enum.Enum):
    REGISTRADO = 'Registrado'
    EN_PROCESO = 'En Proceso'
    ANULADA = 'Anulada'

class EscogerDeporte(enum.Enum):
    FUTBOL = 'Futbol'
    BASQUET = 'Basquet'
    VOLEY = 'Voley'
    OTRO = 'Otro'

class Categoria(enum.Enum):
    MASCULINO = 'Masculino'
    FEMENINO = 'Femenino'

class EstadoPartido(enum.Enum):
    FINALIZADO = 'Finalizado'
    APLAZADO = 'Aplazado'
    SUSPENDIDO = 'Suspendido'
    INICIADO = 'Iniciado'
    ENTRETIEMPO = 'Entretiempo'

class ModoJuego(enum.Enum):
    Eliminacion_Simple = 'Eliminacion simple'
    Rondas_de_Clasificacion = 'Rondas de Clasificacion'
    Puntuacion_Acumulativa = 'Puntuacion Acumulativa'
    Uno_contra_Uno = 'Uno contra Uno'
    Ligas = 'Ligas'
    Fase_Grupos = 'Fase de Grupos'
    Eliminatorias = 'Eliminatorias'

class Registro(models.Model):
    nombre = models.CharField(max_length=50)
    apellido = models.CharField(max_length=50)
    edad = models.PositiveIntegerField()
    EscogerDeporte = models.CharField(max_length=10, choices=[(tag.value, tag.value) for tag in EscogerDeporte], blank=True, null=True)
    EleccionDeRol = models.CharField(max_length=20, choices=[(tag.value, tag.value) for tag in EleccionDeRol], blank=True, null=True)


    def __str__(self):
        return self.nombre


class Jugador(models.Model):
    numero_Camiseta = models.PositiveIntegerField()
    posicion = models.CharField(max_length=50,default='Sin Posicion')
    registro = models.ForeignKey(Registro, on_delete=models.CASCADE, related_name='RegistroList', default=None)  # relacion de uno a muchos

    def __str__(self):
        return self.registro.nombre

class Inscripcion(models.Model):
    fecha_Inscripcion = models.DateField(blank=True, null=True)
    fecha_Aprobacion = models.DateField(blank=True,null=True) #Sugerencia
    fecha_Rechazo = models.DateField(blank=True, null=True) #Sugerencia
    estado_Inscripcion = models.CharField(max_length=10, choices=[(tag.value, tag.value) for tag in EstadoInscripcion], blank=True, null=True)
    jugador = models.ForeignKey(Jugador, on_delete=models.CASCADE, related_name='jugadorList', default=None)  # relacion de uno a muchos

    def __str__(self):
        return f"{self.jugador.registro.nombre} esta {self.estado_Inscripcion or 'Sin Estado'}"

    def validar_inscripcion(self):
        if not self.fecha_Inscripcion:
            raise ValidationError("La fecha de inscripción debe ser proporcionada.")

        if self.estado_Inscripcion == 'Aprobado' and not self.fecha_Aprobacion:
            raise ValidationError("La fecha de aprobación debe ser proporcionada para inscripciones aprobadas.")

        if self.estado_Inscripcion == 'Rechazado' and not self.fecha_Rechazo:
            raise ValidationError("La fecha de rechazo debe ser proporcionada para inscripciones rechazadas.")


class Equipo(models.Model):
    nombre = models.CharField(max_length=50)
    numero_Jugadores = models.PositiveIntegerField()
    categoria = models.CharField(max_length=10, choices=[(tag.value, tag.value) for tag in Categoria], blank=True, null=True)
    inscripcion = models.ForeignKey(Inscripcion, on_delete=models.CASCADE, related_name='inscripcionList', default=None)  # relacion de uno a muchos

    def __str__(self):
        return self.nombre

class Grupo(models.Model):
    nombre = models.CharField(max_length=50)
    capacidad_maxima_equipos = models.PositiveIntegerField()
    nombre_equipo_local = models.CharField(max_length=50)
    nombre_equipo_visitante = models.CharField(max_length=50)

    #Relaciones
    Equipo = models.ManyToManyField(Equipo, related_name='grupos', blank=True)
    def __str__(self):
        return self.nombre


class Sorteo(models.Model):
    pass

class Partido(models.Model):
    fecha = models.DateField(blank=True, null=True)
    hora = models.TimeField(blank=True, null=True)
    numero_encuentro = models.PositiveIntegerField()
    estado = models.CharField(max_length=20, choices=[(tag.value, tag.value) for tag in EstadoPartido], blank=True, null=True)

    #Relaciones
    grupo = models.ManyToManyField(Grupo, related_name='partidos', blank=True)

    def __str__(self):
        return self.estado

class Marcador(models.Model):
    nombre_equipo_local = models.CharField(max_length=50)
    nombre_equipo_visitante = models.CharField(max_length=50)
    punto_marcador_local = models.PositiveIntegerField()
    punto_marcador_visitante = models.PositiveIntegerField()

    def __str__(self):
        return f"Resultado = {self.nombre_equipo_local}: {self.punto_marcador_local} - {self.nombre_equipo_visitante}: {self.punto_marcador_visitante}"


class Temporada(models.Model):
    nombre = models.CharField(max_length=50)
    fecha_inicio = models.DateField(blank=True, null=True)
    fecha_fin = models.DateField(blank=True, null=True)
    ModoJuego = models.CharField(max_length=50, choices=[(tag.value, tag.value) for tag in ModoJuego], blank=True, null=True)

    #Relaciones
    EquipoList = models.ManyToManyField(Equipo, related_name='temporadas', blank=True, default=None)

    def __str__(self):
        return self.nombre

class Reglamento(models.Model):
    nombre = models.CharField(max_length=50)
    fecha = models.DateField(blank=True, null=True)

    Temporada = models.ForeignKey(Temporada, on_delete=models.CASCADE, related_name='temporadas', default=None)  # relacion de uno a muchos
    def __str__(self):
        return self.nombre

class Regla(models.Model):
    descripcion = models.CharField(max_length=50)

    def __str__(self):
        return self.descripcion
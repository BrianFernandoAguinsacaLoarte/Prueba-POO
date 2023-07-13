from django.core.validators import MinValueValidator
from django.db import models


class Persona(models.Model):
    nombre = models.CharField(max_length=50)
    apellido = models.CharField(max_length=50)
    edad = models.IntegerField(validators=[MinValueValidator(0)])

    def __str__(self):
        return self.nombre


class Jugador(Persona):
    numero_Camiseta = models.IntegerField(validators=[MinValueValidator(0)])

    def __str__(self):
        return self.nombre


class JugadorInscrito(models.Model):
    pass


class EstadoIncripsion(models.TextChoices):
    APROBADA = 'Aprobada'
    RECHAZADA = 'Rechazada'
    PENDIENTE = 'Pendiente'

    def __str__(self):
        return self.PENDIENTE

class Inscripcion(models.Model):
    tipo_Inscripcion = models.CharField(max_length=50)
    estado_Inscripcion = models.CharField(max_length=50, choices=EstadoIncripsion.choices, default=EstadoIncripsion.PENDIENTE)
    fecha_Inscripcion = models.DateField()

    def __str__(self):
        return self.tipo_Inscripcion


class Deporte(models.TextChoices):
    FUTBOL = 'Futbol'
    BALONCESTO = 'Baloncesto'
    ECUAVOLY = 'Ecuavoly'

    # Realizar Metodo

    def __str__(self):
        return self.FUTBOL


class Competencia(models.Model):
    nombre = models.CharField(max_length=50)
    tipo_Mode_Juego = models.CharField(max_length=50, choices=Deporte.choices, default=Deporte.FUTBOL)
    inscripcion = models.ForeignKey(Inscripcion, on_delete=models.CASCADE, related_name='competenciaList') # relacion de uno a muchos

    def __str__(self):
        return self.nombre

class Reglamento(models.Model):
    nombre = models.CharField(max_length=50)

    #Realizar Metodo
    def __str__(self):
        return self.nombre

class Arbitro(models.Model):
    #realizar metodo
    #realizar ToString
    pass

class Regla(models.Model):
    disciplina = models.CharField(max_length=50, choices=Deporte.choices, default=Deporte.FUTBOL)
    descripcion = models.TextField()
    def __str__(self):
        return self.descripcion


class Temporada(models.Model):
    nombre = models.CharField(max_length=50)
    duracion = models.IntegerField(validators=[MinValueValidator(0)])
    estado = models.CharField(max_length=50, choices=EstadoIncripsion.choices, default=EstadoIncripsion.PENDIENTE)
    estadistica = models.CharField(max_length=50) #REALIZAR TYPE

    def __str__(self):
        return self.nombre


class EquipoInscrito(models.Model):
    #Realizar metodo
    #Realizar metodo
    pass


class Equipo(models.Model):
    nombre = models.CharField(max_length=50)

    def __str__(self):
        return self.nombre


class ModoJuego(models.TextChoices):
    LIGAS = 'Ligas'
    FASE_GRUPOS = 'Fase Grupos'
    ELIMINATORIAS = 'Eliminatorias'
    AMISTOSO = 'Amistoso'

    def __str__(self):
        return self.LIGAS


class Modalidad(models.Model):
    nombre = models.CharField(max_length=50)
    descripcion = models.TextField()

    #Realizar metodo

    def __str__(self):
        return self.nombre



class Asignacion(models.Model):
    idaYVuelta = models.BooleanField(default=True)

    #Realizar metodo

    def __str__(self):
        return self.idaYVuelta


class Estado(models.TextChoices):
    FINALIZADO = 'Finalizado'
    APLAZADO = 'Aplazado'
    SUSPENDIDO = 'Suspendido'
    INICIADO = 'Iniciado'
    ENTRETIEMPO = 'Entretiempo'

    def __str__(self):
        return self.FINALIZADO


class Partido(models.Model):
    fecha = models.DateField()
    hora = models.TimeField()
    equipo_Local = models.ForeignKey(EquipoInscrito, on_delete=models.CASCADE, related_name='equipoLocalList')
    equipo_Visitante = models.ForeignKey(EquipoInscrito, on_delete=models.CASCADE, related_name='equipoVisitanteList')

    def __str__(self):
        return self.fecha


class Marcador(models.Model):
    nombre_Equipo = models.CharField(max_length=50)
    punto_Marcador_Local = models.IntegerField(validators=[MinValueValidator(0)])
    punto_Marcador_Visitante = models.IntegerField(validators=[MinValueValidator(0)])

    #Realizar metodo

    def __str__(self):
        return self.nombre_Equipo








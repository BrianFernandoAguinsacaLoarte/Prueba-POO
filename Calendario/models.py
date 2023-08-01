from django.db import models

# Create your models here.
class Jugador(models.Model) :
    nombre = models.CharField(max_length=50)
    apellido = models.CharField(max_length=50)
    edad= models.IntegerField()
    genero= models.CharField(max_length=50)
    numeroCamiseta= models.IntegerField()
    deporte = models.CharField(max_length=50)
    posicion = models.CharField(max_length=50)

    def __str__(self):
        return self.nombre + ' ' + self.apellido
class Equipo(models.Model) :
    nombre = models.CharField(max_length=50)

    def __str__(self):
        return self.nombre
class Sorteo (models.Model) :
    fecha = models.DateField()

    def __str__(self):
        return self.fecha

class Grupo (models.Model) :
    nombre = models.CharField(max_length=50)

    def __str__(self):
        return self.nombre

class Temporada (models.Model) :
    nombreTemporada = models.CharField(max_length=50)
    fechaInicio = models.DateField()
    fechaFin = models.DateField()
    Competiciones = models.CharField(max_length=50)
    def __str__(self):
        return self.nombreTemporada
class Horario (models.Model) :
    fecha = models.DateField()

    evento = models.CharField(max_length=50)
    def __str__(self):
        return self.fecha
class Partido (models.Model) :
    lugar = models.CharField(max_length=50)
    hora = models.CharField(max_length=50)
    equipoLocal = models.CharField(max_length=50)
    equipoVisitante = models.CharField(max_length=50)

    def __str__(self):
        return self.equipoLocal + ' ' + self.equipoVisitante

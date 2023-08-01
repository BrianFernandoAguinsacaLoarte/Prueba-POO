from django.http import HttpResponse
from django.shortcuts import render, redirect
from .models import Jugador, Equipo, Sorteo, Grupo, Temporada, Partido, Horario
from django.shortcuts import render, redirect
from .models import Jugador

def ingresar_jugador(request):
    if request.method == 'POST':
        # Obtener los datos del formulario
        nombre = request.POST['nombre']
        apellido = request.POST['apellido']
        edad = int(request.POST['edad'])
        genero = request.POST['genero']
        numero_camiseta = int(request.POST['numero_camiseta'])
        deporte = request.POST['deporte']
        posicion = request.POST['posicion']

        # Crear y guardar el objeto Jugador en la base de datos
        jugador = Jugador(nombre=nombre, apellido=apellido, edad=edad, genero=genero, numeroCamiseta=numero_camiseta, deporte=deporte, posicion=posicion)
        jugador.save()

        return redirect('ingresar_jugador')

    return render(request, 'ingresar_jugador.html')

def definir_equipo(request):
    if request.method == 'POST':
        nombre_equipo = request.POST['nombre_equipo']

        equipo = Equipo(nombre=nombre_equipo)
        equipo.save()

        return redirect('definir_equipo')

    equipos = Equipo.objects.all()
    return render(request, 'definir_equipo.html', {'equipos': equipos})
def eliminar_equipo(request, equipo_id):
    equipo = Equipo.objects.get(pk=equipo_id)
    equipo.delete()
    return redirect('definir_equipo')
def realizar_sorteo(request):
    if request.method == 'POST':
        fecha_sorteo = request.POST['fecha_sorteo']

        sorteo = Sorteo(fecha=fecha_sorteo)
        sorteo.save()

        return redirect('realizar_sorteo')

    sorteos = Sorteo.objects.all()
    return render(request, 'realizar_sorteo.html', {'sorteos': sorteos})

def lista_equipos(request):
    equipos = Equipo.objects.all()
    return render(request, 'lista_equipos.html', {'equipos': equipos})

def horario_partidos(request):
    if request.method == 'POST':
        fecha = request.POST['fecha']
        evento = request.POST['evento']
        horario = Horario(fecha=fecha, evento=evento)
        horario.save()

        return redirect('horario_partidos')

    horarios = Horario.objects.all()
    return render(request, 'horario_partidos.html', {'horarios': horarios})

def programar_partidos(request):
    if request.method == 'POST':
        fecha = request.POST['fecha']
        evento = request.POST['evento']
        horario = Horario.objects.create(fecha=fecha, evento=evento)
        horario.save()

    horarios = Horario.objects.all()
    equipos = Equipo.objects.all()

    return render(request, 'programar_partidos.html', {'horarios': horarios, 'equipos': equipos})


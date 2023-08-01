from django.core.exceptions import ValidationError
from django.shortcuts import render
from django.shortcuts import render
from django.views.generic import CreateView
from .models import Inscripcion


# Create your views here.
def mi_vista(request):
    contexto = {
        'titulo': 'Ejemplo de página HTML en Django',
        'contenido': '¡Hola! Esta es una página HTML generada con Django.',

    }
    return render(request, 'mi_template.html', contexto)
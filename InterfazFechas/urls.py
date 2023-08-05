"""
URL configuration for InterfazFechas project.

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/4.2/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  path('', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  path('', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.urls import include, path
    2. Add a URL to urlpatterns:  path('blog/', include('blog.urls'))
"""
from django.urls import path

from Calendario import views

urlpatterns = [
    path('IngresarJugador', views.ingresar_jugador, name='home'), 
    path('admin/', views.definir_equipo, name='admin'),
    path('equipos/', views.realizar_sorteo, name='lista_equipos'), 
    path('eliminar-equipo/<int:equipo_id>/', views.eliminar_equipo, name='eliminar_equipo'), # Eliminar equipo de la lista de equipos
    path('programar_partidos/', views.programar_partidos, name='programar_partidos'),



]

from django import forms


from dawnbem.models import Registro, Jugador, Inscripcion, Equipo, Partido, Marcador, Temporada, Reglamento, Regla


class RegistroForm(forms.ModelForm):
    class Meta:
        model = Registro
        fields = ['nombre', 'apellido', 'edad', 'EscogerDeporte', 'EleccionDeRol']
        widgets = {
            'nombre': forms.TextInput(
                attrs={
                    'class': 'form-control',
                    'placeholder': 'Ingrese su nombre'
                }
            ),
            'apellido': forms.TextInput(
                attrs={
                    'class': 'form-control',
                    'placeholder': 'Ingrese su apellido'
                }
            ),
            'edad': forms.NumberInput(
                attrs={
                    'class': 'form-control',
                    'placeholder': 'Ingrese su edad'
                }

            ),
            'EscogerDeporte': forms.Select(
                attrs={
                    'class': 'form-control',
                    'placeholder': 'Ingrese su deporte'
                }
            ),
            'EleccionDeRol': forms.Select(
                attrs={
                    'class': 'form-control',
                    'placeholder': 'Ingrese su rol'
                }
            ),

        }
        labels = {
            'nombre': 'Nombre',
            'apellido': 'Apellido',
            'edad': 'Edad',
            'EscogerDeporte': 'Deporte',
            'EleccionDeRol': 'Rol',
        }
class JugadorForm(forms.ModelForm):
    class Meta:
        model = Jugador
        fields = ['numero_Camiseta', 'posicion', 'registro']
        widgets = {
            'numero_Camiseta': forms.NumberInput(
                attrs={
                    'class': 'form-control',
                    'placeholder': 'Ingrese su número de camiseta'
                }
            ),
            'posicion': forms.TextInput(
                attrs={
                    'class': 'form-control',
                    'placeholder': 'Ingrese su posición'
                }
            ),
            'registro': forms.Select(
                attrs={
                    'class': 'form-control',
                    'placeholder': 'Ingrese su registro'
                }
            ),
        }
        labels = {
           'numero_Camiseta': 'Número de camiseta',
           'posicion': 'Posición',
           'registro': 'Registro',
        }

class InscripcionForm(forms.ModelForm):
    class Meta:
        model = Inscripcion
        fields = ['fecha_Inscripcion', 'fecha_Aprobacion', 'fecha_Rechazo', 'estado_Inscripcion', 'jugador']
        widgets = {
            'fecha_Inscripcion': forms.DateTimeInput(
                attrs={
                    'class': 'form-control',
                    'placeholder': 'Ingrese su fecha de inscripción'

                }
            ),
            'fecha_Aprobacion': forms.DateTimeInput(
                attrs={
                    'class': 'form-control',
                    'placeholder': 'Ingrese su fecha de aprobación'
                }
            ),
            'fecha_Rechazo': forms.DateTimeInput(
                attrs={
                    'class': 'form-control',
                    'placeholder': 'Ingrese su fecha de rechazo'
                }
            ),
            'estado_Inscripcion': forms.Select(
                attrs={
                    'class': 'form-control',
                    'placeholder': 'Ingrese su estado de inscripción'
                }
            ),
            'jugador': forms.Select(
                attrs={
                    'class': 'form-control',
                    'placeholder': 'Ingrese su jugador'
                }
            ),

        }
        labels = {
            'fecha_Inscripcion': 'Fecha de inscripción',
            'fecha_Aprobacion': 'Fecha de aprobación',
            'fecha_Rechazo': 'Fecha de rechazo',
            'estado_Inscripcion': 'Estado de inscripción',
            'jugador': 'Jugador',
        }


class EquipoForm(forms.ModelForm):
    Inscripcion = forms.ModelMultipleChoiceField(
        queryset=Jugador.objects.all(),
        widget=forms.SelectMultiple(attrs={'class': 'form-control'}),
        label='Inscripción (seleccione jugadores)')

    class Meta:
        model = Equipo
        fields = ['nombre', 'numero_Jugadores', 'categoria', 'inscripcion']
        widgets = {
            'nombre': forms.TextInput(
                attrs={
                    'class': 'form-control',
                    'placeholder': 'Ingrese su nombre'
                }
            ),
            'numero_Jugadores': forms.NumberInput(
                attrs={
                    'class': 'form-control',
                    'placeholder': 'Ingrese su número de jugadores'
                }
            ),
            'categoria': forms.Select(
                attrs={
                    'class': 'form-control',
                    'placeholder': 'Ingrese su categoría'
                }
            ),
            'inscripcion': forms.SelectMultiple(
                attrs={
                    'class': 'form-control',
                    'placeholder': 'Ingrese su inscripción'
                }
            ),
        }
        labels = {
            'nombre': 'Nombre',
            'numero_Jugadores': 'Número de jugadores',
            'categoria': 'Categoría',
            'inscripcion': 'Inscripción',
        }

class PartidoForm(forms.ModelForm):
    class Meta:
        model = Partido
        fields = ['fecha', 'hora', 'numero_encuentro', 'estado', 'grupo']
        widgets = {
            'fecha': forms.DateInput(
                attrs={
                    'class': 'form-control',
                    'placeholder': 'Ingrese su fecha'
                }
            ),
            'hora': forms.TimeInput(
                attrs={
                    'class': 'form-control',
                    'placeholder': 'Ingrese su hora'
                }
            ),
            'numero_encuentro': forms.NumberInput(
                attrs={
                    'class': 'form-control',
                    'placeholder': 'Ingrese su número de encuentro'
                }
            ),
            'estado': forms.Select(
                attrs={
                    'class': 'form-control',
                    'placeholder': 'Ingrese su estado'
                }
            ),
            'grupo': forms.Select(
                attrs={
                    'class': 'form-control',
                    'placeholder': 'Ingrese su grupo'
                }
            ),

        }
        labels = {
            'fecha': 'Fecha',
            'hora': 'Hora',
            'numero_encuentro': 'Número de encuentro',
            'estado': 'Estado',
            'grupo': 'Grupo',
        }

class MarcadorForm(forms.ModelForm):
    class Meta:
        model = Marcador
        fields = ['nombre_equipo_local', 'nombre_equipo_visitante', 'punto_marcador_local', 'punto_marcador_visitante']
        widgets = {
            'nombre_equipo_local': forms.TextInput(
                attrs={
                    'class': 'form-control',
                    'placeholder': 'Ingrese su nombre de equipo local'
                }
            ),
            'nombre_equipo_visitante': forms.TextInput(
                attrs={
                    'class': 'form-control',
                    'placeholder': 'Ingrese su nombre de equipo visitante'
                }
            ),
            'punto_marcador_local': forms.NumberInput(
                attrs={
                    'class': 'form-control',
                    'placeholder': 'Ingrese su punto de marcador local'
                }
            ),
            'punto_marcador_visitante': forms.NumberInput(
                attrs={
                    'class': 'form-control',
                    'placeholder': 'Ingrese su punto de marcador visitante'
                }
            ),
        }

        labels = {
            'nombre_equipo_local': 'Nombre de equipo local',
            'nombre_equipo_visitante': 'Nombre de equipo visitante',
            'punto_marcador_local': 'Punto de marcador local',
            'punto_marcador_visitante': 'Punto de marcador visitante',
        }

class TemporadaForm(forms.ModelForm):
    class Meta:
        model = Temporada
        fields = ['nombre', 'fecha_inicio', 'fecha_fin', 'ModoJuego', 'EquipoList']
        widgets = {
            'nombre': forms.TextInput(
                attrs={
                    'class': 'form-control',
                    'placeholder': 'Ingrese su nombre'
                }
            ),
            'fecha_inicio': forms.DateInput(
                attrs={
                    'class': 'form-control',
                    'placeholder': 'Ingrese su fecha de inicio'
                }
            ),
            'fecha_fin': forms.DateInput(
                attrs={
                    'class': 'form-control',
                    'placeholder': 'Ingrese su fecha de fin'
                }
            ),
            'ModoJuego': forms.Select(
                attrs={
                    'class': 'form-control',
                    'placeholder': 'Ingrese su modo de juego'
                }
            ),
            'EquipoList': forms.SelectMultiple(
                attrs={
                    'class': 'form-control',
                    'placeholder': 'Ingrese su lista de equipos'
                }
            ),
        }
        labels = {
            'nombre': 'Nombre',
            'fecha_inicio': 'Fecha de inicio',
            'fecha_fin': 'Fecha de fin',
            'ModoJuego': 'Modo de juego',
            'EquipoList': 'Lista de equipos',
        }

class ReglamentoForm(forms.ModelForm):
    class Meta:
        model = Reglamento
        fields = ['nombre', 'fecha', 'Temporada']
        widgets = {
            'nombre': forms.TextInput(
                attrs={
                    'class': 'form-control',
                    'placeholder': 'Ingrese su nombre'
                }
            ),
            'fecha': forms.DateInput(
                attrs={
                    'class': 'form-control',
                    'placeholder': 'Ingrese su fecha'
                }
            ),
            'Temporada': forms.Select(
                attrs={
                    'class': 'form-control',
                    'placeholder': 'Ingrese su temporada'
                }
            ),
        }
        labels = {
            'nombre': 'Nombre',
            'fecha': 'Fecha',
            'Temporada': 'Temporada',
        }

class ReglaForm(forms.ModelForm):
    class Meta:
        model = Regla
        fields = ['descripcion']
        widgets = {
            'descripcion': forms.TextInput(
                attrs={
                    'class': 'form-control',
                    'placeholder': 'Ingrese su descripción'
                }
            ),
        }
        labels = {
            'descripcion': 'Descripción',
        }

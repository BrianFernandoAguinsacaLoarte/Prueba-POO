from django.forms import forms

from dawnbem.models import Registro, EscogerDeporte


class RegistroForm(forms.ModelForm):
    class Meta:
        model = Registro
        fields = '__all__'

    def clean_EscogerDeporte(self):
        deporte = self.cleaned_data['EscogerDeporte']
        if deporte == EscogerDeporte.OTRO:
            otro_deporte = self.cleaned_data.get('otro_deporte')
            if not otro_deporte:
                raise forms.ValidationError('Si eliges "Otro", debes ingresar el nombre del deporte.')
            return otro_deporte
        return deporte
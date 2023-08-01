# Generated by Django 4.2.3 on 2023-07-30 17:47

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('dawnbem', '0035_registro_eleccionderol_registro_escogerdeporte_and_more'),
    ]

    operations = [
        migrations.RemoveField(
            model_name='registro',
            name='EscogerModalidad',
        ),
        migrations.AddField(
            model_name='jugador',
            name='posicion',
            field=models.CharField(default='Sin Posicion', max_length=50),
        ),
        migrations.AlterField(
            model_name='registro',
            name='EscogerDeporte',
            field=models.CharField(blank=True, choices=[('Futbol', 'Futbol'), ('Basquet', 'Basquet'), ('Voley', 'Voley'), ('Otro', 'Otro')], max_length=10, null=True),
        ),
    ]

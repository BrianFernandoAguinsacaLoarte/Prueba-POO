# Generated by Django 4.2.3 on 2023-07-29 21:42

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('dawnbem', '0024_delete_crearrol_registro_eleccionderol'),
    ]

    operations = [
        migrations.AlterField(
            model_name='registro',
            name='EscogerDeporte',
            field=models.CharField(choices=[('Futbol', 'Futbol'), ('Basquet', 'Basquet'), ('Voley', 'Voley'), (models.CharField(max_length=50), models.CharField(max_length=50))], max_length=50),
        ),
    ]

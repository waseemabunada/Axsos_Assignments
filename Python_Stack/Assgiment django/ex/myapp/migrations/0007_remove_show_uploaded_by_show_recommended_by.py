# Generated by Django 5.0.3 on 2024-04-16 18:01

import django.db.models.deletion
from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('myapp', '0006_alter_show_uploaded_by'),
    ]

    operations = [
        migrations.RemoveField(
            model_name='show',
            name='uploaded_by',
        ),
        migrations.AddField(
            model_name='show',
            name='recommended_by',
            field=models.ForeignKey(null=True, on_delete=django.db.models.deletion.CASCADE, related_name='shows_recommendation', to='myapp.user'),
        ),
    ]

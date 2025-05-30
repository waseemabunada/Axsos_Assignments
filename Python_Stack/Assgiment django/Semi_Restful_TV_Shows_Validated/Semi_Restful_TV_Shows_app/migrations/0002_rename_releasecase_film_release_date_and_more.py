# Generated by Django 5.2 on 2025-04-23 17:50

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('Semi_Restful_TV_Shows_app', '0001_initial'),
    ]

    operations = [
        migrations.RenameField(
            model_name='film',
            old_name='releasecase',
            new_name='release_date',
        ),
        migrations.AlterField(
            model_name='film',
            name='description',
            field=models.TextField(blank=True),
        ),
        migrations.AlterField(
            model_name='film',
            name='network',
            field=models.CharField(max_length=255),
        ),
        migrations.AlterField(
            model_name='film',
            name='title',
            field=models.CharField(max_length=255),
        ),
    ]

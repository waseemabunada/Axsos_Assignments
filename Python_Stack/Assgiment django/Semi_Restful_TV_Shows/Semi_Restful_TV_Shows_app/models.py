from django.db import models

class Film(models.Model):
    title = models.CharField(max_length=255)
    network = models.CharField(max_length=255)
    release_date = models.DateField()
    description = models.TextField(blank=True)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)


def create_film(data):
    return Film.objects.create(
        title=data['title'],
        network=data['network'],
        release_date=data['releasedate'],
        description=data['description']
    )

def update_film(film_id, data):
    film = Film.objects.get(id=film_id)
    film.title = data['title']
    film.network = data['network']
    film.release_date = data['releasedate']
    film.description = data['description']
    film.save()
    return film

def delete_film(film_id):
    film = Film.objects.get(id=film_id)
    film.delete()

def get_all_films():
    return Film.objects.all()

def get_film_by_id(film_id):
    return Film.objects.get(id=film_id)

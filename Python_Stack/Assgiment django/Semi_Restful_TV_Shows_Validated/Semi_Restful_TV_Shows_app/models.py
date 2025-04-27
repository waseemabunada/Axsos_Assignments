from django.db import models
from datetime import date
import re

class ShowManager(models.Manager):
    def basic_validator(self, postData, show_id=None):
        errors = {}

        title = postData.get('title', '').strip()
        network = postData.get('network', '').strip()
        release_date = postData.get('releasedate', '').strip()
        description = postData.get('description', '').strip()

        # Title validation
        if len(title) < 2:
            errors["title"] = "Title must be at least 2 characters."

        # Network validation
        if len(network) < 3:
            errors["network"] = "Network must be at least 3 characters."

        # Release date in the past
        if not release_date:
            errors["releasedate"] = "Release date is required."
        else:
            try:
                release_date_obj = date.fromisoformat(release_date)
                if release_date_obj >= date.today():
                    errors["releasedate"] = "Release date must be in the past."
            except ValueError:
                errors["releasedate"] = "Invalid date format."

        # Description is optional, but if present must be at least 10 chars
        if description and len(description) < 10:
            errors["description"] = "Description must be at least 10 characters if provided."

        # Unique title check (SENSEI BONUS)
        existing_shows =self.model.objects.filter(title__iexact=title)
        if show_id:
            existing_shows = existing_shows.exclude(id=show_id)
        if existing_shows.exists():
            errors["title"] = "A show with this title already exists."

        return errors

class Film(models.Model):
    title = models.CharField(max_length=255)
    network = models.CharField(max_length=255)
    release_date = models.DateField()
    description = models.TextField(blank=True)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    objects = ShowManager()  # ربط المانجر


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

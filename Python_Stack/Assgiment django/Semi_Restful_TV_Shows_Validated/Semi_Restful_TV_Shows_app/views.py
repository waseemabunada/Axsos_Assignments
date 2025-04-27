from django.shortcuts import render, redirect, get_object_or_404
from .models import *
from django.contrib import messages
from datetime import date

def index(request):
    return redirect('/shows')

def new_show(request):
    return render(request, 'new.html')

def create_show(request):
    # if request.method == 'POST':
    #     film = create_film(request.POST)  
    #     return redirect(f'/shows/{film.id}')
    # return redirect('/shows')
    if request.method == 'POST':
        errors = Film.objects.basic_validator(request.POST)
        if errors:
            for key, value in errors.items():
                messages.error(request, value)
            return redirect('/shows/new')
        Film.objects.create(
            title=request.POST['title'],
            network=request.POST['network'],
            release_date=request.POST['releasedate'],
            description=request.POST['description']
        )
        return redirect('/shows')

def all_shows(request):
    films = get_all_films()  
    return render(request, 'shows.html', {'display_film': films})

def show_detail(request, id):
    film = get_film_by_id(id)  
    return render(request, 'show.html', {'display_film': film})

def edit_show(request, id):
    film = get_film_by_id(id)  
    return render(request, 'edit.html', {'film': film})

def update_show(request, id):
    # if request.method == 'POST':
    #     update_film(id, request.POST)  
    #     return redirect(f'/shows/{id}')
    # return redirect('/shows')
    show = get_object_or_404(Film, id=id)
    if request.method == 'POST':
        errors = Film.objects.basic_validator(request.POST, show_id=show.id)
        if errors:
            for key, value in errors.items():
                messages.error(request, value)
            return redirect(f'/shows/{id}/edit')
        
        show.title = request.POST['title']
        show.network = request.POST['network']
        show.release_date = request.POST['releasedate']
        show.description = request.POST['description']
        show.save()
        return redirect(f'/shows/{show.id}')


def destroy_show(request, id):
    if request.method == 'POST':
        delete_film(id)  
    return redirect('/shows')
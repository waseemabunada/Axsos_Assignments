from django.shortcuts import render, redirect, get_object_or_404
from .models import *

def index(request):
    return redirect('/shows')

def new_show(request):
    return render(request, 'new.html')

def create_show(request):
    if request.method == 'POST':
        film = create_film(request.POST)  
        return redirect(f'/shows/{film.id}')
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
    if request.method == 'POST':
        update_film(id, request.POST)  
        return redirect(f'/shows/{id}')
    return redirect('/shows')

def destroy_show(request, id):
    if request.method == 'POST':
        delete_film(id)  
    return redirect('/shows')
from django.shortcuts import render,redirect
from . import models 


# Create your views here.
def bookpage(request):
    context={
        'books': models.get_all_books()
    }
    return render (request,'books.html',context)

def add_book(request):
    if request.method == "POST":
        models.add_book(request.POST)
    return redirect('/')

def book_detalies(request ,bookid):
    context={
        'display_book' : models.desplay_book_by_id(bookid),
        'authors': models.get_all_author()

    }
    return render (request,'book_detalies.html',context)

def authorpage(request):
    context={
        'authors': models.get_all_author()
    }
    return render (request,'authors.html',context)

def add_author(request):
    if request.method == "POST":
        models.add_author(request.POST)
    return redirect('/author')

def author_detalies(request ,authorid):
    context={
        'display_author' : models.desplay_author_by_id(authorid),
        'books': models.get_all_books()
    }
    return render (request,'author_detalies.html',context)
def relation_author_to_book(request,bookid)
    if request.method == "POST":
        models.Author.
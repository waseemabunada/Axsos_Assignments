from django.shortcuts import render, redirect
from . import models
from .models import Book
from .models import Author
from django.shortcuts import get_object_or_404

# Create your views here.
def add_book(request):
    if request.method == "POST":
        models.add_book(request.POST)
    context = {
        'books': models.get_books(),
    }
    return render(request, 'add_book.html', context)

def add_author(request):
    if request.method == "POST":
        models.add_author(request.POST)
    context = {
        'authors': models.get_authors(),
    }
    return render(request,'add_author.html',context)

def view_book(request, book_id):
    book = get_object_or_404(Book, id=book_id)
    authors = Author.objects.all() 
    return render(request, 'view_books.html', {'book': book, 'authors': authors})


def view_author(request, author_id):
    author = get_object_or_404(Author, id=author_id)
    books = author.Book.all() 
    return render(request, 'view_author.html', {'author': author, 'books': books})

from django.db import models
from django.shortcuts import render

# Create your models here.
class Book(models.Model):
    book_title = models.CharField(max_length=50)
    book_description = models.TextField()
    authors = models.ManyToManyField('Author', related_name='Book')
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

class Author(models.Model):
    first_name = models.CharField(max_length=30)
    last_name = models.CharField(max_length=30)
    notes = models.TextField()
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)  


def get_books():
    return Book.objects.all()

def get_authors():
    return Author.objects.all()

def add_book(request):
        Book.objects.create(
            book_title=request['title'],
            book_description=request['description']
        )
def add_author(request):
        Author.objects.create(
            first_name=request['first_name'],
            last_name=request['last_name'],
            notes=request['notes']
        )   


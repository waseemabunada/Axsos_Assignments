from django.db import models

class Author(models.Model):
    first_name=models.CharField(max_length=30)
    last_name=models.CharField(max_length=30)
    notes=models.TextField()
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

def add_author(post):
    author_first_name=post['first_name']
    author_last_name=post['last_name']
    author_notes=post['notes']
    Author.objects.create(first_name=author_first_name,last_name=author_last_name,notes= author_notes)

def get_all_author():
    return Author.objects.all()


def desplay_author_by_id(authorid):
    return Author.objects.get(id=authorid)


def connection_author_book(post,bookid):
    author = Author.objects.get(id = post['author_name'])
    book = Book.objects.get(id= bookid)
    book.author.add(author)

def connection_book_author(post,authorid):
    book =Book.objects.get(id =post['book_name'])
    authors= Author.objects.get (id=authorid)
    book.author.add(authors)


# Create your models here.
class Book(models.Model):
    title=models.CharField(max_length=30)
    description=models.TextField()
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    author = models.ManyToManyField(Author, related_name='books')
    
def add_book(post):
    book_title=post['title']
    book_description=post['description']
    Book.objects.create(title=book_title,description=book_description)   #title from class = name key post request

def get_all_books():
    return Book.objects.all()

def desplay_book_by_id(bookid):
    return Book.objects.get(id=bookid)





from django.shortcuts import render, redirect
from .models import User, Book
from django.contrib import messages
from django import template

register = template.Library()

# تعريف الفلتر داخل views.py
@register.filter
def example_filter(value):
    return value.upper()

def root(request):
    if not 'user_id' in request.session:
        return render(request, 'index.html')
    else:
        return redirect('/books')
    
def login(request):
    errors = User.objects.login_validator(request.POST)
    if errors:
        for key, value in errors.items():
            messages.error(request, value, extra_tags='login')
        return redirect('/')
    user = User.objects.get(email=request.POST['email'])
    request.session['first_name'] = user.first_name
    request.session['last_name'] = user.last_name
    request.session['user_id'] = user.id
    return redirect('/books')

def register(request):
    errors = User.objects.registration_validator(request.POST)
    if errors:
        for key, value in errors.items():
            messages.error(request, value, extra_tags='register')
        return redirect('/')
    User.objects.create_user(request.POST)
    messages.success(request, "Registration successful! You can now log in.", extra_tags='success')
    return redirect('/')

def logout(request):
    request.session.clear()
    return redirect('/')


def all_books(request):
    if not 'first_name' in request.session:
        messages.error(request, 'You must first login.', extra_tags='login')
        return redirect('/')
    books = Book.objects.all()
    user_ids_who_like_books = {book.id: list(book.users_who_like.values_list('id', flat=True)) for book in books}
    context = {
        "books": books,
        "user_ids_who_like_books": user_ids_who_like_books,
    }
    return render(request, 'all_books.html', context)


def view_book(request, id):
    if not 'first_name' in request.session:
        messages.error(request, 'You must first login.', extra_tags='login')
        return redirect('/')
    book = Book.objects.get(id=id)
    user_id = request.session['user_id']
    user_likes_book = user_id in book.users_who_like.values_list('id', flat=True)
    users_who_like_this_book = list(book.users_who_like.all())
    context = {
        "book": book,
        "user_likes_book": user_likes_book,
        "users_who_like_this_book": users_who_like_this_book,
    }
    request.session['displayed_book_id'] = id
    return render(request, 'view_book.html', context)

def add_book(request):
    errors = Book.objects.basic_validator(request.POST)
    if errors:
        for key, value in errors.items():
            messages.error(request, value)
        return redirect('/books')
    user = User.objects.get(id=int(request.session['user_id']))
    book = Book.objects.create_book(request.POST, user)
    return redirect(f'/books/{book.id}')

def edit_book(request):
    if request.POST['action'] == 'delete':
        book = Book.objects.get(id=int(request.session['displayed_book_id']))
        book.delete()
        return redirect('/books')
    else:
        if not 'first_name' in request.session:
            messages.error(request, 'You must first login.', extra_tags='login')
            return redirect('/')
        book_id = int(request.session['displayed_book_id'])
        book = Book.objects.get(id=book_id)
        errors = Book.objects.basic_validator(request.POST)
        if errors:
            for key, value in errors.items():
                messages.error(request, value)
            return redirect(f'/books/{book_id}')
        book.title = request.POST['title']
        book.description = request.POST['description']
        book.save()
        return redirect(f'/books/{book.id}')
    
    
def favorite_book_view_all_books(request, book_id):
    if not 'user_id' in request.session:
        messages.error(request, 'You must first log in.', extra_tags='login')
        return redirect('/')
    user = User.objects.get(id=request.session['user_id'])
    book = Book.objects.get(id=book_id)
    if user in book.users_who_like.all():
        book.users_who_like.remove(user)
    else:
        book.users_who_like.add(user)
    return redirect('/')

def favorite_book_view_book(request, book_id):
    if not 'user_id' in request.session:
        messages.error(request, 'You must first log in.', extra_tags='login')
        return redirect('/')
    user = User.objects.get(id=request.session['user_id'])
    book = Book.objects.get(id=book_id)
    if user in book.users_who_like.all():
        book.users_who_like.remove(user)
    else:
        book.users_who_like.add(user)
    return redirect(f'/books/{book_id}')
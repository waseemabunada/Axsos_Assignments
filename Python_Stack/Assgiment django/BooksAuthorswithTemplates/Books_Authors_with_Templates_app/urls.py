from django.urls import path
from . import views 

urlpatterns = [
    path('', views.add_book, name='add_book'),
    path('add_book/', views.add_book, name='add_book'),
    path('add_author/', views.add_author, name='add_author'),
    path('view_book/<int:book_id>/', views.view_book, name='view_book'),
    path('view_author/<int:author_id>/', views.view_author, name='view_author'),
        
]
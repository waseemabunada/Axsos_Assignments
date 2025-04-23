from django.urls import path
from . import views 

urlpatterns = [
    path('', views.bookpage),
    path('addbook', views.add_book),
    path('book_detalies/<int:bookid>',views.book_detalies),
    path('author', views.authorpage),
    path('add_author', views.add_author),
    path('author_detalies/<int:authorid>',views.author_detalies),
    path('relation_author_to_book/<int:authorid>',views.relation_author_to_book)
]
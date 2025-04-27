from django.urls import path
from . import views

urlpatterns = [
    path('', views.index),
    path('register', views.register),
    path('open_home',views.open_home),
    path('logout',views.logout),
    path('login',views.login),
    path('create',views.create),
    path('add',views.add),
    path('shows',views.shows),
    path('show_details',views.show_details),
    path('edit',views.edit),
    path('update',views.update),
    path('delete',views.destroy),
    path('add_comment',views.add_comment),
    path('delete_comment',views.delete_comment),

]
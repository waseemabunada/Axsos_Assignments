from django.urls import path
from . import views

urlpatterns = [
    path('', views.index),  
    path('process_money', views.mony),  
    path('destroy_session',views.clear_session),
]

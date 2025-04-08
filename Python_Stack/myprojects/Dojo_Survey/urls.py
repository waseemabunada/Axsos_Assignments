from django.urls import path
from . import views  
    
urlpatterns = [
    path('Dojo/', views.root),  
    path("result/",views.result),
]

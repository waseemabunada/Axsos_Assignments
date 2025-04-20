from django.urls import path
from . import views
urlpatterns = [   
    path('',views.indexv,name ='index'),
    path('guess',views.result),
    path('reset',views.reset)
]
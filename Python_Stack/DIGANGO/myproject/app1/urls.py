from django.urls import path


urlpatterns = [
 
    path('', include('app1.views.home')),
]

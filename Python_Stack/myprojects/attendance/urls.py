#new
from django.urls import path     
from . import views


urlpatterns = [
    path('student/<int:id>/<str:name>', views.student_info),
]
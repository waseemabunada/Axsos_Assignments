from django.contrib import admin
from django.urls import path
from . import views

urlpatterns = [
    path("", views.index, name="index"),
    path("destroy_session/", views.destroy_session, name="destroy_session"),
    path("admin/", admin.site.urls),
]

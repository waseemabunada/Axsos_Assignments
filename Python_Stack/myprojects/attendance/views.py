# new

from django.shortcuts import render, HttpResponse
def index(request):
    return HttpResponse("this is the equivalent of @app.route('/')!")


def student_info(request, id, name):
    return HttpResponse(f"Student ID: {id}, Name: {name}")
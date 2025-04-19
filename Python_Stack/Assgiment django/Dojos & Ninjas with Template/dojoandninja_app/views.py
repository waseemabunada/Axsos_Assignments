from django.shortcuts import render, redirect
from . import models
# Create your views here.
def index(request):
    context = {
        'dojos': models.get_dojos(),
        'ninjas': models.get_ninjas(),
    }
    return render(request, 'index.html',context)


def create_dojo(request):
    models.create_dojo(request.POST)
    return redirect('/')

def create_ninja(request):
    models.create_ninja(request.POST)
    return redirect('/')

def delete_dojo(request):
    if request.method == "POST":
        dojo_id = request.POST.get("dojo_id")
        dojo = models.Dojo.objects.get(id=dojo_id)
        dojo.delete()
    return redirect('/')
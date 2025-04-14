from django.shortcuts import render
from .models import UserProfile


# Create your views here.
def index(request):
    users=UserProfile.getallusers()
    context = {
        'users':users
    }
    return render(request, 'index.html',context)

def user(request):
    if request.method == 'POST':
        first_name = request.POST.get('first_name')
        last_name = request.POST.get('last_name')
        email = request.POST.get('email')
        age = request.POST.get('age')

        user=UserProfile.create_user(request.POST)
    
    return render(request, 'index.html')

    
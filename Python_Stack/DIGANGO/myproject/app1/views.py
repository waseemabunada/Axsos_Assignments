from django.shortcuts import render

# Create your views here.
def login_view(request):
    return render(request, 'app1/login.html')
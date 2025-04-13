from django.shortcuts import render, redirect

# Create your views here.
def index(request):
    return render(request, 'gold.html')

def mony(request):
    if request.method == 'POST':
        return redirect ("/")
    
def clear_session(request):
    request.clear()  
    return redirect("/")

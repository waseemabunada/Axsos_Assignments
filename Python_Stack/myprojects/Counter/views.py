from django.shortcuts import render, redirect

def index(request):
    request.session['count'] = request.session.get('count', 0) + 1
    return render(request, "index.html", {"count": request.session['count']})

def destroy_session(request):
    request.session.flush()  
    return redirect("")
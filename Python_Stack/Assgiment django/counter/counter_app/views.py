from django.shortcuts import render

# Create your views here.
def index(request):
    if request.method == 'POST':
        count = int(request.POST.get('count', 0)) + 1
    else:
        count = 0

    return render(request, 'index.html', {'count': count})

def destroy_session(request):
    del().request 
    return render(request, 'index.html', {'count': 0}) 
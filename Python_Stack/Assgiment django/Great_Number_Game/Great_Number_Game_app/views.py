from django.shortcuts import render , redirect
import random
    
def indexv(request):
    if 'number' not in request.session:
        request.session['number'] = random.randint(1, 100)
    return render(request,'index.html')

def result(request):
    if request.method == 'POST':
        guess_num= int(request.POST ['ran_num'])
        num =  request.session['number']
        if guess_num > num:
            request.session['box'] = "Too High" 
        elif guess_num < num:
            request.session['box'] = "Too Low"
        else: 
            request.session['box'] = f"{guess_num} Is correct "
    return redirect('/')
def reset(request):
    request.session.flush()
    return redirect('/')
        
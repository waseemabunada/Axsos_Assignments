from django.shortcuts import render, redirect
import random
from datetime import datetime

# Create your views here.
def index(request):
    if 'total_gold' not in request.session:
        request.session['total_gold'] = 0
    if 'activities' not in request.session:
        request.session['activities'] = []
    return render(request, 'gold.html')

def mony(request):
    if request.method == 'POST':
        earned = 0
        activity = ''
        color = 'green'
        time = datetime.now().strftime('%B %d, %Y %I:%M %p')
        if 'Farm' in request.POST:
            earned = random.randint(10, 20)
            activity = f"You entered a {earned} gold from the farm!"
        elif 'Cave' in request.POST:
            earned = random.randint(10, 20)
            activity = f"You entered a {earned} gold from the cave!"
        elif 'House' in request.POST:
            earned = random.randint(10, 20)
            activity = f"You entered a {earned} gold from the house!"
        elif 'Quest' in request.POST:
            earned = random.randint(-50, 50)
            if earned >= 0:
                activity = f"You completed a quest and entered {earned} gold!"
                color = 'green'
            else:
                activity = f"You failed a quest and lost {-earned} gold!"
                color = 'red'
        activity += f" ({time})"
        request.session['total_gold'] += earned
        request.session['activities'].insert(0, (activity, color))
        request.session.modified = True  

    return redirect('/')
def clear_session(request):
    request.session.clear()  
    return redirect("/")

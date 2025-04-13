import random
from datetime import datetime
from flask import Flask, render_template, redirect, session, request, url_for

app = Flask(__name__)
app.secret_key = '123456789' 


@app.route('/')
def index():
    if 'total_golds' not in session:
        session['total_golds'] = 0
    if 'activities' not in session:
        session['activities'] = []
    return render_template("index.html")


@app.route('/process_money', methods=['post'])
def process_money():
    form = request.form['form']    
    min = int(request.form['min'])  
    max = int(request.form['max'])  

    random_number = random.randint(min, max) 
    session['total_golds'] += random_number 
    

    current_datetime = datetime.now()
    formatted_time = current_datetime.strftime("%Y-%m-%d %I:%M %p")
    if (random_number > 0):
        output = f"Earned {random_number} golds from the {form}! ({formatted_time})"
    else:
        output = f"Entered a casino and lost {abs(random_number)} golds... Ouch.. ({formatted_time})" 
    session['activities'].insert(0,output)
    return redirect(url_for("index"))      


@app.route('/destroy_session')
def clear_session():
    session.clear() 
    return redirect("/")

if __name__ == "__main__":
    app.run(debug=True)
import sys
import random 
from flask import Flask, render_template, redirect, session, request
app = Flask(__name__)
app.secret_key = "my_key"

@app.route('/')
def welcome():
    if 'number' not in session :                   
        session['number'] = random.randint(1, 100) 	
    if 'tries' not in session :                    
        session['tries'] = 0
    print(session)
    print("*"*80)
    sys.stdout.flush() 
    return render_template("welcome.html")

# Easy game
@app.route('/easy')
def easy():
    return render_template("easy.html")

# Hard game
@app.route('/hard')
def hard():
    if 'winners' not in session:
        session['winners'] = []
    if 'limit' not in session :                    
        session['limit'] = 5
        session['type'] = 'hard'
    print(session)
    print("*"*80)
    sys.stdout.flush() 
    return render_template("hard.html")

@app.route('/guess_from_user', methods=['POST'])
def check_number():
    # Check the limitation counter for hard game
    if 'limit' in session :
        if (session['limit'] > 0):
            session['limit'] -= 1
    session['tries'] += 1                                                        
    session['user_number'] = int(request.form['user_number'])                    
    if (session['number']- 10 <= session['user_number'] < session['number'] ):   
        session['result'] = 'Low'
    elif (session['number']  < session['user_number'] <= session['number'] + 10): 
        session['result'] = 'High'
    elif (session['user_number'] > session['number']):                         
        session['result'] = 'Too high !'
    else:                                                                      
        session['result'] = 'Too low !'
    return redirect('/show_result')
@app.route('/show_result')
def show():
    if ('limit' in session and session['limit'] == 0):
        if (session['user_number'] == session['number']):
            return render_template("success.html")
        else:
            return render_template ("limit_fail.html") 
    if (session['user_number'] == session['number']): 
        return render_template("success.html")
    else:
        return render_template("fail.html")            
    

@app.route('/destroy_session')
def clear_session():
    item_to_keep = session.get('winners', None)
    session.clear()
    if item_to_keep is not None:
        request.session['winners'] = item_to_keep
    return redirect("/")

@app.route('/leaderboard', methods=['post'])
def leaderbord():
    winners = session['winners']
    name = request.form['winner_name']
    print(name)
    print("*"*80)
    sys.stdout.flush()
    if (name not in session['winners']):
        print("ADD new one")
        sys.stdout.flush()
        win_record = {'name':name,'tries':session['tries']}
        winners.append(win_record)
        session['winners'] = winners
        print ("NEW LIST :")
        print(session['winners'])
        sys.stdout.flush()
    else: 
        print("Update if need")
        sys.stdout.flush()
        if session['winners'][name] > session['tries']:
            session['winners'][name] =  session['tries']
        print ("Updated LIST :")
        print(session['winners'])
        sys.stdout.flush()
    return redirect("/show_leaderboard" )
    
@app.route('/show_leaderboard')
def show_leaderbord():
    winners = session['winners']
    winners.sort(key=lambda x: x['tries'])
    return render_template("leaderboard.html", winners = session['winners'])

@app.route('/back_home')
def back_home():
    del session['limit']
    del session['number']
    del session['tries']
    return redirect('/')

if __name__ == "__main__":
    app.run(debug=True)
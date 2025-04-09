from flask import Flask, render_template, redirect, session, request
app = Flask(__name__)
app.secret_key = "my_key"


@app.route('/')
def index():
    if 'actual_visits'  not in session and 'visits'  not in session:
        session['actual_visits'] = 1 
        session['visits'] = 1
    else:
        
        session['actual_visits'] += 1
        session['visits'] += 1
    return render_template("index.html")

# Add two visits
@app.route('/add_two')
def add2():
    session['visits'] += 2 
    return redirect("/counter")

# Reset visits
@app.route('/reset')
def reset():
    session['visits'] = 1 
    return redirect("/counter")


@app.route('/destroy_session')
def clear_session():
    session.clear() 
    return redirect("/")

@app.route('/increment_by', methods=['POST'])
def increment_by():
    if (request.form['increment_by_number'] != ''):
        number = int(request.form['increment_by_number']) 
    else:
        number = 0
    session['visits'] += number 
    return redirect("/counter")


@app.route('/counter')
def display_page():
    return render_template("index.html")

if __name__ == "__main__":
    app.run(debug=True)
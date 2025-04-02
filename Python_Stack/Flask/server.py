# Flask : Micro framework

from flask import Flask  # Import Flask to allow us to create our app
app = Flask(__name__)    # Create a new instance of the Flask class called "app"

@app.route('/')          # The "@" decorator associates this route with the function immediately following
def landing_page():
    return 'Hello World!'  # Return the string 'Hello World!' as a response

@app.route('/Champion')          # The "@" decorator associates this route with the function immediately following
def Champion():
    return 'Champion!'  # Return the string 'Hello World!' as a response

@app.route('/Say/<name>')        
def Say(name):
    return  f'Hi {name} '  #or addition (+) way to return like as nasri


@app.route('/repeat/<int:id>/<name>')
def detail_page(id ,name):
    fulltext = f' "{name}" {id} times'
    return fulltext

@app.errorhandler(404)  
def page_not_found(e):
    return "Sorry! No response. Try again.", 404



if __name__=="__main__":   # Ensure this file is being run directly and not from a different module    
    app.run(debug=True)    # Run the app in debug mode.


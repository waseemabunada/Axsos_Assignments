from flask import Flask ,render_template , request, redirect
app=Flask(__name__)
@app.route('/')
def index_dojo():
    return render_template("index.html")
@app.route('/result', methods=['post'])
def create_user_info():
    name=request.form['name']
    Locations=request.form['Locations']
    languages=request.form['languages']
    dojo=request.form['dojo']
    return render_template ('result.html',name=name,Locations=Locations,languages=languages,dojo=dojo)

# @app.route('/goBack')
# def return_main():
#     return render_template('index.html')

if __name__=="__main__":
    app.run(debug=True)
from django.shortcuts import render, redirect
from . import models
import bcrypt
from django.contrib import messages

# Root route render a page where users can register or log in
def index(request):
    if 'login' not in request.session:
        request.session['login'] = False
    return render(request,"index.html")

# Function to handle Registration
def register(request):
    if request.method == 'POST':
        errors = models.User.objects.basic_validator(request.POST)
        if len(errors) > 0:
        # If the errors dictionary contains anything redirect the user back to the form to fix the errors
            context = {'errors':errors}
            return render(request,'index.html',context)
        else:
            # If the errors object is empty, that means there is no errors!
            user = models.register(request.POST)
            request.session['login'] = True
            request.session['user_id'] = user.id 
            request.session['email'] = user.email
            return redirect("/shows")

def open_home(request):
    if request.session['login'] == True:
        # If the user is logged in, then go to home page
        if 'user_id' in request.session:
            context = {
                'user':models.get_user(request.session['email']),
                'shows':models.get_all_shows(),
                }
            return render(request,"home.html",context)
    else: 
        # Else render a template containing the SweetAlert message and go back to root route
        return render(request, "not_logged_in.html")

# Log out 
def logout(request):
    request.session.clear()
    request.session['login'] = False
    return redirect('/')

# Log in 
def login(request):
    errors = {}
    if request.method == 'POST':
        # Check the email address
        if (models.is_exists(request.POST['email'])):
            # If the email in database, then check the password
            user = models.get_user(request.POST['email'])
            # use bcrypt's check_password_hash method, passing the hash from our database and the password from the form
            if bcrypt.checkpw(request.POST['password'].encode(), user.password.encode()):
                # if we get True after checking the password, we put the user id and email in session
                request.session['user_id'] = user.id
                request.session['login'] = True
                request.session['email'] = user.email
                return redirect('/shows')
            else: 
                # Wrong password
                errors['login_password'] = 'Incorrect password please try again'
                context = {'errors':errors}
                return render(request,'index.html',context)
        # Email is not in database
        else:
            errors['login_email'] = 'Invalid Email address'
            context = {'errors':errors}
            return render(request,'index.html',context)       
        

# ******************** C (Create) from CRUD ********************
# Function to display page that allows us to create new show
def create(request):
    if request.session['login'] == True:
        if 'des' in request.session:
            desc = request.session['des']
        else:
            desc =""
        context = {'user':models.get_user(request.session['email']),'des':desc}
        return render(request, "new.html", context)
    else: 
        # Else render a template containing the SweetAlert message and go back to root route
        return render(request, "not_logged_in.html")

# Function to add new show to the table
def add(request):
    if request.session['login'] == True:
        if request.method == 'POST':
            errors = models.Show.objects.basic_validator(request.POST)
            if len(errors) > 0:
            # If the errors dictionary contains anything, loop through each key-value pair and make a flash message
                for key, value in errors.items():
                    messages.error(request, value)
                # Redirect the user back to the form to fix the errors
                request.session['des'] = request.POST['description']
                return redirect("/shows/new")
            else:
                # If the errors object is empty, that means there were no errors!
                # Retrieve the show to be created
                show_id = str(models.add(request.POST,request.session['user_id'])) 
                return redirect("/shows/"+show_id)
    else: 
        # Else render a template containing the SweetAlert message and go back to root route
        return render(request, "not_logged_in.html")

# ******************** R (Read one) from CRUD ********************
# Function to show details of one TV show
def show_details(request, id):
    if request.session['login'] == True:
        context = {
            'show':models.get_info(id),
            'comments':models.get_all_comments(id),
            'user':models.get_user(request.session['email'])
            }
        print(context)
        return render(request, "show_info.html", context)
    else: 
        # Else render a template containing the SweetAlert message and go back to root route
        return render(request, "not_logged_in.html")

# ******************** R (Read all) from CRUD ********************
# Function to render a page that diplay all shows in show table
def shows(request):
    if request.session['login'] == True:
        context = {'shows':models.get_all_shows()}
        return render(request, "shows.html",context)
    else: 
        # Else render a template containing the SweetAlert message and go back to root route
        return render(request, "not_logged_in.html")

# ******************** U (Update) from CRUD ********************
# Function to render page that allows us to update show information
def edit(request,id):
    if request.session['login'] == True:
        context = {'show':models.get_info(id)}
        return render(request,"edit_show.html", context)
    else: 
        # Else render a template containing the SweetAlert message and go back to root route
        return render(request, "not_logged_in.html")

# Function to update show data
def update(request):
    if request.session['login'] == True:
        if (request.method == 'POST'):
            id = request.POST['id']
            errors = models.Show.objects.basic_validator(request.POST)
            if len(errors) > 0:
            # If the errors dictionary contains anything, loop through each key-value pair and make a flash message
                for key, value in errors.items():
                    messages.error(request, value)
                # Redirect the user back to the form to fix the errors
                return redirect("/shows/"+id+"/edit")
            else:
                # If the errors object is empty, that means there were no errors!
                # Retrieve the show to be updated, make the changes, and save
                show_id = str(models.update(request.POST))
                return redirect("/shows/"+show_id)
    else: 
        # Else render a template containing the SweetAlert message and go back to root route
        return render(request, "not_logged_in.html")
    
# ******************** D (Update) from CRUD ********************
def destroy(request, id):
    models.delete(id)
    return redirect("/shows")

# ***************************************************************
# Add Comment 
def add_comment(request):
    if request.session['login'] == True:
        if (request.method == 'POST'):
            models.add_comment(request.POST,request.session['user_id'])
            id = request.POST['id']
            return redirect("/shows/"+id)
    else: 
        # Else render a template containing the SweetAlert message and go back to root route
        return render(request, "not_logged_in.html")

# Delete a comment 
def delete_comment(request):
    if request.session['login'] == True:
        if (request.method == 'POST'):
            models.delete_comment(request.POST)
            id = request.POST['id']
            return redirect("/shows/"+id)
    else: 
        # Else render a template containing the SweetAlert message and go back to root route
        return render(request, "not_logged_in.html")
from django.db import models
import datetime
import re	
import bcrypt

# Add Validation FOR User table
class UserManager(models.Manager):
    # Function to check data from form before add it in table
    def basic_validator(self, postData):
        errors = {}
        # add keys and values to errors dictionary for each invalid field
        # Check first name
        if len(postData['first_name']) < 2:
            errors["first_name"] = []
            errors["first_name"].append("First Name should be at least 2 characters")
        if postData['first_name'].isalpha() == False:
            if "first_name" not in errors:
                errors["first_name"] = []
            errors["first_name"].append("First Name cannot contain numbers or special characters")
        # Check last name
        if len(postData['last_name']) < 2:
            errors["last_name"] = []
            errors["last_name"].append("last Name should be at least 2 characters")
        if postData['last_name'].isalpha() == False:
            if "last_name" not in errors:
                errors["last_name"] = []
            errors["last_name"].append("Last Name cannot contain numbers or special characters")
        # Check email
        EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')
        if not EMAIL_REGEX.match(postData['email']):# test whether a field matches the pattern  
            errors["email"] = []
            errors["email"].append("Invalid email address!")
        if is_exists(postData['email']):
            if "email" not in errors:
                errors["email"] = []
            errors["email"].append("The email address you provided is already associated with an existing account. Please choose a different email address or log in if you already have an account.")
        # Check password
        if len(postData['password']) < 8:
            errors["password"] = "Password should be at least 8 characters long"
        # Check confirm password
        if postData['password'] != postData['c_password']:
            errors["c_password"] = "Confirm password should be the same as password"
        # Check birthday 
        current_time = datetime.datetime.today()
        birthday = datetime.datetime.strptime(postData['birthday'],'%Y-%m-%d')
        if birthday > current_time:
            errors["birthday"] = "Birthday cannot be in future"               
        elif birthday.year > current_time.year - 13:
            errors["birthday"] = "Your age should be at least 13 years old"        
        return errors

# Create User table in database
class User(models.Model):
    first_name = models.CharField(max_length=255)
    last_name = models.CharField(max_length=255)
    email = models.EmailField()
    password = models.CharField(max_length=50)
    birthday = models.DateField()
    create_at = models.DateTimeField(auto_now_add =True)
    updated_at = models.DateTimeField(auto_now=True)
    objects = UserManager() 

    # Hash the password before saving
    def save(self, *args, **kwargs):
        if self.password:
            self.password = bcrypt.hashpw(self.password.encode(), bcrypt.gensalt()).decode()
        super().save(*args, **kwargs)

# Add Validation for show table
class ShowManager(models.Manager):
    # Function to check data from form before add it in table
    def basic_validator(self, postData):
        errors = {}
        # add keys and values to errors dictionary for each invalid field
        # Check title
        if len(postData['title']) < 3:
            errors["title"] = []
            errors["title"].append("Show title should be at least 3 characters")
        # If we update show we can get its id to exclude it from filtering 
        if 'id' in postData:
            id = postData['id']
        else:
        # If we create new one then show is still doesn't have id 
            id = None
        if check_if_exists(postData['title'],id):
            # Before adding new error check if the title in the error dictionary 
            if "title" not in errors:
                errors["title"] = []
                errors["title"].append("This show title is exists! it should be unique")
        # Check Network
        if len(postData['network']) < 3:
            errors["network"] = "Network nameshould be at least 3 characters long"
        # Check Release date
        relase_date = datetime.datetime.strptime(postData['release_date'],'%Y-%m-%d')
        if relase_date > datetime.datetime.today():
            errors["release_date"] = "Release date cannot be in the future"
        # Check Description
        if len(postData['description']) < 3:
            errors["description"] = "Description should be at least 3"
        return errors
    
    # Function to check if the show title is exists or not 
def check_if_exists(title, id=None):
    if id is not None:
        return Show.objects.filter(title=title).exclude(id=id).exists()
    else:
        return Show.objects.filter(title=title).exists()

# Snice we have additional information about relation we should sperate the many to many relationship
# Create Show table in database
# class Show(models.Model):
#     title = models.CharField(max_length=255)
#     network = models.CharField(max_length=255)
#     release_date = models.DateField()
#     description = models.CharField(max_length=255)
#     create_at = models.DateTimeField(auto_now_add =True)
#     updated_at = models.DateTimeField(auto_now=True)
#     recommended_by = models.ForeignKey(User, related_name="shows_recommendation", on_delete=models.CASCADE,null=True)
#     users_who_comment = models.ManyToManyField(User, related_name="comments_shows")
#     objects = ShowManager() 

class Show(models.Model):
    title = models.CharField(max_length=255)
    network = models.CharField(max_length=255)
    release_date = models.DateField()
    description = models.CharField(max_length=255)
    create_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    recommended_by = models.ForeignKey(User, related_name="shows_recommendation", on_delete=models.CASCADE, null=True)
    objects = ShowManager()

# Add the intermidate table
class Comment(models.Model):
    user = models.ForeignKey(User, on_delete=models.CASCADE,related_name='user_comments')
    show = models.ForeignKey(Show, on_delete=models.CASCADE, related_name='comments')
    text = models.TextField()
    created_at = models.DateTimeField(auto_now_add=True)

# ******************** C (Create) from CRUD ********************
# This functions is used to add a new show to the Show table 
def add(request_data,user_id):
    user = get_user_by_id(user_id)
    title = request_data['title']
    network = request_data['network']
    release_date = request_data['release_date']
    description = request_data['description']
    new_show = Show.objects.create(title=title, network=network, release_date=release_date, description=description,recommended_by=user)
    return new_show.id

# ******************** R (Read one) from CRUD ********************
# This function will reuturn a show information by its ID
def get_info(id):
    show = Show.objects.get(id=id)
    return show

# ******************** R (Read all) from CRUD ********************
# This function is used to return all shows information to display them 
def get_all_shows():
    return Show.objects.all()

# ******************** U (Update) from CRUD ********************
# Update show data
# **First we need to get new data from form 
#   Note if the user didn't add anything the value will be the old data
# ** Get show entity 
# ** Update values of entity then save 
# ** Return id to go to shows/show_id
def update(request_data):
    id = int(request_data['id'])
    title = request_data['title']
    network = request_data['network']
    release_date = request_data['release_date']
    description = request_data['description']
    show = get_info(id)
    show.title = title
    show.network = network
    show.release_date = release_date
    show.description = description
    show.save()
    return id 

# ******************** D (Update) from CRUD ********************
# This function is used to delete specific show by getting its ID
def delete(id):
    show = get_info(id)
    show.delete()

# ******************** Register and Login ********************
# This functions is used to add a new show to the Show table 
def register(request_data):
    first_name = request_data['first_name']
    last_name = request_data['last_name']
    email = request_data['email']
    password = request_data['password'] # Hash password
    birthday = request_data['birthday']
    user = User.objects.create(first_name=first_name, last_name=last_name, email=email, password=password, birthday=birthday)
    return user

# Get user by email
def get_user(email):
    try:
        user = User.objects.get(email=email)
        print("TYPE of user object", type(user))
        return user
    except User.DoesNotExist:
        print("User with email {} does not exist".format(email))
        return None  # Or you can raise an exception if needed

# Function to check if the show email is exists or not 
def is_exists(email):
    return User.objects.filter(email=email).exists()

# To get a specific user by using user id
def get_user_by_id(id):
    return User.objects.get(id = id)

# To get a specific user by using user id
def get_show_by_id(id):
    return Show.objects.get(id = id)

# Add comment 
def add_comment(request_data, user_id):
    show_id = request_data['id']
    user = get_user_by_id(user_id)
    show = get_show_by_id(show_id)
    text = request_data['comment']
    Comment.objects.create(user=user, show=show, text=text)

# Get show comments 
def get_all_comments(show_id):
    show = get_show_by_id(show_id)
    return show.comments.all().order_by('-created_at')

# Delete a comment
def delete_comment(request_data):
    id = request_data['comment_id']
    comment = Comment.objects.get(id=id)
    comment.delete()
    
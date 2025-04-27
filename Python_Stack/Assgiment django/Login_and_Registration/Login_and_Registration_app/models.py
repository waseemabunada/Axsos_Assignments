from django.db import models
import datetime
import re
import bcrypt

# Add Validation 
class UserManager(models.Manager):
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
        if postData['password'] != postData['confirm_password']:
            errors["confirm_password"] = "Confirm password should be the same as password"

        # Check birthday 
        current_time = datetime.datetime.today()
        birthday = datetime.datetime.strptime(postData['birthday'],'%Y-%m-%d')
        if birthday > current_time:
            errors["birthday"] = "Birthday cannot be in future"               
        elif birthday.year > current_time.year - 13:
            errors["birthday"] = "Your age should be at least 13 years old"        
        return errors


# Create your models here.
class User(models.Model):
    first_name = models.CharField(max_length=50)
    last_name = models.CharField(max_length=50)
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

# ******************** Create ********************
# This functions is used to add a new show to the Show table 
def register(request_data):
    first_name = request_data['first_name']     # (attribute of the class =request_data ['key'])
    last_name = request_data['last_name']
    email = request_data['email']
    password = request_data['password']   # Hash password
    birthday = request_data['birthday']
    user = User.objects.create(first_name=first_name, last_name=last_name, email=email, password=password, birthday=birthday)
    return user

def get_user(email):
    try:
        user = User.objects.get(email=email)
        print("TYPE of user object", type(user))
        return user
    except User.DoesNotExist:
        print("User with email {} does not exist".format(email))
        return None  

    
# Function to check if the show email is exists or not 
def is_exists(email):
    return User.objects.filter(email=email).exists()
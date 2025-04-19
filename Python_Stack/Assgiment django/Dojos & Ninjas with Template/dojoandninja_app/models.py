from django.db import models
# Create your models here.
class Dojo(models.Model):
    name = models.CharField(max_length=25)
    city = models.CharField(max_length=255)
    state = models.CharField(max_length=20)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

class Ninja(models.Model):
    first_name = models.CharField(max_length=25)
    last_name = models.CharField(max_length=25)
    dojo = models.ForeignKey(Dojo, related_name="ninjas", on_delete=models.CASCADE)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

# This function is used to add dojo to the database
def create_dojo(request):
    Dojo.objects.create(name=request['name'], city=request['city'], state=request['state'])

def create_ninja(request):
    Ninja.objects.create(first_name=request['first_name'], last_name=request['last_name'], dojo_id=request['dojo_id'])   
# This function is used to get all dojos from the database
def get_dojos():
    return Dojo.objects.all() 

def get_ninjas():
    return Ninja.objects.all()     

def delete_dojo(request):
    dojo = Dojo.objects.get(id=request['dojo_id'])
    dojo.delete()

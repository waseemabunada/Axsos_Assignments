from django.db import models

# Create your models here.

class User(models.Model):
    first_name = models.CharField(max_length=255)
    last_name = models.CharField(max_length=255)
    email_address = models.CharField(max_length=255)
    age = models.IntegerField()
    created_At = models.DateTimeField(auto_now_add=True)
    updated_At = models.DateTimeField(auto_now_add=True)
    
    

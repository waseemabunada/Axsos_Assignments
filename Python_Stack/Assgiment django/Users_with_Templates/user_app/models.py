from django.db import models

# Create your models here.
class UserProfile(models.Model):
    first_name = models.CharField(max_length=30)
    last_name = models.CharField(max_length=30)
    email = models.EmailField(max_length=254, unique=True)
    Age = models.IntegerField()
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

    def create_user(post_data):
        user = UserProfile.objects.create(
            first_name=post_data['first_name'],
            last_name=post_data['last_name'],
            email=post_data['email'],
            Age=post_data['age']
        )
        return user

    def getallusers():
        users = UserProfile.objects.all()
        return users
from django.shortcuts import render

def index(request):
    return render(request, "form.html")  # عرض الصفحة الرئيسية مع النموذج

def create_user(request):
    if request.method == "POST":
        name_from_form = request.POST['name']  # الحصول على الاسم
        email_from_form = request.POST['email']  # الحصول على البريد الإلكتروني
        print(name_from_form)  
        print(email_from_form)  
        context = {
            "name_on_template": name_from_form,
            "email_on_template": email_from_form
        }
        
        return render(request, "show.html", context)  # عرض البيانات في صفحة جديدة
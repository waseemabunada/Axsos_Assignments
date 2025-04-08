from django.shortcuts import redirect, render

def root(request):
    return render(request,"login.html")

def result(request):
    if request.method == "POST":
        form_name=request.POST["name"]
        form_location=request.POST["location"]
        form_language=request.POST["language"]
        form_comment=request.POST["comment"]
        context={
            "name":form_name,
            "location":form_location,
            "language":form_language,
            "comment":form_comment,
        }
        return render(request,"result.html", context) 
    
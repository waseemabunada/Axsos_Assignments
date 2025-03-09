function bu(el) {
    el.remove(); // حذف الزر الذي تم النقر عليه
}
 var was=document.querySelector(".search-button")
was.onclick = function () {
    if (was.textContent.trim().toLowerCase() === "login") { 
        was.textContent = "Logout";
    } else {
        was.textContent = "Login";
    }
};
function increaseLikes(button) {
    let currentLikes = parseInt(button.textContent);
  
    alert("Ninja was liked");
    //  for loop لزيادة العدد
    for (let i = 0; i < 1; i++) {  
        currentLikes += 1;  
    }
   
    button.textContent = currentLikes + " likes"; // تحديث النص
}
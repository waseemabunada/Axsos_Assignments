console.log("page loaded...");

//DEL
function closeRequest(element) {
    element.parentElement.parentElement.remove()
    document.getElementById("connectionRequests").innerText = Number(document.getElementById("connectionRequests").innerText) - 1
}
//acceptRequest
function acceptRequest(element) {
    addperson(element.parentElement.parentElement.firstChild.nextElementSibling.firstElementChild)
    element.parentElement.parentElement.remove()
    document.getElementById("connectionRequests").innerText = Number(document.getElementById("connectionRequests").innerText) - 1
    document.getElementById("connectionNumber").innerText = Number(document.getElementById("connectionNumber").innerText) + 1

}

//changeName
function changeName(element) {
    document.getElementById("personName").innerText = prompt("Enter a new Name")
}

  //زيادة
function addperson(img) {
    personname = img.nextSibling.textContent
    newperson = `<li class="card-list-item start">` + img.outerHTML + personname + `</li>`


    document.getElementById("friendsList").innerHTML = document.getElementById("friendsList").innerHTML + newperson
}
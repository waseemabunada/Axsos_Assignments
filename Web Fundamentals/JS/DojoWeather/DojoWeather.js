function myFunction(el) {
    alert("Loading weather report");
  }

  function hideSection() {
    document.getElementById("cookieSection").style.display = "none";
}
function convertTemperature() {
    let unit = document.getElementById("tempSelect").value;
    let highTemps = document.querySelectorAll(".high-temp");
    let lowTemps = document.querySelectorAll(".low-temp");

    highTemps.forEach(temp => {
        let currentTemp = parseInt(temp.textContent); 
        if (unit === "f") {
            temp.textContent = Math.round((currentTemp * 9/5) + 32) + "°";
        } else {
            temp.textContent = Math.round((currentTemp - 32) * 5/9) + "°";
        }
    });

    lowTemps.forEach(temp => {    // كل عنصر يتم تمريره في التكرار يتم تسميته temp عبارة عن فور لوب 
        let currentTemp = parseInt(temp.textContent);
        if (unit === "f") {
            temp.textContent = Math.round((currentTemp * 9/5) + 32) + "°";
        } else {
            temp.textContent = Math.round((currentTemp - 32) * 5/9) + "°";
        }
    });
}

















// for (let i = 0; i < highTemps.length; i++) {
//     let currentTemp = parseInt(highTemps[i].textContent); 
//     if (unit === "f") {
//         highTemps[i].textContent = Math.round((currentTemp * 9 / 5) + 32) + "°";
//     } else {
//         highTemps[i].textContent = Math.round((currentTemp - 32) * 5 / 9) + "°";
//     }
// }
// for (let i = 0; i < lowTemps.length; i++) {
//     let currentTemp = parseInt(lowTemps[i].textContent);
//     if (unit === "f") {
//         lowTemps[i].textContent = Math.round((currentTemp * 9 / 5) + 32) + "°";
//     } else {
//         lowTemps[i].textContent = Math.round((currentTemp - 32) * 5 / 9) + "°";
//     }
// }
// }



//shatha way
// function convertTemperature(){
// if(Selection.value)
//     if(Selection.value=="c"){
//         var result =Math.round((el.innerText - 32) *5/9)
//         el.innerText=Math.trunc(result) }
//     }
//     else if(Selection.value=="F"){
//         var result =Math.round((el.innerText * 9/5) + 32)
//         el.innerText=Math.trunc(result) }
//     }
// }
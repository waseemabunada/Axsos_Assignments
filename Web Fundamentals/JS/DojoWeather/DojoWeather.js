function myFunction() {
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

    lowTemps.forEach(temp => {
        let currentTemp = parseInt(temp.textContent);
        if (unit === "f") {
            temp.textContent = Math.round((currentTemp * 9/5) + 32) + "°";
        } else {
            temp.textContent = Math.round((currentTemp - 32) * 5/9) + "°";
        }
    });
}

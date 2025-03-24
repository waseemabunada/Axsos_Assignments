
document.getElementById("searchIcon").addEventListener("click", function () {
    let searchValue = document.getElementById("search").value;
    alert("Search input: " + searchValue);
});

document.getElementById("sound-img").addEventListener("click", function () {
    document.getElementById("audio").play();
});


const button = document.querySelector(".Inside-the-picture button");
button.addEventListener("mouseover", () => {
    button.style.backgroundColor = "white";
    button.style.color = "hsl(4.03deg 70.62% 58.63%)";
});
button.addEventListener("mouseout", () => {
    button.style.backgroundColor = "";
    button.style.color = "";
});



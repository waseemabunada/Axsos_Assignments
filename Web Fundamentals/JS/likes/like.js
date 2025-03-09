function likes(el) {
    var likeText = el.previousElementSibling;
    var likeCount = parseInt(likeText.textContent);

    for (var i = 0; i < 1; i++) {  
        likeCount++;
    }

    likeText.textContent = likeCount + " like(s)";
}

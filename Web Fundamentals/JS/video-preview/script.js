document.addEventListener("DOMContentLoaded", function () {
    const videos = document.querySelectorAll("video");

    videos.forEach(video => {
        video.muted = true; // تأكد أن الفيديو مكتوم عند التشغيل
    });
});
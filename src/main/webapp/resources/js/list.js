$(document).ready(function() {
  $("#roomListBtn").on("click", function() {
    $("#roomlist").get(0).scrollIntoView({ behavior: "smooth" });
  });
});
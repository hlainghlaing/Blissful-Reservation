/**
 * 
 */
$(document).ready(function () {
	 var url = window.location.href;
    // Add the active class to the corresponding navigation item
    $("nav ul li a").each(function() {
      if (url === (this.href)) {
        $(this).addClass("active");
      }
    });
    
    $('.menu-toggle').on('click', function () {
        $(this).toggleClass('active');
        $('.g-nav').toggleClass('is-show');
    });
});
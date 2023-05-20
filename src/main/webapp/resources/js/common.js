/**
 * 
 */
$(document).ready(function () {
    $('.menu-toggle').on('click', function () {
        $(this).toggleClass('active');
        $('.g-nav').toggleClass('is-show');
    });
});
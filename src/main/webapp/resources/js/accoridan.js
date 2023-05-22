$(document).ready(function() {
  $('.faq-question').click(function() {
    $('.faq-question').not(this).removeClass('active');
    $('.faq-answer').not($(this).find('.faq-answer')).slideUp();

    $(this).toggleClass('active');
    var answer = $(this).find('.faq-answer');
    answer.slideToggle();
  });
});


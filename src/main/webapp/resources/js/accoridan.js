$(document).ready(function() {
    $('.faq-question .icon').click(function(e) {
      e.stopPropagation();

      var question = $(this).closest('.faq-question');
      var answer = question.find('.faq-answer');

      question.toggleClass('active');
      answer.slideToggle();
    });
  });



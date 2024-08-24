include("jquery-1.11.0.min.js");
window.jQuery || document.write('<script src="jquery-1.11.0.min.js"><\/script>')
$(window).load(function() {
    $('.loader-item').fadeOut();
    $('#pageloader').delay(350).fadeOut('slow');
    $('body').delay(350).css({'overflow-y':'visible'});
})

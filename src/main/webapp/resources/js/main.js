
/* 슬라이드 쇼 관련 자바스크립트 */
var slideIndex = 1;
showSlides(slideIndex);

function plusSlides(n) {
  showSlides(slideIndex += n);
}

function currentSlide(n) {
  showSlides(slideIndex = n);
}

function showSlides(n) {
  var i;
  var slides;
  var dots;

  $(document).ready(function(){
	  
	  $(document).find('#picture1').css('background-image', 'url(./resources/image/img_nature_wide.jpg)');
	  $(document).find('#picture2').css('background-image', 'url(./resources/image/img_snow_wide.jpg)');
	  $(document).find('#picture3').css('background-image', 'url(./resources/image/img_mountains_wide.jpg)');
	  
	  slides = $(document).find('.mySlides');
	  dots = $(document).find('.dot');
	  	  
	  if (n > slides.length) {slideIndex = 1}
	  if (n < 1) {slideIndex = slides.length}

	  slides.each(function() {
		 $(this).css('display', 'none'); 
	  });
	  
	  dots.each(function() {
		 $(this).removeClass('active');
	  });
	  
	  slides.eq(slideIndex-1).css('display', 'block');
	  dots.eq(slideIndex-1).addClass('active');
  });

}
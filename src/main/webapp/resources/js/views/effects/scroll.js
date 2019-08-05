window.onscroll = function() {scrollFunction()};

function scrollFunction() {

	var divEl = $(".makers_contents");
	var divY = divEl.position().top;
	var divUs = $(".makers_profile");
	
  if (divY - document.body.scrollTop < $(window).height() - 200 || divY - document.documentElement.scrollTop <  $(window).height() - 200) {
	  divEl.addClass("makers_contents_animate");
	  divUs.addClass("makers_profile_animate");
    
  } else {
	  divEl.removeClass("makers_contents_animate");
	  divUs.removeClass("makers_profile_animate");
  }
}
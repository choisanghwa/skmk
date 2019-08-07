var animating = false;

/* 효과적인 넘버링 이펙트 api 옵션 관련 */
window.odometerOptions = {
  format: '(,ddd)'
};

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

//Get the Sidebar
var mySidebar = document.getElementById("mySidebar");

// Get the DIV with overlay effect
var overlayBg = document.getElementById("myOverlay");

// Toggle between showing and hiding the sidebar, and add overlay effect
function w3_open() {
	if (mySidebar.style.display === 'block') {
		mySidebar.style.display = 'none';
		overlayBg.style.display = "none";
	} else {
		mySidebar.style.display = 'block';
		overlayBg.style.display = "block";
	}
}

// Close the sidebar with the close button
function w3_close() {
	mySidebar.style.display = "none";
	overlayBg.style.display = "none";
}

function openNav(boardName, navObj) {
	
	if(animating == false) {
		var elmnt;
		
		switch(boardName) {
			case 'dash_menu' : elmnt = document.getElementById("button_menu"); break;
			case 'dash_user' : elmnt = document.getElementById("button_user"); break;
			case 'dash_alerm' : elmnt = document.getElementById("button_alerm"); break;
			case 'dash_chart' : elmnt = document.getElementById("button_chart"); break;
			default : elmnt = null; break;
		}
		
		openBoard(boardName, elmnt);		
	}
}

function openBoard(boardName, elmnt) {
	var i, dashBoard, dash_buttons, navObj;

	$(".nav_items").removeClass("w3-blue");
	
	
	var bgColor = boardColor(boardName);

	dashBoard = document.getElementsByClassName("dashBoard");
	for (i = 0; i < dashBoard.length; i++) {
		dashBoard[i].style.display = "none";
	}
	dash_buttons = document.getElementsByClassName("dash_buttons");
	for (i = 0; i < dash_buttons.length; i++) {
		dash_buttons[i].style.backgroundColor = "";
	}

	document.getElementById(boardName).style.display = "block";		

	switch(boardName) {
		case 'dash_menu' : navObj = document.getElementById("nav_menu"); break;
		case 'dash_user' : navObj = document.getElementById("nav_user"); break;
		case 'dash_alerm' : navObj = document.getElementById("nav_alerm"); break;
		case 'dash_chart' : navObj = document.getElementById("nav_chart"); break;
		case 'dash_cart' : navObj = document.getElementById("nav_cart"); break;
		case 'dash_order' : navObj = document.getElementById("nav_order"); break;
	}
	navObj.classList.add("w3-blue");
}

function boardColor(boardName) {
	switch (boardName) {
	case "dash_alerm":
		return "#F44336";
		break;
	case "dash_chart":
		return "#2196F3";
		break;
	case "dash_menu":
		return "#009688";
		break;
	case "dash_user":
		return "#FF9800";
		break;
	}
}

//Open and close sidebar
function w3_open() {
	document.getElementById("mySidebar").style.display = "block";
	document.getElementById("mySidebar").style.display = "block";
	document.getElementById("myOverlay").style.display = "block";
}

function w3_close() {
	document.getElementById("mySidebar").style.display = "none";
	document.getElementById("mySidebar").style.display = "none";
	document.getElementById("myOverlay").style.display = "none";
}


$(window).resize(function() {
	if(window.outerWidth <= 992 ) {
		$('.w3-main').attr('style', 'margin-left : 0 !important;');
		document.getElementById("mySidebar").style.display = "none";
		document.getElementById("myOverlay").style.display = "none";
		
		$('.guestContent').removeClass("s9");
	} else {
		$('.w3-main').attr('style', 'margin-left : 300px !important;');
		document.getElementById("myOverlay").style.display = "none";
		document.getElementById("mySidebar").style.display = "block";
		$('.guestContent').addClass("s9");
	}
	
	if(window.outerWidth <= 768) {
		$("#commentTitle").addClass("w3-left");
	} else {
		$("#commentTitle").removeClass("w3-left");
	}
});

$(document).ready(function() {
	$(".nav_items").unbind().bind('click',function(event) {
		var id  = this.id;
		
		if(id == 'nav_month' || id == 'nav_product') {
			event.preventDefault();
			var hash = this.hash;	
		    if (animating == false) {
		    	$(".nav_items").removeClass("w3-blue");
		    	$(this).addClass("w3-blue");
		    	animating = true;
				$('html, body').animate({
					scrollTop : $(hash).offset().top
					}, 0, function() { window.location.hash = hash;
					animating = false;
				});
		    }
		}
	});
});


$(document).ready(function(){
	$(".product").click(function(){
        $("#foodModal").modal();
    });
});

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

function openBoard(boardName, elmnt) {
	var i, dashBoard, dash_buttons;

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
	elmnt.style.backgroundColor = color;

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
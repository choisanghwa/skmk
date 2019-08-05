
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


$('#submit_guestBook').click(function(e) {
	e.preventDefault();
	
	var inputData = $('#registerMemberForm')[0];
	var formData = new FormData(inputData);	
	var email = $('#inputEmail').val();
	
	if (CheckStringEmpty($("#inputName").val())) {
		alert('이름을 입력하세요');
		$("#inputName").focus();
		return false;
	} else if (CheckStringEmpty(email)) {
		alert('이메일을 입력하세요');
		$("#inputEmail").focus();
		return false;
	} else if (CheckEmail(email) == false) {
		alert('이메일 주소가 유효하지 않습니다. ex)abc@gmail.com');
		$("#inputEmail").focus();
		return false;
	} else if (CheckStringEmpty($("#inputPassword").val())) {
		alert('비밀번호를 입력하세요');
		$("#inputPassword").focus();
		return false;
	} else if (CheckStringEmpty($("#inputPasswordCheck").val())) {
		alert('비밀번호를 다시 한번 더 입력하세요');
		$("#inputPasswordCheck").focus();
		return false;
	} else if ($("#inputPassword").val() !== $("#inputPasswordCheck").val()) {
		alert('비밀번호를 둘다 동일하게 입력하세요');
		return false;
	} else if (CheckStringEmpty($("#inputMobile").val())) {
		alert('휴대폰 번호를 입력하세요');
		$("#inputMobile").focus();
		return false;
	} else if (($("#inputAgree").is(":checked") == false)) {
		alert('약관에 동의하셔야 합니다');
		return false;
	}
	else { // 무사히 모두 통과되면 회원가입 수행
		
		$.ajax({
			url : '../member/register',
			type : 'POST',
			data : formData,
			enctype : 'multipart/form-data',
			processData: false,
			contentType : false,
			cache : false,
			dataType : "text",
			success : function(data) {
				if(data == 1) {
					alert("회원 가입을 축하합니다.");
					location.href = "../login";
				} else if (data == 0) {
					alert("이미 가입된 아이디 입니다.");
				} else {
					alert("등록 중에 에러가 발생하였습니다.");
				}
			},
			error : function(value) {
				alert("AJAX Error!");
			}
		});
	}
});
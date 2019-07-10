var slideIndex = 1;

$(document).ready(function(){	
	// showFoodSlides(slideIndex); 
	$(".product").click(function(){
 		showFoodDetail($(this).attr("data-food"));
// 		$("#foodModal").modal();
		
    });
});

function CheckStringEmpty(value) {
	if (value == "" || value == null || value == undefined ||
			( value != null && typeof value == "object" && !Object.keys(value).length )) {
		return true;
	} else {
		return false;
	}
}

$(function() {
	// 상점 개설 처리
	$('#join-addFood').click(function(e) {
		e.preventDefault();
		var formData = new FormData($('#insertFoodForm')[0]);
		
		if (CheckStringEmpty($("#inputFoodName").val())) {
			alert('음식 이름을 입력하세요');
			$("#inputFoodName").focus();
			return false;
		} else if (CheckStringEmpty($("#inputFoodPrice").val())) {
			alert('음식 가격을 입력하세요');
			$("#inputFoodPrice").focus();
			return false;
		} else { // 무사히 모두 통과되면 회원가입 수행
			$.ajax({
				url : '../food/insertFood',
				type : 'POST',
				data : formData,
				enctype : 'multipart/form-data',
				processData: false,
				contentType : false,
				cache : false,
				dataType : "text",
				success : function(data) {
					if(data == 1) {
						alert("음식을 등록하였습니다.");
						location.href = "../main";
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
});





function plusSlides(n) {
  showFoodSlides(slideIndex += n);
}

function currentSlide(n) {
  showFoodSlides(slideIndex = n);
}

function showFoodSlides(n) {
	var i;
	var slides = document.getElementsByClassName("food-fullPicture");
	var dots = document.getElementsByClassName("demo");
	var captionText = document.getElementById("caption");
	if (n > slides.length) {
		slideIndex = 1
	}
	if (n < 1) {
		slideIndex = slides.length
	}
	for (i = 0; i < slides.length; i++) {
		slides[i].style.display = "none";
	}
	for (i = 0; i < dots.length; i++) {
		dots[i].className = dots[i].className.replace(" active", "");
	}
	slides[slideIndex - 1].style.display = "block";
	dots[slideIndex - 1].className += " active";
	captionText.innerHTML = dots[slideIndex - 1].alt;
}

function showFoodDetail(foodCode) {
	$.ajax({
		url : './food/getFoodDetail',
		type : 'POST',
		data : {"foodCode" : foodCode},
		dataType : "text",
		success : function(data) {
			alert("테스트 성공")
		},
		error : function(value) {
			alert("AJAX Error!");
		}
	});
}

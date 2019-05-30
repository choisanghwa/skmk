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

function CheckStringEmpty(value) {
	if (value == "" || value == null || value == undefined ||
			( value != null && typeof value == "object" && !Object.keys(value).length )) {
		return true;
	} else {
		return false;
	}
}

function CheckEmail(value) {
	var emailRegex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	return emailRegex.test(value);
}

$(function() {
	// 회원 가입 처리
	$('#join-submit').click(function(e) {
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
});
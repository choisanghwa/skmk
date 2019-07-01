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
	$('#join-create').click(function(e) {
		e.preventDefault();
	
		var formData = new FormData($('#registerShopForm')[0]);	

		if (CheckStringEmpty($("#inputShopName").val())) {
			alert('가게 이름을 입력하세요');
			$("#inputShopName").focus();
			return false;
		} else if (CheckStringEmpty($("#inputShopAddress").val())) {
			alert('가게 주소를 입력하세요');
			$("#inputShopAddress").focus();
			return false;
		} else if (CheckStringEmpty($("#inputShopLicense").val())) {
			alert('사업자 등록번호를 입력하세요');
			$("#inputShopLicense").focus();
			return false;
		} else if (($("#inputAgree").is(":checked") == false)) {
			alert('약관에 동의하셔야 합니다');
			return false;
		}
		else {
			
			$.ajax({
				url : '../shop/checkShopCode',
				type : 'GET',
				data : {"shopCode" : $("#inputShopCode").val()},
				
				dataType : "text",
				success : function(data) {
					if(data == 0) {
						$.ajax({
							url : '../shop/register',
							type : 'POST',
							data : formData,
							enctype : 'multipart/form-data',
							processData: false,
							contentType : false,
							cache : false,
							dataType : "text",
							success : function(data) {
								if(data == 1) {
									alert("상점 개설을 축하합니다.");
									location.href = "./successInsertShop";
								} else if (data == 0) {
									alert("상점 개설에  실패하였습니다.");
								} else {
									alert("개설 중에 에러가 발생하였습니다.");
								}
							},
							error : function(value) {
								alert("AJAX Error!");
							}
						});
					} else if (data == 0) {
						alert("이미 사용중인 URL 주소 입니다. 다시 확인해주십시오.");
					} else {
						alert("개설 중에 에러가 발생하였습니다.");
					}
				},
				error : function(value) {
					alert("AJAX Error!");
				}
			});
		}
	});
});

$(document).ready(function() {
	if($('#goLogin').length) {
		
	}
});

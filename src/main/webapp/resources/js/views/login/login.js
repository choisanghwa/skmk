
function CheckStringEmpty(value) {
	if (value == "" || value == null || value == undefined ||
			( value != null && typeof value == "object" && !Object.keys(value).length )) {
		return true;
	} else {
		return false;
	}
}


function loginProcess() {
	if(CheckStringEmpty($("#login").val())) {
		alert("이메일을 입력해 주세요.");
	} else if (CheckStringEmpty($("#password").val())) {
		alert("패스워드를 입력해 주세요.");
	}
	else {
		$.ajax({
			url : './login/loginProcess',
				type : 'POST',
				data : {
					memberMail:$("#login").val(),
					memberPassword:$("#password").val(),
				},
				dataType : "text",
				success : function(data) {
					if(data == 1) {
						alert("로그인 성공");
						location.href = "./main";
					} else {
						alert("로그인 실패");
					}
				},
				error : function(value) {
					alert("로그인 실패");
				}
		})
	}
}

$(document).ready(function() {
	$("#goLogin").click(function(){
		location.href="login";
	});
	
	$("#goRegisterMember").click(function(){
		location.href="login/registerMember";
	});
	
	$("#cancel-submit").click(function(){
		location.href="../login";
	});
	
	$("#login").keydown(function(key) {
        if (key.keyCode == 13) {
            loginProcess();
        }
    });
	
	$("#password").keydown(function(key) {
        if (key.keyCode == 13) {
            loginProcess();
        }
    });

	$("#loginMember").click(function() {
        loginProcess();
	});
	
	$("#logout").click(function() {
		location.href="./logout";
	});
	
	$("#goAddShop").click(function() {
		location.href = "./shop/goRegisterShop";
	});
	
	$("#goInsertFood").click(function() {
		location.href = "./food/goInsertFood";
	});
	
	$("#cancel-create").click(function() {
		location.href = "../main";
	});
	
	$("#cancel-addFood").click(function() {
		location.href = "../main";
	});
});

function main() {
	location.href = "./main";
}
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
});
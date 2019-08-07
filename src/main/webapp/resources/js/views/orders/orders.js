var isTimeOut = true;
var isMouseOverGoCart = true;
var isMouseOverAddCart = true;

function MouseEnterGoCart() {
	isMouseOverGoCart = false;
}

function MouseLeaveGoCart() {
	isMouseOverGoCart = true;
}

function MouseEnterAddCart() {
	isMouseOverAddCart = false;
}

function MouseLeaveAddCart() {
	isMouseOverAddCart = true;
}

$(document).ready(function() {
	$("#addCart").click(function() {
		$("#goCart").addClass("effect_tooltiptext_visible");
		isTimeOut = false;
		setTimeout(function() {
			isTimeOut = true;
			if(!isMouseOverGoCart != !isMouseOverAddCart) {
			} else {
				$("#goCart").removeClass("effect_tooltiptext_visible");
			}
		}, 3000);
	});
	
	$("#addCart").mouseleave(function() {
		if(isTimeOut == true) {
			$("#goCart").removeClass("effect_tooltiptext_visible");			
		}
	});
	
	$("#goCart").mouseleave(function() {
		if(isTimeOut == true) {
			$("#goCart").removeClass("effect_tooltiptext_visible");			
		}
	});
	
	$("#purchase").click(function() {
		location.href="orders/goOrders";
	});
	
	$("#cancel-order").click(function() {
		location.href = "../main";
	});
});
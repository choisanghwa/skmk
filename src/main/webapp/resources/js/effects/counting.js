$(document).ready(function(){	
	
	var count = 1;
	$("#countResults").html(count);
	
	$(".product").click(function(){
		count = 1;
		$("#countResults").html(count);
    });
	
	
	$("#addCount").click(function(){
		$("#countResults").html(++count);	
    });
	$("#removeCount").click(function(){
		if (count == 1) {
			$("#countResults").html(count);
		} else {
			$("#countResults").html(--count);	
		}
    });
});
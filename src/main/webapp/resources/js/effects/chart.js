$(document).ready(function() {
	setTimeout(move(), 10000);
});


function move() {
	var elem1 = document.getElementById("chart-newOrders");
	var elem2 = document.getElementById("chart-newCustomers");
	var elem3 = document.getElementById("chart-oldCustomers");
	
	var width1 = 0;
	var width2 = 0;
	var width3 = 0;
	
	var id1 = setInterval(frame1, 10);
	var id2 = setInterval(frame2, 10);
	var id3 = setInterval(frame3, 10);
	
	function frame1() {
		if (width1 == 25) {
			clearInterval(id1);
		} else {
			width1 = width1 + 0.5;
			elem1.style.width = width1 + '%';
			elem1.innerHTML = '+ ' + width1 * 1 + '%';
		}
	}
	
	function frame2() {
		if (width2 == 50) {
			clearInterval(id2);
		} else {
			width2 = width2 + 0.5;
			elem2.style.width = width2 + '%';
			elem2.innerHTML = '+ ' + width2 * 1 + '%';
		}
	}
	
	function frame3() {
		if (width3 == 75) {
			clearInterval(id3);
		} else {
			width3 = width3 + 0.5;
			elem3.style.width = width3 + '%';
			elem3.innerHTML = '+ ' + width3 * 1 + '%';
		}
	}
}
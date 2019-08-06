$(document).ready(function() {
	$("#makeQR").click(function() {
		$.ajax({
			url : './shop/makeQR',
				type : 'POST',
				dataType : "json",
				success : function(data) {
					if(data != null) {
						
						var result = data['shopQR'];
						if (result != null) {
							alert("QR 코드 생성 성공");
							$(".qr_title").html("<h5><b>등록된 qr 주소</b></h5>");
							$("#qr_codes").attr('src', './resources/image/qr/' + result);
							$("#qr_area").append("<button class='w3-button w3-dark-grey QRButtons'" +
									" id='printQR'>QR 코드 인쇄</button>");
							$("#makeQR").css('display', 'none');
						}
					} else {
						alert("QR 코드 생성 실패");
						$(".qr_title").html("<h5><b>qr 코드 생성 실패</b></h5>");
						$('#qr_image').attr('src', './resources/image/no_qr.jpg');
					}
				},
				beforeSend : function() {
					$('#qr_image').attr('src', './resources/image/loading.gif');
			    }, error : function(value) {
					alert("AJAX Error!");
					$(".qr_title").html("<h5><b>qr 코드 생성 실패</b></h5>");
					$('#qr_image').attr('src', './resources/image/no_qr.jpg');
				}
		})
	});	
	
	$(document).on("click", "#printQR", function(){
		$("#qr_codes").print({
			globalStyles: true,
			mediaPrint: false,
			stylesheet: null,
			noPrintSelector: ".no-print",
			iframe: true,
			append: null,
			prepend: null,
			manuallyCopyFormValues: true,
			deferred: $.Deferred(),
			timeout: 750,
			title: null,
			doctype: '<!doctype html>'
		});
	});
});

$(window).on('load', function () {
    load('#contentLoad', '1');
    $("#loadMore").on("click", function () {
        load('#contentLoad', '1', 'loadMore');
    })
});

function load(id, cnt, btn) {
    var contents_list = id + " .contentItem:not(.showed)";
    var contents_length = $(contents_list).length;
    var contents_total_count;
    if (cnt < contents_length) {
        contents_total_count = cnt;
    } else {
        contents_total_count = contents_length;
        $('.loadMore').hide();
    }
    $(contents_list + ":lt(" + contents_total_count + ")").addClass("showed");
}

$(function() {
	
	$("#submit_guestBook").click(function(e) {
		e.preventDefault();
		var formData = new FormData($('#guestBookForm')[0]);
		
		
		$.ajax({
			url : './guestBook/register',
			type : 'POST',
			data : formData,
			enctype : 'multipart/form-data',
			processData: false,
			contentType : false,
			cache : false,
			dataType : "json",
			success : function(data) {
				$(".contentList").prepend("<li class='w3-padding-16 w3-row contentItem showed' style='text-align:left;'>" +
						"<span class='w3-left w3-col s2 w3-large' style='margin-left:30px;'>" + data.guestList[0].guestBookTitle +
						 "</span><span class='w3-opacity w3-right' style='margin-left:20px;'>" + data.guestList[0].guestBookTime +
						" </span><p class='guestContent w3-right w3-col s9' style='margin-left:20px;'>" + data.guestList[0].guestBookContent +
						"</p><br></li>");
				var count = $(".button_user h3").text();
				$(".button_user h3").text(parseInt(count) + 1);
			},
			error : function(value) {
				alert("AJAX Error!");
			}
		});
	});
});
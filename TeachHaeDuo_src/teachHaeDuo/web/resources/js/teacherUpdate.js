/**
 * 
 */
/**
 * 
 */
$(function() {
	// 활동 지역
	$(".sel").change(
		function() {
			console.log($(".sel").val());
			var selVal = $(".sel").val();
			$("#active").append(
				"<div class='active_div'>" + "<span class='active_span'>"
				+ selVal + "</span>"
				+ "</div>" + "<input type='hidden' name='activeArea' value='" + selVal + "'>")
			var spantt = document.getElementsByClassName("active_span")
			console.log(spantt);
		});

	// 활동지역 초기화
	$("#area_reset").click(function() {
		console.log("초기화버튼");
		$(".active_div").nextAll().remove();
	});

	// 어학
	$("#language_plus_btn").click(
		function() {
			console.log("추가 버튼 눌렀어");
			$("#language_tr1").after(
				'<tr id="tr2" class="language_sel">' + '<td></td><td></td><td>'
				+ '<select name="language">'
				+ '<option value="">선택해주세요.</option>'
				+ '<option value="TOEIC">TOEIC</option>'
				+ '<option value="TOFEL">TOFEL</option>'
				+ '<option value="TEPS">TEPS</option>'
				+ '<option value="JPT">JPT</option>'
				+ '<option value="HSK">HSK</option></select>&nbsp;'
				+ '<input type="text" name="score">'
				);
		});

	$("#language_delete_btn").click(
		function() { 
			$(".language_sel").remove();
		});

});

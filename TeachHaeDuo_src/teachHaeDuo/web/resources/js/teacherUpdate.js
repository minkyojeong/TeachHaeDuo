/**
 * 
 */
/**
 * 
 */
$(function() {
	$(".sel").change(
		function() {
			console.log($(".sel").val());
			var selVal = $(".sel").val();
			$("#active").append(
				"<div class='active_div'>" + "<span class='span'>"
				+ selVal + "</span>&nbsp;&nbsp;&nbsp;"
				+ "</div>")
			var spantt = document.getElementsByClassName(".span")
			console.log(spantt);
		});
	// 활동지역 초기화
	$(document).on("click", '#area_reset', function() {
		console.log("초기화버튼");
		$(".ggg").remove();
	});

	$(function() {
		$("#btn").click(
			function() {
				if ($("#tr2").css('display') == 'none') {
					$("#tr2").show();
				} else if ($("#tr2").css('display') == 'table-row'
					&& $("#tr3").css('display') == 'none') {
					console.log("여기");
					$("#tr3").show();
				} else if ($("#tr3").css('display') == 'table-row'
					&& $("#tr4").css('display') == 'none') {
					$("#tr4").show();
				} else if ($("#tr4").css('display') == 'table-row'
					&& $("#tr5").css('display') == 'none') {
					$("#tr5").show();
				}
			});
		$("#btn_2").click(function() {
			$("#tr2").hide();
		});
		$("#btn_3").click(function() {
			$("#tr3").hide();
		});
		$("#btn_4").click(function() {
			$("#tr4").hide();
		});
		$("#btn_5").click(function() {
			$("#tr5").hide();
		});
	});
	
	
	
});

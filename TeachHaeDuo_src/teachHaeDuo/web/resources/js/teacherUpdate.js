/**
 * 
 */
/**
 * 
 */
$(function() {

	// 교습 가능 지역 모달창
	$("#area_select").click(function() {
		$("#acti_area_modal").show();
	});

	$(".acti_area_modal_close").click(function() {
		$("#acti_area_modal").hide();
	});

	acti_area_modal.addEventListener("click", e => {
		const evTarget = e.target
		if (evTarget.classList.contains("acti_area_modal_overlay")) {
			$("#acti_area_modal").hide();
		}
	})
	
	$("#acti_area_select_btn").click(function() {
		console.log("확인버튼 눌렀어");
		$("#acti_area_modal").hide();
		$(".active_div").nextAll().remove();
		var acti = [];
		$("input[name=acti_area]:checked").each(function(){
			var chk = $(this).val();
			console.log($(this).val());
			acti.push(chk);
			console.log("acti :" + acti);
		});
		for(i = 0 ; i < acti.length ; i++){
			$("#active").append(
					"<div class='active_div'>" + "<span class='active_span'>"
					+ acti[i] + "</span>"
					+ "</div>" + "<input type='hidden' name='activeArea' value='" + acti[i] + "'>")
		}
	});
	$("#acti_area_select_reset").click(function(){
		$("input[name=acti_area]").prop('checked',false);
	});
	

	// 활동지역 초기화
	$("#area_reset").click(function() {
		console.log("초기화버튼");
		$(".active_div").nextAll().remove();
		$("input[name=acti_area]").prop('checked',false);
		chk_area_arr = [];
	});

	// 어학
	$("#language_plus_btn").click(
		function() {
			console.log("추가 버튼 눌렀어");
			$("#language_tr1").after(
				'<tr id="tr2" class="language_sel">' + '<td></td><td>'
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

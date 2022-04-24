$(function() {
	var check = $("input[type='checkbox']");
	check.click(function() {
		$(".toggle_p").toggle();
	});
	$("#text_div1").mouseover(function() {
		$("#arrow_active1").show();
		$("#arrow1").hide();
	});
	$("#text_div1").mouseout(function() {
		$("#arrow_active1").hide();
		$("#arrow1").show();
	});
	$("#text_div2").mouseover(function() {
		$("#arrow_active2").show();
		$("#arrow2").hide();
	});
	$("#text_div2").mouseout(function() {
		$("#arrow_active2").hide();
		$("#arrow2").show();
	});
	$("#text_div3").mouseover(function() {
		$("#arrow_active3").show();
		$("#arrow3").hide();
	});
	$("#text_div3").mouseout(function() {
		$("#arrow_active3").hide();
		$("#arrow3").show();
	});


	/* modal js */
	$(".charge_btn").click(function() {
		$("#pencilcharge_modal").show();
	});

	$(".pencilcharge_modal_close").click(function() {
		$("#pencilcharge_modal").hide();
	});

	pencilcharge_modal.addEventListener("click", e => {
		const evTarget = e.target
		if (evTarget.classList.contains("pencilcharge_modal_overlay")) {
			$("#pencilcharge_modal").hide();
		}
	})

	var pencilwon = 0;
	$("#won").text(pencilwon);

	$("#btn1").click(function() {
		if (pencilwon > 0) {
			pencilwon -= 10000
			$("#won").val(pencilwon);
		}
	});
	$("#btn2").click(function() {
		pencilwon += 10000
		$("#won").val(pencilwon);
	});
	$("#btn3").click(function() {
		pencilwon += 30000
		$("#won").val(pencilwon);
	});
	$("#btn4").click(function() {
		pencilwon += 50000
		$("#won").val(pencilwon);
	});
	$("#btn5").click(function() {
		pencilwon += 100000
		$("#won").val(pencilwon);
	});

	$("#reset").click(function() {
		pencilwon = 0;
		$("#won").val(pencilwon);
	});

	$("charge").click(function() {
		if (pencilwon > 0) {
			var frm = document.charge_frm;
			frm.action = "pencilCharge.do";
			frm.method = "post"
			frm.submit();
		} else {
			alert("충전 금액은 0원 초과로 입력해주세요");
		}
	});
	
	


});
/**
 * 
 */
$(function() {
	
	if($("#alarm_yn").val()=='Y'){
		console.log("알람 수신ok네?")
		$("#checkbox").prop("checked", true);
	} else{
		$("#checkbox").prop("checked", false);
	}
	
	$("#checkbox").change(function(){
		location.href = "alarmYNChange";
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


	/* modal 충전하기 js */
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

	$("#charge").click(goCharge);
	
	function goCharge() {
		console.log("충전하기 들어옴");
		var won = $("#won").val()
		console.log(won);
		if (won > 0) {
			console.log("충전하기 누름");
			var frm = document.charge_frm;
			frm.action = "pencilCharge.do";
			frm.method = "post"
			frm.submit();
		} else {
			alert("충전 금액은 0원 초과로 입력해주세요");
		}
	}
	
	


	/* modal 0원 js */
	$(".won_modal_close").click(function() {
		$("#won_modal").hide();
	});

	won_modal.addEventListener("click", e => {
		const evTarget = e.target
		if (evTarget.classList.contains("won_modal_overlay")) {
			$("#won_modal").hide();
		}
	})


	/* modal 연락 요청 보낸 내역 js */
	
	$(".send_alarm_modal_close").click(function() {
		$("#send_alarm_modal").hide();
	});

	send_alarm_modal.addEventListener("click", e => {
		const evTarget = e.target
		if (evTarget.classList.contains("send_alarm_modal_overlay")) {
			$("#send_alarm_modal").hide();
		}
	})
	
	
	
	/* modal 내가 찜한 선생님 js */
	

	$(".like_modal_close").click(function() {
		$("#like_modal").hide();
	});

	like_modal.addEventListener("click", e => {
		const evTarget = e.target
		if (evTarget.classList.contains("like_modal_overlay")) {
			$("#like_modal").hide();
		}
	})
	
});
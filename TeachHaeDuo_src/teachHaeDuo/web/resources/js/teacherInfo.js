// 신고 버튼 클릭 시 모달창 띄우기
$("#btn_report").on('click', function() {
	$(".report").show();
});
// 취소 버튼 클릭 시 모달창 닫기
$("#btn_report_cancel").on('click', function() {
	$(".report").hide();
});
// 모달창 띄우고 내용 있는 곳 부분 제외한 곳 누르면 모달창 닫기
$(".report").on('click', function() {
	if (event.target == $(".report").get(0)) {
		$(".report").hide();
	}
});
// 신고 버튼 클릭 시 처리 내용
$("#btn_report_send").on('click', function() {
	$.ajax({
		url: "reportInsert.ax",
		type: "post",
		data: {
			m_r_receiveid: $("#m_r_receiveid").val(),
			report_category: $("#report_category").val(),
			m_r_content: $("#m_r_content").val()
		},
		success: function(result) {
			console.log(result);
			if (result == 1) {
				alert("신고 되었습니다.");
				$(".report_sel select").val("blame").prop("selected", true);
				$(".report_input textarea").val("");
				$(".report").hide();
			} else if (result == -1) {
				alert("신고 내용을 입력해주세요.");
				$(".report_input textarea").focus();
			} else if (result == 0) {
				alert("로그인을 한 후에 신고가 가능합니다. 로그인 페이지로 이동");
				location.href = "login";
			}
		},
		error: function(request, status, error) {
			console.log("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
		}
	});
});

// 쪽지 보내기 버튼 클릭 시 모달창 띄우기
$("#btn_message").on('click', function() {
	$(".message").show();
});
// 취소 버튼 클릭 시 모달창 닫기
$("#btn_message_cancel").on('click', function() {
	$(".message").hide();
});
// 모달창 띄우고 내용 있는 곳 부분 제외한 곳 누르면 모달창 닫기
$(".message").on('click', function() {
	if (event.target == $(".message").get(0)) {
		$(".message").hide();
	}
});
// 쪽지 보내기 성공 시, 별점 및 내용 입력 창 초기화 후 알럿창 띄우고 모달창 닫기
$("#btn_message_send").on('click', function() {
	alert("쪽지를 보냈습니다. 답장을 기다려주세요.");
	$(".message_input textarea").val("");
	$(".message").hide();
});

// 리뷰쓰기 버튼 클릭 시 모달창 띄우기
$("#btn_review").on('click', function() {
	$(".review").show();
});
// 취소 버튼 클릭 시 모달창 닫기
$("#btn_review_cancel").on('click', function() {
	$(".review").hide();
});
// 모달창 띄우고 내용 있는 곳 부분 제외한 곳 누르면 모달창 닫기
$(".review").on('click', function() {
	if (event.target == $(".review").get(0)) {
		$(".review").hide();
	}
});
// 리뷰 등록 성공 시, 내용 입력 창 초기화 후 알럿창 띄우고 모달창 닫기
$("#btn_review_send").on('click', function() {
	alert("리뷰가 등록되었습니다.");
	$(".review_input select").val("1").prop("selected", true);
	$(".review_input textarea").val("");
	$(".review").hide();
});

var cnt = 1;
// 찜하기 클릭 시마다 이미지 변경
$("#btn_like").on('click', function() {
	console.log("찜 클릭!");
	console.log(cnt);
	if (cnt % 2 == 1) {
		$("#btn_like > img").attr("src", "http://localhost:8090/myWeb2/resources/icons/like_color.png");
		// 선생님 찜 했다는 모달창 띄우기
		$(".like").show();
		// 모달창 띄우고 내용 있는 곳 부분 제외한 곳 누르면 모달창 닫기
		$(".like").on('click', function() {
			if (event.target == $(".like").get(0)) {
				$(".like").hide();
			}
		});
	} else {
		$("#btn_like > img").attr("src", "http://localhost:8090/myWeb2/resources/icons/like.png");
		// 찜 취소했다는 모달창 띄우기
		$(".cancle_like").show();
		// 모달창 띄우고 내용 있는 곳 부분 제외한 곳 누르면 모달창 닫기
		$(".cancle_like").on('click', function() {
			if (event.target == $(".cancle_like").get(0)) {
				$(".cancle_like").hide();
			}
		});
	}
	cnt++;
});
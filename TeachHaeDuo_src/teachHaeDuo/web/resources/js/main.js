// 메인_검색창에서 과목 검색 후, 엔터 키 눌렀을 때 처리부분
$("#object").keydown(function() {
	if (event.keyCode == 13) {
		console.log($(this).val());
		$("#search_form").attr("action", "teacherSearch");
		//location.href = "teacherSearch?object=" + $(this).val();
	}
});

// 메인_카테고리 선택 시 처리
function teacherSearch(object) {
	var form = document.createElement('form');
	let obj;

	obj = document.createElement('input');
	obj.setAttribute('type', 'text');
	obj.setAttribute('name', 'object');
	obj.setAttribute('value', object);

	form.appendChild(obj);
	form.setAttribute('method', 'post');
	form.setAttribute('action', 'teacherSearch');
	document.body.appendChild(form);
	form.submit();
}
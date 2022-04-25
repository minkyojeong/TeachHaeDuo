$(function(){
	$("#btn1").click(function() {
		if (ssMV != null) {
			var roleSt = '<%= ssMV.getRoleSt() %>';

			if (roleSt == "S") {
				location.href = "mypageStudent";
			} else if (roleSt == "T") {
				location.href = "mypageTeacher"
			}
		}
	});

	$("#logout").click(function() {
		location.href = "logout";
	});
	$("#btn3").click(function() {
		console.log("메인으로");
		location.href = "<%= request.getContextPath() %>";
	});
});
	

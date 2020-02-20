$(document).ready(function(){
	
	$.ajaxSetup({
		contentType:"application/json"
	});
	var setConnected = false;
	//회원가입 페이지
	$(document).on('click', '#signUp', function(e) {
		$("body").html(signUpPage);
	});
	
	//회원가입 제출
	$(document).on('click', '#regi', function(e) {
		$.post("/doc-talk/user",
				{
					"email":$("#userId").val(),
					"password":$("#userPass").val()
				},
			function(data){
				console.warn(data);
					// if(data.code==200){
					// 	alert("등록이 완료 되었습니다.");
					// 	$("body").html(loginPage);
					// }else if(data.code==201){
					// 	alert("이미 등록된 아아디 입니다.");
					// }
			}).fail(function(jqXHR){
				alert("회원 가입 실패 [code : "+jqXHR.code+" ]");
			});
	});
	
	//로그인 페이지
	$(document).on('click', '#signIn', function(e) {
		$("body").html(loginPage);
	});
	
	//로그인 시도 후 메인페이지
	var userId = "";
	$(document).on('click', '#login', function(e) {
		userId = $("#userId").val()
		$.post("/main",
				{
					userId : userId,
					userPassword : $("#userPassword").val()
				},
				function(data){
					if(data.code==200){
						var mainObject = new Object();
						mainObject.userId = userId;
						mainObject.friendsList = data.friendsList;
						$("body").html(mainPage(mainObject));
						
					}else if(data.code==202){
						alert("아이디 또는 패스워드가 잘못되었습니다.");
					}else if(data.code==203){
					}
				}).fail(function(jqXHR){
					alert("로그인 실패 [code : "+jqXHR+" ]");
				})
	});
})

	
	
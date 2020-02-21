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
				JSON.stringify({
					email : $("#userId").val(),
					password : $("#userPass").val()
				}),
			function(data){
				if(data == 'success'){
					alert("등록이 완료 되었습니다.");
					$("body").html(loginPage);
				}else if(data == 'exist email'){
					alert("이미 등록된 아아디 입니다.");
				}
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
		$.post("/doc-talk/login",
				JSON.stringify({
					email : $("#userId").val(),
					password : $("#userPassword").val()
				}),
				function(data){
					if(data == 'success'){
						getQuestions();
					}else if(data == 'fail'){
						alert("아이디 또는 패스워드가 잘못되었습니다.");
					}
				}).fail(function(jqXHR){
					alert("로그인 실패 [code : "+jqXHR+" ]");
				})
	});
	
	var QuestionListData;
	//질문 리스트 페이지
	var getQuestions = function(){
		$.get("/doc-talk/question",
			function(data){
			QuestionListData=data;
				$("body").html(questionListPage(data));
			}).fail(function(jqXHR){
				alert("에러 [code : "+jqXHR.code+" ]");
			});
	}

	//질문 상세 페이지
	questionDetail = function(id){
		$.get("/doc-talk/question/"+id,
				function(data){
					$("body").html(questionDetailPage(data));
				}).fail(function(jqXHR){
					alert("에러 [code : "+jqXHR.code+" ]");
				});
	}
	
	dateFormatSet = function(date){
		date = date.replace("T"," ");
		date = date.substr(0, date.length-4);
		return date;
	}
	
	questionListPageGo = function(){
		$("body").html(questionListPage(QuestionListData));
	}
})

	
	
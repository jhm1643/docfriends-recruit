//회원가입 페이지
	var signUpPage = '<div class="wrapper fadeInDown">'+
						'<div id="loginContent">'+
							"<h2 class='inactive underlineHover' id='signIn'> Sign In </h2>"+
							"<h2 class='active' id='signUp'>Sign Up </h2>"+
								"<form id='regiForm'>"+
									"<input type='text' id='userId' class='fadeIn second' placeholder='아이디'>"+
									"<input type='password' id='userPass' class='fadeIn third' placeholder='패스워드'>"+
									"<input type='button' class='fadeIn second submitButton' id='regi' value='완료'>"+
								"</form>"+
						"</div>"+
					"</div>";
	
	var loginPage= '<div class="wrapper fadeInDown">'+
						'<div id="loginContent">'+
							'<h2 class="active" id="signIn"> Sign In </h2>'+
							'<h2 class="inactive underlineHover" id="signUp">Sign Up </h2>'+
								'<div class="fadeIn first">'+
								'</div>'+
							'<form id="loginForm">'+
							'<input type="text" id="userId" class="fadeIn second" placeholder="아이디">'+
							'<input type="password" id="userPassword" class="fadeIn third" placeholder="패스워드">'+
							'<input type="button" class="fadeIn second submitButton" id="login" value="로그인">'+
							'</form>'+
						"</div>"+
					'</div>';
	
	 var questionListPage = function(data){
		console.warn(data);
	 	var html = 
	 		'<div class="wrapper fadeInDown">'+
	 			'<div id="mainContent">';
	 	
		 for(var i=0;i<data.length;i++){
			 html+=
			 '<div class="question" onClick="questionDetail('+data[i].id+');">'+
				'<div class="question_title">'+data[i].title+'</div>'+
				'<div class="question_hashTag">'+data[i].hashTag+'</div>'+
				'<div class="question_content">'+data[i].content+'</div>'+
				'<div class="answer_count">답변'+data[i].answers.length+'</div>'+
			'</div>';
		 }
		 
		 html+=
			 "</div>"+
	 	'</div>';
	 	return html;
	}
	
	var questionDetailPage = function(data){
		console.warn(data);
		var html = 
			'<div class="wrapper fadeInDown">'+
			'<input type="button" onClick="questionListPageGo()" value="뒤로가기">'+
				'<div id="mainContent">'+
					'<div class="question">'+
						'<div class="question_title">'+data.title+'</div>'+
						'<div class="question_detail_date">'+dateFormatSet(data.questionDate)+'</div>'+
						'<div class="question_detail_content">'+data.content+'</div>'+
						'<div class="question_hashTag">'+data.hashTag+'</div>'+
						'<div class="question_sourceUrl">출처 : '+data.sourceUrl+'</div>'+
					'</div>';
		for(var i=0;i<data.answers.length;i++){
			html+=
				'<div class="answer">'+
					'<div class="answer_title">'+data.answers[i].title+'</div>'+
					'<div class="answer_date">'+dateFormatSet(data.answers[i].answerDate)+'</div>'+
					'<div class="answer_content">'+data.answers[i].content+'</div>'+
				'</div>';
		}
			html+=	
				'</div>'+
			'</div>';
	 	return html;
	}
		
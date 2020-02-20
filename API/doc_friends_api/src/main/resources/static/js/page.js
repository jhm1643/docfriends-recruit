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
	
	 var mainPage = function(){
	 	var html = '<div class="wrapper fadeInDown">'+
	 	'<div id="mainContent">'+
	 		'aa'+
	 	"</div>"+
	 	'</div>';
	 	return html;
	}
		

// 회원가입 이동
window.addEventListener("load", function() {
    var container = document.querySelector(".login-container");
	var joinButton = container.querySelector(".join-button");  
	
	joinButton.addEventListener("click", function() {
		location.href = "join.jsp";
	});
});


// 로그인
window.addEventListener("load", function() {
    var loginForm = document.querySelector(".loginForm");

	var loginIdInput = loginForm.querySelector(".loginId");
	var pwInput = loginForm.querySelector(".pw");
	var loginBtn = loginForm.querySelector(".loginBtn");
	
	
	
	loginBtn.addEventListener("click", function(e){
		e.preventDefault();
		var id = loginIdInput.value;
		var pw = pwInput.value;
		load(id, pw);
    });
	
	
	function load(id, pw) {
		if(id == undefined || pw == undefined) {
			alert('아이디 및 패스워드를 입력해주세요');
		} 
		
		console.log("id:"+id+"/ pw:"+pw);
		
		var request = new XMLHttpRequest();
        request.onload = function() {
			var results = JSON.parse(request.responseText);
			console.log("data :"+results);
			
			var loginResult = results.result;
			
			console.log(loginResult);

			if(loginResult == 'false') {   
				alert('아이디 또는 비밀번호를 확인해주세요');
				return;
			} else {
				loginForm.submit();  // 성공이면 제출
			}
        }

        request.open("GET", "/api/common/login?loginId="+id+"&pw="+pw, true);  
        request.send();
	};
});

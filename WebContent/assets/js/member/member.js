
// 회원가입 이동
window.addEventListener("load", function() {
    var container = document.querySelector(".login-container");
	var joinButton = container.querySelector(".join-button");  
	
	joinButton.addEventListener("click", function() {
		location.href = "/member/join.jsp";
	});
});
	
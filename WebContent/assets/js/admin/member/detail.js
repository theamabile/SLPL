/*-------------------------------- detail -------------------------------------*/

// 비밀번호 유효성 검사
/*window.addEventListener("load", function() {
	var container = document.querySelector(".container-item");
	var passwordInput = container.querySelector(".password");
	var updateBtn = container.querySelector(".submit-button");
	
	var regex = /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;
	
	updateBtn.addEventListener("click", function() {
		var isValid = regex.test(passwordInput.value);
		if(false == isValid) {
			var infoText = document.createElement("span");
			infoText.append("비밀번호는 영문, 특수문자, 숫자를 포함해야 합니다.");
			passwordInput.append(infoText);
		}
	});
});*/

// 삭제 전 확인
window.addEventListener("load", function() {
	var container = document.querySelector(".container-item");
	var deleteBtn = container.querySelector(".delete-button");
	if(deleteBtn != null) {
		deleteBtn.addEventListener("click", function() {
			var name = container.querySelector(".name-input").value;
			var no = container.querySelector(".no-input").value;
			var isDelete = confirm(name+"님을 삭제하시겠습니까?");
			if(isDelete) {
				location.href="delete?no="+no;
			}
		});
	}
	
});

// 이메일 처리
window.addEventListener("load", function() {
	var container = document.querySelector(".container-item");
	var emailAddress = container.querySelector('select[name="emailAddress"]');   // 속성으로 갖고와보기
	
	emailAddress.addEventListener("change", function() {
		var customAddress = container.querySelector(".customAddress");
		
		if(emailAddress.value == "none") {	// 직접 입력이면 입력창 활성화
			customAddress.readOnly = false;
			customAddress.required = true;
		} else {
			customAddress.readOnly = true;
			customAddress.required = false;
			customAddress.value = "";
		}
	});
});
	
	
// 닉네임 중복확인
window.addEventListener("load", function() {
	var container = document.querySelector(".container-item");
	
	var nicknameInput = container.querySelector(".nickname");
	var nicknameBtn = container.querySelector(".nicknameBtn");
	//loginId
	
	nicknameBtn.addEventListener("click", function() {
		var win = open("confirm_nickname.jsp", "_blank", "width=300px, height=400px");
		win.addEventListener("load", function(){
			var nicknameInput = win.opener.document.querySelector(".nickname"); //.getElementsByClassName("nickname");
			console.log("ddfdfs : "+nicknameInput.value);
			
			if( nicknameInput.value != "") {
				var textInput = win.document.querySelector(".textInput");
				textInput.value = nicknameInput.value;
			}
		});
		win.addEventListener("beforeunload ", function(){
			console.log("종료!");
		});
	});
});
		
		
		
/*window.addEventListener("load", function() {

    var section = document.getElementById("s3");
    var searchButton = section.getElementsByClassName("search-button")[0];
    
    var win;
    searchButton.onclick = function() {
        win = open("ex1-zipcode.html", "_blank", "width=300px, height=400px");
        win.addEventListener("load", function() {            
            var addBtn = win.document.getElementsByTagName("input")[0];
            addBtn.value = "희희";
        });
    };

});     
*/
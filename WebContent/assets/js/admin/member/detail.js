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
	


// 아이디 중복확인
window.addEventListener("load", function() {
	var container = document.querySelector(".container-item");
	
	var loginIdBox = container.querySelector(".id-box");
	var loginIdInput = loginIdBox.querySelector(".loginId");
	var loginIdBtn = loginIdBox.querySelector(".loginIdBtn");
	var infoText = loginIdBox.querySelector(".infoText");
	var isLoginIdConfirm = loginIdBox.querySelector(".loginIdConfirm");
		
	loginIdBtn.addEventListener("click", function() {
		var request = new XMLHttpRequest();
        request.onreadystatechange = function() {
            if(request.readyState == 4) {
				var result = JSON.parse(request.responseText);
				var count = result[0].count;
				if(count > 0) {   // 조회 결과 같은 항목 갯수가 0이 아니면
					infoText.classList.remove("infotext-none");
					infoText.classList.add("infotext-warning");
					infoText.innerText = "중복된 아이디입니다.";		
					isLoginIdConfirm.value = "";			
				} else {
					infoText.classList.remove("infotext-warning");
					infoText.classList.add("infotext-none");
					infoText.innerText = "사용 가능한 아이디입니다.";	
					isLoginIdConfirm.value ="y";	
				}
            }
        }

        var url = "/api/admin/member/add?field=login_id&query="+loginIdInput.value;
        request.open("GET", url, true);   // 서버 데이터로 받기 프로젝트 이름 넣어줘야함^_^
        request.send();
	});
	
	loginIdInput.addEventListener("focusout", function() {
		var value = loginIdInput.value;
		if(value == "") {
			infoText.classList.remove("infotext-none");
			infoText.classList.add("infotext-warning");
			infoText.innerText = "아이디를 입력해주세요";		
			isLoginIdConfirm.value = "";
		} else {
			var request = new XMLHttpRequest();
	        request.onreadystatechange = function() {
	            if(request.readyState == 4) {
					var result = JSON.parse(request.responseText);
					var count = result[0].count;
					if(count > 0) {   // 조회 결과 같은 항목 갯수가 0이 아니면
						infoText.classList.remove("infotext-none");
						infoText.classList.add("infotext-warning");
						infoText.innerText = "이미 사용중인 아이디입니다.";		
						isLoginIdConfirm.value = "";			
					} else {
						infoText.classList.remove("infotext-warning");
						infoText.classList.add("infotext-none");
						infoText.innerText = "사용 가능한 아이디입니다.";	
						isLoginIdConfirm.value ="y";	
					}
	            }
	        }
	
	        var url = "/api/admin/member/add?field=login_id&query="+value;
	        request.open("GET", url, true);   // 서버 데이터로 받기 프로젝트 이름 넣어줘야함^_^
	        request.send();
		}
	});
		
	var submitBtn = container.querySelector(".submit-button");
	submitBtn.addEventListener("click", function(e) {
		e.preventDefault();
		if(isLoginIdConfirm.value == "n") {
			alert('아이디 중복체크 해주세요.');
			return false;    // submit 버튼의 경우 리턴타입이 true 일 때만 제출함
		}
	});
});

// 닉네임 중복확인
window.addEventListener("load", function() {
	var container = document.querySelector(".container-item");
	
	var nicknameBox = container.querySelector(".nickname-box");
	var nicknameInput = nicknameBox.querySelector(".nickname");
	var nicknameBtn = nicknameBox.querySelector(".nicknameBtn");
	var infoText = nicknameBox.querySelector(".infoText");
	var isNicknameConfirm = nicknameBox.querySelector(".nicknameConfirm");
		
	nicknameBtn.addEventListener("click", function() {
		var request = new XMLHttpRequest();
        request.onreadystatechange = function() {
            if(request.readyState == 4) {
				var result = JSON.parse(request.responseText);
				var count = result[0].count;
				if(count > 0) {   // 조회 결과 같은 항목 갯수가 0이 아니면
					infoText.classList.remove("infotext-none");
					infoText.classList.add("infotext-warning");
					infoText.innerText = "중복된 닉네임입니다.";		
					isNicknameConfirm.value = "";			
				} else {
					infoText.classList.remove("infotext-warning");
					infoText.classList.add("infotext-none");
					infoText.innerText = "사용 가능한 닉네임입니다.";	
					nicknameConfirm.value ="y";	
				}
            }
        }

        var url = "/api/admin/member/add?field=nickname&query="+nicknameInput.value;
        request.open("GET", url, true);   // 서버 데이터로 받기 프로젝트 이름 넣어줘야함^_^
        request.send();
	});
	
	
	nicknameInput.addEventListener("focusout", function() {
		var value = nicknameInput.value;
		if(value == "") {
			infoText.classList.remove("infotext-none");
			infoText.classList.add("infotext-warning");
			infoText.innerText = "아이디를 입력해주세요";		
			nicknameConfirm.value = "";
		} else {
			var request = new XMLHttpRequest();
	        request.onreadystatechange = function() {
	            if(request.readyState == 4) {
					var result = JSON.parse(request.responseText);
					var count = result[0].count;
					if(count > 0) {   // 조회 결과 같은 항목 갯수가 0이 아니면
						infoText.classList.remove("infotext-none");
						infoText.classList.add("infotext-warning");
						infoText.innerText = "이미 사용중인 아이디입니다.";		
						nicknameConfirm.value = "";			
					} else {
						infoText.classList.remove("infotext-warning");
						infoText.classList.add("infotext-none");
						infoText.innerText = "사용 가능한 아이디입니다.";	
						nicknameConfirm.value ="y";	
					}
	            }
	        }
	
	        var url = "/api/admin/member/add?field=nickname&query="+value;
	        request.open("GET", url, true);   // 서버 데이터로 받기 프로젝트 이름 넣어줘야함^_^
	        request.send();
		}
	});
	
});
		
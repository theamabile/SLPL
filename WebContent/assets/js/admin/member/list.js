/*-------------------------------- list -------------------------------------*/

// 체크박스 선택
window.addEventListener("load", function() {
    var allCheckBox = document.getElementsByClassName("checkAll");
    allCheckBox[0].onchange = function() {
        var checkList = document.getElementsByClassName("checkMember");
        for(var check of checkList) {
            check.checked = allCheckBox[0].checked;
        }
    }
});

// 검색 이동
window.addEventListener("load", function() {
    var container = document.querySelector(".container-item");
	var searchButton = container.querySelector(".searchButton");
	var field = container.querySelector(".field");
	var query = container.querySelector(".query");
	
    searchButton.onclick = function() {
		var queryValue = query.value.trim();
		if(queryValue == "") {
			alert('검색어를 입력하세요');
			query.value = '';
			return;
		}
		location.href = "list?field="+field.value+"&query="+queryValue;
    }
});

// 선택 회원에게 메세지 보내기
window.addEventListener("load", function() {
    var container = document.querySelector(".container-item");
	var messageBtn = container.querySelector(".messageBtn");
	
    messageBtn.onclick = function() {
		//http://localhost:8080/admin/member/message?checkMember=1&checkMember=3
		
		var hrefURL = "messageSend?sendAllMember=n&";     	
		// get방식으로 name에 따른 값을 url로 만들것이므로, class 말고 name을 사용
		var checks = document.getElementsByName("checkMember");
		var checkedCount = 0;
		for(var check of checks) {
			if(check.checked == true) {
				checkedCount++;
				hrefURL += "checkMember="+check.value+"&";
			}
        }
		
		// 체크 된게 있으면
		if(checkedCount > 0) {
			hrefURL = hrefURL.slice(0, hrefURL.length-1);   // 마지막 &제거
			location.href = hrefURL;
		} else {
			alert("선택 된 회원이 없습니다.");
		}
    }
});

// 전체 회원에게 메세지 보내기
window.addEventListener("load", function() {
    var container = document.querySelector(".container-item");
	var messageAllBtn = container.querySelector(".messageAllBtn");
	
    messageAllBtn.onclick = function() {
		var hrefURL = "messageSend?sendAllMember=y";     	
		location.href = hrefURL;
    }
});


// 페이지 전환
window.addEventListener("load", function() {
    var container = document.querySelector(".container-item");

	var prevBtn = container.querySelector(".prevBtn");
	var nextBtn = container.querySelector(".nextBtn");
	var fieldInput = container.querySelector(".field");
	var queryInput = container.querySelector(".query");
	
	
	var currentPageInput = container.querySelector(".currentPage");
	var allPageCountInput = container.querySelector(".allPageCount");
	var currentPage = parseInt(currentPageInput.value);
	var allPageCount = parseInt(allPageCountInput.value);
	
	
	var prevScopeBtn = container.querySelector(".prevScopeBtn");
	var nextScopeBtn = container.querySelector(".nextScopeBtn");
	
	var startPageInput = container.querySelector(".startPage");
	var endPageInput = container.querySelector(".endPage");
	var startPage = parseInt(startPageInput.value);
	var endPage = parseInt(endPageInput.value);
	
	var url = "";
	//검색어가 있으면 같이 넘겨주기
	console.log("fieldInput.value : "+fieldInput.value);
	if(fieldInput.value != "" && queryInput.value != "") {
		url = "list?field="+fieldInput.value+"&query="+queryInput.value+"&page=";
	} else {
		url = "list?page=";
	}
	
    prevBtn.onclick = function() {
		if(currentPage > 1) {
			var prevPage = currentPage - 1;
			location.href = url + prevPage;
		} else {
			alert('이전 페이지가 없습니다');
		}
    }

	nextBtn.onclick = function() {		
		if(currentPage < allPageCount) {
			var nextPage = currentPage + 1;
			location.href = url + nextPage;
		} else {
			alert('다음 페이지가 없습니다');
		}
    }

 	prevScopeBtn.onclick = function() {
		if(startPage > 1) {
			location.href = url + (startPage-1);
		}  else {
			alert('이동 할 페이지가 없습니다.');
		}
		
    }

	nextScopeBtn.onclick = function() {	
		if(endPage < allPageCount) {
			location.href = url + (endPage+1);
		} else {
			alert('이동 할 페이지가 없습니다.');
		}
		
    }
	

});







// 리스트 row 클릭
function clickTableRow(url, id) {
	location.href = url+id;
}


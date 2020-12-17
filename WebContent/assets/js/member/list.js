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
		location.href = "messageList?field="+field.value+"&query="+queryValue;
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
		url = "messageList?field="+fieldInput.value+"&query="+queryInput.value+"&page=";
	} else {
		url = "messageList?page=";
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
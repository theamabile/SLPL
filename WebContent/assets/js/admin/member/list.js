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


// 페이지 전환 ajax
window.addEventListener("load", function() {
	var tbody = document.querySelector("tbody");
	var pager = document.querySelector(".pager");
	var pageList = pager.querySelector(".pageList");
	
	var prevScopeBtn = pager.querySelector(".prevScopeBtn");
	var nextScopeBtn = pager.querySelector(".nextScopeBtn");
	
    var container = document.querySelector(".container-item");
	var fieldInput = container.querySelector(".field");
	var queryInput = container.querySelector(".query");
	
	var pageScopeCount = 0;   // 일단 안받아옴
	var pageItemCount = 0;
	
	configLoad(); // 필요한 설정 정보 로드
	
	
	pageList.addEventListener("click", function(e){
		e.preventDefault();
		var page = parseInt(e.target.innerText);    //숫자 연산 때문에 parseInt해줘야함
		
		if(e.target.tagName != "A") {    // 눌린애가 a태그가 아니면 리턴
			return;
		}
		
		var current = pager.querySelector(".current-page");	
		var currentPage = parseInt(current.innerText);    //현재 페이지 정보를 받아옴
		if(currentPage == page) {
			return;
		}
		
		load(page);
	});
	
	// 이전 영역 버튼 
	prevScopeBtn.onclick = function() {
		var current = pager.querySelector(".current-page");	
		var page = parseInt(current.innerText);    //현재 페이지 정보를 받아옴
		if(page == undefined) {
			page = 1;
		}
		console.log("prevScope - before:"+page);
		page = page - pageScopeCount;
		/*if(page < 0) {
			alert('이동 할 페이지가 없습니다.');
		}*/
		load(page);
    }

	// 다음 영역 버튼 
	nextScopeBtn.onclick = function() {
		var current = pager.querySelector(".current-page");	
		var page = parseInt(current.innerText);    //현재 페이지 정보를 받아옴
		if(page == undefined) {
			page = 1;
		}
		page = page + pageScopeCount;
		console.log("nextScope :"+page);
		load(page);
    }
	
	
	function load(page){
		if(page == undefined) {
			page = 1;
		} 
		
		var request = new XMLHttpRequest();
        request.onload = function() {
			//console.log(request.responseText);
			var results = JSON.parse(request.responseText);
			
			var header = results.header;
			var list = results.list;
			var allCount = header.allCount;   		   
			var field = header.field;
			var query = header.query;   
			
			var isSearched = false;
			if(field != undefined && query != undefined) {
				isSearched = true;
				queryInput.value = query;   // 검색이면 검색어 넣어주기
			}
			//console.log("list.length : "+list.length);
			//console.log("query: "+query);
			
			if(list.length <= 0) {   // nextScope 버튼 눌렀을때  예외처리
				alert('이동 할 페이지가 없습니다.');
				return;
			}
			
			// 비우기
			tbody.innerHTML = "";
			pageList.innerHTML = "";
			
			/*console.log("allCount : "+allCount);*/
			if(allCount <= 0) {
				var textInfo = '<td colspan="9">항목이 존재하지 않습니다.</tr>';
				if(isSearched == true) {
					textInfo = '<td colspan="9">"'+queryInput.value+'"에 대한 검색 결과가 없습니다.</td>';
				}	
				tbody.insertAdjacentHTML('beforeend', textInfo);  //태그에 끼워넣기*/
				
				var pageNum = '<li><a class="current-page">'+1+'</a></li>'
				pageList.insertAdjacentHTML('beforeend', pageNum);  //태그에 끼워넣기*/
				
			} else {
				
				var pageCount = 1 + Math.floor((allCount-1)/pageItemCount);             // 띄울 수 있는 전체 페이지 갯수
				var startPage = 1 + pageScopeCount * Math.floor((page-1)/pageScopeCount);   // 페이지 범위
				var endPage = startPage + (pageScopeCount-1);
				
				//console.log("pageScopeCount : "+pageScopeCount+" / Math.floor(page/pageScopeCount) : "+Math.floor(page/pageScopeCount) );
				
				if(endPage > pageCount) {
					endPage = pageCount;
				}
			
				/*console.log("pageCount : "+pageCount+" / startPage : "+startPage+" / endPage : "+endPage);*/
				// 페이지 scope
				for(var i=startPage ; i<=endPage ; i++) {
					var pageNum = '<li><a>'+i+'</a></li>';
					if(i == page) {
						pageNum = '<li><a class="current-page">'+i+'</a></li>';
					}
					pageList.insertAdjacentHTML('beforeend', pageNum);  //태그에 끼워넣기*/
				}
				
				// 테이블
				for(var i=0 ; i<list.length ; i++) {
					var m = list[i];
					var tr = '<tr>\
	                            <td><input type="checkbox" class="checkMember" name="checkMember" value="${m.id}"></td>\
	                            <td>'+m.id+'</td>\
	                            <td><a href="detail?id=${m.id}">'+m.loginId+'</a></td>\
	                            <td>'+m.name+'</td>\
	                            <td>'+m.nickname+'</td>\
	                            <td>'+m.authority+'</td>\
	                            <td>'+m.categoryName+'</td>\
	                            <td>'+m.email+'</td>\
	                            <td>'+m.regdate+'</td>\
	                        </tr>'
					
					tbody.insertAdjacentHTML('beforeend', tr);  //태그에 끼워넣기*/
				}
			}
        }

		var url = makeURL();
        request.open("GET", url+page, true);  
        request.send();
	};
	
	function makeURL() {
		var url = "/api/admin/member/list";
		//검색어가 있으면 같이 넘겨주기
		if(fieldInput.value != "" && queryInput.value != "") {
			url += "?field="+fieldInput.value+"&query="+queryInput.value+"&page=";
		} else {
			url += "?page=";
		}
		return url;
	}
	
	function configLoad() {
		var configRequest = new XMLHttpRequest();
	    configRequest.onload = function() {
			console.log(configRequest.responseText);
			var results = JSON.parse(configRequest.responseText);
			
			pageScopeCount = parseInt(results.pageScopeCount);
			pageItemCount =  parseInt(results.pageItemCount);
		}
	    configRequest.open("POST", "/api/admin/member/list", true);  
	    configRequest.send();
	}
	
});


// 페이지 전환
/*window.addEventListener("load", function() {
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
	

});*/







// 리스트 row 클릭
function clickTableRow(url, id) {
	location.href = url+id;
}


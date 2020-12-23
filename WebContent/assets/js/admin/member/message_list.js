
/*-------------------------------- list -------------------------------------*/

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
		if(e.target.tagName != "A") {    // 눌린애가 a태그가 아니면 리턴
			return;
		}
		
		var page = parseInt(e.target.innerText);    //숫자 연산 때문에 parseInt해줘야함
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
		page = page - pageScopeCount;
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
		load(page);
    }
	
	
	function load(page){
		if(page == undefined) {
			page = 1;
		} 
		
		var request = new XMLHttpRequest();
        request.onload = function() {
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
			
			if(list.length <= 0) {   // nextScope 버튼 눌렀을때  예외처리
				alert('이동 할 페이지가 없습니다.');
				return;
			}
			
			// 비우기
			tbody.innerHTML = "";
			pageList.innerHTML = "";
			
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
				
				if(endPage > pageCount) {
					endPage = pageCount;
				}
				
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
	                            <td>'+m.id+'</td>\
	                            <td>'+m.type+'</td>\
	                            <td><a href="detail?id='+m.id+'">'+m.title+'</a></td>\
								<td>'+m.senderName+'</td>\
	                            <td>'+m.receiverName+'</td>\
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
		var url = "/api/admin/member/message/list";
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
	    configRequest.open("POST", "/api/admin/member/message/list", true);  
	    configRequest.send();
	}
	
});
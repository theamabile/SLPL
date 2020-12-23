window.addEventListener("load", function() {
	
	var recomIcon = document.querySelector(".recom-icon");
	var reportIcon = document.querySelector(".report-icon");
	var popupContainer = document.querySelector(".popup-container");
	var popupCancelButton = document.querySelector(".popup-cancel-button");
	var pageMove = document.querySelector(".page-move-button");
	var pageMoveButton = document.querySelector(".page-result-button");
			
	pageMove.onclick = function(e){
		var pageMoveVal = e.target.value;
		switch(pageMoveVal){
			case "test-save":
			location.href="/test/test/list/test_list";
			break;
			
			case "test-another-play":
			location.href="/test/test/list/test_list";
			
			case "go-make":
			location.href="/test/test/make/reg-test";
		}
		
	}
	
	recomIcon.onclick = function() {
		console.log("추천");
	}

	reportIcon.onclick = function() {
		console.log("신고");
		popupContainer.classList.remove("d-done");
	}

	popupCancelButton.onclick = function() {
		popupContainer.classList.add("d-done");
	}

	pageMoveButton.onclick = function(e) {
		if (e.target.tagName != "BUTTON")
			return;
		e.target.parentElement.classList.add("d-done");
		e.target.parentElement.nextElementSibling.classList
				.remove("d-done");
	}
	
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

			
});
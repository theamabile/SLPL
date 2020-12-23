

/*-------------------------------- detail -------------------------------------*/
// 목록으로 이동
window.addEventListener("load", function() {
    var container = document.querySelector(".container-item");
	var listButton = container.querySelector(".listButton");
	
	if(listButton != null) {
	    listButton.onclick = function() {
			location.href = "list";
	    }
	}
});

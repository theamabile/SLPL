

/*-------------------------------- detail -------------------------------------*/
// 목록으로 이동
window.addEventListener("load", function() {
    var container = document.querySelector(".container-item");
	var listButton = container.querySelector(".listButton");
	
    listButton.onclick = function() {
		location.href = "messagelist";
    }
});

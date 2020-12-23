window.addEventListener("load",function(){
	var container = document.querySelector(".preview-detail-container");
	
	
	var request =new XMLHttpRequest();
	
	var result = JSON.parse(request.responseText);
	
	var title = container.firstElementChild;
	var c = request.getAttribute("c");
	title.innerText=request.getAttribute("c");
	
});

/*<div class="alert warning">
  <span class="closebtn">&times;</span>  
  <strong>Warning!</strong> Indicates a warning that might need attention.
</div>*/

/* 
parentElement : alert이 추가 될 parent 태그
position : beforeend 같은 부모에 추가 될 위치 afterbegin(기본값)
tex : alert 텍스트
type : alert 유형에 대한 String
       danger warning(기본값) success info*/
function showAlert(parentElement, position='afterbegin', text, type='warning') {
	type = type.toLowerCase();
	position = position.toLowerCase();
	
	if(parentElement != null) {
		var alertDiv = document.createElement("div");
		alertDiv.classList.add("alert");
		alertDiv.classList.add(type);
		
		var alert = '<span class="closebtn">&times;</span>\
  					 <strong>'+type+'!</strong>'+ text;

		alertDiv.insertAdjacentHTML('afterbegin', alert);      
		parentElement.insertAdjacentHTML(position, alertDiv);  
	}
}



// 알럿 처리하는 함수
window.addEventListener("load", function() {
	var alertDiv = document.querySelector(".alert");
	if(alertDiv != null) {
		var close = alertDiv.querySelector("closebtn");
		var i;
		
		for (i = 0; i < close.length; i++) {
		  close[i].onclick = function(){
		    var div = this.parentElement;
		    div.style.opacity = "0";
		    setTimeout(function(){ div.style.display = "none"; }, 600);
		  }
		}
	}
});

// low-step6 -> deatil
window.addEventListener("load",function(){
    var section = document.querySelector("#create-container");
    var resultPreview = section.querySelector(".result-preview");

    resultPreview.onclick = function(event){
        // 이벤트
        if(event.target.className =="result-preview"){
            return;
        }
        var detail = window.open("resultDetail.html", "","width=650,height=800,left=650,top=100");

    }

});


// 예시보기 기능
window.addEventListener("load",function(){
    var section = document.querySelector("#create-container");
    var typeBox =section.querySelector(".type-box");
    var exBtn =typeBox.querySelector("input");
    var exBox = exBtn.nextElementSibling;
   
    
    exBtn.onclick = function(){
        console.log("예시보기");
        if(exBox.style.display!="block"){
            exBox.style.display="block";
        return;     
    }
        exBox.style.display="none";
    }
});
// nav 기능 // 작성 페이지 저장
window.addEventListener("load",function(){
    var section = document.querySelector("#create-container");
    var nav = section.querySelector(".nav-buttons");
    var pro = nav.querySelector("input");
    var next = pro.nextElementSibling;
    
    var start=section.querySelector(".input-container");
    var current = start;
    




    // nav 기능
    pro.onclick=function(){
        if(current ==start){
            alert("이전 항목이 없습니다.");
            return;     
        }
        current.classList.remove("active");
        current = current.previousElementSibling;
        current.classList.add("active");

    };

    next.onclick = function(){
        if(current.nextElementSibling ==nav){
            alert("해당 테스트를 등록하시겠습니까??");
            return;     
        }
        var form = current.firstElementChild;
        
        current.classList.remove("active");
        current = current.nextElementSibling;
        current.classList.add("active");

        //alert(form.id);
		var formUrl = form.getAttribute('action');
		 var params = $("#"+form.id).serialize();
		alert(params);
		            $.ajax({
		                url:formUrl,
		                type:"POST",
		                data:$("#"+form.id).serialize(),
		                dataType : 'text', 
		                error:function(request,status,error){
        				alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
      					},
		                success:function(data){
		                    alert("성공!");	
		                }
		            });
		    
    }
});
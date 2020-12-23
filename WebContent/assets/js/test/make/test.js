
// 이미지 미리보기
function previewImg(f){

	var file = f.files;

	// 확장자 체크
	if(!/\.(gif|jpg|jpeg|png)$/i.test(file[0].name)){
		alert('gif, jpg, png 형식의 이미지를 등록해주세요 ');

		// 선택한 파일 초기화
		f.outerHTML = f.outerHTML;
		f.previousElementSibling.innerHTML = '';

	}
	else {

		var reader = new FileReader();
		reader.onload = function(e){
			f.previousElementSibling.innerHTML = '<img src="' + e.target.result + '"  style="width: 100%;height: 100%;">';
		}

		// 파일 읽기
		reader.readAsDataURL(file[0]);

	}
}
// 결과 이름 넣어주기
window.addEventListener("load",function(){
	var section = document.querySelector("#create-container");
	var lowStep3 = section.querySelector(".low-step3");
	var lowStep4 = section.querySelectorAll(".low-step4");
	var lowStep6 = section.querySelector(".low-step6");
	var prevBox =lowStep6.querySelectorAll(".text");
	var nameContainers = lowStep3.querySelectorAll(".result-name-container");
	
	var name1=nameContainers[0].querySelector(".result-name");
	var name2=nameContainers[1].querySelector(".result-name");
	var name3=nameContainers[2].querySelector(".result-name");
	var name4=nameContainers[3].querySelector(".result-name");
	
			
	name1.addEventListener("change",function(){
			
		lowStep4[0].querySelector(".result-name").innerHTML=name1.value;
		prevBox[0].firstElementChild.innerHTML=name1.value;
	});
	name2.addEventListener("change",function(){
			
		lowStep4[1].querySelector(".result-name").innerHTML=name2.value;
		prevBox[1].firstElementChild.innerHTML=name2.value;
	});
	name3.addEventListener("change",function(){
			
		lowStep4[2].querySelector(".result-name").innerHTML=name3.value;
		prevBox[2].firstElementChild.innerHTML=name3.value;
	});
	name4.addEventListener("change",function(){
			
		lowStep4[3].querySelector(".result-name").innerHTML=name4.value;
		prevBox[3].firstElementChild.innerHTML=name4.value;
	});
	
//표지에 테스트명 넣어주기
	
		var lowStep1 = section.querySelector(".low-step1");
		var nameBox = lowStep1.querySelector(".testName-box");
		var title = nameBox.lastElementChild;
		var coverText = section.querySelector(".mainCover-text");
		
		title.addEventListener("change",function(){
		coverText.style.fontSize='35px';	
		coverText.innerHTML=title.value;
	});
});
	
// 성향 값 받아서 보여주기
window.addEventListener("load",function(){
	var section = document.querySelector("#create-container");
	var lowStep1 = section.querySelector(".low-step1");
	
	var typeInputBox = lowStep1.querySelector(".type-input");
	var type1 = typeInputBox.querySelector(".type1");
	var type2 = typeInputBox.querySelector(".type2");

	type1.addEventListener("change",function(e){
		
		//문제 페이지
		var prev1 = section.querySelectorAll(".preview-type1");
		for(var i =0; i<prev1.length; i++ ){
			prev1[i].value=type1.value;
		}
		//결과 페이지
		var result1 = section.querySelectorAll(".result-type1");
		for(var i =0; i<result1.length; i++ ){
			result1[i].innerText=type1.value;
		}
	});
	
	type2.addEventListener("change",function(e){
		
		var prev2 = section.querySelectorAll(".preview-type2");
		for(var i =0; i<prev2.length; i++ ){
			prev2[i].value=type2.value;
		}
		var result2 = section.querySelectorAll(".result-type2");
		for(var i =0; i<result2.length; i++ ){
			result2[i].innerText=type2.value;
		}
	});
	
	
});

// step6 -> deatil
//window.addEventListener("load",function(){
 //   var section = document.querySelector("#create-container");
 //   var resultPreview = section.querySelector(".result-preview");

//    resultPreview.onclick = function(event){
        // 이벤트
//        if(event.target.className =="result-preview"){
//            return;
//        }
//        var detail = window.open("/test/make/result-detail?id="+id, "","width=650,height=800,left=650,top=100");
 //       var detail = window.open("/test/make/result-detail", "","width=650,height=800,left=650,top=100");
 //   };

//});


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
    };
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
//다음페이지
    next.onclick = function(){
        if(current.nextElementSibling ==nav){
            //alert("해당 테스트를 등록하시겠습니까??");
			location.href="create-end";

            return;     
        }

        var form = current.firstElementChild;

        console.log("form 타입"+form.enctype);

        //기존 폼의 데이터 전송
		var formUrl = form.getAttribute('action');
		console.log("form action : " +formUrl )
		 var params = $("#"+form.id).serialize();
	

		if(current.classList.contains('low-step2')){
			
			 var formData = new FormData();
	
			var file = form.querySelector(".file");
			var f = file.files[0];
			
			formData.append("page",form.querySelector(".page").value);
			formData.append("question",form.querySelector(".question-content").value);
			formData.append("answer",form.querySelector(".answer1").value);
			formData.append("answer",form.querySelector(".answer2").value);
			
			var typeValues = form.querySelectorAll(".type-value");
			for(var i=0; i <4;i++)
				formData.append("type-value",typeValues[i].value);
			
			formData.append("file", f);
			
			var request = new XMLHttpRequest();
			request.open("POST", "/test/make/"+formUrl);
			request.send(formData);
			console.log("multipart");
			
		}else if(current.classList.contains('low-step4')){
			
			var formData = new FormData();
	
			var file = form.querySelector(".file");
			var f = file.files[0];
			
			console.log(form.querySelector(".page").value);
			formData.append("page",form.querySelector(".page").value);
			formData.append("result-content",form.querySelector(".result-content").value);
						
			formData.append("file", f);
			
			var request = new XMLHttpRequest();
			request.open("POST","/test/make/"+formUrl);
			request.send(formData);
			
		}else if(current.classList.contains('low-step5')){

			var formData = new FormData();
	
			var file = form.querySelector(".file");
			var f = file.files[0];
			
			formData.append("file", f);
			
			var request = new XMLHttpRequest();
			request.open("POST", "/test/make/"+formUrl);
			request.send(formData);
			
		}else{
			
		            $.ajax({
		                url:formUrl,
		                type:"POST",
		                data:params,
		                dataType : 'text', 
		                error:function(request,status,error){
			alert("테스트 등록에 실패하였습니다.");
        				//alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
      					},
		                success:function(data){
		                    //alert("성공!");	
		                }
		            });
		}
		
		current.classList.remove("active");
        current = current.nextElementSibling;
        current.classList.add("active");
    };

});
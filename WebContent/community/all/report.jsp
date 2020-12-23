<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../../../assets/css/reset.css" type="text/css"
	rel="stylesheet">
<link href="../../../assets/css/admin/community.css" type="text/css"
	rel="stylesheet">

<script type="text/javascript">


	 window.addEventListener("load", function() {
		 console.log("시작222");
		var reportReg = document.getElementById("reportReg");
		//var xInput = document.getElementByName("report-reason");
		
		console.log(reportReg);

		reportReg.onclick = function() {
			var check_count = document.getElementsByName("report-reason").length;
			var reason = 1;
			
	        for (var i=0; i<check_count; i++) {
	            if (document.getElementsByName("report-reason")[i].checked == true) {
	               reason = document.getElementsByName("report-reason")[i].value;
	               console.log(reason);
	            }
	        }

			load(reason);
			window.opener.location.reload(); //부모창 reload
			self.close();    //현재 팝업창 Close  
		}

		 function load(reason) {
			 if (reason == undefined)
				 reason = 1;
			var request = new XMLHttpRequest();
			request.onload = function() {
				if (request.readyState == 4) {
					console.log("성공");
	
				}
			}
			request.open("POST", "/community/all/report?id="+${id}+"&reason=" + reason, true);
			request.send();
		} 

	}); 
</script>
</head>
<body>


	<section class="report-section">
		<h1 class="title-name">게시글 신고</h1>
		<span class="title2-name">신고 사유를 선택해주세요</span>
		<form class="report-form">
			<input class="report-list" type="radio" name="report-reason" checked="checked" value="1" />성적인 게시글 <br>
			<input class="report-list" type="radio" name="report-reason" value="2" /> 폭력적인 또는 혐오스러운 게시글 <br>
			<input class="report-list" type="radio" name="report-reason" value="3" />증오 또는 학대하는 게시글 <br>
			<input class="report-list" type="radio" name="report-reason" value="4" />유해하거나 위험한 행위를 조장하는 게시글 <br>
			<input class="report-list" type="radio" name="report-reason" value="5" /> 스팸 또는 사용자를 현혹하는 게시글 <br>
			<input class="report-cancle-button" id="reportReg-cancle"
				type="button" value="취소">
			<input class="report-reg-button" id="reportReg"
				type="button" value="신고">
		</form>

	</section>

</body>
</html>
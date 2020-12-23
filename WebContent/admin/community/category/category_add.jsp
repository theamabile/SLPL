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
		var categoryReg = document.getElementById("category-reg");
		var xInput = document.getElementById("x-input");
		var yInput = document.getElementById("y-input");

		categoryReg.onclick = function() {
			var x = xInput.value;
			var y = yInput.value;

			load(x, y);

			window.opener.location.reload(); //부모창 reload
			self.close();    //현재 팝업창 Close  
		}

		function load(x, y) {
			if (x == undefined)
				alert("아이디 입력")
			if (y == undefined)
				alert("이름 입력")
			var request = new XMLHttpRequest();
			request.onload = function() {
				if (request.readyState == 4) {
					console.log("성공")

				}
			}
			request.open("POST", "/admin/community/category/category_add?id="
					+ x + "&name=" + y, true);
			request.send();
		}

	});
</script>
</head>
<body>


	<section class="community-add">
		<h1 class="title-name">커뮤니티 등록</h1>
		<form action="">




			<!-- <input type="text" id="x-input">
          <input type="text" id="y-input"> -->


			<div class="content">
				<div class="community-add-row">
					<span class="title">아이디</span> <input class="add-input" type="text"
						id="x-input" placeholder="아이디">
				</div>
				<div class="community-add-row">
					<span class="title">커뮤니티명</span> <input class="add-input"
						type="text" id="y-input" placeholder="커뮤니티명">

				</div>
				<input id="category-reg" class="community-add-button" type="button"
					value="등록">
			</div>
		</form>

	</section>

</body>
</html>
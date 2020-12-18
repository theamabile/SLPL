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

		categoryReg.onclick = function() {
			/* window.opener.location.reload();    //부모창 reload

			window.close();    //현재 팝업창 Close */

		};

	});
</script>
</head>
<body>


	<section class="community-add">
		<h1 class="title-name">커뮤니티 등록</h1>
		<form action="" method="post">
			<div class="content">
				<div class="community-add-row">
					<span class="title">아이디</span> <input class="add-input" type="text"
						name="id" placeholder="아이디">
				</div>
				<div class="community-add-row">
					<span class="title">커뮤니티명</span> <input class="add-input"
						type="text" name="name" placeholder="커뮤니티명">

				</div>
				<input id="category-reg" class="community-add-button" type="submit"
					value="등록">
			</div>
		</form>

	</section>

</body>
</html>
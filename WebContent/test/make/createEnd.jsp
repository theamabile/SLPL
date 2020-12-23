<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<!-- reset을 제일 위에 -->
<link rel="stylesheet" href="../../assets/css/reset.css" type="text/css">
<link rel="stylesheet" href="../../assets/css/common/style.css"
	type="text/css">
<link href="../../assets/css/test/test_make.css" type="text/css"
	rel="stylesheet">


</head>

<body>
	<!------------------------------------------- 헤더 -------------------------------------------------->
	<jsp:include page="../../common/header.jsp"></jsp:include>


	<section id="body" class="body">
		<div class="container">
			<main id="main" class="main">
				<!------------------------------------------- 메뉴  -------------------------------------------------->
				<jsp:include page="../../common/nav.jsp"></jsp:include>

				<section class="content">
					<div class="content-box">
						<h1 class="d-none">제작 완료 페이지</h1>
						<div class="create-end-container">
						<div class="cover-img-box" style="overflow:hidden">
							<div class="cover-img" >
							</div>
							</div>
							<div class="end-comment">
								<p>
									짝짝짝. <span>${nickName}</span>님의 < <span>${testName}</span> > 완성되었습니다!
								</p>
							</div>
							<nav class="end-nav">
								<input type="button" value="다른 테스트 제작 하러 가기"
									class="puple-button-m nav-button" onclick="location.href='formSelect.html';"> <input type="button"
									value="다른 테스트 참여하기" class="puple-button-m nav-button"  onclick="location.href='../list/test_list';">
								<input type="button" value="제작된 테스트 확인하기"
									class="puple-button-m nav-button" onclick="location.href='test/play/action?id?="+${cookie.testId.value}+"';">
							</nav>
						</div>
					</div>
				</section>
			</main>
		</div>
	</section>
	</main>
	</div>
	</section>
	<!------------------------------------------- 풋터  -------------------------------------------------->
	<jsp:include page="../../common/footer.jsp"></jsp:include>
</body>

</html>
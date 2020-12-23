<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>심리테스트</title>
<link rel="stylesheet" href="../../assets/css/reset.css" type="text/css">
<link rel="stylesheet" href="../../assets/css/common/style.css" type="text/css">
<link rel="stylesheet" href="../../assets/css/test/play.css" type="text/css">
<script type="text/javascript" src="../../assets/js/test/play/action.js"></script>
</head>
<script>
	
</script>
<body>
	<header id="header">
		<jsp:include page="../../common/header.jsp"></jsp:include>
	</header>

	<!-- 텍스트에 ()는 DB에서 입력받기 위함 -->
	<section id="body" class="body">
		<div class="container">
			<main id="main" class="main">
				<nav class="body-nav">
					<div>
						<ul class="body-menu">
							<li><a href="#">MAKE</a></li>
							<li><a href="#">TEST</a></li>
							<li><a href="#">COMMUNITY</a>
								<ul class="body-detail-menu">
									<li><a href="">전체게시판 </a></li>
									<li><a href="">민팥부 </a></li>
									<li><a href="">민팥찍 </a></li>
									<li><a href="">민슈부 </a></li>
									<li><a href="">민슈찍 </a></li>
									<li><a href="">반민팥부 </a></li>
									<li><a href="">반민팥찍 </a></li>
									<li><a href="">반민슈부 </a></li>
									<li><a href="">반민슈찍 </a></li>
								</ul></li>
						</ul>
					</div>
				</nav>

				<section id="aPart1" class="page">
					<c:forEach var="s" items="${list}">
						<div class="title">
							<span>${s.tName}</span>
						</div>
						<div class="cover-image">
							<img src="/test/coverImg?id=${s.tId}" alt="표지">
						</div>
						<a href="action?id=${s.tId}&qId=${s.qNum}" class="page-next-button move-button-m">테스트 참여하기</a>
					</c:forEach>
				</section>

				<section id="aPart2" class="page d-done">
					<section id="tA"></section>
					<section id="fA">
						<article class="top">
							<span class="order"></span> <span class="progress"></span>
						</article>
						<span class="title"></span>
						<article class="qna">
							<article class="content-container">

								<c:forEach var="i" begin="1" end="3">
									<input type="hidden" name="result1" class="result1 answer-button">
								</c:forEach>
								<button type="button" class="result1 result1-button move-button-m answer-button"></button>

								<c:forEach var="i" begin="1" end="3">
									<input type="hidden" name="result2" class="result2 answer-button">
								</c:forEach>
								<button type="button" class="result2 result2-button move-button-m answer-button"></button>

								<c:forEach var="i" begin="1" end="3">
									<input type="hidden" name="result3" class="result3 answer-button">
								</c:forEach>
								<button type="button" class="result3 result3-button move-button-m answer-button"></button>

								<c:forEach var="i" begin="1" end="3">
									<input type="hidden" name="result4" class="result4 answer-button">
								</c:forEach>
								<button type="button" class="result4 result4-button move-button-m answer-button"></button>
							</article>
						</article>
					</section>
				</section>
			</main>
		</div>
	</section>

	<!------------------------------------------- 풋터  -------------------------------------------------->
	<jsp:include page="../../common/footer.jsp"></jsp:include>
</body>
</html>
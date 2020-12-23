<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>인기테스트 관리</title>
<link href="../../../assets/css/reset.css" type="text/css"
	rel="stylesheet">
<link href="../../../assets/css/admin/style.css" type="text/css"
	rel="stylesheet">
<link href="../../../assets/css/admin/popularTest.css" type="text/css"
	rel="stylesheet">
</head>
<body>
	<!------------------------------------------- 헤더 -------------------------------------------------->
	<jsp:include page="../../common/header.jsp"></jsp:include>


	<div id="body" class="body">

		<!------------------------------------------- 메뉴  -------------------------------------------------->
		<jsp:include page="../../common/menu.jsp"></jsp:include>


		<main class="main">
			<section class="container align-center">
				<h1 class="d-none">인기테스트 관리 세부 화면</h1>
				<!-- container-item클래스가 꽉 채워진 박스 기준이라 min-width만 설정해주기 위해 member-container를 같이 넣어줌-->
				<div class="container-item detail-item">
					<a href="test"> 인기테스트 관리 </a>
					<h1>> 세부 정보</h1>
					<div class="detail-container">
						<div class="test-cover-regist">
							<div class="test-cover-img" style="background: center / cover no-repeat url('/admin/test/best/detail-cover?testId=${param.id}')">
							</div>
							<c:set var="t" items="${t}" />
							<form action="detail" method="post">
								<div class="regist-btns">
								<input name="id" type=text value="${t.id}" class="d-none">
								<input name="memberId" type=text value="${t.memberId}" class="d-none">
									<span>베스트 등록 상태 : <span>${t.bestState}</span></span> <input type="submit"
										name="reg" type="button" value="best" class="puple-button-m">
									<input type="submit" name="reg" type="button" value="nomal"
										class="puple-button-m">
								</div>
							</form>
						</div>

						<div class="writer-info">

							<c:set var="infor" items="${infor}" />
							<h2 class="title">제작한 회원 정보</h2>
							<ul class="info-box">
								<li><a class="info-tab">회원 아이디
										<div class="info-id">${infor.memberLoginId}</div>
								</a></li>
								<li><a class="info-tab"></span>제작한 테스트 수
										<div class="info-number">${infor.regCnt}</div></a></li>
								<li><a class="info-tab"></span>평균 조회수
										<div class="info-number">${infor.hitAvg}</div></a></li>
								<li><a class="info-tab"></span>평균 공유수
										<div class="info-number">${infor.shereAvg}</div></a></li>
								<li><a class="info-tab"></span>평균 추천수
										<div class="info-number">${infor.recommendAvg}</div></a></li>
								<li><a class="info-tab"></span>베스트 등록수
										<div class="info-number">${infor.bestCnt}</div></a></li>
							</ul>
						</div>
					</div>

				</div>
			</section>
			<!------------------------------------------- 풋터  -------------------------------------------------->
			<jsp:include page="../../common/footer.jsp"></jsp:include>
		</main>

	</div>




</body>
</html>
</body>
</html>
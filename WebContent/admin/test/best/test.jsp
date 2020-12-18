<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
<script src="../../../assets/js/admin/test/best/test.js"></script>
</head>
<body>
	<!------------------------------------------- 헤더 -------------------------------------------------->
	<jsp:include page="../../common/header.jsp"></jsp:include>


	<div id="body" class="body">

		<!------------------------------------------- 메뉴  -------------------------------------------------->
		<jsp:include page="../../common/menu.jsp"></jsp:include>


		<main class="main">
			<section class="container">
				<h1 class="d-none">인기테스트 관리 게시판</h1>

				<!-- container-item클래스가 꽉 채워진 박스 기준이라 min-width만 설정해주기 위해 member-container를 같이 넣어줌-->
				<div class="container-item popular-container">
					<h1>인기테스트 관리</h1>

					<div class="tools">
						<section class="filter">
							<h1 class="d-none">필터</h1>
							<form action="test">
								<select class="align" name="align">
									<option value="" selected disabled hidden>==정렬==</option>
									<option ${(param.align == "HIT_CNT")?"selected":""}
										value="HIT_CNT">조회 수</option>
									<option ${(param.align == "RECOMMEND_CNT")?"selected":""}
										value="RECOMMEND_CNT">추천 수</option>
									<option ${(param.align == "SHARE_CNT")?"selected":""}
										value="SHARE_CNT">공유 수</option>
								</select> <select class="best-state" name="best-state">
									<option value="" selected disabled hidden>==베스트 등록
										여부==</option>
									<option ${(param.best-state=="")?"selected":""} value="">전체</option>
									<option ${(param.best-state=="1")?"selected":""} value="1">베스트
										등록</option>
									<option ${(param.best-state =="0")?"selected":""} value="0">베스트
										비등록</option>
								</select> <input type="text" name="keyword" class="search-id"
									placeholder="아이디 검색" value="${param.keyword}"> <input
									type="submit" class="gray-button-m" value="검색">
							</form>
						</section>

					</div>
					<form action="test" method="post">
						<section class="list-container">
							<h1 class="d-none">인기 테스트 목록</h1>
							<table>
								<thead>
									<tr>
										<th class="w70">번호</th>
										<th class="w200">테스트 명</th>
										<th class="w110">제작자</th>
										<th class="w70">추천 수</th>
										<th class="w70">조회 수</th>
										<th class="w70">공유 수</th>
										<th class="w70">등록 여부</th>
										<th class="w40"><input type="checkbox" id="checkAll"></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="t" items="${list}">
										<tr>
											<td class="w70">${t.id}</td>
											<td class="w200"><a href="detail?id=${t.id}&memberId=${t.memberId}">${t.name}</a></td>
											<td class="w110">${t.memberId}</td>
											<td class="w70">${t.recommendCnt}</td>
											<td class="w70">${t.hitCnt}</td>
											<td class="w70">${t.shareCnt}</td>
											<td class="w70">${t.bestState}</td>
											<td class="w40"><input type="checkbox"
												name="check-state-id" value="${t.id}"></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</section>

						<section class="register-box">
							<h1 class="d-none">베스트 게시판 등록</h1>
							<input type="submit"  name="reg" value="best" class="puple-button-m">
							<input type="submit" name="reg" value="nomal" class="gray-button-m">
						</section>
					</form>

					<c:set var="page" value="${(param.p ==null)?1:param.p}"></c:set>
					<c:set var="startN" value="${page-(page-1)%5 }"></c:set>
					<c:set var="lastN" value="23"></c:set>

					<nav class="page-nav">
						<c:if test="${startN-1>1}">
							<a href="?p=${startN-1}&f= class="btn-prev">이전</a>
						</c:if>
						<c:if test="${startN-1<=1}">
							<span class="btn-prev">이전</span>
						</c:if>
						<ul class="page-list">
							<c:forEach var="i" begin="0" end="4">
								<li><a class="index"
									href="?p=${startN+i}&align=${param.align}&best-state=${param.best-state}&keyword=${param.keyword}">${startN+i}</a></li>
							</c:forEach>
						</ul>
						<c:if test="${startN+5<lastN}">
							<a href="?p=${startN+5}&f=&q=" class="btn-next">다음</a>
						</c:if>
						<c:if test="${startN+5>=lastN}">
							<span class="btn-next">다음</span>
						</c:if>
					</nav>
				</div>
			</section>


			<!------------------------------------------- 풋터  -------------------------------------------------->
			<jsp:include page="../../common/footer.jsp"></jsp:include>

		</main>

	</div>

</body>
</html>
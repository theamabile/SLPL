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

</head>
<body>
	<header class="header">
		<h1 class="d-none">심리플리</h1>

		<section class="logo">
			<h1 class="d-none">HOME</h1>
			<a href="index.html"> <img
				src="../../../assets/images/admin/admin-title.png" alt="홈" />
			</a>
		</section>

		<div class="title">ADMIN DASHBOARD</div>

		<div class="login-menu">
			<input type="button" id="logout" value="LOGOUT"
				class="white-button-s" />
		</div>
	</header>

	<div id="body" class="body">
		<nav>
			<h1 class="d-none">메인 메뉴</h1>
			<ul class="main-menu">
				<li>
					<div class="first-menu-item">
						<img class="menu-img"
							src="../../../assets/images/admin/admin_menu_dashboard.png"
							alt="대시보드" /> <a href="#">DASH BOARD</a>
					</div>
				</li>
				<li>
					<div class="first-menu-item">
						<img class="menu-img"
							src="../../../assets/images/admin/admin_menu_member.png"
							alt="회원 관리" /> <a href="#">MEMBER</a>
					</div>

					<ul>
						<li><a href="list.html">LIST</a></li>
						<li><a href="add.html">ADD</a></li>
					</ul>
				</li>
				<li>
					<div class="first-menu-item">
						<img class="menu-img"
							src="../../../assets/images/admin/admin_menu_community.png"
							alt="게시판 관리" /> <a href="#">COMMUNITY</a>
					</div>
				</li>
				<li>
					<div class="first-menu-item">
						<img class="menu-img"
							src="../../../assets/images/admin/admin_menu_test.png"
							alt="테스트 관리" /> <a href="#">TEST</a>
					</div>

					<ul>
						<li><a href="">맡으신거</a></li>
						<li><a href="">popularTest</a></li>
						<li><a href="">적어주세요</a></li>
					</ul>
				</li>
			</ul>
		</nav>


		<main class="main">
			<section class="container">
				<h1 class="d-none">인기테스트 관리 게시판</h1>

				<!-- container-item클래스가 꽉 채워진 박스 기준이라 min-width만 설정해주기 위해 member-container를 같이 넣어줌-->
				<section class="container-item popular-container">
					<h1>인기테스트 관리</h1>

					<div class="tools">
						<section class="filter">
							<h1 class="d-none">필터</h1>
							<form action="test" method="post">
								<select class="array" name="rray" >
								<option value="" selected disabled hidden>==정렬==</option>
									<option value="lookup-num">조회 수</option>
									<option value="recommend-num">추천 수</option>
									<option value="share-num">공유 수</option>
								</select>
								<select class="best-state" name="best-state">
								<option value="" selected disabled hidden>==베스트 등록 여부==</option>
									<option value="best">전체</option>
									<option value="best">베스트 등록</option>
									<option value="nomal">베스트 비등록</option>
								</select>
								 <input type="text" name="keyword" class="search-id"
									placeholder="아이디 검색"> <input type="submit"
									class="gray-button-m" value="검색">
							</form>
						</section>

					</div>


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
										<td class="w70">${t.testNo}</td>
										<td class="w200"><a href="detail">${t.title}</a></td>
										<td class="w110">${t.id}</td>
										<td class="w70">${t.recommendNum}</td>
										<td class="w70">${t.lookUpNum}</td>
										<td class="w70">${t.shareNum}</td>
										<td class="w70">${t.bestState}</td>
										<td class="w40"><input type="checkbox" name="checkMember"></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</section>

					<section class="register-box">
						<h1 class="d-none">베스트 게시판 등록</h1>
						<input type="button" value="Best 등록" class="puple-button-m">
						<input type="button" value="Best 삭제" class="gray-button-m">
					</section>
					<nav class="page-nav">
							<span class="btn-prev">이전</span>
						<ul class="page-list">
							<c:forEach var="i" begin="0" end="4">
								<li><a class="index" href="">${i+1}</a></li>
							</c:forEach>
						</ul>
							<span class="btn-next">다음</span>
					</nav>
				</section>
			</section>

			<footer class="footer">
				한국심리콘텐츠개발연구소<br> 대표이사 : 정혜진 사업자등록번호 : 197-06-18554 사업자 정보확인
				통신판매업 신고 : 2020-서울특별시-1102<br> 사업장주소 : 서울 종로구 인사동길 12 대일빌딩 7층,
				15층 대표번호 : 010-9965-2278 제품/서비스/멤버십: 1588-3366 구매문의 : 1588-6084<br>

				본 사이트의 컨텐츠는 저작권법의 보호를 받는 바 무단 전재, 복사, 배포 등을 금합니다.<br> 게시된 이메일
				주소가 자동 수집되는 것을 거부하며, 이를 위반 시 정보통신법에 의해 처벌됨을 유념하시기 바랍니다.<br>

				Copyright © 2020-2020 KCPDL. All Rights Reserved.<br>
			</footer>

		</main>

	</div>

</body>
</html>
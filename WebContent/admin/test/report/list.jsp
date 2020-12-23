<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>관리자 - 신고 테스트 목록 관리</title>
<link href="<%=request.getContextPath()%>/assets/css/reset.css" type="text/css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/assets/css/admin/style.css" type="text/css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/assets/css/admin/reportTest.css" type="text/css" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" rel="stylesheet">

<script>
	window.onload = function() {
		console.log("시작");

		var allCheckBox = document.getElementById("checkAll");
		var category = document.querySelector(".category");
		var categoryValue = category.options[category.selectedIndex].value;
		var checkIds = document.querySelectorAll(".checkId");
		var pageingOverPreButton = document
				.querySelector(".paging-over-pre-button");
		var pageingOverNextButton = document
				.querySelector(".paging-over-next-button");

		/* pageingOverPreButton.onclick = function(e) {
			alert("이전 페이지가 없습니다.");
		};
		
		pageingOverNextButton.onclick = function(e) {
			alert("다음 페이지가 없습니다.");
		}; */

		allCheckBox.onclick = function() {
			if (allCheckBox.checked) {
				for (var i = 0; i < checkIds.length; i++) {
					checkIds[i].checked = true;
				}
			} else if (allCheckBox.checked == false) {
				for (var i = 0; i < checkIds.length; i++) {
					checkIds[i].checked = false;
				}
			}
		}
	};
</script>
</head>
<body>
	<!-- header -->
	<jsp:include page="../../common/header.jsp"></jsp:include>

	<div id="body" class="body">
		<!-- menu  -->
		<jsp:include page="../../common/menu.jsp"></jsp:include>

		<!-- main -->
		<main class="main">
			<section class="container">
				<h1 class="d-none">신고 테스트 관리</h1>
				<!-- container-item클래스가 꽉 채워진 박스 기준이라 min-width만 설정해주기 위해 member-container를 같이 넣어줌-->
				<form action="list" method="get">
					<section class="container-item member-container">
						<h1>신고 테스트 목록</h1>
						<div class="tools">
							<section class="filter">
								<h1 class="d-none">필터</h1>

								<select name="key" class="category">
									<option value="testId">테스트 번호</option>
									<option value="memberId">신고자 아이디</option>
								</select>
								<input type="text" name="keyword" class="search-keyword" placeholder="검색어 입력">
								<input type="submit" class="gray-button-s" name="search" value="검색">

							</section>

							<section class="button-box">

								<h1 class="d-none">상태 변경</h1>
								<button type="submit" name="stateType" value="type1" class="puple-button-s type-change-button">선택 신고 중</button>
								<button type="submit" name="stateType" value="type2" class="puple-button-s type-change-button">선택 수정 중</button>
								<button type="submit" name="stateType" value="type3" class="puple-button-s type-change-button">선택 수정 완료</button>
								<button type="submit" name="stateType" value="type4" class="puple-button-s type-change-button">선택 수정 미완료</button>
								<div></div>
							</section>
						</div>

						<section>
							<h1 class="d-none">테스트 신고 목록</h1>

							<table class="table">
								<thead>
									<tr>
										<th>
											<input type="checkbox" id="checkAll">
										</th>
										<th>신고 번호</th>
										<th>테스트 번호</th>
										<th>신고자 아이디</th>
										<th>신고 유형</th>
										<th>경고쪽지 발송날짜</th>
										<th>신고 날짜</th>
										<th>상태</th>
									</tr>
								</thead>
								<tbody>

									<c:forEach var="r" items="${list}">
										<tr>
											<td>
												<input type="checkbox" class="checkId" name="checkId" value="${r.id}">
											</td>
											<td>${r.id}</td>
											<td>
												<a href="detail?id=${r.id}">${r.testId}</a>
											</td>
											<td>${r.memberId}</td>
											<td>${r.type}</td>
											<td>${r.warringMsgDate}</td>
											<td>${r.regdate}</td>
											<td>${r.state}</td>
										</tr>
									</c:forEach>

								</tbody>
							</table>

						</section>

						<c:set var="page" value="${(empty param.page == null)?1:param.page}" />
						<c:set var="startNum" value="${page-(page-1)%3}" />
						<c:set var="lastNum" value="23" />

						<div class="paging">
							<c:if test="${startNum>1}">
								<a href="?page=${startNum-1}&key=&keyword=">
									<i class="fas fa-angle-left"></i>
								</a>
							</c:if>
							<c:if test="${startNum<=1}">
								<a class="paging-button" href="?page=${startNum-1}&key=&keyword=" class="paging-over-pre-button">
									<i class="fas fa-angle-left"></i>
								</a>
							</c:if>

							<c:forEach var="i" begin="0" end="4">
								<a href="?page=${startNum+i}&key=&keyword=">${startNum+i}</a>
							</c:forEach>

							<c:if test="${startNum+5<lastNum}">
								<a href="?page=${startNum+5}&key=&keyword=">
									<i class="fas fa-angle-right"></i>
								</a>
							</c:if>
							<c:if test="${startNum+5>=lastNum}">
								<a href="?page=${startNum+5}&key=&keyword=" class="paging-over-next-button">
									<i class="fas fa-angle-right"></i>
								</a>
							</c:if>
						</div>
					</section>
				</form>
			</section>
			<!-- footer -->
			<jsp:include page="../../common/footer.jsp"></jsp:include>
		</main>
	</div>
</body>
</html>
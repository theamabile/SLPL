<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>관리자 - 회원관리</title>
<link href="../../../assets/css/reset.css" type="text/css"
	rel="stylesheet">
<link href="../../../assets/css/admin/style.css" type="text/css"
	rel="stylesheet">
<link href="../../../assets/css/admin/community.css" type="text/css"
	rel="stylesheet">

<script>
        
    window.onload = function() {
        console.log("시작");

        var allCheckBox = document.getElementById("checkAll");
        allCheckBox.onchange = function() {
            var checks = document.getElementsByName("checkMember");
            for(var check of checks) {
                check.checked = !(check.checked);
            }
        }
        
    };
    
    
    

    </script>
</head>
<body>
	<!------------------------------------------- 헤더 -------------------------------------------------->
	<jsp:include page="../../common/header.jsp"></jsp:include>

	<div id="body" class="body">

		<!------------------------------------------- 메뉴  -------------------------------------------------->
		<jsp:include page="../../common/menu.jsp"></jsp:include>


		<main class="main">
			<section class="container">
				<h1 class="d-none">공지글 관리</h1>

				<!-- container-item클래스가 꽉 채워진 박스 기준이라 min-width만 설정해주기 위해 member-container를 같이 넣어줌-->
				<section class="container-item member-container">
					<h1>공지글 관리</h1>

					<div class="tools">
						<section class="filter">
							<h1 class="d-none">필터</h1>
							<!--  <form>
                                <select class="category">
                                    <option value="name">이름</option>
                                    <option value="id">아이디</option>
                                </select>
                                <input type="text" name="keyword" class="search-keyword" placeholder="검색어 입력">
                                <input type="button" class="gray-button-m" name="search" value="검색"> 
                            </form> -->
				<!-- 			<form action="list" method="post">
								<div class="notice-select">
									<input class="select-checkbox" type="checkbox"
										name="checkCategory">전체 <input class="select-checkbox"
										type="checkbox" name="checkCategory" value=1>민슈찍 <input
										class="select-checkbox" type="checkbox" name="checkCategory"
										value=2>민슈부 <input class="select-checkbox"
										type="checkbox" name="checkCategory" value=8>반민슈찍 <input
										class="select-checkbox" type="checkbox" name="checkCategory"
										value=6>반민슈부 <input class="select-checkbox"
										type="checkbox" name="checkCategory" value=7>민팥찍 <input
										class="select-checkbox" type="checkbox" name="checkCategory"
										value=3>민팥부 <input class="select-checkbox"
										type="checkbox" name="checkCategory" value=5>반민팥찍 <input
										class="select-checkbox" type="checkbox" name="checkCategory"
										value=4>반민팥부
								</div>
							</form> -->

						</section>


					</div>
					<form action="delete" method="post">
						<section class="delete-box">
							<h1 class="d-none">삭제 메뉴</h1>
							<a class="a-puple-button-m" href="reg">공지글 작성</a> <input
								type="submit" value="삭제" class="gray-button-m">
						</section>
						<section>
							<h1 class="d-none">공지글 관리</h1>
							<table>
								<thead>
									<tr>
										<th><input type="checkbox" id="checkAll"></th>
										<th class="center">번호</th>
										<th class="center">커뮤니티명</th>
										<th class="center">공지글 제목</th>
										<th class="center">등록날짜</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="n" items="${list}">
										<tr>
											<td><input type="checkbox" class="checkMember"
												name="checkMember" value="${n.id}"></td>
											<td class="center"><a href="d">${n.id}</a></td>
											<td class="center"><a href="d">${n.categoryName}</a></td>
											<td>${n.title}</td>
											<td class="center">${n.regDate}</td>
										</tr>
									</c:forEach>
								</tbody>

							</table>

							<c:set var="page" value="${(param.p == null)?1:param.p}"></c:set>
							<c:set var="startNum" value="${page-(page-1)%5}"></c:set>
							<c:set var="lastNum"
								value="${fn:substringBefore(Math.ceil(count/5),'.') }"></c:set>


							<div class="pager">
								<c:if test="${startNum > 1}">
									<a
										href="?c=${param.c}&p=${startNum-1}&f=${param.f}&q=${param.q}"
										class="">이전</a>
								</c:if>
								<c:if test="${startNum <= 1}">
									<span onclick="alert('이전 페이지가 없습니다.');">이전</span>

								</c:if>


								<ul class="ul-pager">
									<c:forEach var="i" begin="0" end="4">
										<c:if test="${(startNum+i) <= lastNum}">
											<li class="li-pager"><a
												class="text- ${(page ==(startNum+i))?'purple': ''} bold"
												href="?c=${param.c}&p=${startNum+i}&f=${param.f}&q=${param.q}">${startNum+i}
											</a>
										</c:if>
									</c:forEach>
								</ul>

								<c:if test="${startNum+4 < lastNum}">
									<a
										href="?c=${param.c}&p=${startNum+5}&f=${param.f}&q=${param.q}"
										class="">다음</a>

								</c:if>

								<c:if test="${startNum+4 > lastNum}">
									<span onclick="alert('다음 페이지가 없습니다.');">다음</span>

								</c:if>
							</div>

						</section>
					</form>
				</section>

			</section>


			<!------------------------------------------- 풋터  -------------------------------------------------->

			<jsp:include page="../../common/footer.jsp"></jsp:include>

		</main>

	</div>

</body>
</html>
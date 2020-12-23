<%@page import="java.util.List"%>
<%@page import="com.slpl.web.service.community.*"%>
<%@page import="com.slpl.web.entity.community.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
<link rel="stylesheet" href="../../assets/css/community/community.css"
	type="text/css">


<script type="text/javascript">

ㄴ
	function showHideBox(obj) {
		var box = document.getElementById('dispBox'); // ShowHide 대상
		if (obj.checked) {
			box.style.display = "table-row-group"; // display속성을 block로 지정. Block와 줄바꿈을 함
			// box.style.display = "inline";              // inline 와 줄바꿈이 없음
		} else {
			box.style.display = "none"; // display 속성을 보이지 없앰.
		}

	}

	window.onload = function() {

		console.log("카테고리");
		var pager = document.getElementsByClassName('body-detail-menu')[0];

		pager.onclick = function(e) {
			e.preventDefault();
			var category = e.target.innerText;
			console.log(category);
			load(category);
		}

		function load(category) {
			if (category == undefined)
				category = "전체게시판";
			var request = new XMLHttpRequest();
			request.onload = function() {
				if (request.readyState == 4) {
					console.log("성공")
				}
			}
			request.open("POST", "/community/all/list?c=" + category, true);
			request.send();
		}

	}
</script>

</head>

<body>
	<%@include file="../../common/header.jsp"%>


	<section id="body" class="body">



		<div class="container">
			<main id="main" class="main">
				 <%@include file="../../common/nav.jsp"%>
			

				<section class="list content">

					<div class="breadcrumbs">
						<h4>글목록</h4>
						<ul>
							<li>community></li>
							<li>all</li>
						</ul>
					</div>
					<form class="table-form">
						<div class="search-form margin-top first align-right">

							<fieldset class="search-field">
								<label class="hidden">검색분류</label> <select class="searh-box"
									name="f">
									<option ${(param.f == "title")? "selected" : ""} value="title">제목</option>
									<option ${(param.f == "member_name")? "selected" : ""}
										value="member_name">글쓴이</option>
								</select> <label class="hidden">검색어</label> <input class="searh-box"
									type="text" name="q" value="${param.q }" /> <input
									class="button" type="submit" value="검색" /> <a
									href="write?c=${param.c}"><input class="button"
									type="button" value="글쓰기" /></a>
							</fieldset>



						</div>

						<!-- <div class="">
               </div> -->

						<h3 class="hidden">목록</h3>
						<div class="notice-hide-btn">
							<input type="checkbox" class="notice-checkBox"
								onclick="showHideBox(this)" /><span>공지글 보기</span>
						</div>

						<table class="list-table">
							<thead>
								<tr>
									<th>번호</th>
									<th>제목</th>
									<th>글쓴이</th>
									<th>작성일</th>
									<th>추천</th>
									<th>조회수</th>
								</tr>
							</thead>

							<tbody id="dispBox">
								<c:forEach var="notice" items="${notice}">
									<tr class="notice-list">
										<td colspan="4" class="left-padding50"><a
											href="detail?id=${notice.id}">${notice.title}</a></td>
										<td colspan="2" class="center">${notice.regDate}</td>

									</tr>
								</c:forEach>
							</tbody>

							<tbody>
								<c:forEach var="n" items="${list}">
									<tr>
										<td class="center">${n.num}</td>
										<td class="left"><a href="detail?c=${param.c}&id=${n.id}">${n.title}<span><a
													class="reply-cnt" href="reply_p?id=${n.id}">${n.commentCnt}</a></span></a></td>
										<td class="center">${n.memberNick}</td>
										<td class="center">${n.regDate}</td>
										<td class="center">${n.recommendCnt}</td>
										<td class="center">${n.hitCnt}</td>

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
					</form>


				</section>
			</main>
		</div>
	</section>
	<!--//content -->
	<%@include file="../../common/footer.jsp"%>
<%@page import="java.util.List"%>
<%@page import="com.slpl.web.service.community.*"%>
<%@page import="com.slpl.web.entity.community.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@include file="../../common/header.jsp"%>



<section id="body" class="body">



	<div class="container">
		<main id="main" class="main">
			<%-- <%@include file="../../common/nav.jsp"%> --%>
			<nav class="body-nav">
				<div class="my-info">
					<div class="my-info-container">
						<h5>내 정보</h5>
						<h3>심심풀이</h3>
						<div class="info-profile">
							 <img class="my-info-img"
								src="/assets/images/community/dog.jpg">
								<div class="my-info-nick"><span >닉네임</span></div>
								<div class="my-info-part"> <span >소속정보</span></div>
								
			
						</div>
						<div class="my-info-link" >
							<a href="#">내가쓴글</a> <a href="#">쪽지</a>
						</div>
						
						<div>
							<a href="write.jsp" class="write-button">글쓰기</a>
						</div>
					</div>
				</div>
				<div>
					<ul class="body-menu">
						<li><a href="#">MAKE</a></li>
						<li><a href="#">TEST</a></li>
						<li><a href="#">COMMUNITY</a>
						
						
							<ul class="body-detail-menu">
							
								<li value=""><a  href="/community/all/list?category=">전체게시판 </a></li>
								
								<li> <input> <a href="">민팥부 </a></li>
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

						<fieldset>
							<label class="hidden">검색분류</label> <select name="f">
								<option ${(param.f == "title")? "selected" : ""} value="title">제목</option>
								<option ${(param.f == "member_name")? "selected" : ""}
									value="member_name">글쓴이</option>
							</select> <label class="hidden">검색어</label> 
							<input type="text" name="q"
								value="${param.q }" /> <input class="button" type="submit"
								value="검색" /> <a href="write"><input class="button"
								type="button" value="글쓰기" /></a>
								<input class="hidden" name="categoryId" value="${list.categoryId}">
						</fieldset>



					</div>

					

					<h3 class="hidden">목록</h3>
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
						<tbody>

							<c:forEach var="n" items="${list}">

								<tr>
									<td class="center">${n.id}</td>
									<td class="left"><a href="detail?id=${n.id}">${n.title}<span><a
												class="reply-cnt" href="reply_p?id=${n.id}">${n.commentCnt}</a></span></a></td>
									<td class="center">${n.memberName}</td>
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
					

					<div>
						<c:if test="${startNum > 1}">
							<a href="?p=${startNum-1}&f=${param.f}&q=${param.q}" class="">이전</a>
						</c:if>
						<c:if test="${startNum <= 1}">
							<span onclick="alert('이전 페이지가 없습니다.');">이전</span>

						</c:if>


						<ul>
							<c:forEach var="i" begin="0" end="4">
								<c:if test="${(startNum+i) <= lastNum}">
									<li><a
										class="text- ${(page ==(startNum+i))?'purple': ''} bold"
										href="?p=${startNum+i}&f=${param.f}&q=${param.q}">${startNum+i}
									</a>
								</c:if>
							</c:forEach>
						</ul>

						<c:if test="${startNum+4 < lastNum}">
							<a href="?p=${startNum+5}&f=${param.f}&q=${param.q}" class="">다음</a>

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




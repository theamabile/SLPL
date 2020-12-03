<%@page import="java.util.List"%>
<%@page import="com.slpl.web.board.all.ListService"%>
<%@page import="com.slpl.web.board.all.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


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
</head>

<body>
	<header id="header">
		<div id="top_header" class="top_header">
			<div>mypage</div>
			<div>logout</div>
		</div>
		<div id="main_header" class="main_header">
			<ul class="main_nav">
				<a href="list"><img
					src="../../assets/images/common/logo.png" alt="MBTI로고"></a>

				<li><a href="#">MAKE</a></li>
				<li><a href="#">TEST</a></li>
				<li><a href="#">COMMUNITY</a></li>
			</ul>
		</div>
	</header>
	<!-- //header -->

	<section id="body" class="body">
		<div class="container">
			<main id="main" class="main">
				<nav class="body_nav">
					<ul>
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
				</nav>
				<section id="content" class="content">

					<div class="breadcrumbs">
						<h4>글보기</h4>
						<ul>
							<li>board ></li>
							<li>all</li>
						</ul>
					</div>

					<div class="margin-top first">
						<h3 class="hidden">공지사항 내용</h3>
						<table class="table">
							<tbody>
								<tr>
									<th>제목</th>
									<td class="text-align-left text-indent text-strong text-orange"
										colspan="3">${n.title}</td>
								</tr>
								<tr>
									<th>작성일</th>
									<td class="text-align-left text-indent" colspan="3"><fmt:formatDate
											value="${n.regDate}" pattern="yyyy-MM-dd hh:mm:ss" /></td>
								</tr>
								<tr>
									<th>작성자</th>
									<td>${n.userNick}</td>
									<th>조회수</th>
									<td>${n.hits}</td>
								</tr>
								<%-- <tr>
									<th>첨부파일</th>
									<td colspan="3"><c:forTokens var="fileName"
											items="${n.files}" delims="," varStatus="st">
											<fmt:formatDate var="year" value="${n.regdate}"
												pattern="yyyy" />

											<a download href="/static/notice/${year}/${n.id}/${fileName}">${fileName}</a>
											<c:if test="${st.last == false}">
                                	/
                                	</c:if>
										</c:forTokens></td>

								</tr> --%>
								<tr class="content">
									<td colspan="4">${n.content}</td>
								</tr>
							</tbody>
						</table>
					</div>


				</section>
			</main>
		</div>
	</section>
	<!--//content -->

	<footer id="footer" class="footer">
		<div class="container">


			<address>
				한국심리콘텐츠개발연구소 대표이사 : 정혜진 사업자등록번호 : 197-06-18554 사업자 정보확인 통신판매업 신고 :
				2020-서울특별시-1102 <br> 사업장주소 : 서울 종로구 인사동길 12 대일빌딩 7층, 15층 대표번호 :
				010-9965-2278 제품/서비스/멤버십: 1588-3366 구매문의 : 1588-6084
			</address>
			<br> 본 사이트의 컨텐츠는 저작권법의 보호를 받는 바 무단 전재, 복사, 배포 등을 금합니다. 게시된 이메일
			주소가 자동 수집되는 것을 거부하며, 이를 위반 시 정보통신법에 의해 처벌됨을 유념하시기 바랍니다.<br>
			Copyright © 2020-2020 KCPDL. All Rights Reserved.

		</div>
	</footer>
	<!-- //footer -->
</body>

</html>





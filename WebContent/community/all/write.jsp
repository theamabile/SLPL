<%@page import="java.util.List"%>
<%@page import="com.slpl.web.service.community.*"%>
<%@page import="com.slpl.web.entity.community.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../../common/header.jsp"%>

<!-- <!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
reset을 제일 위에
<link rel="stylesheet" href="../../assets/css/reset.css" type="text/css">
<link rel="stylesheet" href="../../assets/css/common/style.css"
	type="text/css">
<link rel="stylesheet" href="../../assets/css/community/write.css"
	type="text/css">
	
		<link rel="stylesheet" href="../../assets/css/community/community.css"
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
				<a href="index.html"><img
					src="../../assets/images/common/logo.png" alt="MBTI로고"></a>

				<li><a href="#">MAKE</a></li>
				<li><a href="#">TEST</a></li>
				<li><a href="#">COMMUNITY</a></li>
			</ul>
		</div>
	</header>
	//header -->

	<section id="body" class="body">
		<div class="container">
			<main id="main" class="main">
			<%@include file="../../common/nav.jsp"%>
				<!-- <nav class="body-nav">
					<div class="my-info">
						<div>
							<h5>내 정보</h5>
							<h3>심심풀이</h3>
							<div>
								<img alt="" src=""> <span>닉네임</span> <span>소속정보</span>
								<div>
									<a>내가쓴글</a> <a>쪽지</a>
									<div>
										<a href=""></a><input type="button" class="input" value="글쓰기">
									</div>
								</div>
							</div>
						</div>
					</div>
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
				</nav> -->
				<section  class="content write">
					<div class="content-box">
					<div class="breadcrumbs">
						<h4 class="hidden">글쓰기</h4>
						<ul>
							<li>community></li>
							<li>all</li>
						</ul>
					</div>
					<form method="post" enctype="multipart/form-data">
					<div>
						<input class="button" type="submit" value="등록">
						
						 <input class="button" type="button" value="목록">
					</div>
					
					<div>
						<select name="community">
							<option selected="selected">전체게시판</option>
							<option>민팥부</option>
							<option>민팥찍</option>
							<option>민슈부 </option>
							<option>민슈찍 </option>
							<option>반민팥부</option>
							<option>반민팥찍</option>
							<option>반민슈부</option>
							<option>반민슈찍 </option>
						</select>
					</div>
						<div>
							<input class="input-text input-title" type="text" placeholder="제목"
								name="title">
						</div>
						<div>
							<input class="input-text input-content" type="text" value=""
								name="content">
								<input type="file" value="파일 올리기"
								name="file">
						</div>
						<!-- <div>
							<input class="input-reply" type="textarea" min="1" max="200"
								placeholder="댓글작성..">
						</div> -->
						<!-- <div>
							<input class="input-text" type="text" value="작성자"> <input
								class="input-reply" type="text" value="댓글">
						</div> -->
					</form>
					</div>
				</section>
			</main>
		</div>
		
	</section>
	<!--//content -->

<%@include file="../../common/footer.jsp"%>





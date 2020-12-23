<%@page import="java.util.List"%>
<%@page import="com.slpl.web.service.community.*"%>
<%@page import="com.slpl.web.entity.community.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../../common/header.jsp"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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

 window.onload = function() {
    console.log("시작");

    console.log("시작22");
	//var recommendBtn = document.getElementById(".recommend-button");
	var regBtn =  document.getElementsByClassName("reg-button")[0];
	var commentBox = document.getElementsByClassName("input-reply")[0];
	//recommendBtn.
	
	regBtn.onclick = function(e){
        e.preventDefault();
    	if(commentBox.value == ""){
    		alert("댓글을 입력해주세요");
    	}
    	return;
    }
    
};  
   

    </script>

</head>

<body>
<jsp:include page="../../common/header.jsp"/>
	<section id="body" class="body">
		<div class="container">
			<main id="main" class="main">
				<jsp:include page="../../common/nav.jsp"/>
				<section class="content write">
					<div class="content-box">
					<div class="breadcrumbs">
						<h4 class="hidden">글쓰기</h4>
						<ul>
							<li>community></li>
							<li>all</li>
						</ul>
					</div>
					<form method="post" >
						<input class="button" type="submit" value="등록" >
						<a class="a-input" href="list?c=${param.c}">목록</a>
					
					
						<div>
							<input class="input-text input-title" type="text" placeholder="제목"
								name="title" value=" ${n.title}">
						</div>
						<div>
							<input class="input-text input-content" type="text" value=" ${n.content}"
								name="content">
						</div>
						<input name="id" value="${n.id}" class="hidden">
					</form>
					</div>
				</section>
			</main>
		</div>
		
	</section>
	<!--//content -->
	<jsp:include page="../../common/footer.jsp"/>





<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="my-info">
	<div class="my-info-container">
		<h5>내 정보</h5>
		<h3>심리플리</h3>
		<div class="info-profile">
			<div class="profile-img" style="background: center / cover no-repeat url('/admin/common/profile?id=${login.id}');"></div>
			<div class="my-info-texts">
				<div class="my-info-nick"><span>${login.nickname}</span></div>
				<div class="my-info-part"><span>${categoryName}</span></div>
			</div>
		</div>
		<div class="my-info-link" >
			<a href="#">내가쓴글</a> <a href="/member/message/list">쪽지</a>
		</div>
		
		<div>
			<a href="write.jsp" class="write-button">글쓰기</a>
		</div>
	</div>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
window.addEventListener("load", function() {
	var loginDiv = document.querySelector(".login");
	var logoutDiv = document.querySelector(".logout");

	if(loginDiv != null) {
		loginDiv.addEventListener("click", function(e){
			location.href="/admin/common/login";
	    });
	}
	
	if(logoutDiv != null) {
		logoutDiv.addEventListener("click", function(e){
			location.href="/admin/common/logout";
	    });
	}
});
</script>	

</head>
<body>
<header class="header">
        <h1 class="d-none"> 심리플리</h1>     

        <section class="logo">
            <h1 class="d-none">HOME</h1>            
            <a href="#">                    
                <img src="<%=request.getContextPath()%>/assets/images/admin/admin-title.png" alt="홈" />
            </a>    
        </section>
        
        <div class="title">
            ADMIN DASHBOARD
        </div>

		
       	<form action="login" method="get" class="login-menu">
       		<c:choose>
       			<c:when test="${login == null}">
       				<input type="submit" value="LOGIN" class="white-button-s login"/>
       			</c:when>
       			<c:otherwise>
					<div class="profile-img" style="background: center / cover no-repeat url('/admin/common/profile?id=${login.id}');"></div>   <!-- 물리주소 안됨 프로젝트로부터 갖고와야됨 -->
					<div class="loginName-box">
	       				<span class="loginName">${login.name}</span>
	       				<span>님 반가워요!</span>
       				</div>
       				<input type="button" value="LOGOUT" class="white-button-s logout" />  <!--  onclick="location.href='logout';" -->
       			</c:otherwise>
       		</c:choose>
       	</form>
    </header>

</body>
</html>
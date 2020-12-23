<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 - 회원관리</title>
<link href="../../assets/css/reset.css" type="text/css" rel="stylesheet">
<link href="../../assets/css/admin/style.css" type="text/css" rel="stylesheet">
<link href="../../assets/css/admin/member.css" type="text/css" rel="stylesheet">

<script type="text/javascript" src="../../assets/js/admin/member/login.js"></script>

</head>
<body>
<!------------------------------------------- 헤더 -------------------------------------------------->
    <jsp:include page="header.jsp"></jsp:include> 
	
    <div id="body" class="body" >  
        <!------------------------------------------- 메인  -------------------------------------------------->
        <main class="main">
            <section class="container">
                <h1 class="d-none"> 로그인 </h1> 
                <div class="login-container">
                    <section class="container-item">
                        <h1 class="d-none"> LOGIN </h1> 
                        <div class="login-img">
                            <img src="<%=request.getContextPath()%>/assets/images/member/login_icon.png" alt="LOGIN">
                        </div>
                        <form action="login" method="post" class="loginForm">
                            <input type="text" name="loginId" class="input-wf loginId" placeholder="ID"><br>
                            <input type="password" name="pw" class="input-wf pw" placeholder="PASSWORD"><br>
                            
                            <input type="hidden" name="return-url" value="${returnUrl}" />
                            <input type="submit" class="puple-button-wf loginBtn" value="LOGIN"> 
                        </form>
                    </section>
                </div>
            </section>
            
        	<!------------------------------------------- 풋터  -------------------------------------------------->
            
            <jsp:include page="footer.jsp"></jsp:include> 
        </main>

    </div>
</body>
</html>
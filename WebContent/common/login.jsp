<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../assets/css/reset.css" type="text/css">
<link rel="stylesheet" href="../assets/css/common/style.css" type="text/css">
<link rel="stylesheet" href="../assets/css/member/member.css" type="text/css">

<script type="text/javascript" src="../assets/js/common/login.js"></script>

</head>
<body>

<!------------------------------------------- 헤더 -------------------------------------------------->
   <jsp:include page="header.jsp"></jsp:include> 
	

   <section id="body" class="body">
      <div class="container">
         <main id="main" class="main">
              <section class="content login-content">
              	<div class="login-container">
              		<h1 class="d-none">로그인</h1>
                    <div class="login-img">
                        <img src="../assets/images/member/login_icon.png" alt="LOGIN">
                    </div>
                    <form action="login" method="post" class="loginForm">
                        <input type="text" name="loginId" class="input-wf loginId" placeholder="아이디"><br>
                        <input type="password" name="pw" class="input-wf pw" placeholder="패스워드"><br>
                        <div class="button-box">
                        	<div class="security-box"> 
                        		<input type="checkbox" name="security">보안접속</input>
                        	</div>
                        	
                        	<div class="find-box">
                        		<span><a href="findId.jsp">아이디 찾기</a></span>
								<span>|</span>
                        		<span><a href="/findPw.jsp">비밀번호 찾기</a></span>
                        	</div>
                        </div>
                        
                        <input type="hidden" name="return-url" value="${returnUrl}" />
                        <input type="submit" class="puple-button-wf loginBtn" value="로그인"> 
                        <input type="button" class="puple-border-button-wf join-button" value="회원가입"> 
                    </form>
              	</div>
            </section>
         </main>
      </div>
   </section>
   
   <!------------------------------------------- 풋터  -------------------------------------------------->
   <jsp:include page="footer.jsp"></jsp:include> 

</body>
</html>
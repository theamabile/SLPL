<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../../assets/css/reset.css" type="text/css">
<link rel="stylesheet" href="../../assets/css/common/style.css" type="text/css">
<link rel="stylesheet" href="../assets/css/member/member.css" type="text/css">

<script src="../../assets/js/member/member.js"></script>
</head>
<body>

 <header id="header">
      <div id="top_header" class="top_header">
         <div>mypage</div>
         <div>logout</div>
      </div>
      <div id="main_header" class="main_header">
         <ul class="main_nav">
            <a href="list"><img src="../../assets/images/common/logo.png"
               alt="MBTI로고"></a>

            <li><a href="#">MAKE</a></li>
            <li><a href="#">TEST</a></li>
            <li><a href="#">COMMUNITY</a></li>
         </ul>
      </div>
   </header>

   <section id="body" class="body">
      <div class="container">
         <main id="main" class="main">
              <section class="content login-content">
              	<div class="login-container">
              		<h1 class="d-none">로그인</h1>
                    <div class="login-img">
                        <img src="../assets/images/member/login_icon.png" alt="LOGIN">
                    </div>
                    <form>
                        <input type="text" name="id" class="input-wf" placeholder="아이디"><br>
                        <input type="password" name="pw" class="input-wf" placeholder="패스워드"><br>
                        <div class="button-box">
                        	<div class="security-box"> 
                        		<input type="checkbox" name="security">보안접속</input>
                        	</div>
                        	
                        	<div class="find-box">
                        		<span><a href="/member/findId.jsp">아이디 찾기</a></span>
								<span>|</span>
                        		<span><a href="/member/findPw.jsp">비밀번호 찾기</a></span>
                        	</div>
                        </div>
                        
                        <input type="submit" class="puple-button-wf" value="로그인"> 
                        <input type="button" class="puple-border-button-wf join-button" value="회원가입"> 
                    </form>
              	</div>
            </section>
         </main>
      </div>
   </section>
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

</body>
</html>
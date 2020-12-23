<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 - 회원추가</title>
<link href="../../assets/css/reset.css" type="text/css" rel="stylesheet">
<link href="../../assets/css/admin/style.css" type="text/css" rel="stylesheet">
<link href="../../assets/css/admin/member.css" type="text/css" rel="stylesheet">

<script src="../../assets/js/admin/member/add.js"></script>
</head>
<body>
<!------------------------------------------- 헤더 -------------------------------------------------->
    <jsp:include page="../common/header.jsp"></jsp:include> 
	
    <div id="body" class="body" >  
        
        <!------------------------------------------- 메뉴  -------------------------------------------------->
        <jsp:include page="../common/menu.jsp"></jsp:include>


        <!------------------------------------------- 메인  -------------------------------------------------->
        <main class="main">
			<section class="container">
                <h1 class="d-none"> 회원관리 </h1> 

                <div class="detail-container">  <!-- container-item클래스로 제작된걸 사이징만 해주기 위해 감쌌음 -->
                    <section class="container-item">     
                        <h1> 회원 추가 </h1> 
                        <form action="/admin/member/add" method="post" class="input-form" enctype="multipart/form-data">
                            <div class="form-group">
                                
                                <div class="id-box">
	                                <label>아이디</label>
	                                <input type="text" name="loginId" class="input-wf loginId" placeholder="아이디" required/>
	                                <span class="infoText"></span>
                               		<input type="hidden" class="loginIdConfirm" value="n">
                                </div>
                                
								<label>비밀번호</label>
                                <input type="password" name="pw" class="input-wf" placeholder="비밀번호" required="required"/>
                                
								<label>이름</label>
                                <input type="text" name="name" class="input-wf" placeholder="이름" autofocus required/>
                 
                                <div class="nickname-box">
                                	<label>닉네임</label>    
                                    <input type="text" name="nickname" class="input-wf nickname" placeholder="닉네임" required/>
                                    <span class="infoText"></span>
                               		<input type="hidden" class="nicknameConfirm" value="n"/>
                                </div>
                                
                            </div>
                            
                            <div class="form-group">
                                <label>휴대전화</label>
                                <input type="number" name="phoneNumber" value="01033337777" class="input-wf" pattern="01[016789]\d{3,4}\d{4}" placeholder="01088886666" required/>
                         
                                <label>이메일</label>
                                <div class="email-box">
                                    <input type="text" name="emailId" value="test123334" placeholder="이메일" list="emailAddress"/>
                                    @ 
                                    <select name="emailAddress">
                                        <option value="naver.com">naver.com</option>
                                        <option value="daum.net">daum.net</option>
                                        <option value="hanmail.net">hanmail.net</option>
                                        <option value="gmail.com">gmail.com</option>
                                        <option value="none">직접입력</option>
                                    </select>
                                    <%-- none일경우 직접입력하고 직접입력 활성화 시 required 되도록 자바스크립트 작업 필요 --%>
                                    <input type="text" name="customAddress" class="customAddress" placeholder="naver.com" disabled="true">
                                </div>
                                
                                <label>생년월일</label>
                                <div class="birth-box">
                                    <input type="number" name="year" list="year" placeholder="1997"/> 
                                        <datalist id="year">
	                                        <c:forEach var="year" begin="1900" end="2020">
	                                        	<option value="${year}">${year}</option>
	                                        </c:forEach>
                                        </datalist>
                                    <input type="number" name="month" list="month" pattern="[1-12]" placeholder="6"/>
                                        <datalist id="month">
                                            <c:forEach var="month" begin="1" end="12">
	                                        	<option value="${month}">${month}</option>
	                                        </c:forEach>
                                        </datalist>
                    
                                    <input type="number" name="day" list="day" placeholder="18"/> 
                                        <datalist id="day">
                                            <c:forEach var="day" begin="1" end="31">
	                                        	<option value="${day}">${day}</option>
	                                        </c:forEach>
                                        </datalist>
                                </div>
                            </div>
                            
                            
                           	<div class="gender-group">
                                <label>성별</label>
                                <div class="radio-group">
                                	<div class="radio-btn">
                                		 <input type="radio" value="남자" name="gender" class="radio-item" required>남자</input>
                                	</div>
                                	<div class="radio-btn">
                                		<input type="radio" value="여자" name="gender" class="radio-item">여자</input>
                                	</div>
                                	<div class="radio-btn">
                                		<input type="radio" value="선택안함" name="gender" class="radio-item">선택안함</input>
                                	</div>
                                </div>
                           	</div>
                           	
                            <div class="profile-group">
                               	<label>프로필 이미지</label>
								<div class="input-btn-box">
									<input type="file" name="profile" />
									<a download href="/static/notice/${year}/${n.id}/${fileName}">${m.profileImg}</a>
								</div>
                            </div>
								
                            <div class="form-group">
                                <label>소속</label>
                                <select name="category" class="input-wf">
	                                <c:forEach var="c" items="${categorys}">
	                                	<option value="${c.id}">${c.name}</option>
	                                </c:forEach>
                                </select>
                                
                                <label>권한</label>
                                <select name="authority" class="input-wf">
                                    <option value="admin">관리자</option>
                                    <option value="user" selected>회원</option>
                                </select>
                            </div>
                            
                            <div class="button-area">
                                <input type="submit" value="추가" class="puple-button-wf submit-button"/> 
                            </div>
                            
                        </form>
                    </section >
                </div>   
            </section>

<!------------------------------------------- 풋터  -------------------------------------------------->
            
            <jsp:include page="../common/footer.jsp"></jsp:include> 
        </main>

    </div>


</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>관리자 - 회원관리</title>
<link href="../../assets/css/reset.css" type="text/css" rel="stylesheet">
<link href="../../assets/css/admin/style.css" type="text/css" rel="stylesheet">
<link href="../../assets/css/admin/member.css" type="text/css" rel="stylesheet">

<script src="../../assets/js/admin/member/detail.js"></script>
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
                        <h1> 회원 정보 수정 </h1> 
                        <form method="post" enctype="multipart/form-data" class="input-form">
                            <div class="form-group">
                            
                            	<label>아이디</label>
                                <input type="text" name="loginId" class="input-wf loginId"  value="${member.loginId}"  placeholder="아이디" required readonly>
                                
                                <label>비밀번호</label>
                                <input type="password" name="pw" class="input-wf password" value="${member.pw}" placeholder="비밀번호" required>
                                
                                <label>이름</label>
                                <input type="text" name="name" class="input-wf name-input" value="${member.name}" placeholder="이름" autofocus required>
                                
                                <div class="nickname-box">
                                	<label>닉네임</label>    
                                    <input type="text" name="nickname" class="input-wf nickname" value="${member.nickname}" placeholder="닉네임" required/>
                                    <span class="infoText"></span>
                               		<input type="hidden" class="nicknameConfirm" value="n"/>
                                </div>
                                
                            </div>
                            
                            <div class="form-group">
                                <label>휴대전화</label>
                                <input type="number" name="phoneNumber" class="input-wf" value="${member.phoneNumber}" pattern="01[016789]-\d{3,4}-\d{4}" placeholder="010-8888-6666" required>
                         
                                <label>이메일</label>
                                <div class="email-box">
                                	
                                    <input type="text" name="emailId" placeholder="이메일" value="${emailId}">
                                    @ 
                                    <select name="emailAddress">
                                        <option value="naver.com" <c:if test="${emailAddress eq 'naver.com'}">selected</c:if> >naver.com</option>
                                        <option value="daum.net" <c:if test="${emailAddress eq 'daum.net'}">selected</c:if> >daum.net</option>
                                        <option value="hanmail.net" <c:if test="${emailAddress eq 'hanmail.net'}">selected</c:if> >hanmail.net</option>
                                        <option value="gmail.com" <c:if test="${emailAddress eq 'gmail.com'}">selected</c:if> >gmail.com</option>
                                        <option value="none" <c:if test="${isCustomAddr == true}">selected</c:if> >직접입력</option>
                                    </select>
                                    
                                    <c:choose> 
                                    	<c:when test="${isCustomAddr == true}"> 
                                    		<input type="text" name="customAddress" class="customAddress" placeholder="naver.com" value="${emailAddress}">
                                    	</c:when>
									    <c:otherwise> 
									    	<input type="text" name="customAddress" class="customAddress" placeholder="naver.com" readonly>
									    </c:otherwise>
									</c:choose>
                                </div>
                                
                                <label>생년월일</label>
                                <div class="birth-box">
                                	<fmt:formatDate var="birthYear" value="${member.birthday}" pattern="yyyy"/>
                                    <input type="number" name="year" list="year" placeholder="1997" value="${birthYear}">
                                        <datalist id="year">
	                                        <c:forEach var="year" begin="1900" end="2020">
	                                        	<option value="${year}">${year}</option>	                                        	
	                                        </c:forEach>
                                        </datalist>
                                        
                                    <fmt:formatDate var="birthMonth" value="${member.birthday}" pattern="MM"/>
                                    <input type="number" name="month" list="month" pattern="[1-12]" placeholder="6" value="${birthMonth}">
                                        <datalist id="month">
                                            <c:forEach var="month" begin="1" end="12">
	                                        	<option value="${month}">${month}</option>
	                                        </c:forEach>
                                        </datalist>
                    				
                    				<fmt:formatDate var="birthDay" value="${member.birthday}" pattern="dd"/>
                                    <input type="number" name="day" list="day" placeholder="18" value="${birthDay}"> 
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
                                		<input type="radio" value="남자" name="gender" class="radio-item" 
                                   			<c:if test="${member.gender eq '남자'}">checked</c:if>>남자</input>
                                	</div>
                                    <div class="radio-btn">
                                    	<input type="radio" value="여자" name="gender" class="radio-item"
                                    		<c:if test="${member.gender eq '여자'}">checked</c:if>>여자</input>
                                    </div>
                                    <div class="radio-btn">
                                    	<input type="radio" value="선택안함" name="gender" class="radio-item"
                                    		<c:if test="${member.gender eq '선택안함'}">checked</c:if>>선택안함</input>
                               		</div>
                                </div>
                           	</div>
                           	
                            <div class="profile-group">
                              	<label>프로필 이미지</label>
								<div class="input-btn-box">
									<input type="file" name="profile" />
									<a download href="/static/notice/${year}/${n.id}/${member.profileImg}">${member.profileImg}</a>
								</div>
                            </div>
                            
							
                            <div class="form-group">
                            	<label>가입일</label>
								<fmt:formatDate var="regdate" value="${member.regdate}" pattern="yyyy-MM-dd hh:mm:ss"/>
								<input type="text" name="regdate" value="${regdate}" class="input-wf" readonly>  
								
                                <label>소속</label>
                                <select name="category" class="input-wf">
	                                <c:forEach var="c" items="${categorys}">
	                                	<option value="${c.id}" <c:if test="${c.id eq member.categoryId}">selected</c:if> >${c.name}</option>
	                                </c:forEach>
                                </select>                                

                                <label>권한</label>
                                <select id="authority" name="authority" class="input-wf">
                                    <option value="admin" <c:if test="${'admin' eq member.authority}">selected</c:if> >관리자</option>
                                    <option value="user" <c:if test="${'user' eq member.authority}">selected</c:if> >회원</option>
                                </select>
                            </div>
                            
                            <div class="button-area">
                            	<input type="hidden" name="id" value="${member.id}" class="no-input">
                                <input type="submit" value="수정" class="puple-button-wf submit-button"> 
                            	<input type="button" value="삭제" class="gray-button-wf delete-button"> 
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
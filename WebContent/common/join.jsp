<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../assets/css/reset.css" type="text/css">
<link rel="stylesheet" href="../assets/css/common/style.css" type="text/css">
<link rel="stylesheet" href="../assets/css/member/member.css" type="text/css">
<script src="../assets/js/member/detail.js"></script>
</head>
<body>

	<!------------------------------------------- 헤더 -------------------------------------------------->
    <jsp:include page="header.jsp"></jsp:include> 
	

	<section id="body" class="body">
		<div class="container">
			<main id="main" class="main">
				<!------------------------------------------- 메뉴  -------------------------------------------------->
       			<jsp:include page="nav.jsp"></jsp:include>


				<section class="content">
					<div class="join-container">
						<h4>회원 가입</h4>
						<form action="join" name="member" method="post" class="joinForm" enctype="multipart/form-data">
							<div class="form-group">
								<div class="input-btn-box">
									<label>아이디<span class="required-text">*</span></label> 
									<div class="id-box">
										<input type="text" name="loginId" class="loginId" placeholder="아이디" required> 
										<span class="infoText"></span>
		                                <input type="hidden" class="loginIdConfirm" value="n">
									</div>
								</div>
								
								<div class="input-box">
									<label>비밀번호<span class="required-text">*</span></label>
									<input type="password" name="pw" placeholder="비밀번호" required>
								</div>
								<div class="input-box">
									<label>이름<span class="required-text">*</span></label>
									<input type="text" name="name" placeholder="이름" autofocus required>
								</div>

								<div class="input-btn-box">
									<label>닉네임<span class="required-text">*</span></label>
									<div class="nickname-box">
										<input type="text" name="nickname" class="nickname" placeholder="닉네임" required>
										<span class="infoText"></span>
	                                	<input type="hidden" class="nicknameConfirm" value="n">
									</div>
								</div>
								
							</div>

							<div class="form-group">
								<div class="input-box">
									<label>휴대전화<span class="required-text">*</span></label> 
									<input type="number" name="phoneNumber" pattern="01[016789]\d{3,4}\d{4}" placeholder="01088886666" required>
								</div>

								<div class="input-box">
									<label>이메일<span class="required-text">*</span></label>
									<div class="email-box">
										<input type="text" name="emailId" placeholder="이메일" list="emailAddress" required> @ 
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
								</div>
							</div>


							<div class="form-group">
								<div class="input-box">
									<label>생년월일</label>
									<div class="birth-box">
										<input type="number" name="year" list="year" placeholder="1997">
										<datalist id="year">
											<c:forEach var="year" begin="1900" end="2020">
												<option value="${year}">${year}</option>
											</c:forEach>
										</datalist>
										
										<input type="number" name="month" list="month" pattern="[1-12]" placeholder="6">
										<datalist id="month">
											<c:forEach var="month" begin="1" end="12">
												<option value="${month}">${month}</option>
											</c:forEach>
										</datalist>

										<input type="number" name="day" list="day" placeholder="18">
										<datalist id="day">
											<c:forEach var="day" begin="1" end="31">
												<option value="${day}">${day}</option>
											</c:forEach>
										</datalist>
									</div>
								</div>

                           	
	                            <div class="input-box">
	                               	<label>프로필 이미지</label>
									<div class="input-btn-box">
										<input type="file" name="profile" />
										<a download href="/static/notice/${year}/${n.id}/${fileName}">${m.profileImg}</a>
									</div>
	                            </div>
	                            
	                            <div class="input-box">
	                                <label>소속</label>
	                                <select name="category">
		                                <c:forEach var="c" items="${categorys}">
		                                	<option value="${c.id}">${c.name}</option>
		                                </c:forEach>
	                                </select>
                                </div>
								
								<div class="input-box">
									<label>성별</label>
									<div class="radio-group">
										<input type="radio" value="man" name="gender" class="radio-item">남자</input>
										<input type="radio" value="girl" name="gender" class="radio-item">여자</input> 
										<input type="radio" value="none" name="gender" class="radio-item">선택안함</input>
									</div>
								</div>
							</div>
							
							<div class="button-area">
								<input type="submit" value="가입" class="puple-button-wf submit-button">
							</div>

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
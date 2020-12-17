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
				<nav class="body-nav">
					<div class="my-info">
						<div class="my-info-container">
							<h5>내 정보</h5>
							<h3>심심풀이</h3>
							<div>
								<img class="my-info-img" src="/assets/images/community/dog.jpg">
								<span>닉네임</span> <span>소속정보</span>

							</div>
							<div class="my-info-link">
								<a href="#">내가쓴글</a> <a href="#">쪽지</a>
							</div>

							<div>
								<a href="write.jsp" class="write-button">글쓰기</a>
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
				</nav>

				<section class="content">
					<div class="join-container">
						<h4>회원 가입</h4>
						<form action="/admin/member/add" name="member" method="post">
							<div class="form-group">
								<div class="input-btn-box">
									<label>아이디<span class="required-text">*</span></label> 
									<input type="text" name="loginId" placeholder="아이디" required> 
									<input type="button" name="nickname_confirm" class="gray-button-m" value="중복확인">
								</div>
								<div class="input-box">
									<label>비밀번호<span class="required-text">*</span></label>
									<input type="password" name="pw" placeholder="비밀번호" required>
								</div>
								<div class="input-box">
									<label>이름<span class="required-text">*</span></label>
									<input type="text" name="name"  placeholder="이름" autofocus required>
								</div>

								<div class="input-btn-box">
									<label>닉네임<span class="required-text">*</span></label>
									<input type="text" name="nickname" placeholder="닉네임" required>
									<input type="button" name="nickname_confirm" class="gray-button-m" value="중복확인">
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
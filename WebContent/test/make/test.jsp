<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<link href="../../assets/css/test/test_make.css" type="text/css"
	rel="stylesheet">
<script src="../../assets/js/test/make/test.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

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
					<div class="content-box">
						<h1 class="d-none">테스트 제작 페이지</h1>
						<div class="create-container" id="create-container">
							<div class="title">
								<h1>테스트 제작</h1>
								<input type="range">
							</div>
							<section class="input-container low-step1 active">
								<form id="reg-test"  action="reg-test" method="post">
									<div class="testName-box">
										<h1>테스트명</h1>
										<input type="text" maxlength="20" autofocus
											placeholder="테스트명을 작성해주세요" name="test-name">
									</div>
									<div class="type-box">
										<h1>성격 유형</h1>
										<input type="button" class="gray-button-s" value="예시보기">
										<p class="ex-list d-none">
											다음 유형들을 참고하세요 <br> <br> 친화력, 협동성, 사교적, 성실함, 인내심,
											정직성<br> 책임감, 현실적, 능동적, 비열함, 사회성, 냉철함<br> 자발성, 위법성,
											나태함, 능동성, 폭력성, 신뢰성<br> 지도성, 사교성, 집중력, 침착성, 창의성, 인내성
										</p>
										<div class="type-input">
											<span>1</span> <input name="types" type="text"> <span>2</span>
											<input name="types" type="text">
										</div>
									</div>
								</form>
							</section>
							<section class="input-container low-step2">
								<form id="reg-question" action="reg-question" method="post">
									<div class="question-container">
										<P>1/6</P>
										<div class="question">
											<span>문제1</span> <input type="text">
										</div>
									</div>
									<div class="question-img-box">
										<div class="question-img">
											<button class="puple-button-s">이미지 등록</button>
										</div>
									</div>
									<div class="answer-box">
										<input type="text" class="type" placeholder="도덕성" readonly>
										<input type="text" class="type" placeholder="유연성" readonly>
										<div class="answer-set">
											<span>선택지1</span> <input type="text"> <select
												name="type-value" class="type-value">
												<option value="-1">-1</option>
												<option value="0">0</option>
												<option value="1">1</option>
											</select> <select name="type-value" class="type-value">
												<option value="-1">-1</option>
												<option value="0">0</option>
												<option value="1">1</option>
											</select>
										</div>
										<div class="answer-set">
											<span>선택지2</span> <input type="text"> <select
												name="type-value" class="type-value">
												<option value="-1">-1</option>
												<option value="0">0</option>
												<option value="1">1</option>
											</select> <select name="type-value" class="type-value">
												<option value="-1">-1</option>
												<option value="0">0</option>
												<option value="1">1</option>
											</select>
										</div>
									</div>
								</form>
							</section>
							<section class="input-container low-step3">
								<form id="reg-result-name" action="" method="post">
									<h1 class="title-h1">결과 이름 짓기</h1>
									<div class="name-container">
										<div class="types">
											<input type="text" class="type" placeholder="도덕성" readonly>
											<input type="text" class="type" placeholder="유연성" readonly>
										</div>
										<div class="result-name-container">
											<p>결과1</p>
											<input type="text" readonly> <input type="text"
												readonly> <input type="text" class="result-name">
										</div>
										<div class="result-name-container">
											<p>결과2</p>
											<input type="text" readonly> <input type="text"
												readonly> <input type="text" class="result-name">
										</div>
										<div class="result-name-container">
											<p>결과3</p>
											<input type="text" readonly> <input type="text"
												readonly> <input type="text" class="result-name">
										</div>
										<div class="result-name-container">
											<p>결과4</p>
											<input type="text" readonly> <input type="text"
												readonly> <input type="text" class="result-name">
										</div>
								</form>
							</section>
								<section class="input-container low-step4">
								<form id="reg-result-content" action="" method="post">
									<div class="result-detail-container">
										<div class="detail-content">
											<div>
												<p>도덕성</p>
												<p>사교성</p>
											</div>
											<p class="result-name">결과이르으으음</p>
											<textarea name="" class="result-content"
												placeholder="결과에 대한 설명을 작성해주세요"></textarea>
										</div>
										<div class="img-container">
											<div class="img"></div>
											<!-- 나중에 자바스크립트로 변경예정 -->
											<input type="file" accept="image/gif,image/jpeg,image/png">
										</div>
									</div>
								</form>
							</section>
				<section class="input-container low-step5">
					<form id="update-cover-img" action="" method="post">
						<h1 class="title-h1">테스트 표지 만들기</h1>
						<div class="cover-container">
							<div class="mainCover-img">
								<div class="mainCover-text">표지에 나올 설명</div>
							</div>

							<!-- 나중에 자바스크립트로 변경예정 -->
							<input type="file" accept="image/gif,image/jpeg,image/png">
						</div>
					</form>
				</section>
				<section class="input-container low-step6">
					<h1 class="title-h1">결과 미리보기</h1>
					<div class="result-preview-container">
						<div class="result-preview">
							<div class="result">
								<div class="result-img"></div>
								<div class="text">
									<p>결과 이름~</p>
								</div>
							</div>
							<div class="result">
								<div class="result-img"></div>
								<div class="text"></div>
							</div>
							<div class="result">
								<div class="result-img"></div>
								<div class="text"></div>
							</div>
							<div class="result">
								<div class="result-img"></div>
								<div class="text"></div>
							</div>
						</div>
					</div>
				</section>
				<nav class="nav-buttons">
					<input type="button" value="pro" class="puple-button-m"> <input
						type="button" value="next" class="puple-button-m">
				</nav>
		</div>
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
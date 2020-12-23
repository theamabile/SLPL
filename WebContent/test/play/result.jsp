<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>심리테스트</title>
<link rel="stylesheet" href="../../assets/css/reset.css" type="text/css">
<link rel="stylesheet" href="../../assets/css/common/style.css" type="text/css">
<link rel="stylesheet" href="../../assets/css/test/play.css" type="text/css">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" rel="stylesheet">
<script type="text/javascript" src="../../assets/js/test/play/result.js"></script>
<script>
/***************** SNS 공유용 주소 연결 용 *******************/
var url_default_ks = "https://story.kakao.com/share?url=";
var url_default_fb = "https://www.facebook.com/sharer/sharer.php?u=";
var url_default_tw_txt = "https://twitter.com/intent/tweet?text=";
var url_default_tw_url = "&url=";
var url_default_band = "http://band.us/plugin/share?body=";
var url_route_band = "&route=";
var url_default_naver = "http://share.naver.com/web/shareView.nhn?url=";
var title_default_naver = "&title=";

var url_this_page = location.href; /* 현재url */
var title_this_page = document.title;
var url_combine_ks = url_default_ks + url_this_page;
var url_combine_fb = url_default_fb + url_this_page;
var url_combine_tw = url_default_tw_txt + document.title
		+ url_default_tw_url + url_this_page;
var url_combine_band = url_default_band + encodeURI(url_this_page) + '%0A'
		+ encodeURI(title_this_page) + '%0A' + '&route=tistory.com';
var url_combine_naver = url_default_naver + encodeURI(url_this_page)
		+ title_default_naver + encodeURI(title_this_page);			
/************************************************************* */
</script>


</head>


<body>
	<header id="header">
		<div id="top_header" class="top_header">
			<div>mypage</div>
			<div>logout</div>
		</div>
		<div id="main_header" class="main_header">
			<ul class="main_nav">
				<a href="action">
					<img src="../../assets/images/common/logo.png" alt="MBTI로고">
				</a>

				<!-- <div class="menu"> -->
				<li><a href="#">MAKE</a></li>
				<li><a href="#">TEST</a></li>
				<li><a href="#">COMMUNITY</a></li>
			</ul>
		</div>
	</header>

	<!-- 텍스트에 ()는 DB에서 입력받기 위함 -->
	<section id="body" class="body">
		<div class="container">
			<main id="main" class="main">
				<nav class="body-nav">
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

				<!-- DB: TEST, TYPE, ANSWER_SCORE => 결과를 찾고 CHARACTER -> TEST_RESULT -->
				<section id="rPart1" class="page">
					<div class="total">
						<h1>성향 분석중...</h1>
						<article class="total-content">
							<c:forEach var="r" items="${list}">
								<span>${r.tName} 테스트는 ${r.tMemberName} 님이<br> MBTI 사이트에서 제작하신 테스트입니다.<br></span>
								<span>${r.tRegdate}에 제작되었고,<br></span>
								<span>현재 이용한 테스터 수는 ${r.tHitCnt}명,<br></span>
								<span>추천 수는 ${r.tRecomCnt}개 입니다.<br></span>
								<span>${r.tRecomCnt+1}번째 추천인이 되보는건 어떨까요?</span>
							</c:forEach>
						</article>
					</div>
					<button type="button" class="page-result-button move-button-m">테스트 결과보기</button>
				</section>

				<section id="rPart2" class="page d-done">
					<c:forEach var="r" items="${list}">
					<div class="result">
						<span class="title">${r.cName}</span>
						<div class="img">
							<img src="/test/coverImg?id=${r.tId}" alt="테스트 결과 이미지">
						</div>
						<span class="result-content">${r.cContent}</span>
					</div>
					<div class="type">
						<span>참여인원 ${r.tHitCnt}명 중<br>당신의 유형은 (8)% 입니다.
						</span>
					</div>
					</c:forEach>
					<div class="recom">
						<span class="test-icon recom-icon"><i class="far fa-thumbs-up fa-3x"></i>추천</span> 
						<span class="test-icon report-icon"><i class="fas fa-ban fa-3x"></i>신고</span>
					</div>

					<!-- SNS버튼 시작 -->
					<div class="share">
						<!-- 페이스북 공유 버튼 -->
						<a href="" onclick="window.open(url_combine_fb, '', 'scrollbars=no, width=600, height=600'); return false;">
							<img src="../../assets/images/test/play/face.png" title="페이스북으로 공유하기" class="sharebtn_custom">
						</a>
						<!-- 트위터 공유 버튼 -->
						<a href="" onclick="window.open(url_combine_tw, '', 'scrollbars=no, width=600, height=600'); return false;">
							<img src="../../assets/images/test/play/twt.png" title="트위터로 공유하기" class="sharebtn_custom">
						</a>
						<!-- 카카오 스토리 공유 버튼 -->
						<a href="" onclick="window.open(url_combine_ks, '', 'scrollbars=no, width=600, height=600'); return false;">
							<img src="../../assets/images/test/play/kakao.png" title="카카오스토리로 공유하기" class="sharebtn_custom">
						</a>
						<!-- 네이버 공유 버튼 -->
						<a href="" onclick="window.open(url_combine_naver, '', 'scrollbars=no, width=600, height=600'); return false;">
							<img src="../../assets/images/test/play/naver.png" title="네이버로 공유하기" class="sharebtn_custom">
						</a>
						<!-- 밴드 공유 버튼 -->
						<a href="" onclick="window.open(url_combine_band, '', 'scrollbars=no, width=584, height=635'); return false;">
							<img src="../../assets/images/test/play/band.png" title="밴드로 공유하기" class="sharebtn_custom">
						</a>
					</div>
					<!-- SNS버튼 끝 -->

					<div class="page-move-button">
						<button type="button" class="page-move-button move-button-s" value="test-save">테스트 결과 저장하러 가기</button>
						<button type="button" class="page-move-button move-button-s" value="test-another-play">다른 테스트 하러 가기</button>
						<button type="button" class="page-move-button move-button-s" value="go-make">나도 테스트 제작 하기</button>
					</div>

					<div id="report-popup" class="popup-container d-done">
						<h1>신고 유형</h1>
						<form method="get" action="result.jsp">
							<div class="report-popup-container">
								<label for="report-type1"><input type="radio" id="report-type1" name="report-type" value="type1" checked="checked">불건전한 컨텐츠</label> <label for="report-type2"><input type="radio" id="report-type2" name="report-type" value="type2">욕설 컨텐츠</label> <label for="report-type3"><input type="radio" id="report-type3" name="report-type" value="type3">성적인 컨텐츠</label>
							</div>
							<button type="submit" class="move-button-s report-submit-button" value="submit">확인</button>
							<button type="button" class="move-button-s popup-cancel-button">취소</button>
						</form>
					</div>
				</section>
			</main>
		</div>
	</section>


	<section id="footer" class="footer">
		<div class="container">
			<footer id="footer"> 한국심리콘텐츠개발연구소 대표이사 : 정혜진 사업자등록번호 : 197-06-18554 사업자 정보확인 통신판매업 신고 : 2020-서울특별시-1102 사업장주소 : 서울 종로구 인사동길 12 대일빌딩 7층, 15층 대표번호 : 010-9965-2278 제품/서비스/멤버십: 1588-3366 구매문의 : 1588-6084 본 사이트의 컨텐츠는 저작권법의 보호를 받는 바 무단 전재, 복사, 배포 등을 금합니다. 게시된 이메일 주소가 자동 수집되는 것을 거부하며, 이를 위반 시 정보통신법에 의해 처벌됨을 유념하시기 바랍니다. Copyright © 2020-2020 KCPDL. All Rights Reserved. </footer>
		</div>
	</section>
</body>
</html>
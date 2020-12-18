<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.slpl.web.service.test.TestListViewService" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자 - 회원관리</title>
    <link href="../../../assets/css/reset.css" type="text/css" rel="stylesheet">
    <link href="../../../assets/css/admin/style.css" type="text/css" rel="stylesheet">
    <link href="../../../assets/css/admin/test-list.css" type="text/css" rel="stylesheet">
</head>
<body>    
    <header class="header">
        <h1 class="d-none"> 심리플리</h1>     

        <section class="logo">
            <h1 class="d-none">HOME</h1>            
            <a href="index.html">                    
                <img src="../../../assets/images/admin/admin-title.png" alt="홈" />
            </a>    
        </section>
        
        <div class="title">
            ADMIN DASHBOARD
        </div>

        <div class="login-menu">
            <input type="button" id="logout" value="LOGOUT" class="white-button-s"/>
        </div>        
    </header>

    <div id="body" class="body" >  
        <nav>
            <h1 class="d-none">메인 메뉴</h1>
            <ul class="main-menu">
                <li>
                    <div class="first-menu-item">
                        <img class="menu-img" src="../../../assets/images/admin/admin_menu_dashboard.png" alt="대시보드"/>   
                        <a href="#">DASH BOARD</a>    
                    </div>                    
                </li>
                <li>
                    <div class="first-menu-item">
                        <img class="menu-img" src="../../../assets/images/admin/admin_menu_member.png" alt="회원 관리"/> 
                        <a href="#">MEMBER</a>    
                    </div>                    
                    
                    <ul>
                        <li><a href="list.html">LIST</a></li>
                        <li><a href="add.html">ADD</a></li>
                    </ul>
                </li>
                <li>
                    <div class="first-menu-item">
                        <img class="menu-img" src="../../../assets/images/admin/admin_menu_community.png" alt="게시판 관리"/> 
                        <a href="#">COMMUNITY</a>    
                    </div>                    
                </li>
                <li>
                    <div class="first-menu-item">
                        <img class="menu-img" src="../../../assets/images/admin/admin_menu_test.png" alt="테스트 관리"/> 
                        <a href="#">TEST</a>
                    </div>                    

                    <ul>
                        <li><a href="">맡으신거</a></li>
                        <li><a href="">여기다</a></li>
                        <li><a href="">적어주세요</a></li>
                    </ul>
                </li>
            </ul>
        </nav> 
       

        <main class="main">
            <section class="container">
                <h1 class="d-none"> 회원관리 </h1> 

                <!-- container-item클래스가 꽉 채워진 박스 기준이라 min-width만 설정해주기 위해 member-container를 같이 넣어줌-->            
                <section class="container-item member-container">             
                    <h1> <a href="test-list">테스트 목록</a> </h1> 

                    <div class="tools">
                        
                        <section class="filter">
                            <h1 class="d-none">필터</h1>
                            <form action="test-list">
                                <select class="category" name="a">
                                    <option value="REGDATE">정렬 기준</option>
                                    <option value="ID">번호</option>
                            		<option value="NAME">테스트 명</option>
                                    <option value="HIT_CNT">조회수</option>
                            		<option value="RECOMMEND_CNT">추천수</option>
                                    <option value="SHARE_CNT">공유수</option>
                            		<option value="REGDATE">등록일</option>
                                    <option value="PUBLIC_STATE">공개여부</option>
                            		<option value="LEV_NAME">난이도</option>
                                    <option value="CATE_NAME">유형</option>
                            	</select>
                            	<select class="category" name="o">
                                    <option value="DESC">내림차순</option>
                            		<option value="ASC">오름차순</option>
                            	</select>
                            	<select class="category" name="pl">
                            		<option value="10">10개</option>
                                    <option value="20">20개</option>
                                    <option value="50">50개</option>
                                    <option value="100">100개</option>
                            	</select>
                            	<select class="category" name="c">
                                    <option value="NAME">테스트 명</option>
                                    <option value="NICKNAME">제작자</option>
                                    <option value="ID">테스트 번호</option>
                                </select>
                                <input type="hidden" name="o" value="0">
                                <input type="text" name="k" class="search-keyword" placeholder="검색어 입력">
                                <input type="submit" class="gray-button-m" value="검색"> 
                            </form>
                        </section>   
            
                    </div>
                    
                        
                    <section class="test-list">
                        <h1 class="d-none">테스트 목록</h1>
                        <table>
                            <thead>
                                <tr>
                                    <th>번호</th>
                                    <th>테스트명</th>
                                    <th>제작자</th>
                                    <th>조회수</th>
                                    <th>추천수</th>
                                    <th>공유수</th>
                                    <th>등록일</th>
                                    <th>공개 여부</th>
                                    <th>난이도</th>
                                    <th>유형</th>
                                </tr>
                            </thead>
                            <tbody>
                            	<c:forEach var="n" items= "${list}">
                            	<c:set var="state" value="${(n.publicState == 1)?'공개':'비공개' }"/>
                                <tr>
                                    <td>${n.id }</td>
                                    <td>${n.name }</td>
                                    <td>${n.nickname }</td>
                                    <td>${n.hitCnt }</td>
                                    <td>${n.recommendCnt }</td>
                                    <td>${n.shareCnt }</td>
                                    <td>${n.regdate }</td>
                                    <td>${state }</td>
                                    <td>${n.levName }</td>
                                    <td>${n.cateName }</td>
                                </tr>
                                </c:forEach>      
                            </tbody>
                           
                            <div class="detail-position"></div>
                        </table>
						
						<c:set var="page" value="${(param.p == null)?1:param.p }"/>
                        <c:set var="startNum" value="${page-(page-1)%5}"  />
                        <div class="page">
                            <div class="link">
                            	<c:if test="${startNum>1 }">
                                <a class="prev" href="test-list?p=${startNum-1}&pl=${param.pl}&c=${param.c}&k=${param.k}&a=${param.a}&o=${param.o}">이전</a>
                                </c:if>
                                <c:if test="${startNum<=1 }">
                               	<a class="prev">이전</a>
                                </c:if>
                                <c:forEach var="i" begin="0" end="4">
                                <a class="page-num" href="test-list?p=${startNum+i}&pl=${param.pl}&c=${param.c}&k=${param.k}&a=${param.a}&o=${param.o}">${startNum+i}</a>
                                </c:forEach>
                                <a class="next" href="test-list?p=${startNum+5}&pl=${param.pl}&c=${param.c}&k=${param.k}&a=${param.a}&o=${param.o}">다음</a>
                            </div>  
                        </div>
                    </section>
                </section >
            </section>
            
            
            <footer class="footer">
                한국심리콘텐츠개발연구소<br> 
                대표이사 : 정혜진 사업자등록번호 : 197-06-18554 사업자 정보확인 통신판매업 신고 : 2020-서울특별시-1102<br>
        
                사업장주소 : 서울 종로구 인사동길 12 대일빌딩 7층, 15층 대표번호 : 010-9965-2278 제품/서비스/멤버십: 1588-3366 구매문의 : 1588-6084<br>
            
                본 사이트의 컨텐츠는 저작권법의 보호를 받는 바 무단 전재, 복사, 배포 등을 금합니다.<br>
                
                게시된 이메일 주소가 자동 수집되는 것을 거부하며, 이를 위반 시 정보통신법에 의해 처벌됨을 유념하시기 바랍니다.<br>
        
                Copyright © 2020-2020 KCPDL. All Rights Reserved.<br>
            </footer>    

        </main>

    </div>

</body>
</html>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자 - 메세지관리</title>
    <link href="../../assets/css/reset.css" type="text/css" rel="stylesheet">
    <link href="../../assets/css/admin/style.css" type="text/css" rel="stylesheet">
    <link href="../../assets/css/admin/message.css" type="text/css" rel="stylesheet">
    
    <script src="../../assets/js/member/list.js"></script>
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
                <h1 class="d-none"> 메세지 관리 </h1> 

                <!-- container-item클래스가 꽉 채워진 박스 기준이라 min-width만 설정해주기 위해 member-container를 같이 넣어줌-->            
                <section class="container-item member-container">             
                    <h1> 메세지 목록 </h1> 
                    
                    <form>
                    	<div class="tools">
	                        <section class="filter">
	                            <h1 class="d-none">필터</h1>
                                <select name="field" class="field">
                                    <option value="receiver_name" <c:if test="${field eq 'receiver_name'}">selected</c:if>>수신인</option>
                                    <option value="title" <c:if test="${field eq 'title'}">selected</c:if>>제목</option>
                                </select>
                                <input type="text" name="query" class="query" placeholder="검색어 입력" autocomplete="off"
                                	<c:if test="${searchResult == true}">value="${query}"</c:if> >
                                <input type="button" class="gray-button-m searchButton" value="검색"> 
	                        </section>   
	            
	                        <section class="tools-box">
	                            <h1 class="d-none">부가 메뉴</h1>
	                            <input type="button" value="공지 메세지 전송" class="puple-button-l messageBtn">
	                            <input type="submit" value="선택 삭제" class="gray-button-m checkDelBtn">
	                        </section>
	                    </div>  
	                    <section>
	                        <h1 class="d-none">메세지 목록</h1>
	                        <table>
	                            <thead>
	                                <tr>
	                                    <th class="table-width-s">식별번호</th>
	                                    <th class="table-width-m">메세지 분류</th>
	                                    <th class="table-width-l">제목</th>
	                                    <th class="table-width-m">수신인</th>
	                                    <th class="table-width-m">날짜</th>
	                                </tr>
	                            </thead>
	                            <tbody class="table-body">
	                            	<c:if test="${searchResult eq false}">
	                            		<tr>
	                            			<td colspan="9">'${keyword}'에 대한 검색 결과가 없습니다.</td>
	                            		</tr>
	                            	</c:if>
	                            	<c:forEach var="m" items="${list}">
		                            	<tr>
		                                    <td>${m.id}</td>
		                                    <td>${m.type}</td>  <!-- 경고/공지 -->
		                                    <td><a href="messageDetail?id=${m.id}">${m.title}</a></td>
		                                    <td>${m.receiverName}</td>
		                                    <td>${m.regdate}</td>
		                                </tr>
	                                </c:forEach>                                           
	                            </tbody>
	                        </table>
	                    </section>
                    </form>
                    
                  	 <div>
                       	<input type="button" value="◀◀" class="prevScopeBtn"/>
                       	<input type="button" value="◀"  class="prevBtn"/>
                        <ul>
                        	<c:forEach varStatus="i" begin="${startPage}" end="${endPage}">
                        		  <c:choose>
							         <c:when test="${field != null && query != null}">
								         <li><a href="messageList?field=${field}&query=${query}&page=${i.index}" <c:if test="${currentPage == i.index}">class="current-page"</c:if> >
	                        					${i.index}</a></li>
							         </c:when>
							         <c:otherwise>
							           	<li><a href="messageList?page=${i.index}" <c:if test="${currentPage == i.index}">class="current-page"</c:if> >
	                        				${i.index}</a></li>
							         </c:otherwise>
							      </c:choose>
                        	</c:forEach>
                        </ul>
                        <input type="button" value="▶"  class="nextBtn" />
                        <input type="button" value="▶▶" class="nextScopeBtn" />
                        
                        
                        <input type="hidden" name="startPage" value="${startPage}" class="startPage">   
                        <input type="hidden" name="endPage" value="${endPage}" class="endPage">   
                        <input type="hidden" name="currentPage" value="${currentPage}" class="currentPage">    <!-- next나 pre 버튼을 누를 때 현재 페이지 정보가 필요함 -->
                        <input type="hidden" name="allPageCount" value="${allPageCount}" class="allPageCount">    <!-- next나 pre 버튼을 누를 때 현재 페이지 정보가 필요함 --> 
                      	</div>
                </section>
            </section>
            
        	<!------------------------------------------- 풋터  -------------------------------------------------->
            
            <jsp:include page="../common/footer.jsp"></jsp:include> 
        </main>

    </div>
	
</body>
</html>
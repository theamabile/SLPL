<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../../assets/css/reset.css" type="text/css">
<link rel="stylesheet" href="../../assets/css/common/style.css" type="text/css">
<link rel="stylesheet" href="../../assets/css/member/member.css" type="text/css">
<link rel="stylesheet" href="../../assets/css/member/message.css" type="text/css">

<script src="../../assets/js/member/message_list.js"></script>
</head>
<body>

<!------------------------------------------- 헤더 -------------------------------------------------->
<jsp:include page="../../common/header.jsp"></jsp:include> 
	
	<section id="body" class="body">
		<div class="container">
			<main id="main" class="main">
				<!------------------------------------------- 메뉴  -------------------------------------------------->
	       		<jsp:include page="../../common/nav.jsp"></jsp:include>

	            <section class="content">
	              	<div class="message-container">
	                    <h4> 메세지 목록 </h4> 
	                    <form>
	                    	<input type="hidden" name="memberId" class="memberId" value="${login.id}">
	                    	<div class="tools">
		                        <section class="filter">
		                            <h1 class="d-none">필터</h1>
	                                <select name="field" class="field">
	                                    <option value="title" <c:if test="${field eq 'title'}">selected</c:if>>제목</option>
	                                    <option value="content" <c:if test="${field eq 'content'}">selected</c:if>>내용</option>
	                                </select>
	                                <input type="text" name="query" class="query" placeholder="검색어 입력" autocomplete="off"
	                                	<c:if test="${searchResult == true}">value="${query}"</c:if> >
	                                <input type="button" class="puple-button-m searchButton" value="검색"> 
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
		                                    <th class="table-width-m">발신날짜</th>
		                                </tr>
		                            </thead>
		                            <tbody class="table-body">
		                            	<c:if test="${searchResult eq false}">
		                            		<tr>
		                            			<td colspan="9">'${query}'에 대한 검색 결과가 없습니다.</td>
		                            		</tr>
		                            	</c:if>
		                            	<c:forEach var="m" items="${list}">
			                            	<tr>
			                                    <td>${m.id}</td>
			                                    <td>${m.type}</td>  <!-- 경고/공지 -->
			                                    <td><a href="detail?id=${m.id}">${m.title}</a></td>
			                                    <td>${m.regdate}</td>
			                                </tr>
		                                </c:forEach>                                           
		                            </tbody>
		                        </table>
		                    </section>
                    	</form>
                    	
                    	<div class="pager">
	                       	<input type="button" value="이전" class="prevScopeBtn"/>
	                        <ul class="pageList">
	                        	<c:forEach varStatus="i" begin="${startPage}" end="${endPage}">
	                        		  <c:choose>
								         <c:when test="${field != null && query != null}">
									         <li><a href="list?field=${field}&query=${query}&page=${i.index}" <c:if test="${currentPage == i.index}">class="current-page"</c:if> >
		                        					${i.index}</a></li>
								         </c:when>
								         <c:otherwise>
								           	<li><a href="list?page=${i.index}" <c:if test="${currentPage == i.index}">class="current-page"</c:if> >
		                        				${i.index}</a></li>
								         </c:otherwise>
								      </c:choose>
	                        	</c:forEach>
	                        </ul>
	                        <input type="button" value="다음" class="nextScopeBtn" />
	                    </div>
            
              		</div>
            	</section>
         	</main>
      	</div>
   </section>
   
   <!------------------------------------------- 풋터  -------------------------------------------------->
   <jsp:include page="../../common/footer.jsp"></jsp:include> 


</body>
</html>
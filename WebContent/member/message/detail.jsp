<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>심리플리</title>
<link rel="stylesheet" href="../../assets/css/reset.css" type="text/css">
<link rel="stylesheet" href="../../assets/css/common/style.css" type="text/css">
<link rel="stylesheet" href="../../assets/css/member/member.css" type="text/css">
<link rel="stylesheet" href="../../assets/css/member/message.css" type="text/css">

<script src="../../assets/js/member/message.js"></script>
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
	              	<div class="detail-msg-container">
	                    <h4> 메세지 상세 </h4> 
	                        <form method="post">
	                        	<div class="input-box">		                     
				                    <label>메세지 분류</label>               
		                         	<select name="messageType" disabled>
		                                <option value="경고" <c:if test="${message.type eq '경고'}">selected</c:if> >경고</option>
                                		<option value="공지" <c:if test="${message.type eq '공지'}">selected</c:if> >공지</option>
		                            </select>
	                            </div>
	                            
	                            <div class="input-box">	
		                           	<label>수신처</label>
		                            <div class="member-box">
			                           <!-- 	<select name="sendType" readonly>
			                            	<option value="all" select>전체</option>
			                            	<option value="personal">개인</option>
			                            </select> -->
			                            <input type="text" name="receiverName" value="${message.receiverName}" placeholder="수신인" readonly>
			                            <!-- <input type="text" name="memberNames" placeholder="수신인" readonly> -->
		                            </div>
	                            </div>
	                            
	                            <div class="input-box">	
		                            <label>제목</label>
		                            <input type="text" name="title" value="${message.title}" placeholder="제목" readonly>
	                            </div>
	                            <div class="input-box">	
		                            <label>내용</label>
		                            <textarea name="content" class="input-message" readonly>
		                            ${message.content}
		                            </textarea>
								</div>
	                            <input type="button" value="목록" class="gray-button-wf listButton"> 
	                        </form>
	                    </form>
	              	</div>
	            </section>
         	</main>
      	</div>
   	</section>
   	
   <!------------------------------------------- 풋터  -------------------------------------------------->
   <jsp:include page="../../common/footer.jsp"></jsp:include> 


</body>
</html>
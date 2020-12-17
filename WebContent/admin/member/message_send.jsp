<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>관리자 - 메세지관리</title>
<link href="../../assets/css/reset.css" type="text/css" rel="stylesheet">
<link href="../../assets/css/admin/style.css" type="text/css" rel="stylesheet">
<link href="../../assets/css/admin/message.css" type="text/css" rel="stylesheet">

<script src="../../assets/js/admin/member/message.js"></script>
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
                <h1 class="d-none"> 메세지 전송 </h1> 

                <div class="send-msg-container">  <!-- container-item클래스로 제작된걸 사이징만 해주기 위해 감쌌음 -->
                    <section class="container-item">     
                        <h1> 메세지 전송 </h1> 
                        <form method="post">
                        	<label>메세지 분류</label>   
                         	<select name="type" class="input-wf" >
                                <option value="경고">경고</option>
                                <option value="공지">공지</option>
                            </select>
                            <label>수신처</label>
                            <div class="member-box">
	                           	<select name="sendType" disabled>
	                            	<option value="all" <c:if test="${sendAllMember == true}">selected</c:if>>전체</option>
	                            	<option value="personal" <c:if test="${sendAllMember == false}">selected</c:if> >개인</option>
	                            </select>
                          		<input type="text" name="memberName" value="${memberNames}" placeholder="수신인" readonly>
                            </div>
                            
                            <label>제목</label>
                            <input type="text" name="title" class="input-wf" placeholder="제목">
                            
                            <label>내용</label>
                            <textarea name="content" class="input-wf input-message">
                            </textarea>

							
                           	<input type="hidden" name="sendAllMember" value="${sendAllMember}" >
                            <c:forEach var="m" items="${list}">
                           		<input type="hidden" name="id" value="${m.id}" >
                            </c:forEach>
	                            
                            <input type="submit" value="전송" class="puple-button-wf submit-button"> 
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
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
<link href="../../../assets/css/reset.css" type="text/css" rel="stylesheet">
<link href="../../../assets/css/admin/style.css" type="text/css" rel="stylesheet">
<link href="../../../assets/css/admin/message.css" type="text/css" rel="stylesheet">

<script src="../../../assets/js/admin/member/message.js"></script>
</head>
<body>
<!------------------------------------------- 헤더 -------------------------------------------------->
    <jsp:include page="../../common/header.jsp"></jsp:include> 
	
    <div id="body" class="body" >  
        
        <!------------------------------------------- 메뉴  -------------------------------------------------->
        <jsp:include page="../../common/menu.jsp"></jsp:include>


        <!------------------------------------------- 메인  -------------------------------------------------->
        <main class="main">
            <section class="container">
                <h1 class="d-none"> 메세지 상세 정보 </h1> 

                <div class="detail-msg-container">  <!-- container-item클래스로 제작된걸 사이징만 해주기 위해 감쌌음 -->
                    <section class="container-item">     
                        <h1> 메세지 상세 정보 </h1> 
                        <form method="post">		                     
		                    <label>메세지 분류</label>               
                         	<select name="messageType" class="input-wf" disabled>
                                <option value="경고" <c:if test="${message.type eq '경고'}">selected</c:if> >경고</option>
                                <option value="공지" <c:if test="${message.type eq '공지'}">selected</c:if> >공지</option>
                            </select>
                            
                           	<label>수신처</label>
                            <div class="member-box">
	                            <input type="text" name="receiverName" value="${message.receiverName}" placeholder="수신인" readonly>
                            </div>
                            
                            <label>제목</label>
                            <input type="text" name="title" class="input-wf" value="${message.title}" placeholder="제목" readonly>
                            
                            <label>내용</label>
                            <textarea name="content" class="input-wf input-message" readonly>
                            ${message.content}
                            </textarea>

                            <input type="button" value="목록" class="gray-button-wf listButton"> 
                        </form>
                    </section >
                </div>   
            </section>
            
        	<!------------------------------------------- 풋터  -------------------------------------------------->
            
            <jsp:include page="../../common/footer.jsp"></jsp:include> 
        </main>

    </div>
</body>
</html>
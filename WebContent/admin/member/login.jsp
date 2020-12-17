<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>관리자 - 회원관리</title>
<link href="../../assets/css/reset.css" type="text/css" rel="stylesheet">
<link href="../../assets/css/admin/style.css" type="text/css" rel="stylesheet">
<link href="../../assets/css/admin/member.css" type="text/css" rel="stylesheet">
</head>
<body>
<!------------------------------------------- 헤더 -------------------------------------------------->
    <jsp:include page="../common/header.jsp"></jsp:include> 
	
    <div id="body" class="body" >  
        <!------------------------------------------- 메인  -------------------------------------------------->
        <main class="main">
            <section class="container">
                <h1 class="d-none"> 로그인 </h1> 
                <div class="login-container">
                    <section class="container-item">
                        <h1 class="d-none"> LOGIN </h1> 
                        <div class="login-img">
                            <img src="<%=request.getContextPath()%>/assets/images/member/login_icon.png" alt="LOGIN">
                        </div>
                        <form>
                            <input type="text" name="id" class="input-wf" placeholder="ID"><br>
                            <input type="password" name="pw" class="input-wf" placeholder="PASSWORD"><br>
                            <input type="submit" class="puple-button-wf" value="LOGIN"> 
                        </form>
                    </section>
                </div>
            </section>
            
        	<!------------------------------------------- 풋터  -------------------------------------------------->
            
            <jsp:include page="../common/footer.jsp"></jsp:include> 
        </main>

    </div>
</body>
</html>
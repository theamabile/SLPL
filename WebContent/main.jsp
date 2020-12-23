<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
     header {
         display: block;
         position: fixed;
         top: 0;
         left: 0;
         right: 0;
         padding: 1rem;
         background: #f6f6f6;
         font-weight: bold;
         display: flex;
         justify-content: space-between;
         align-items: center;
     }

     header ul li {
         display:inline; /* 세로나열을 가로나열로 변경 */
     }   

 </style>
</head>
<body>

	<!------------------------------------------- 헤더 -------------------------------------------------->
   	<jsp:include page="../common/header.jsp"></jsp:include> 
	
	
	<section id="body" class="body">
      <div class="container">
         <main id="main" class="main">
             	하의하이
         </main>
      </div>
   </section>

  	<!------------------------------------------- 풋터  -------------------------------------------------->
   <jsp:include page="../common/footer.jsp"></jsp:include> 

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>result Datail</title>
    <link rel="stylesheet" href="../../assets/css/reset.css" type="text/css">
<link href="../../assets/css/test/test_make.css" type="text/css" rel="stylesheet">
 <script src="../../assets/js/test/make/resultDeail.js"></script>
 
</head>
<body>
    <div class="preview-detail-container">
        <h1><%=request.getAttribute("name") %></h1>
        <img class="detail-img" src="" alt="">
        <div class="detail-text-box">
            <textarea name=""  class="detail-text">
                <%=request.getAttribute("content") %>
            </textarea>
        </div>
</div>
</body>
</html>
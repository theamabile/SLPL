<%@page import="java.util.List"%>
<%@page import="com.slpl.web.service.community.*"%>
<%@page import="com.slpl.web.entity.community.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<!-- reset을 제일 위에 -->
<link rel="stylesheet" href="../../assets/css/reset.css" type="text/css">
<link rel="stylesheet" href="../../assets/css/common/style.css"
	type="text/css">
<!-- <link rel="stylesheet" href="../../assets/css/community/list.css"
	type="text/css"> -->
		<link rel="stylesheet" href="../../assets/css/community/community.css"
	type="text/css">
	<link rel="stylesheet" href="../../assets/css/common/fontawesome.css"
	type="text/css">

</head>

<body>
	<header id="header">
		<div id="top_header" class="top_header">
			<div>mypage</div>
			<div>logout</div>
		</div>
		<div id="main_header" class="main_header">
			<ul class="main_nav">
				<a href="list"><img src="../../assets/images/common/logo.png"
					alt="MBTI로고"></a>

				<li><a href="#">MAKE</a></li>
				<li><a href="#">TEST</a></li>
				<li><a href="#">COMMUNITY</a></li>
			</ul>
		</div>
	</header>






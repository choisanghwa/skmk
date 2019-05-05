<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--  views/include/header.jsp -->

<!--  jstl core tag 설정 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- 컨텍스트 경로 -->
	<c:set var="path" value="${pageContext.request.contextPath}" />

<!-- CSS 참조 영역 -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

	<link rel="stylesheet" href="./resources/css/basic.css"> <!-- 1. basic CSS -->
	<link rel="stylesheet" href="./resources/css/login.css"> <!-- 2. 로그인 뷰 관련 CSS -->

<!-- JS 참조 영역 -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>

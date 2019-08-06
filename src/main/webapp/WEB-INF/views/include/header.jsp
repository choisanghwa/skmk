<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!--  jstl core tag 설정 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- 컨텍스트 경로 -->
<c:set var="path" value="${pageContext.request.contextPath}" />

<!-- 기본 파일 참조 -->
	<script src="${path}/resources/js/jquery/jquery-3.4.1.min.js"></script>
	<link rel="stylesheet" href="${path}/resources/css/font/import_fonts.css">
	<link rel="stylesheet" href="${path}/resources/css/basic.css">

<!-- 부트스트랩 & 메터리얼 참조 (둘다 동시에 쓰면 충돌 발생함) -->
<c:choose>
	<c:when test="${page == 'login/login.jsp' ||
					page == 'member/registerMember.jsp' ||
					page == 'shop/registerShop.jsp' ||
					page == 'food/registerFood.jsp' ||
					page == 'main/main.jsp'}"> <!-- 부트 스트랩을 쓸  경우 -->
		<link rel="stylesheet" href="${path}/resources/css/bootstrap/bootstrap.min.css">
		<link rel="stylesheet" href="${path}/resources/css/bootstrap/bootstrap-theme.min.css">
		<script src="${path}/resources/js/bootstrap/bootstrap.min.js"></script>
	</c:when>
	<c:when test="${page == 'main/main2.jsp'}"> <!-- 매터리얼을 쓸 경우 -->
		<link rel="stylesheet" href="./resources/css/material/materialize.min.css">
		<script src="${path}/resources/js/material/materialize.min.js"></script>
	</c:when>	
	<c:otherwise> <!-- 둘다 쓰지 않을 경우 -->
	</c:otherwise>
</c:choose>

<!-- 특정 페이지에 대한 자바 스크립트 or CSS 파일 부가 참조 영역 -->
<c:choose>
	<c:when test="${page == 'main/main.jsp'}">
		<script src="${path}/resources/js/effects/scroll.js"></script>
		<script src="${path}/resources/js/effects/counting.js"></script>
		<link rel="stylesheet" href="${path}/resources/css/effects/buttons.css">
	</c:when>
</c:choose>

<!-- CSS 참조 영역 -->
	<link rel="stylesheet" href="${path}/resources/css/views/login/login.css">
	<link rel="stylesheet" href="${path}/resources/css/views/main/main.css">
	<link rel="stylesheet" href="${path}/resources/css/views/guestBook/guestBook.css">
	<link rel="stylesheet" href="${path}/resources/css/views/food/food.css">
	<link rel="stylesheet" href="${path}/resources/css/effects/tooltip.css">
	
	<link rel="stylesheet" href="${path}/resources/css/apis/odometer/odometer-theme-minimal.css" />
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<!-- JS 참조 영역 -->
	<script src="${path}/resources/js/apis/odometer/odometer.js"></script>
	<script src="${path}/resources/js/views/main/main.js"></script>
	<script src="${path}/resources/js/views/login/login.js"></script>
	<script src="${path}/resources/js/views/member/member.js"></script>
	<script src="${path}/resources/js/views/shop/shop.js"></script>
	<script src="${path}/resources/js/views/food/food.js"></script>
	<script src="${path}/resources/js/views/guestBook/guestBook.js"></script>
	<script src="${path}/resources/js/views/orders/orders.js"></script>
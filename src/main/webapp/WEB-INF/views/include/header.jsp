<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!--  jstl core tag 설정 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- 컨텍스트 경로 -->
<c:set var="path" value="${pageContext.request.contextPath}" />

<!-- 기본 파일 참조 -->
	<script src="${path}/resources/js/jquery/jquery-3.4.1.min.js"></script>
	<link rel="stylesheet" href="${path}/resources/css/views/basic.css">

<!-- 부트스트랩 & 메터리얼 참조 (둘다 동시에 쓰면 충돌 발생함) -->
<c:choose>
	<c:when test="${page == 'login/login.jsp' ||
					page == 'member/registerMember.jsp'}"> <!-- 부트 스트랩을 쓸  경우 -->
		<link rel="stylesheet" href="${path}/resources/css/bootstrap/bootstrap.min.css">
		<link rel="stylesheet" href="${path}/resources/css/bootstrap/bootstrap-theme.min.css">
		<script src="${path}/resources/js/bootstrap/bootstrap.min.js"></script>
	</c:when>
	<c:when test="${page == 'main/main.jsp'}"> <!-- 매터리얼을 쓸 경우 -->
		<link rel="stylesheet" href="./resources/css/material/materialize.min.css">
		<script src="${path}/resources/js/material/materialize.min.js"></script>
	</c:when>	
	<c:otherwise> <!-- 둘다 쓰지 않을 경우 -->
	</c:otherwise>
</c:choose>

<!-- CSS 참조 영역 -->
	<link rel="stylesheet" href="${path}/resources/css/views/login/login.css">
	<link rel="stylesheet" href="${path}/resources/css/views/main/main.css">

<!-- JS 참조 영역 -->
	<script src="${path}/resources/js/views/main/main.js"></script>
	<script src="${path}/resources/js/views/login/login.js"></script>
	<script src="${path}/resources/js/views/member/member.js"></script>
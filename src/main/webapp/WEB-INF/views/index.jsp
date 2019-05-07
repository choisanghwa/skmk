<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page session="false" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no">
	<title>SKMK - Social Key, Mobile KIOSK</title>
	<%@ include file="include/header.jsp" %>
</head>
<body>
	<c:if test="${page != null }">
		<jsp:include page="${page}"></jsp:include>
	</c:if>
</body>
</html>

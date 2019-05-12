<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="slideshow-container">

	<!-- 슬라이드 div 객체 -->
	<div class="mySlides fade">
		<div class="img" id="picture1">
			<!-- 첫번째 슬라이드에 해당하는 이미지 객체 -->
			<div class="text">플레이스 1</div>
			<!-- 첫번째 슬라이드 이미지 안에 들어가 있는 텍스트 객체 -->
		</div>
	</div>

	<div class="mySlides fade">
		<div class="img" id="picture2">
			<div class="text">플레이스 2</div>
		</div>
	</div>

	<div class="mySlides fade">
		<div class="img" id="picture3">
			<div class="text">플레이스 3</div>
		</div>
	</div>

	<!-- 화살표 '<'에 해당하는 객체 -->
	<a class="prev" onclick="plusSlides(-1)">&#10094;</a>
	<!-- 화살표 '>'에 해당하는 객체 -->
	<a class="next" onclick="plusSlides(1)">&#10095;</a>

</div>
<br>

<!-- 아래 도트 3개, 슬라이드 쇼의 그림을 선택할 수 있다. -->
<div style="text-align: center">
	<span class="dot" onclick="currentSlide(1)"></span>
	<span class="dot" onclick="currentSlide(2)"></span>
	<span class="dot" onclick="currentSlide(3)"></span>
</div>

<br>
<br>
<br>

<div class="contents-wrap">
	<button class="button card-panel waves-effect white">주문하기</button>
	<c:if test="${status == 'success'}">
		<button class="button card-panel waves-effect white" id="goPlace">가게 생성</button>
	</c:if>        
	<c:if test="${status != 'success'}">
		<button class="button card-panel waves-effect white" id="goLogin">로그인</button>
	</c:if> 
</div>
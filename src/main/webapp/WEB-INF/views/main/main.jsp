<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="path" value="${pageContext.request.contextPath}" />
<c:set var="url" value="${url}" />
<c:set var="isMyShop" value="${isMyShop}" />

<!-- Sidebar/menu -->

<!-- Top menu on small screens -->
<a href="javascript:void(0)" class="w3-bar-item w3-button w3-padding-24 w3-left slide_button" onclick="w3_open()"><i class="fa fa-bars"></i></a>

<nav class="w3-sidebar w3-collapse w3-white w3-animate-left"
	style="z-index: 3; width: 300px;" id="mySidebar">
	<br>
	<div class="w3-container w3-row">
		<div class="w3-col s4">
			<c:if test="${member != null}">
				<img src="${path}/resources/image/${member.getMemberImage()}"
					class="w3-circle w3-margin-right" style="width: 72px">
			</c:if>
			<c:if test="${member == null}">
				<img src="${path}/resources/image/member/unknown_userImage.png"
					class="w3-circle w3-margin-right" style="width: 72px">
			</c:if>		
		</div>

		<div class="w3-col s7 w3-bar">
			<c:if test="${member != null}">
				<span><strong>${member.getMemberName()} 님,</strong> 환영합니다.</span>
			</c:if>
			<c:if test="${member == null}">
				<span>로그인이 필요합니다.</span>
			</c:if>			
			<br>
			<a href="#"
				class="w3-bar-item w3-button"><i class="fa fa-envelope"></i></a> <a
				href="#" class="w3-bar-item w3-button"><i class="fa fa-user"></i></a>
			<a href="#" class="w3-bar-item w3-button"><i class="fa fa-cog"></i></a>
		</div>
		
		<a href="#"
			class="w3-col s1 w3-bar w3-button w3-padding-16 w3-hide-large" style="position:absolute;"
			onclick="w3_close()" title="close menu"><i class="fa fa-remove fa-fw"></i></a>
		
		<div class="w3-row s8 w3-bar">
			<c:if test="${member != null}">
				<button class="btn waves-effect waves-light" id="logout" style="float:right;">로그아웃</button>
			</c:if>
			<c:if test="${member == null}">
				<button class="btn waves-effect waves-light" id="goLogin" style="float:right;">로그인 하기</button>
			</c:if>		
		</div>
	</div>
	<hr>
	<div class="w3-container">
		<h5>Dashboard</h5>
	</div>
	<div class="w3-bar-block">
		<a href="#"
			class="w3-bar-item w3-button w3-padding w3-blue"><i
			class="fa fa-users fa-fw"></i>  Overview</a> <a href="#"
			class="w3-bar-item w3-button w3-padding"><i
			class="fa fa-eye fa-fw"></i>  Views</a> <a href="#"
			class="w3-bar-item w3-button w3-padding"><i
			class="fa fa-users fa-fw"></i>  Traffic</a> <a href="#"
			class="w3-bar-item w3-button w3-padding"><i
			class="fa fa-bullseye fa-fw"></i>  Geo</a> <a href="#"
			class="w3-bar-item w3-button w3-padding"><i
			class="fa fa-diamond fa-fw"></i>  Orders</a> <a href="#"
			class="w3-bar-item w3-button w3-padding"><i
			class="fa fa-bell fa-fw"></i>  News</a> <a href="#"
			class="w3-bar-item w3-button w3-padding"><i
			class="fa fa-bank fa-fw"></i>  General</a> <a href="#"
			class="w3-bar-item w3-button w3-padding"><i
			class="fa fa-history fa-fw"></i>  History</a> <a href="#"
			class="w3-bar-item w3-button w3-padding"><i
			class="fa fa-cog fa-fw"></i>  Settings</a><br>
		<br>
	</div>
</nav>


<div class="contents-wrap">
	<!-- Overlay effect when opening sidebar on small screens -->
	<div class="w3-overlay w3-hide-large w3-animate-opacity"
		onclick="w3_close()" style="cursor: pointer" title="close side menu"
		id="myOverlay"></div>
	
	<!-- !PAGE CONTENT! -->
	<div class="w3-main" style="margin-left: 300px;">
	
	<c:if test="${shop != null}">
		<c:if test="${member == null || (member != null && isMyShop ne '1')}"> <!-- 일부 -->
			<header class="w3-container" style="padding-top: 22px">
				<h5>
					<b><i class="fa fa-dashboard"></i> My Dashboard</b>
				</h5>
			</header>

			<div class="w3-row-padding w3-margin-bottom">
				<div class="w3-half dash_buttons"
					onclick="openBoard('dash_menu', this)">
					<div class="w3-container w3-teal w3-padding-16 button_menu">
						<div class="w3-left">
							<div class="foodList">
								<img src="${path}/resources/image/foodList.png"
									style="width: 100%; height: 100%;">
							</div>
						</div>
						<div class="w3-right">
							<h3>${fn:length(foodList)}</h3>
						</div>
						<div class="w3-clear"></div>
						<h4>메뉴</h4>
					</div>
				</div>
				<div class="w3-half dash_buttons"
					onclick="openBoard('dash_user', this)">
					<div
						class="w3-container w3-orange w3-text-white w3-padding-16 button_user">
						<div class="w3-left">
							<i class="fa fa-users w3-xxxlarge"></i>
						</div>
						<div class="w3-right">
							<h3>${fn:length(guestList)}</h3>
						</div>
						<div class="w3-clear"></div>
						<h4>Users</h4>
					</div>
				</div>
			</div>
			<div class="w3-panel dashBoard" id="dash_menu" style="display:block;">			
				<c:forEach items="${foodList}" var="foodList">
					<div class="product" data-food="${foodList.foodCode}" id="openModal">
						<img src="${path}/resources/image/${foodList.foodImage[0]}" class="product_picture">
						<p>${foodList.foodName}</p>
						<p>${foodList.foodPrice} 원</p>
					</div>				
				</c:forEach>
				
				<div class="product" id="openModal">
					<img src="${path}/resources/image/레몬주스_1.png" class="product_picture">
					<p>레몬주스_1</p>
					<p>5000 원</p>
				</div>
				<div class="product" id="openModal">
					<img src="${path}/resources/image/레몬주스_2.png" class="product_picture">
					<p>레몬주스_2</p>
					<p>5000 원</p>
				</div>
				<div class="product" id="openModal">
					<img src="${path}/resources/image/망고주스_1.png" class="product_picture">
					<p>망고주스_1</p>
					<p>5000 원</p>
				</div>
				<div class="product" id="openModal">
					<img src="${path}/resources/image/망고주스2.png" class="product_picture">
					<p>망고주스_2</p>
					<p>5000 원</p>
				</div>
				<div class="product" id="openModal">
					<img src="${path}/resources/image/오렌지주스_1.png" class="product_picture">
					<p>오렌지주스_1</p>
					<p>5000 원</p>
				</div>
				<div class="product" id="openModal">
					<img src="${path}/resources/image/오렌지주스_2.png" class="product_picture">
					<p>오렌지주스_2</p>
					<p>5000 원</p>
				</div>
				<div class="product" id="openModal">
					<img src="${path}/resources/image/세트1.png" class="product_picture">
					<p>세트1</p>
					<p>5000 원</p>
				</div>
				<div class="product" id="openModal">
					<img src="${path}/resources/image/세트2.png" class="product_picture">
					<p>세트2</p>
					<p>5000 원</p>
				</div>
				<div class="product" id="openModal">
					<img src="${path}/resources/image/세트3.png" class="product_picture">
					<p>세트3</p>
					<p>5000 원</p>
				</div>
			</div>

			<div class="w3-panel dashBoard" id="dash_user">
				<div class="w3-container">
					<h3>방명록</h3>
					<div id ="contentLoad">
						<ul class="w3-ul w3-card-4 w3-white contentList">
							<c:forEach items="${guestList}" var="guestList" varStatus="status">
								<li class="w3-padding-16 w3-row contentItem" style="text-align:left;">
									<span class="w3-left w3-col s2 w3-large" style="margin-left:30px;">${guestList.guestBookTitle}</span>
									<span class="w3-opacity w3-right" style="margin-left:20px;">${guestList.guestBookTime}</span>
									<p class="guestContent w3-right w3-col s9" style="margin-left:20px;">${guestList.guestBookContent}</p>				
									<br>
								</li>			
							</c:forEach>
						
							<li class="w3-padding-16 loadMore" id="loadMore">
								<span class="w3-xlarge loadMore">▼ 더 보기</span><br></li>
						</ul>
					</div>
					<br>
					<br>
					<form id="guestBookForm">
						<div class="form-group form-inline" style="float:left;">	
							<label for="commentTitle" id="commentTitle">제목  : </label>
							<input class="form-control" type="text" minlength="2" maxlength="20" placeholder="2~ 20자  이내  입력" name="GuestBookTitle" id="guestBookTitle">
						</div>				
						<textarea class="form-control" rows="8" minlength="2" maxlength="500" placeholder="최대  500자 이내 입력" name="GuestBookContent" id="guestBookContent"></textarea>
						<br>
						<button class="btn btn-primary form-control" style="float:right; width:150px;"id="submit_guestBook">
							<i class="fa fa-check spaceLeft"></i>등록 하기
						</button>
					</form>
				</div>
			</div>
		</c:if>
		<c:if test="${member != null }">
			<c:if test="${url eq 'main' || (url ne 'main' && isMyShop eq '1')}">		
					<!-- Header -->
					<header class="w3-container" style="padding-top: 22px">
						<h5>
							<b><i class="fa fa-dashboard"></i> My Dashboard</b>
						</h5>
					</header>
		
					<div class="w3-row-padding w3-margin-bottom">
						<div class="w3-quarter dash_buttons"
							onclick="openBoard('dash_alerm', this)">
							<div class="w3-container w3-red w3-padding-16 button_alerm">
								<div class="w3-left">
									<i class="fa fa-comment w3-xxxlarge"></i>
								</div>
								<div class="w3-right">
									<h3>0</h3>
								</div>
								<div class="w3-clear"></div>
								<h4>알림</h4>
							</div>
						</div>
						<div class="w3-quarter dash_buttons"
							onclick="openBoard('dash_chart', this)">
							<div class="w3-container w3-blue w3-padding-16 button_chart">
								<div class="w3-left">
									<i class="fa fa-eye w3-xxxlarge"></i>
								</div>
								<div class="w3-right odometer" id="number_statistics">
									0
								</div>
								<div class="w3-clear"></div>
								<h4>통계</h4>
							</div>
						</div>
						<div class="w3-quarter dash_buttons"
							onclick="openBoard('dash_menu', this)">
							<div class="w3-container w3-teal w3-padding-16 button_menu">
								<div class="w3-left">
									<div class="foodList">
										<img src="${path}/resources/image/foodList.png"
											style="width: 100%; height: 100%;">
									</div>
								</div>
								<div class="w3-right">
									<h3>${fn:length(foodList)}</h3>
								</div>
								<div class="w3-clear"></div>
								<h4>메뉴</h4>
							</div>
						</div>
						<div class="w3-quarter dash_buttons"
							onclick="openBoard('dash_user', this)">
							<div
								class="w3-container w3-orange w3-text-white w3-padding-16 button_user">
								<div class="w3-left">
									<i class="fa fa-users w3-xxxlarge"></i>
								</div>
								<div class="w3-right">
									<h3>${fn:length(guestList)}</h3>
								</div>
								<div class="w3-clear"></div>
								<h4>Users</h4>
							</div>
						</div>
					</div>
		
					<button class="w3-button w3-dark-grey" id="goInsertFood">
						음식 등록하기 <i class="fa fa-arrow-right"></i>
					</button>
		
					<div class="w3-panel dashBoard" id="dash_alerm">
						<h2><b>현재 기능 미 구현되어 있음.</b></h2>
					</div>
		
					<div class="w3-panel dashBoard" id="dash_chart" style="display:block;">
						<div class="w3-row-padding" style="margin: 0 -16px;">
							<div class="w3-third">
								<c:if test="${shop != null}"> 
									<c:if test="${shop.getShopQR() == null}">
										<h5><b>QR 주소 없음</b></h5>
										<img src="${path}/resources/image/qr/unknown_shopQR.png" style="width: 100px;"
										alt="QR 주소 없음" id="qr_image">
										<button class="button card-panel waves-effect white" id="makeQR" style="width : 80%;">QR 코드 생성</button>
									</c:if>
									<c:if test="${shop.getShopQR() != null}">
										<h5><b>등록된 QR 주소</b></h5>
										<img src="${path}/resources/image/qrcode.png" style="width: 100%"
											alt="등록된 QR 주소">
									</c:if>
								</c:if>
							</div>
							<div class="w3-twothird">
								<h5><b>통계 자료 (미구현 됨)</b></h5>
								<table class="w3-table w3-striped w3-white">
									<tr>
										<td><i class="fa fa-user w3-text-blue w3-large"></i></td>
										<td>하루에 방문한 고객 수</td>
										<td><i>XX 명</i></td>
									</tr>
									<tr>
										<td><i class="fa fa-bell w3-text-red w3-large"></i></td>
										<td>하루에 발생한 주문 수</td>
										<td><i>XX 건</i></td>
									</tr>
									<tr>
										<td><i class="fa fa-money w3-text-yellow w3-large"></i></td>
										<td>일일 매출 현황</td>
										<td><i> XXXX 원</i></td>
									</tr>
									<tr>
										<td><i class="fa fa-external-link-square w3-text-red w3-large"></i></td>
										<td>전달 대비 매출 증감세.</td>
										<td><i>XX % 증가</i></td>
									</tr>
									<tr>
										<td><i class="fa fa-pie-chart w3-text-blue w3-large"></i></td>
										<td>월간 품목별 최다 주문 건</td>
										<td><i>제품 명 / XX 건 (전체 OO.O%)</i></td>
									</tr>
									<tr>
										<td><i class="fa fa-heart w3-text-red w3-large"></i></td>
										<td>월간 긍정 평가 기록 횟수.</td>
										<td><i>XX 건</i></td>
									</tr>
									<tr>
										<td><i class="fa fa-users w3-text-green w3-large"></i></td>
										<td>월간 방명록 기록 횟수</td>
										<td><i>XX 건</i></td>
									</tr>
								</table>
							</div>
						</div>
					</div>
		
					<div class="w3-panel dashBoard" id="dash_menu">			
						<c:forEach items="${foodList}" var="foodList">
							<div class="product" data-food="${foodList.foodCode}" id="openModal">
								<img src="${path}/resources/image/${foodList.foodImage[0]}" class="product_picture">
								<p>${foodList.foodName}</p>
								<p>${foodList.foodPrice} 원</p>
							</div>				
						</c:forEach>
						
						<div class="product" id="openModal">
							<img src="${path}/resources/image/레몬주스_1.png" class="product_picture">
							<p>레몬주스_1</p>
							<p>5000 원</p>
						</div>
						<div class="product" id="openModal">
							<img src="${path}/resources/image/레몬주스_2.png" class="product_picture">
							<p>레몬주스_2</p>
							<p>5000 원</p>
						</div>
						<div class="product" id="openModal">
							<img src="${path}/resources/image/망고주스_1.png" class="product_picture">
							<p>망고주스_1</p>
							<p>5000 원</p>
						</div>
						<div class="product" id="openModal">
							<img src="${path}/resources/image/망고주스2.png" class="product_picture">
							<p>망고주스_2</p>
							<p>5000 원</p>
						</div>
						<div class="product" id="openModal">
							<img src="${path}/resources/image/오렌지주스_1.png" class="product_picture">
							<p>오렌지주스_1</p>
							<p>5000 원</p>
						</div>
						<div class="product" id="openModal">
							<img src="${path}/resources/image/오렌지주스_2.png" class="product_picture">
							<p>오렌지주스_2</p>
							<p>5000 원</p>
						</div>
						<div class="product" id="openModal">
							<img src="${path}/resources/image/세트1.png" class="product_picture">
							<p>세트1</p>
							<p>5000 원</p>
						</div>
						<div class="product" id="openModal">
							<img src="${path}/resources/image/세트2.png" class="product_picture">
							<p>세트2</p>
							<p>5000 원</p>
						</div>
						<div class="product" id="openModal">
							<img src="${path}/resources/image/세트3.png" class="product_picture">
							<p>세트3</p>
							<p>5000 원</p>
						</div>
					</div>
		
					<div class="w3-panel dashBoard" id="dash_user">
						<div class="w3-container">
							<h3>방명록</h3>
							<div id ="contentLoad">
								<ul class="w3-ul w3-card-4 w3-white contentList">
									<c:forEach items="${guestList}" var="guestList" varStatus="status">
										<li class="w3-padding-16 w3-row contentItem" style="text-align:left;">
											<span class="w3-left w3-col s2 w3-large" style="margin-left:30px;">${guestList.guestBookTitle}</span>
											<span class="w3-opacity w3-right" style="margin-left:20px;">${guestList.guestBookTime}</span>
											<p class="guestContent w3-right w3-col s9" style="margin-left:20px;">${guestList.guestBookContent}</p>				
											<br>
										</li>			
									</c:forEach>
								
									<li class="w3-padding-16 loadMore" id="loadMore">
										<span class="w3-xlarge loadMore">▼ 더 보기</span><br></li>
								</ul>
							</div>
							<br>
							<br>
							<form id="guestBookForm">
								<div class="form-group form-inline" style="float:left;">	
									<label for="commentTitle" id="commentTitle">제목  : </label>
									<input class="form-control" type="text" minlength="2" maxlength="20" placeholder="2~ 20자  이내  입력" name="GuestBookTitle" id="guestBookTitle">
								</div>				
								<textarea class="form-control" rows="8" minlength="2" maxlength="500" placeholder="최대  500자 이내 입력" name="GuestBookContent" id="guestBookContent"></textarea>
								<br>
								<button class="btn btn-primary form-control" style="float:right; width:150px;"id="submit_guestBook">
									<i class="fa fa-check spaceLeft"></i>등록 하기
								</button>
							</form>
		
						</div>
					</div>
					<hr>
					<div class="w3-container">
						<h5><b>월간 그래프 (미구현)</b></h5>
						<br>
						<p><b>신규 주문 비율</b></p>
						<div class="w3-grey">
							<div class="w3-container w3-center w3-padding w3-green"
								style="width: 25%">+25%</div>
						</div>
						<br>
						<p><b>신규 고객 주문 비율</b></p>
						<div class="w3-grey">
							<div class="w3-container w3-center w3-padding w3-orange"
								style="width: 50%">50%</div>
						</div>
						<br>
						<p><b>기존 고객 주문 비율</b></p>
						<div class="w3-grey">
							<div class="w3-container w3-center w3-padding w3-red"
								style="width: 75%">75%</div>
						</div>
					</div>
					<hr>
		
					<div class="w3-container">
						<h5><b>품목별 판매 수익 현황 그래프 (미구현)</b></h5>
						<table
							class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white">
							<tr>
								<td>XXX</td>
								<td>65%</td>
							</tr>
							<tr>
								<td>ㅁㅁㅁ</td>
								<td>15.7%</td>
							</tr>
							<tr>
								<td>OOO</td>
								<td>5.6%</td>
							</tr>
							<tr>
								<td>△△△</td>
								<td>2.1%</td>
							</tr>
							<tr>
								<td>@@@</td>
								<td>1.9%</td>
							</tr>
							<tr>
								<td>☆☆☆</td>
								<td>1.5%</td>
							</tr>
						</table>
						<br>
						<button class="w3-button w3-dark-grey">
							전체 수익 현황 (미구현)  <i class="fa fa-arrow-right"></i>
						</button>
					</div>
			</c:if>
		</c:if>	
	</c:if>
	
	<c:if test="${shop == null}">
		<c:if test="${member != null && url eq 'main'}">
			<img src="${path}/resources/image/no_shop.png" class="warning_pictures">
			<h2>현재 상점이 개설되지 않았습니다.</h2>
			<button class="w3-button w3-dark-grey width_200" id="goAddShop">가게 생성</button>
		</c:if>
		<c:if test="${url ne 'main'}">
			<img src="${path}/resources/image/no_url.png" class="warning_pictures">
			<h2>상점이 개설되지 않았거나 올바른 주소가 아닙니다.</h2>
			<button class="w3-button w3-dark-grey width_200" onclick="main()">돌아 가기</button>
		</c:if>
	</c:if>
		<hr>
		<div class="w3-container background_us">
			<div class="makers_contents">
				<h5>만든 사람들</h5>
				<div class="w3-row makers_profile">
					<div class="w3-col m2 text-center">
						<img class="w3-circle" src="${path}/resources/image/koo.png"
							style="width: 96px; height: 96px">
					</div>
					<div class="w3-col m10 w3-container" style="text-align:left;">
						<h4>
							구 본 일 <span class="w3-opacity w3-medium"> 2019년 6월 30일</span>
						</h4>
						<p>
							2018년 2월 : 영진전문대학 컴퓨터정보계열 졸업<br>
							2017년 10월  - 2018년 12월 : ㈜토탈소프트뱅크 - 응용 소프트웨어 개발직 근무<br>
							2019년 6월 - : 2인 프로젝트 'SKMK - Social Key, Mobile Kiosk' 개발 참여
						</p>
						<br>
					</div>
				</div>
		
				<div class="w3-row makers_profile">
					<div class="w3-col m2 text-center">
						<img class="w3-circle" src="${path}/resources/image/choi.png"
							style="width: 96px; height: 96px">
					</div>
					<div class="w3-col m10 w3-container" style="text-align:left;">
						<h4>
							최 상 화 <span class="w3-opacity w3-medium"> 2019년 6월 30일</span>
						</h4>
						<p>
							2018년 2월 : 영진전문대학 컴퓨터정보계열 졸업<br>
							2017년 10월 - 2018년 12월 : 한국건강관리협회 대구경북지역 전산직 근무<br>
							2019년 6월 - : 2인 프로젝트 'SKMK - Social Key, Mobile Kiosk' 개발 참여
						</p>
						<br>
					</div>
				</div>
			</div>
			<br>
			<div class="w3-container w3-dark-grey w3-padding-32">
				<div class="w3-row">
					<div class="w3-container w3-third">
						<h5 class="w3-bottombar w3-border-green">기 획</h5>
						<p>구 본 일</p>
						<p>최 상 화</p>
					</div>
					<div class="w3-container w3-third">
						<h5 class="w3-bottombar w3-border-red">개 발</h5>
						<p>구 본 일</p>
						<p>최 상 화</p>
					</div>
					<div class="w3-container w3-third">
						<h5 class="w3-bottombar w3-border-orange">디 자 인</h5>
						<p>구 본 일</p>
						<p>최 상 화</p>
					</div>
				</div>
			</div>
		</div>
		<!-- Footer -->
		<footer class="w3-container w3-padding-16 w3-light-grey">
			<h4>본 홈페이지는 상업적인 용도의 홈페이지가 아닙니다.</h4>
			<p>
				Copyright by SKMK
			</p>
		</footer>
	
		<!-- End page content -->
	</div>
	

</div>


<!-- Modal -->
<div class="modal fade" id="foodModal" role="dialog">
	<div class="modal-dialog modal-lg">
		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close closeFoodModal"
					data-dismiss="modal">&times;</button>
				<h4 class="modal-title">음식 상세 화면</h4>
			</div>
			<div class="modal-body bodyFoodModal">
				<div class="food-container">
				  <div class="food-slideArea"></div>
				  <div class="food-listArea"><div class="food-row"></div></div>
				</div>
				<hr>
				<div class="food-detailArea">
				  	<div id="foodName">바닷가</div><br>
				  	<div id="foodPrice">20000 원</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default closeChatRouteModal"
					data-dismiss="modal">닫기</button>
			</div>
		</div>

	</div>
</div>
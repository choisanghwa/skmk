<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- <div class="slideshow-container">

	슬라이드 div 객체
	<div class="mySlides fade">
		<div class="img" id="picture1">
			첫번째 슬라이드에 해당하는 이미지 객체
			<div class="text">플레이스 1</div>
			첫번째 슬라이드 이미지 안에 들어가 있는 텍스트 객체
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

	화살표 '<'에 해당하는 객체
	<a class="prev" onclick="plusSlides(-1)">&#10094;</a>
	화살표 '>'에 해당하는 객체
	<a class="next" onclick="plusSlides(1)">&#10095;</a>

</div>
<br>

아래 도트 3개, 슬라이드 쇼의 그림을 선택할 수 있다.
<div style="text-align: center">
	<span class="dot" onclick="currentSlide(1)"></span>
	<span class="dot" onclick="currentSlide(2)"></span>
	<span class="dot" onclick="currentSlide(3)"></span>
</div>

<br>
<br>
<br> -->

<!-- Sidebar/menu -->
<nav class="w3-sidebar w3-collapse w3-white w3-animate-left"
	style="z-index: 3; width: 300px;" id="mySidebar">
	<br>
	<div class="w3-container w3-row">
		<div class="w3-col s4">
			<img src="${member.getMemberImage()}" class="w3-circle w3-margin-right"
				style="width: 72px">
		</div>
		<div class="w3-col s8 w3-bar">
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
		<div class="w3-row s8 w3-bar">
			<button class="btn waves-effect waves-light" id="logout">로그아웃</button>
		</div>
	</div>
	<hr>
	<div class="w3-container">
		<h5>Dashboard</h5>
	</div>
	<div class="w3-bar-block">
		<a href="#"
			class="w3-bar-item w3-button w3-padding-16 w3-hide-large w3-dark-grey w3-hover-black"
			onclick="w3_close()" title="close menu"><i
			class="fa fa-remove fa-fw"></i>  Close Menu</a> <a href="#"
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

	<c:if test="${shop != null}">
	
		<!-- Overlay effect when opening sidebar on small screens -->
		<div class="w3-overlay w3-hide-large w3-animate-opacity"
			onclick="w3_close()" style="cursor: pointer" title="close side menu"
			id="myOverlay"></div>

		<!-- !PAGE CONTENT! -->
		<div class="w3-main" style="margin-left: 300px; margin-top: 43px;">

			<!-- Header -->
			<header class="w3-container" style="padding-top: 22px">
				<h5>
					<b><i class="fa fa-dashboard"></i> My Dashboard</b>
				</h5>
			</header>

			<div class="w3-row-padding w3-margin-bottom">
				<div class="w3-quarter">
					<div class="w3-container w3-red w3-padding-16">
						<div class="w3-left">
							<i class="fa fa-comment w3-xxxlarge"></i>
						</div>
						<div class="w3-right">
							<h3>52</h3>
						</div>
						<div class="w3-clear"></div>
						<h4>Messages</h4>
					</div>
				</div>
				<div class="w3-quarter">
					<div class="w3-container w3-blue w3-padding-16">
						<div class="w3-left">
							<i class="fa fa-eye w3-xxxlarge"></i>
						</div>
						<div class="w3-right">
							<h3>99</h3>
						</div>
						<div class="w3-clear"></div>
						<h4>Views</h4>
					</div>
				</div>
				<div class="w3-quarter">
					<div class="w3-container w3-teal w3-padding-16">
						<div class="w3-left">
							<i class="fa fa-share-alt w3-xxxlarge"></i>
						</div>
						<div class="w3-right">
							<h3>23</h3>
						</div>
						<div class="w3-clear"></div>
						<h4>Shares</h4>
					</div>
				</div>
				<div class="w3-quarter">
					<div class="w3-container w3-orange w3-text-white w3-padding-16">
						<div class="w3-left">
							<i class="fa fa-users w3-xxxlarge"></i>
						</div>
						<div class="w3-right">
							<h3>50</h3>
						</div>
						<div class="w3-clear"></div>
						<h4>Users</h4>
					</div>
				</div>
			</div>
			
			<button class="w3-button w3-dark-grey" id="goInsertFood">
				음식 등록하기 <i class="fa fa-arrow-right"></i>
			</button>

			<div class="w3-panel">
				<div class="w3-row-padding" style="margin: 0 -16px">
					<div class="w3-third">
						<h5>Regions</h5>
						<img src="/w3images/region.jpg" style="width: 100%"
							alt="Google Regional Map">
					</div>
					<div class="w3-twothird">
						<h5>Feeds</h5>
						<table class="w3-table w3-striped w3-white">
							<tr>
								<td><i class="fa fa-user w3-text-blue w3-large"></i></td>
								<td>New record, over 90 views.</td>
								<td><i>10 mins</i></td>
							</tr>
							<tr>
								<td><i class="fa fa-bell w3-text-red w3-large"></i></td>
								<td>Database error.</td>
								<td><i>15 mins</i></td>
							</tr>
							<tr>
								<td><i class="fa fa-users w3-text-yellow w3-large"></i></td>
								<td>New record, over 40 users.</td>
								<td><i>17 mins</i></td>
							</tr>
							<tr>
								<td><i class="fa fa-comment w3-text-red w3-large"></i></td>
								<td>New comments.</td>
								<td><i>25 mins</i></td>
							</tr>
							<tr>
								<td><i class="fa fa-bookmark w3-text-blue w3-large"></i></td>
								<td>Check transactions.</td>
								<td><i>28 mins</i></td>
							</tr>
							<tr>
								<td><i class="fa fa-laptop w3-text-red w3-large"></i></td>
								<td>CPU overload.</td>
								<td><i>35 mins</i></td>
							</tr>
							<tr>
								<td><i class="fa fa-share-alt w3-text-green w3-large"></i></td>
								<td>New shares.</td>
								<td><i>39 mins</i></td>
							</tr>
						</table>
					</div>
				</div>
			</div>
			<hr>
			<div class="w3-container">
				<h5>General Stats</h5>
				<p>New Visitors</p>
				<div class="w3-grey">
					<div class="w3-container w3-center w3-padding w3-green"
						style="width: 25%">+25%</div>
				</div>

				<p>New Users</p>
				<div class="w3-grey">
					<div class="w3-container w3-center w3-padding w3-orange"
						style="width: 50%">50%</div>
				</div>

				<p>Bounce Rate</p>
				<div class="w3-grey">
					<div class="w3-container w3-center w3-padding w3-red"
						style="width: 75%">75%</div>
				</div>
			</div>
			<hr>

			<div class="w3-container">
				<h5>Countries</h5>
				<table
					class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white">
					<tr>
						<td>United States</td>
						<td>65%</td>
					</tr>
					<tr>
						<td>UK</td>
						<td>15.7%</td>
					</tr>
					<tr>
						<td>Russia</td>
						<td>5.6%</td>
					</tr>
					<tr>
						<td>Spain</td>
						<td>2.1%</td>
					</tr>
					<tr>
						<td>India</td>
						<td>1.9%</td>
					</tr>
					<tr>
						<td>France</td>
						<td>1.5%</td>
					</tr>
				</table>
				<br>
				<button class="w3-button w3-dark-grey">
					More Countries  <i class="fa fa-arrow-right"></i>
				</button>
			</div>
			<hr>
			<div class="w3-container">
				<h5>Recent Users</h5>
				<ul class="w3-ul w3-card-4 w3-white">
					<li class="w3-padding-16"><img src="/w3images/avatar2.png"
						class="w3-left w3-circle w3-margin-right" style="width: 35px">
						<span class="w3-xlarge">Mike</span><br></li>
					<li class="w3-padding-16"><img src="/w3images/avatar5.png"
						class="w3-left w3-circle w3-margin-right" style="width: 35px">
						<span class="w3-xlarge">Jill</span><br></li>
					<li class="w3-padding-16"><img src="/w3images/avatar6.png"
						class="w3-left w3-circle w3-margin-right" style="width: 35px">
						<span class="w3-xlarge">Jane</span><br></li>
				</ul>
			</div>
			<hr>

			<div class="w3-container">
				<h5>Recent Comments</h5>
				<div class="w3-row">
					<div class="w3-col m2 text-center">
						<img class="w3-circle" src="/w3images/avatar3.png"
							style="width: 96px; height: 96px">
					</div>
					<div class="w3-col m10 w3-container">
						<h4>
							John <span class="w3-opacity w3-medium">Sep 29, 2014, 9:12
								PM</span>
						</h4>
						<p>Keep up the GREAT work! I am cheering for you!! Lorem ipsum
							dolor sit amet, consectetur adipiscing elit, sed do eiusmod
							tempor incididunt ut labore et dolore magna aliqua.</p>
						<br>
					</div>
				</div>

				<div class="w3-row">
					<div class="w3-col m2 text-center">
						<img class="w3-circle" src="/w3images/avatar1.png"
							style="width: 96px; height: 96px">
					</div>
					<div class="w3-col m10 w3-container">
						<h4>
							Bo <span class="w3-opacity w3-medium">Sep 28, 2014, 10:15
								PM</span>
						</h4>
						<p>Sed do eiusmod tempor incididunt ut labore et dolore magna
							aliqua.</p>
						<br>
					</div>
				</div>
			</div>
			<br>
			<div class="w3-container w3-dark-grey w3-padding-32">
				<div class="w3-row">
					<div class="w3-container w3-third">
						<h5 class="w3-bottombar w3-border-green">Demographic</h5>
						<p>Language</p>
						<p>Country</p>
						<p>City</p>
					</div>
					<div class="w3-container w3-third">
						<h5 class="w3-bottombar w3-border-red">System</h5>
						<p>Browser</p>
						<p>OS</p>
						<p>More</p>
					</div>
					<div class="w3-container w3-third">
						<h5 class="w3-bottombar w3-border-orange">Target</h5>
						<p>Users</p>
						<p>Active</p>
						<p>Geo</p>
						<p>Interests</p>
					</div>
				</div>
			</div>

			<!-- Footer -->
			<footer class="w3-container w3-padding-16 w3-light-grey">
				<h4>FOOTER</h4>
				<p>
					Powered by <a href="https://www.w3schools.com/w3css/default.asp"
						target="_blank">w3.css</a>
				</p>
			</footer>

			<!-- End page content -->
		</div>
	</c:if>        
	<c:if test="${shop == null}">
		<button class="button card-panel waves-effect white" id="goAddShop">가게 생성</button>
	</c:if> 
</div>
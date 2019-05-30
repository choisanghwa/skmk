<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<div class="page-header">
	<div class="col-md-6 col-md-offset-3">
		<h3>가게 개설 화면</h3>
	</div>
</div>
<div class="col-md-6 col-md-offset-3">
	<form role="form">
		<div class="form-group">
			<label for="inputShopName">가게 이름</label>
			<input type="text" class="form-control" id="inputShopName" placeholder="가게 명을 입력해 주세요.">
		</div>
		<div class="form-group">
			<label for="inputShopAddress">가게 주소</label>
			<input type="text" class="form-control" id="inputShopAddress" placeholder="가게 주소를 입력해 주세요.">
		</div>
		<div class="form-group">
			<label for="inputShopLogo">가게 로고</label>
			<input type="file" class="form-control" id="inputShopLogo" placeholder="가게 로고를 등록해 주세요.">
		</div>
		<div class="form-group">
			<label for="inputShopLicense">사업자 등록번호</label>
			<input type="text" class="form-control" id="inputShopLicense" placeholder="사업자 등록번호를 입력해주세요.">
		</div>

		<div class="form-group">
			<label>약관 동의</label>
			<div data-toggle="buttons">
				<span class="fa fa-check"></span>
				<input type="checkbox" name="fancy-checkbox-default" id="inputAgree" autocomplete="off" />
				<a href="#">이용약관</a>에 동의합니다.
			</div>
		</div>
		
		<div class="form-group text-center">
			<button type="button" id="join-create" class="btn btn-primary">
				가게 개설 <i class="fa fa-check spaceLeft"></i>
			</button>
			<button type="button" id="cancel-create" class="btn btn-warning">
				개설 취소<i class="fa fa-times spaceLeft"></i>
			</button>
		</div>
	</form>
</div>
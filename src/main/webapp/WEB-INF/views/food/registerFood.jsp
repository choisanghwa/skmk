<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<div class="page-header">
	<div class="col-md-6 col-md-offset-3">
		<h3>음식 등록 화면</h3>
	</div>
</div>
<div class="col-md-6 col-md-offset-3">
	<form role="form" multiple="true">
		<div class="form-group">
			<label for="inputFoodName">음식 이름</label>
			<input type="text" class="form-control" id="inputFoodName" placeholder="음식 명을 입력해 주세요.">
		</div>
		<div class="form-group">
			<label for="inputFoodPrice">음식 가격</label>
			<input type="text" class="form-control" id="inputFoodPrice" placeholder="음식 가격을 입력해 주세요.">
		</div>
		<div class="form-group">
			<label for="inputFoodImage">음식 이미지</label>
			<input type="file" class="form-control" id="inputFoodImage" placeholder="음식 이미지를 등록해 주세요.">
		</div>
		
		<div class="form-group text-center">
			<button type="button" id="join-addFood" class="btn btn-primary">
				음식 등록 <i class="fa fa-check spaceLeft"></i>
			</button>
			<button type="button" id="cancel-addFood" class="btn btn-warning">
				개설 취소<i class="fa fa-times spaceLeft"></i>
			</button>
		</div>
	</form>
</div>
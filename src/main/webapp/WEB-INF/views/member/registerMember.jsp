<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<div class="page-header">
	<div class="col-md-6 col-md-offset-3">
		<h3>회원가입 Form</h3>
	</div>
</div>
<div class="col-md-6 col-md-offset-3">
	<form role="form">
		<div class="form-group">
			<label for="inputName">성명</label>
			<input type="text" class="form-control" id="inputName" placeholder="이름을 입력해 주세요.">
		</div>
		<div class="form-group">
			<label for="inputEmail">이메일 주소</label>
			<input type="email" class="form-control" id="inputEmail" placeholder="이메일 주소를 입력해 주세요.">
		</div>
		<div class="form-group">
			<label for="inputPassword">비밀 번호</label>
			<input type="password" class="form-control" id="inputPassword" placeholder="비밀번호를 입력해 주세요.">
		</div>
		<div class="form-group">
			<label for="inputPasswordCheck">비밀번호 확인</label>
			<input type="password" class="form-control" id="inputPasswordCheck" placeholder="비밀번호 확인을 위해 다시한번 입력 해 주세요.">
		</div>
		<div class="form-group">
			<label for="inputMobile">휴대폰 번호</label>
			<input type="tel" class="form-control" id="inputMobile" placeholder="휴대폰 번호를 입력해 주세요.">
		</div>
		<div class="form-group">
			<label for="inputMemberImage">프로필 사진 등록</label>
			<input type="file" class="form-control" id="inputMemberImage" placeholder="프로필 사진을 등록해 주세요.">
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
			<button type="button" id="join-submit" class="btn btn-primary">
				회원가입 <i class="fa fa-check spaceLeft"></i>
			</button>
			<button type="button" id="cancel-submit" class="btn btn-warning">
				가입 취소<i class="fa fa-times spaceLeft"></i>
			</button>
		</div>
	</form>
</div>
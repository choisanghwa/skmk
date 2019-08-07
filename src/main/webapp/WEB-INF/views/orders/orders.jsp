<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="path" value="${pageContext.request.contextPath}" />

<div class="page-header">
	<div class="col-md-6 col-md-offset-3">
		<h3>주문 페이지</h3>
	</div>
</div>
<div class="col-md-6 col-md-offset-3">
	<form role="form" id="registerMemberForm" enctype="multipart/form-data">
		<table class="table table-hover order-table">
			<thead>
				<tr>
					<th colspan="2">주문 명</th>
					<th>판매가</th>
					<th>수량</th>
					<th>주문 금액</th>
				</tr>
			</thead>
			<tr>
				<td><img src="${path}/resources/image/레몬주스_1.png" style="width:100px;"></td>
				<td valign=middle>레몬 주스_1</td>
				<td align=center valign=middle>￦ 20000</td>
				<td align=center valign=middle>2</td>
				<td align=center valign=middle>￦ 40000</td>
			</tr>
			<tr>
				<td><img src="${path}/resources/image/망고주스_1.png" style="width:100px;"></td>
				<td valign=middle>망고 주스_1</td>
				<td align=center valign=middle>￦ 14000</td>
				<td align=center valign=middle>3</td>
				<td align=center valign=middle>￦ 42000</td>
			</tr>
		</table>
		<div class="form-group text-center">
			<button type="submit" id="commitOrder" class="btn btn-primary">
				주문하기 <i class="fa fa-check spaceLeft"></i>
			</button>
			<button type="button" id="cancel-order" class="btn btn-warning">
				주문 취소<i class="fa fa-times spaceLeft"></i>
			</button>
		</div>
	</form>
</div>
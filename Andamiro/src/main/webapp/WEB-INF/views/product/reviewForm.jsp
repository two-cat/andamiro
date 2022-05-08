<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<form name="rf" action="reviewForm" method="post">
	<!-- hidden field(작성자, 부모글 번호)-------- -->
	<input type="hidden" name="idx_fk" value="${loginUser.idx }"> <input
		type="hidden" name="pnum" value="${item.pnum}">
	<!-- --------------------------------------- -->
	<table class="table" id="review">
		<thead>
			<th>리뷰</th>
		</thead>
		<tr>
			<c:if test="${loginUser ne null}">
				<td style="text-align: center"><span
					class="label label-success" name="idx_fk">${loginUser.name}</span>
					<select name="score">
						<option value="">별점</option>
						<option value="5">★★★★★</option>
						<option value="4">★★★★</option>
						<option value="3">★★★</option>
						<option value="2">★★</option>
						<option value="1">★</option>
				</select></td>
				<td style="width: 70%"><textarea name="content" rows="2"
						placeholder="리뷰를 남겨주세여" class="form-control"></textarea></td>
				<td>
					<button class="btn btn-light">리뷰쓰기</button>
				</td>
			</c:if>
		</tr>
	</table>
</form>


